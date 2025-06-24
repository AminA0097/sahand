package com.userservice.sahand.Utils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;

public class QueryDsl<T> {

    private static final Pattern FILTER_PATTERN = Pattern.compile("^e\\.([a-zA-Z0-9_.]+)@(.+)$");
    private static final Set<String> SUPPORTED_OP = Set.of("eq", "ne", "in", "gt", "lt");

    public BooleanBuilder createFilter(Class<T> entityClass, String filter) throws Exception {
        PathBuilder<T> pathBuilder = new PathBuilder<>(entityClass, "e");
        BooleanBuilder builder = new BooleanBuilder();
        String finalFilter = validateFilter(filter);
        String[] filterArray = finalFilter.split(";");

        for (String filterItem : filterArray) {
            if (!filterItem.startsWith("e.")) continue;

            String condition = filterItem.substring(2);
            int atIndex = condition.indexOf('@');
            if (atIndex < 0) continue;

            String fieldPath = condition.substring(0, atIndex);
            String operatorAndValue = condition.substring(atIndex + 1);

            String operator = null;
            String value = null;
            for (String op : SUPPORTED_OP) {
                if (operatorAndValue.startsWith(op)) {
                    operator = op;
                    value = operatorAndValue.substring(op.length());
                    break;
                }
            }
            if (operator == null) {
                throw new Exception("Unsupported operator in filter: " + operatorAndValue);
            }

            Path<?> path = buildNestedPath(pathBuilder, entityClass, fieldPath);

            Field targetField = findFieldByPath(entityClass, fieldPath);
            Object castedValue = castValue(targetField.getType(), value);
            BooleanExpression expr = buildOp(path, operator, castedValue);
            builder.and(expr);
        }
        return builder;
    }
    private Path<?> buildNestedPath(PathBuilder<?> root, Class<?> rootClass, String fieldPath) throws Exception {
        String[] parts = fieldPath.split("\\.");
        Path<?> path = root;
        Class<?> currentClass = rootClass;

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            Field field = findField(currentClass, part);
            if (field == null) {
                throw new Exception("Field not found: " + part);
            }
            Class<?> fieldType = field.getType();

            if (i < parts.length - 1) {
                path = ((PathBuilder<?>) path).get(part);
                currentClass = fieldType;
            } else {
                path = ((PathBuilder<?>) path).get(part, fieldType);
            }
        }
        return path;
    }
    private Field findFieldByPath(Class<?> clazz, String fieldPath) throws Exception {
        String[] parts = fieldPath.split("\\.");
        Class<?> currentClass = clazz;
        Field field = null;
        for (String part : parts) {
            field = findField(currentClass, part);
            if (field == null) throw new Exception("Field not found: " + part);
            currentClass = field.getType();
        }
        return field;
    }


    private Field findField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (clazz.getSuperclass() != null) {
                return findField(clazz.getSuperclass(), fieldName);
            }
            System.err.println("Field '" + fieldName + "' not found in class " + clazz.getName());
            return null;
        }
    }

    public BooleanExpression buildOp(Path<?> path, String op, Object value) throws Exception {
        switch (op) {
            case "eq":
                return Expressions.booleanOperation(Ops.EQ, path, Expressions.constant(value));
            case "ne":
                return Expressions.booleanOperation(Ops.NE, path, Expressions.constant(value));
            case "gt":
                return Expressions.booleanOperation(Ops.GT, (Expression<? extends Comparable>) path, Expressions.constant((Comparable) value));
            case "lt":
                return Expressions.booleanOperation(Ops.LT, (Expression<? extends Comparable>) path, Expressions.constant((Comparable) value));
            case "in":
                if (value instanceof Collection) {
                    return Expressions.booleanOperation(Ops.IN, (Expression<?>) path, Expressions.constant(value));
                }
                throw new IllegalArgumentException("Value for 'in' must be a collection");
            default:
                throw new UnsupportedOperationException("Unknown operator: " + op);
        }
    }

    public String validateFilter(String filter) {
        String[] filters = filter.split(";");
        StringBuilder finalFilter = new StringBuilder();
        for (String f : filters) {
            if (!f.matches(FILTER_PATTERN.pattern())) {
                continue;
            }
            if (!f.startsWith("e")) {
                continue;
            }
            finalFilter.append(f).append(";");
        }
        return finalFilter.toString();
    }

    private Object castValue(Class<?> type, String value) {
        if (type.equals(String.class)) return value;
        if (type.equals(Integer.class) || type.equals(int.class)) return Integer.parseInt(value);
        if (type.equals(Long.class) || type.equals(long.class)) return Long.parseLong(value);
        if (type.equals(Boolean.class) || type.equals(boolean.class))
            return value.equals("1") ? true : false;
        if (type.equals(Double.class) || type.equals(double.class)) return Double.parseDouble(value);
        return value;
    }
}

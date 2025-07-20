package com.userservice.sahand.Utils;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.regex.Pattern;

@Service
public class FilterUtil {

    private static final Pattern FILTER_PATTERN = Pattern.compile("^e\\.([a-zA-Z0-9_.]+)@([a-z]+)(.+)?$");
    private static final Set<String> SUPPORTED_OP = Set.of("eq", "ne", "in", "gt", "lt");

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

    public StringBuilder createFilter(String input) {
        String finalFilter = validateFilter(input);
        String[] filterArray = finalFilter.split(";");
        StringBuilder whereClause = new StringBuilder();

        boolean first = true;

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
            if (operator == null) continue;

            whereClause.append(" and ");
            whereClause.append("(");
            String jpqlField = "e." + fieldPath;
            boolean isNumeric = isNumericField(fieldPath);

            switch (operator) {
                case "eq":
                    whereClause.append(jpqlField).append(" = ")
                            .append(isNumeric ? value : "'" + value + "'");
                    break;
                case "ne":
                    whereClause.append(jpqlField).append(" != ")
                            .append(isNumeric ? value : "'" + value + "'");
                    break;
                case "gt":
                    whereClause.append(jpqlField).append(" > ")
                            .append(isNumeric ? value : "'" + value + "'");
                    break;
                case "lt":
                    whereClause.append(jpqlField).append(" < ")
                            .append(isNumeric ? value : "'" + value + "'");
                    break;
                case "in":
                    String[] items = value.split(",");
                    whereClause.append(jpqlField).append(" in (");
                    for (int i = 0; i < items.length; i++) {
                        if (i > 0) whereClause.append(", ");
                        String item = items[i].trim();
                        whereClause.append(isNumeric ? item : "'" + item + "'");
                    }
                    whereClause.append(")");
                    break;
            }
            whereClause.append(")");

            first = false;
        }

        return whereClause;
    }

    private boolean isNumericField(String fieldPath) {
        String[] parts = fieldPath.split("\\.");
        String last = parts[parts.length - 1].toLowerCase();
        return last.equals("id") || last.endsWith("id");
    }

    private String parseNumberOrQuote(String value) {
        try {
            if (value.contains(".")) {
                Double.parseDouble(value);
            } else {
                Long.parseLong(value);
            }
            return value; // valid number
        } catch (NumberFormatException e) {
            return "'" + value + "'"; // fallback to quoted string
        }
    }
}

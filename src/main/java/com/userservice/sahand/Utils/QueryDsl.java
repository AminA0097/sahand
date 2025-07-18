package com.userservice.sahand.Utils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class QueryDsl<T> {

    private static final Pattern FILTER_PATTERN = Pattern.compile("^e\\.([a-zA-Z0-9_.]+)@(.+)$");
    private static final Set<String> SUPPORTED_OP = Set.of("eq", "ne", "in", "gt", "lt");

    private final Map<String, PathBuilder<?>> joinPath = new HashMap<>();

    public BooleanBuilder createQueryDsl(
            JPAQueryFactory query,
            PathBuilder<?> rootPath,
            Class<?> entityClass,
            String filter) throws Exception {
        BooleanBuilder builder = new BooleanBuilder();
        String finalFilter = validateFilter(filter);
        String[] filterArray = finalFilter.split(";");

        return null;
    }

    public String validateFilter(String filter) {
        String[] filters = filter.split(";");
        StringBuilder finalFilter = new StringBuilder();
        for (String f : filters) {
            if (!f.matches(FILTER_PATTERN.pattern())) {
                throw new RuntimeException("Invalid filter: " + f);
            }
            if (!f.startsWith("e")) {
                throw new RuntimeException("Invalid filter: " + f);
            }
            finalFilter.append(f).append(";");
        }
        return finalFilter.toString();
    }
}

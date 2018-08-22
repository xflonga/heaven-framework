package org.heaven.framework.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by xflonga on 2018/7/19
 *
 * @author xflonga
 */
public class StringUtils {
    private StringUtils() {}

    public static boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }

    public static Set<String> toSet(String value, String separator) {
        return new HashSet<>(toList(value, separator));
    }

    public static List<String> toList(String value, String separator) {
        if (isBlank(value)) {
            return new ArrayList<>(0);
        }

        if (isBlank(separator)) {
            List<String> result = new ArrayList<>(1);
            result.add(value);
            return result;
        }

        return Stream.of(value.split(separator)).filter(v -> !isBlank(v)).collect(Collectors.toList());
    }

}

package org.heaven.framework.util;

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

}

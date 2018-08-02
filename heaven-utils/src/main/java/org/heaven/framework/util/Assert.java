package org.heaven.framework.util;

/**
 * 断言工具类
 * Create by xflonga on 2018/7/30
 *
 * @author xflonga
 */
public class Assert {
    private Assert() {}

    /**
     * 字符串非空白
     *
     * @param value 需要断言的字符串
     * @param error 错误信息
     * @throws IllegalArgumentException 如果为空白时抛出该异常
     */
    public static void notBlank(String value, String error) throws IllegalArgumentException {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(error);
        }
    }


}

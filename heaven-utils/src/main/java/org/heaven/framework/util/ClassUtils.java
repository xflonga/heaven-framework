package org.heaven.framework.util;

/**
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
public class ClassUtils {

    public static ClassLoader getClassLoader(Class<?> clz, ClassLoader classLoader) {
        if (classLoader != null) {
            return classLoader;
        }
        if (clz != null) {
            return clz.getClassLoader();
        }
        ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
        return clzLoader == null ? ClassLoader.getSystemClassLoader() : clzLoader;
    }
}

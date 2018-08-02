package org.heaven.framework.config;

/**
 * 关于配置的接口。<br/>
 * 配置指的是应用程序中某些属性与它的值，通过{key，value}的形式存储。
 *
 * Create by xflonga on 2018/7/19
 *
 * @author xflonga
 */
public interface IEnvironment {

    /**
     * 获取指定key的值
     *
     * @param key 配置的key
     * @return 配置的值，如果没有则返回null
     */
    String getValue(String key);

    /**
     * 获取指定key的值，并将结果转换为retrunClz类型返回。支持自定义对象类型。
     * 如果未配置该值或者改值为空，则返回null
     *
     * @param key 配置的key
     * @param returnClz 返回的类型
     * @param <T> 返回的具体类型
     * @return 配置的值，如果没有则返回null
     * @exception ClassCastException 类型转换失败，如真实的类型为String，但需要将其转换为Map，则会抛出异常。
     */
    <T> T getValue(String key, Class<T> returnClz) throws ClassCastException;

    // TODO: 支持泛型的转换
    //<T> T getValue(String key, JavaType javaType) throws ClassCastException;
}

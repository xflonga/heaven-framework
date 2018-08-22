package org.heaven.framework.config.impl;

import org.heaven.framework.config.IEnvironment;
import org.heaven.framework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by xflonga on 2018/8/9
 *
 * @author xflonga
 */
public class Environment implements IEnvironment {

    /**
     * 这里不使用ConcurrentHashMap,暂时不涉及并发写操作
     */
    private Map<String, String> config = new HashMap<>();


    @Override
    public String getValue(String key) {
        return this.config.get(key);
    }

    @Override
    public <T> T getValue(String key, Class<T> returnClz) throws ClassCastException {
        String value = this.config.get(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }

        if (returnClz == null) {
            throw new ClassCastException("Please specifty return class type!");
        }
        if (returnClz.isAssignableFrom(Integer.class)) {
            return (T) new Integer(value);
        }
        if (returnClz.isAssignableFrom(Boolean.class)) {
            return (T) new Boolean(value);
        }
        if (returnClz.isAssignableFrom(Long.class)) {
            return (T) new Long(value);
        }
        if (returnClz.isAssignableFrom(Double.class)) {
            return (T) new Double(value);
        }
        if (returnClz.isAssignableFrom(Float.class)) {
            return (T) new Float(value);
        }
        if (returnClz.isAssignableFrom(String.class)) {
            return (T) value;
        }
        if (returnClz.isAssignableFrom(List.class)) {

        }
        if (returnClz.isAssignableFrom(Map.class)) {

        }
        if (returnClz.isEnum()) {

        }
        return null;
    }
}

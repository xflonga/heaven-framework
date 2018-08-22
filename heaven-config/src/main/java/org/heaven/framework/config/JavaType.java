package org.heaven.framework.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Create by xflonga on 2018/8/22
 *
 * @author xflonga
 */
@Getter
@Setter
public class JavaType {

    /**
     * 类型
     */
    private Class type;

    /**
     *
     */
    private JavaType subType;

    /**
     *
     */
    private Class innerType;
}

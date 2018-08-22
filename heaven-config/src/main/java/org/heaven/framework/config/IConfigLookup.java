package org.heaven.framework.config;

import org.heaven.framework.config.exception.ConfigException;

import java.util.List;

/**
 * 查找配置文件的接口，可能是在某个目录，可能是在类路径的下的某个目录，也有可能是在某个Jar包中。
 * 如：
 * classpath: ${path}
 * file: ${path}
 *
 * Create by xflonga on 2018/7/30
 *
 * @author xflonga
 */
public interface IConfigLookup {

    /**
     * 根据文件名查找配置
     *
     * @param name 文件名，可以是绝对路径也可以是相对路径
     * @return 配置文件列表
     */
    List<ConfigDefinition> lookup(String name) throws ConfigException;
}

package org.heaven.framework.config;

import java.util.List;

/**
 * 查找配置文件的接口
 *
 * Create by xflonga on 2018/7/30
 *
 * @author xflonga
 */
public interface IConfigLookup {

    /**
     * 查找配置
     *
     * @return 配置文件列表
     */
    List<ConfigDefinition> lookup(String path);
}

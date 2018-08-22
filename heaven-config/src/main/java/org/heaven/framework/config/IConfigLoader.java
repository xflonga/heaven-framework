package org.heaven.framework.config;

/**
 * 配置加载接口
 *
 * Create by xflonga on 2018/8/9
 *
 * @author xflonga
 */
public interface IConfigLoader {

    /**
     * 加载配置，需要完成配置的查找与存储操作
     */
    void load(IEnvironment environment);
}

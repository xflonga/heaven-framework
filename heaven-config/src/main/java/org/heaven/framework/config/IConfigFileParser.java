package org.heaven.framework.config;

import org.heaven.framework.config.exception.ConfigParserException;

import java.util.Map;

/**
 * 配置文件解析器接口，用于将配置文件解析成{key,value}格式
 *
 * Create by xflonga on 2018/7/30
 *
 * @author xflonga
 */
public interface IConfigFileParser {

    /**
     * 将配置文件解析成Map<String, String>格式。
     * 不管真实的value是什么数据类型，在这里一律解析为String类型。
     *
     * @param config 待解析的文件
     * @return Map类型的配置，如果没有配置则返回空的Map。
     * @throws ConfigParserException 配置解析错误时抛出异常，如配置文件中配置的格式不正确
     */
    Map<String, String> parse(ConfigDefinition config) throws ConfigParserException;
}

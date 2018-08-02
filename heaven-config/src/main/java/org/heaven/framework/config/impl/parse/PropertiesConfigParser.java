package org.heaven.framework.config.impl.parse;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.IConfigFileParser;
import org.heaven.framework.config.exception.ConfigParserException;
import org.heaven.framework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 用于*.properties类型的文件解析
 *
 * Create by xflonga on 2018/7/31
 *
 * @author xflonga
 */
public class PropertiesConfigParser implements IConfigFileParser {

    /**
     * 支持{key,value}结构数据，也支持list结构数据
     * <p>
     * list结构示例：application.properties
     *
     * heaven.active.profile=local
     * heaven.active.profile[0]=git
     * heaven.active.profile[1]=redis
     *
     * 最终结果：{"heaven.active.profile": "redis,git,local"}
     * </p>
     *
     * @param config 待解析的文件
     * @return
     * @throws ConfigParserException
     */
    @Override
    public Map<String, String> parse(ConfigDefinition config) throws ConfigParserException {
        if (config == null || config.getContent() == null) {
            return Collections.emptyMap();
        }

        Properties properties = new Properties();
        try {
            properties.load(config.getContent());
        } catch (IOException e) {
            throw new ConfigParserException("Parse configFile[" + config.getName() + "] fail", e);
        }

        Map<String, String> content = new HashMap<>(properties.size());
        Map<String, StringBuilder> listConfig = new HashMap<>();
        Enumeration<String> iterator = (Enumeration<String>) properties.propertyNames();
        while (iterator.hasMoreElements()) {
            String key = iterator.nextElement();
            if (StringUtils.isBlank(key)) {
                throw new ConfigParserException("Parse configFile[" + config.getName() + "] fail: key cannot be null");
            }

            // 支持数组结构
            if (key.endsWith("]")) {
                int i = key.indexOf('[');
                if (i != -1) {
                    String realK = key.substring(0, i);
                    if (listConfig.containsKey(realK)) {
                        listConfig.get(realK).append(',').append(properties.getProperty(key));
                    } else {
                        StringBuilder value = new StringBuilder(properties.getProperty(key));
                        listConfig.put(realK, value);
                    }
                    continue;
                }
            }
            content.put(key, properties.getProperty(key));
        }

        if (!listConfig.isEmpty()) {
            listConfig.forEach((k, v) -> {
                if (content.containsKey(k)) {
                    v.append(',').append(content.get(k));
                }
                content.put(k, v.toString());
            });
        }
        return content;
    }

}

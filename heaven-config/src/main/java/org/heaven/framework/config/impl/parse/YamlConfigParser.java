package org.heaven.framework.config.impl.parse;

import lombok.AllArgsConstructor;
import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.IConfigFileParser;
import org.heaven.framework.config.exception.ConfigParserException;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.util.*;

/**
 * 用于*.yml和*.yaml配置文件的解析
 *
 * Create by xflonga on 2018/7/31
 *
 * @author xflonga
 */
@AllArgsConstructor
public class YamlConfigParser implements IConfigFileParser {

    /**
     * yaml解析器
     */
    private Yaml yaml;

    public YamlConfigParser() {
        this(new Yaml());
    }

    @Override
    public Map<String, String> parse(ConfigDefinition config) throws ConfigParserException {
        if (!supportYamlParser()) {
            LoggerFactory.getLogger(YamlConfigParser.class).warn("Unsupport config file format: *.yaml or *.yml");
            return Collections.emptyMap();
        }

        Map<String, String> content = new HashMap<>();
        Iterator<Object> iterator = this.yaml.loadAll(config.getContent()).iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof Map)) {
                throw new ConfigParserException("Config must be {key, value} structure, please check file [" + config.getName() + "]");
            }

            this.format2Map(content, (Map<String, Object>) object, new StringBuilder(), config.getName());
        }
        return content;
    }

    /**
     * 将yaml文件的内容转换为map结构返回
     *
     * @param content 最终返回的配置
     * @param source 配置文件中每一层的配置
     * @param preKey key的前缀，由于yaml中key的分层特性，因此需要将所有层的key值组合在一起作为一个完整的key
     */
    private void format2Map(Map<String, String> content, Map<String, Object> source, StringBuilder preKey, String file)
            throws ConfigParserException {
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            StringBuilder key = new StringBuilder(preKey);
            if (key.length() != 0) {
                key.append('.').append(entry.getKey());
            } else {
                key.append(entry.getKey());
            }

            Object value = entry.getValue();
            if (value instanceof Map) {
                this.format2Map(content, (Map<String, Object>) value, key, file);
            }

            else if (value instanceof Collection) {
                this.format2Map(content, (Collection<Object>) value, key, file);
            }

            else {
                String realkey = this.existsKey(content, key.toString(), file);
                content.put(realkey, value.toString());
            }
        }
    }

    private void format2Map(Map<String, String> content, Collection<Object> source, StringBuilder preKey, String file)
            throws ConfigParserException {
        for (Object o : source) {
            if (o instanceof Map) {
                this.format2Map(content, (Map<String, Object>) o, preKey, file);
            }

            else if (o instanceof Collection) {
                this.format2Map(content, (Collection<Object>) o, preKey, file);
            }

            else {
                break;
            }
        }

        String key = this.existsKey(content, preKey.toString(), file);
        StringBuilder value = new StringBuilder();
        source.forEach(v -> value.append(',').append(v));
        content.put(key, value.substring(1));
    }

    private boolean supportYamlParser() {
        try {
            Class.forName("org.yaml.snakeyaml.Yaml");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private String existsKey(Map<String, String> content, String key, String file) throws ConfigParserException {
        if (content.containsKey(key)) {
            throw new ConfigParserException("Parser config[" + file + "] fail: Duplicate key[" + key + "]");
        }
        return key;
    }

}

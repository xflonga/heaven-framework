package org.heaven.framework.config;

import org.heaven.framework.config.util.FileUtils;

import java.util.HashMap;
import java.util.Map;

public enum ConfigType {

    /**
     * 用户自定义文件名
     */
    USER_PROPERTIES(1),
    USER_YML(5),

    /**
     * *.properties
     */
    APP_PROFILE_PROPERTIES(10),
    APP_PROPERTIES(15),
    BOOTSTRAP_PROPERTIES(20),

    /**
     * *.yml
     */
    APP_PROFILE_YML(25),
    APP_YML(30),
    BOOTSTRAP_YML(35),

    /**
     * *.yaml
     */
    APP_YAML(40),
    BOOTSTRAP_YAML(35);

    private int level;
    private Map<String, ConfigType> types = new HashMap<>();

    ConfigType(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public ConfigType of(String name) {
        String filename = FileUtils.getFilename(name);
        if (filename.endsWith(".properteis")) {
            if (filename.startsWith("application")) {

            } else if (filename.startsWith("bootstrap")) {

            } else if (filename.startsWith("application-")) {

            }
        } else if (filename.endsWith(".yml")) {

        } else if (filename.endsWith(".yaml")) {

        } else {
            return null;
        }

        return ConfigType.valueOf(ConfigType.class, filename);
    }
}

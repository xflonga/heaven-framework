package org.heaven.framework.config;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

/**
 * Create by xflonga on 2018/7/31
 *
 * @author xflonga
 */
@Getter
@Setter
public class ConfigDefinition {

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件内容
     */
    private InputStream content;

    /**
     * 文件类型
     */
    private Type type;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 配置文件类型
     */
    public static enum Type {

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

        Type(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }
    }

    public static enum From {

    }
}

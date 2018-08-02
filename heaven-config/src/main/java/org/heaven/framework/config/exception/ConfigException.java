package org.heaven.framework.config.exception;

/**
 * 关于配置方面的异常
 *
 * Create by xflonga on 2018/7/31
 *
 * @author xflonga
 */
public abstract class ConfigException extends Exception {


    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}

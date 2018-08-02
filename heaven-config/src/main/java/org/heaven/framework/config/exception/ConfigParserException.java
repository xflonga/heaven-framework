package org.heaven.framework.config.exception;

/**
 * 配置解析异常
 *
 * Create by xflonga on 2018/7/31
 *
 * @author xflonga
 */
public class ConfigParserException extends ConfigException {

    public ConfigParserException(String message) {
        super(message);
    }

    public ConfigParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigParserException(Throwable cause) {
        super(cause);
    }
}

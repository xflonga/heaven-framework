package org.heaven.framework.config.exception;

/**
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
public class ConfigLookupException extends ConfigException {

    public ConfigLookupException(String message) {
        super(message);
    }

    public ConfigLookupException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigLookupException(Throwable cause) {
        super(cause);
    }
}

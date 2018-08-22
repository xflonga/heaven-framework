package org.heaven.framework.config.exception;

/**
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
public class UnsupportedFileFormatException extends ConfigException {

    public UnsupportedFileFormatException(String message) {
        super(message);
    }

    public UnsupportedFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFileFormatException(Throwable cause) {
        super(cause);
    }
}

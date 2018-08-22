package org.heaven.framework.config.impl.lookup;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.IConfigLookup;
import org.heaven.framework.config.exception.ConfigException;
import org.heaven.framework.config.exception.ConfigLookupException;
import org.heaven.framework.config.exception.UnsupportedFileFormatException;
import org.heaven.framework.config.util.FileUtils;
import org.heaven.framework.util.StringUtils;

import java.util.List;

/**
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
public abstract class AbstractConfigLoolup implements IConfigLookup {


    @Override
    public List<ConfigDefinition> lookup(String name) throws ConfigException {
        if (StringUtils.isBlank(name)) {
            throw new ConfigLookupException("File name cannot be null!");
        }

        int i = name.lastIndexOf('.');
        if (i == -1) {
            throw new ConfigLookupException(String.format("File [%s] isn't a effective filename, maybe it's directory!", name));
        }

        if (!FileUtils.getSupportFileFormat().contains(name.substring(i))) {
            throw new UnsupportedFileFormatException("Heaven support file format: " + FileUtils.getSupportFileFormat() +
                    ", please check file: " + name);
        }
        return this.search(name);
    }

    protected abstract List<ConfigDefinition> search(String name) throws ConfigLookupException;

//    private String resolveName(String name) {
//        if (name.startsWith("/")) {
//            return name;
//        }
//        return null;
//    }

}

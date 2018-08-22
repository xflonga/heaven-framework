package org.heaven.framework.config.impl.lookup;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.exception.ConfigLookupException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Create by xflonga on 2018/8/22
 *
 * @author xflonga
 */
public class FilePathConfigLookup extends AbstractConfigLoolup {

    /**
     * 如果文件名以'/'开头，则认为是绝对路径，否则认为是相对路径
     *
     * @param name 文件名，可以是绝对路径也可以是相对路径
     * @return
     */
    @Override
    protected List<ConfigDefinition> search(String name) throws ConfigLookupException {
        File file = new File(name);
        if (!file.exists()) {
            throw new ConfigLookupException(String.format("File [%s] doesn't exists!", name));
        }

        if (!file.isFile()) {
            throw new ConfigLookupException(String.format("File [%s] isn't a effective filename, maybe it's directory!", name));
        }

        ConfigDefinition conf = new ConfigDefinition();
        try {
            conf.setName(file.getCanonicalPath());
            conf.setContent(new FileInputStream(file));
        } catch (IOException e) {
            throw new ConfigLookupException(e);
        }
        return Collections.singletonList(conf);
    }
}

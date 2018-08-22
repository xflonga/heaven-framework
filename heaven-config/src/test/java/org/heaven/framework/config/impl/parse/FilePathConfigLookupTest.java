package org.heaven.framework.config.impl.parse;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.exception.ConfigException;
import org.heaven.framework.config.exception.ConfigLookupException;
import org.heaven.framework.config.exception.UnsupportedFileFormatException;
import org.heaven.framework.config.impl.lookup.FilePathConfigLookup;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by xflonga on 2018/8/22
 *
 * @author xflonga
 */
public class FilePathConfigLookupTest {

    private FilePathConfigLookup configLookup = new FilePathConfigLookup();

    @Test(expected = ConfigLookupException.class)
    public void testFileDoesNotExists() throws ConfigException {
        configLookup.lookup("dos.yml");
    }

    @Test(expected = UnsupportedFileFormatException.class)
    public void testFileFormatUnsupport() throws ConfigException {
        configLookup.lookup("pom.xml");
    }

    @Test(expected = ConfigLookupException.class)
    public void testIsDircetory() throws ConfigException {
        configLookup.lookup("application.yml");
    }

    @Test
    public void test() throws Exception {
        List<ConfigDefinition> configs = configLookup.lookup("src/test/resources/application.yml");
        Assert.assertEquals(1, configs.size());
        configs.get(0).close();
    }


}

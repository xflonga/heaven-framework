package org.heaven.framework.config.impl.parse;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.exception.ConfigParserException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Create by xflonga on 2018/8/1
 *
 * @author xflonga
 */
public class PropertiesConfigParserTest {

    private PropertiesConfigParser configParser = new PropertiesConfigParser();


    @Test
    public void test() throws IOException, ConfigParserException {
        ConfigDefinition config = new ConfigDefinition();
        config.setName("application.properties");

        try (InputStream content = PropertiesConfigParserTest.class.getClassLoader().getResourceAsStream("application.properties")) {
            config.setContent(content);
            Map<String, String> env = configParser.parse(config);
            assertEquals("redis,git,local", env.get("heaven.active.profile"));
        }


    }
}

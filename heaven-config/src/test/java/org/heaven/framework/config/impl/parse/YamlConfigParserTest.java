package org.heaven.framework.config.impl.parse;

import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.config.exception.ConfigParserException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Create by xflonga on 2018/8/2
 *
 * @author xflonga
 */
public class YamlConfigParserTest {

    private YamlConfigParser configParser = new YamlConfigParser();


    @Test
    public void test() throws IOException, ConfigParserException {
        ConfigDefinition config = new ConfigDefinition();
        config.setName("application.yml");

        try (InputStream content = PropertiesConfigParserTest.class.getClassLoader().getResourceAsStream("application.yml")) {
            config.setContent(content);
            Map<String, String> env = configParser.parse(config);

            assertEquals("8080", env.get("server.port"));
            assertEquals("/heaven", env.get("server.context-path"));

            String profile = env.get("heaven.active.profile");
            assertNotNull(profile);
            List<String> profiles = Arrays.asList(profile.split(","));
            assertEquals(3, profiles.size());
            assertTrue(profiles.contains("redis"));
            assertTrue(profiles.contains("local"));
            assertTrue(profiles.contains("git"));

        }


    }
}

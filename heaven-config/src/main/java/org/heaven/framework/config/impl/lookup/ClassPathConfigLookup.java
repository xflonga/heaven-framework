package org.heaven.framework.config.impl.lookup;

import lombok.AllArgsConstructor;
import org.heaven.framework.config.ConfigDefinition;
import org.heaven.framework.util.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 从类路径下查找配置文件
 *
 *
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
@AllArgsConstructor
public class ClassPathConfigLookup extends AbstractConfigLoolup {

    private ClassLoader classLoader;

    public ClassPathConfigLookup() {
        this(ClassUtils.getClassLoader(ClassPathConfigLookup.class, null));
    }

    @Override
    protected List<ConfigDefinition> search(String name) {
        Enumeration<URL> urls;
        try {
            urls = this.classLoader.getResources(name);
        } catch (IOException e) {
            return Collections.emptyList();
        }

        List<ConfigDefinition> configs = new ArrayList<>();
        while (urls.hasMoreElements()) {
            ConfigDefinition config = new ConfigDefinition();
            config.setName(name);

            URL url = urls.nextElement();
            URI uri = null;

            if ("file".equals(url.getProtocol())) {
                try {
                    uri = new URI(url.toString());
                    File file = new File(uri.getSchemeSpecificPart());
//                    file


                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

            } else if ("jar".equals(url.getProtocol())) {

            } else if ("war".equals(url.getProtocol())) {

            }



        }
        return null;
    }
}

package org.heaven.framework.config.util;

import org.heaven.framework.util.StringUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by xflonga on 2018/8/7
 *
 * @author xflonga
 */
public class FileUtils {

    private static Set<String> supportFileFormat = new HashSet<>(4);

    /**
     * 获取支持的文件类型
     *
     * @return
     */
    public static Set<String> getSupportFileFormat() {
        return supportFileFormat;
    }

    /**
     * 获取文件名，example：
     *
     * ""  ==>  ""
     * "/app/application.yml"  ==>  "application.yml"
     * "app/sub/application.yml"  ==>  "application.yml"
     * "app/sub/application"  ==>  "application"
     *
     * @param path 文件名，可以包含文件路径
     * @return
     */
    public static String getFilename(String path) {
        if (StringUtils.isBlank(path)) {
            return "";
        }

        int i = path.lastIndexOf(File.separator);
        if (i == -1) {
            return path;
        }

        return i == path.length() ? "" : path.substring(i + 1);
    }

    static {
        supportFileFormat.add(".yml");
        supportFileFormat.add(".yaml");
        supportFileFormat.add(".properties");
    }
}

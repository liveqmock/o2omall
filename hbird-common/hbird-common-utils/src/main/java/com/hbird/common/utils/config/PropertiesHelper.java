package com.hbird.common.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 读取配置文件.properties中的值
 * 
 * @author ljz
 * 
 */
public final class PropertiesHelper {

    private static final String SEPARATOR_COMMA = ",";
    private static final String[] CONFIG_FILES = { "conf/app.properties", "conf/authen.properties",
            "conf/important.properties" };
    private final Log logger = LogFactory.getLog(this.getClass());

    private static PropertiesHelper propertiesHelper = null;

    private Properties properties = null;

    public static PropertiesHelper newInstance() {
        if (null == PropertiesHelper.propertiesHelper) {
            PropertiesHelper.propertiesHelper = new PropertiesHelper();
        }

        return PropertiesHelper.propertiesHelper;
    }

    private PropertiesHelper() {
        this.properties = new Properties();
        load(this.properties, CONFIG_FILES);
    }

    private void load(Properties properties, String[] configFiles) {
        if (configFiles == null || configFiles.length == 0) {
            return;
        }

        for (String configFile : configFiles) {
            load(properties, configFile);
        }
    }

    private void load(Properties properties, String configFile) {
        InputStream fileInputStream = null;

        try {
            fileInputStream = PropertiesHelper.class.getResourceAsStream("/" + configFile);
            if (fileInputStream != null) {
                properties.load(fileInputStream);
            }
        } catch (IOException ioe) {
            this.logger.error("加载配置文件发生异常！", ioe);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ioe) {
                this.logger.error("关闭文件流发生异常！", ioe);
            }
        }
    }

    /**
     * 得到配置文件中对应元素值
     * 
     * @param name
     * @return
     * @throws IOException
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    /** 得到配置文件中对应元素值,以逗号隔开的数据集合 */
    public List<String> getListValue(String key) {
        return Arrays.asList(getValue(key).split(SEPARATOR_COMMA));
    }
}

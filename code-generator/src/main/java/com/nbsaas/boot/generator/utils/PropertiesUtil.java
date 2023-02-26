package com.nbsaas.boot.generator.utils;


import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @author Rhythm-2019
 * @version 1.0
 * @description: Properties工具类
 */
public class PropertiesUtil {

    /**
     * 项目中的所有配置
     */
    public static Map<String, String> constMap = new HashMap<>();

    static {
        // 加载配置文件

        File dir = new File(System.getProperty("user.dir") + "/adapters/generator2/src/main/resources/");
        List<File> fileList = FileUtil.getFileList(dir);
        try {
            for (File file : fileList) {
                if (file.getName().endsWith(".properties")) {
                    Properties properties = new Properties();
                    properties.load(new FileReader(file));

                    Map<String, String> map = PropertiesUtil.putPropertiesInMap(properties);
                    constMap.putAll(map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("遇到严重异常");
        }
    }

    /**
     * 将properties中全部放入Map中
     *
     * @param properties 配置对象
     * @return map
     */
    public static Map<String, String> putPropertiesInMap(Properties properties) {
        HashMap<String, String> map = new HashMap<String, String>();
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

    /**
     * 获取常量集合
     *
     * @return 常量集合
     */
    public static Map<String, String> getConstMap() {
        return constMap;
    }
}

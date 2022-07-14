package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env","production");
        switch (env){
            case "production":
                properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;

                case "an":
                    properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/anouther.properties");
            default:
                throw new RuntimeException("env not supported");
        }

    }


    public static ConfigUtils getInstance(){
        if (configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getUrl(){
        String prop =   properties.getProperty("baseUrl");
        if (prop != null){
            return prop;
        }else {
            throw new RuntimeException("Cant found the base url");
        }
    }


    public String getEmail(){
        String prop =   properties.getProperty("email");
        if (prop != null){
            return prop;
        }else {
            throw new RuntimeException("Cant found the email");
        }
    }


    public String getPassword(){
        String prop =   properties.getProperty("password");
        if (prop != null){
            return prop;
        }else {
            throw new RuntimeException("Cant found the password");
        }
    }


}

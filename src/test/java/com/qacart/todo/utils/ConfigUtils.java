package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private  Properties properties ;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
       String env = System.getProperty("env","PRODUCTION");
       switch (env){
           case "PRODUCTION":
               properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
               break;
           default:
               throw new RuntimeException("Environment is not supported");

       }

    }
    public static ConfigUtils getInstance(){
        if(configUtils==null){
            configUtils =new ConfigUtils();
        }
        return configUtils;
    }
    public  String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop!=null)return prop ;
            throw new RuntimeException("Could not find the base url in the property file");
    }
    public  String getemail(){
        String prop = properties.getProperty("email");
        if(prop!=null)return prop ;
        throw new RuntimeException("Could not find the email in the property file");
    }
    public  String getPassword(){
        String prop = properties.getProperty("password");
        if(prop!=null)return prop ;
        throw new RuntimeException("Could not find the password in the property file");
    }
}

package com.test;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class ProUtil {

    private Properties pro;

    //构造方法
    public ProUtil(String filePath){
        this.pro=readProperties(filePath);
    }

    //读取配置文件
    private Properties readProperties(String  filePath){
        Properties properties =new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            properties.load(bufferedInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String  getPro(String key){

        Iterator<String> it=pro.stringPropertyNames().iterator();
        while(it.hasNext()){
            String value=it.next();
            System.out.println(key+":"+pro.getProperty(key));
            return pro.getProperty(key);
        }
        return  " ";



    }

    public static void main(String[] args) throws  Exception{
        ProUtil proUtil =new ProUtil("element.properties");
        proUtil.getPro("name");
    }

}

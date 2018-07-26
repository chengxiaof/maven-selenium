package com.test;

import com.sun.java.swing.plaf.windows.TMSchema;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {

    private Properties pro;
    private  String filePath;

    //构造方法
    public ProUtil(String filePath){
        this.filePath = filePath;
    }

    //读取配置文件
    private Properties readProperties(){
        Properties prop =new Properties();

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  getPto(String key) throws Exception{



        String username = prop.getProperty(key);
        return username;
    }

    public static void main(String[] args) throws  Exception{
        ProUtil proUtil =new ProUtil();
        proUtil.getPto("username");
    }

}

package com.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.*;

public class SelectDriverTest {

    public WebDriver driverName(String browser){
        if(browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.marionette","geckodriver");
            return  new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver","chromedriver");
            return  new ChromeDriver();
        }
    }

}
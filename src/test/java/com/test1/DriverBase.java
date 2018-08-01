package com.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {
    public WebDriver driver;
    public  DriverBase(String brower){
        SelectDriverTest selectDriverTest = new SelectDriverTest();
        this.driver = selectDriverTest.driverName(brower);
    }

    public void stop(){
        driver.close();
        System.out.println("stop webdriver");
    }

    //封装element
    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

}

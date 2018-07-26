package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Login {

    public WebDriver driver;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void loginTest(){
        driver.findElement(By.id("js-signin-btn")).click();
        WebElement formElement = driver.findElement(By.id("signup-form"));
        WebElement user = formElement.findElement(By.name("email"));
        user.isDisplayed();
        WebElement pwd = formElement.findElement(By.name("password"));
        pwd.isDisplayed();
        WebElement loginButton  = formElement.findElement(By.className("moco-btn-red"));
        loginButton.isDisplayed();
        user.sendKeys("15116999073");
        pwd.sendKeys("a.123456");
        loginButton.click();
        WebElement header = driver.findElement(By.id("header-avator"));
        Actions actions =new Actions(driver);
        actions.moveToElement(header).perform();
        String name = driver.findElement(By.className("name")).getText();
        System.out.println(name);




    }

    public static void main(String[] args){

        Login  login = new Login();
        login.InitDriver();
        login.loginTest();
    }

}

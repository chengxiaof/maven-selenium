package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Login {

    public WebDriver driver;
    public  WebElement element;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    public void loginTest(){


        String username = "15116999073";
        String password = "a.123456";
        String id_jsbtn = "id";
        String id_signup = "id";
        String name_email = "name";
        String name_password = "name";
        String className_mocobtn = "className";
        String id_header = "id";
        String className = "name";


        String filePath = "element.properties";
        ProUtil proUtil = new ProUtil(filePath);
        String value = proUtil.getPro(id_jsbtn);

        ByUserElement(id_jsbtn,value).click();
        WebElement formElement = ByUserElement(id_signup,value);
        WebElement user =ByUserElement(name_email,value);
        user.isDisplayed();
        WebElement pwd = ByUserElement(name_password,value);
        pwd.isDisplayed();
        WebElement loginButton = ByUserElement(className_mocobtn,value);
        loginButton.isDisplayed();
        user.sendKeys(username);
        pwd.sendKeys(password);
        loginButton.click();
        WebElement header = ByUserElement(id_header,value);
        Actions actions =new Actions(driver);
        actions.moveToElement(header).perform();
        String name = ByUserElement(className,value).getText();
        System.out.println(name);




    }

    public  WebElement ByUserElement(String key,String name){

        switch (key){
            case "id" :element = driver.findElement(By.id(name));
            break;
            case "name" :element = driver.findElement(By.name(name));
            break;
            case "className" :element = driver.findElement(By.className(name));
            break;
            case "tagName" :element = driver.findElement(By.tagName(name));
            break;
            case "linkText" :element = driver.findElement(By.linkText(name));
            break;
            case "partialLinkText" :element = driver.findElement(By.partialLinkText(name));
            break;
            case "xpath" :element = driver.findElement(By.xpath(name));
            break;
            case "cssSelector" :element = driver.findElement(By.cssSelector(name));
            break;
            default:System.out.println("未获取到key值");
            break;

        }
        return element;
    }

    public static void main(String[] args){

        Login  login = new Login();
        login.InitDriver();
        login.loginTest();
    }

}

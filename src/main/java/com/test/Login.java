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
    String filePath = "element.properties";

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
        String id_jsbtn = "id_jsbtn";
        String id_signup = "id_signup";
        String name_email = "name_email";
        String name_password = "name_password";
        String className_mocobtn = "className_mocobtn";
        String id_header = "id_header";
        String classNames = "classNames";


       /* ByUserElement(id_jsbtn1,id_jsbtn2).click();
        WebElement formElement = ByUserElement(id_signup1,id_signup2);
        WebElement user =ByUserElement(name_email1,name_email2);
        user.isDisplayed();
        WebElement pwd = ByUserElement(name_password1,name_password2);
        pwd.isDisplayed();
        WebElement loginButton = ByUserElement(className_mocobtn1,className_mocobtn2);
        loginButton.isDisplayed();
        user.sendKeys(username);
        pwd.sendKeys(password);
        loginButton.click();
        WebElement header = ByUserElement(id_header,value);
        Actions actions =new Actions(driver);
        actions.moveToElement(header).perform();
        String name = ByUserElement(className,value).getText();
        System.out.println(name);*/




    }

    public void getValues(String param){

        ProUtil proUtil = new ProUtil(filePath);
        param = proUtil.getPro(param);
        String param1=param.split(">")[0];
        String param2=param.split(">")[1];
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

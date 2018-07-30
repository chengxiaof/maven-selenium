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


        String username = "username";
        String password = "password";
        String id_jsbtn = "id_jsbtn";
        String id_signup = "id_signup";
        String name_email = "name_email";
        String name_password = "name_password";
        String className_mocobtn = "className_mocobtn";
        String id_header = "id_header";
        String classNames = "classNames";



        ProUtil proUtil = new ProUtil(filePath);
        username = proUtil.getPro(username);
        password = proUtil.getPro(password);

        id_jsbtn = proUtil.getPro(id_jsbtn);
        String id_jsbtn1=id_jsbtn.split(">")[0];
        String id_jsbtn2=id_jsbtn.split(">")[1];

        id_signup = proUtil.getPro(id_signup);
        String id_signup1=id_signup.split(">")[0];
        String id_signup2=id_signup.split(">")[1];

        name_email = proUtil.getPro(name_email);
        String name_email1=name_email.split(">")[0];
        String name_email2=name_email.split(">")[1];

        name_password = proUtil.getPro(name_password);
        String name_password1=name_password.split(">")[0];
        String name_password2=name_password.split(">")[1];

        className_mocobtn = proUtil.getPro(className_mocobtn);
        String className_mocobtn1=className_mocobtn.split(">")[0];
        String className_mocobtn2=className_mocobtn.split(">")[1];

        id_header = proUtil.getPro(id_header);
        String id_header1=id_header.split(">")[0];
        String id_header2=id_header.split(">")[1];

        classNames = proUtil.getPro(classNames);
        String classNames1=classNames.split(">")[0];
        String classNames2=classNames.split(">")[1];


        ByUserElement(id_jsbtn1,id_jsbtn2).click();
        WebElement formElement = ByUserElement(id_signup1,id_signup2);

        //user.isDisplayed();

        //pwd.isDisplayed();

        //loginButton.isDisplayed();
        formElement.findElement(By.name(name_email2)).sendKeys(username);
        formElement.findElement(By.name(name_password2)).sendKeys(password);
        formElement.findElement(By.className(className_mocobtn2)).click();
        WebElement header = ByUserElement(id_header1,id_header2);
        Actions actions =new Actions(driver);
        actions.moveToElement(header).perform();
        String name = ByUserElement(classNames1,classNames2).getText();
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

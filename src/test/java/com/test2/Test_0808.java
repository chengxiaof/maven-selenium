package com.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.bind.Element;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test_0808 {
    WebDriver driver;
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void Login(){
        driver.findElement(By.id("js-signin-btn")).click();
        WebElement form = driver.findElement(By.id("signup-form"));
        form.findElement(By.name("email")).sendKeys("15116999073");
        form.findElement(By.name("password")).sendKeys("a.123456");
        form.findElement(By.className("moco-btn-red")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("header-avator"))).perform();
        String name =driver.findElement(By.className("name")).getText();

        System.out.println(name);

    }

    public void SelectText(){
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.xpath("//*[@id=\"setting-profile\"]/div[2]/a")).click();
        WebElement form =driver.findElement(By.id("profile"));
        WebElement SelectElement =form.findElement(By.name("job"));
        Select select = new Select(SelectElement);
        select.selectByValue("11");
        select.selectByIndex(10);
        select.selectByVisibleText("java工程师");
    }

    //切换窗口
    public void windowHandle(){
        WebElement js =driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[9]/div[2]/a/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(js).perform();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[3]/div[1]/div/div/div/div[2]/a[11]")).click();
         String search_handle =driver.getWindowHandle();
         Set<String> handles= driver.getWindowHandles();
         for(String handle:handles){
             if(handle.equals(search_handle)==false){
                 driver.switchTo().window(handle);
                 driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[2]/div/div[3]/div/ul/li[3]/a")).click();


             }
         }
    }

    public static  void main(String[] args){
        Test_0808 test = new Test_0808();
        test.initDriver();
        test.Login();
        test.SelectText();


    }
}

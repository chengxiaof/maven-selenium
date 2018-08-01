package com.test1;

import com.test.LoginTest;
import org.openqa.selenium.WebElement;

public class loginPage extends BasePage {
    public loginPage(DriverBase driver) {
        super(driver);
    }

    //获取用户名
    public WebElement getUserElement(){
       return element(getByLocator.getLocator("name_email"));
    }

    //获取密码
    public WebElement getPasswordElement(){
        return element(getByLocator.getLocator("name_password"));
    }

    //获取登录按钮
    public WebElement getLoginButtonElement(){
        return element(getByLocator.getLocator("className_mocobtn"));
    }


}

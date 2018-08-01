package com.test1;

public class loginPageHandle {
    public DriverBase driver;
    public loginPage lp;
    public  loginPageHandle(DriverBase driver){
        this.driver = driver;
        lp = new loginPage(driver);
    }

    //输入用户名称
    public  void sendKeysUser(String username){
        lp.sendKeys(lp.getUserElement(),username);
    }

    //输入密码
    public  void sendKeysPass(String password){
        lp.sendKeys(lp.getUserElement(),password);
    }

    //点击登录
    public  void clickLoginButton(){
        lp.click(lp.getLoginButtonElement());
    }

    //判断是否是登录页面
    public boolean assertLoginPage(){
        return
    }


}

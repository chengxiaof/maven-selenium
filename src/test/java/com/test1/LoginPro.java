package com.test1;

public class LoginPro {
    public loginPageHandle lph;
    public LoginPro(DriverBase driver){
        lph = new loginPageHandle(driver);
    }

    public void login(String username,String password){
        lph.sendKeysUser(username);
        lph.sendKeysPass(password);
        lph.clickLoginButton();
    }
}

package com.framework.businessLogic;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import org.omg.Dynamic.Parameter;
import org.openqa.selenium.WebDriver;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/15 - 15:53
 * @Copyright lenovo
 */
public class LoginFlow {
    WebDriver driver;
    public LoginFlow(WebDriver driver){
        this.driver=driver;
    }
    public HomePage login(String phone,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.inputPhone(phone);
        loginPage.inputPassword(password);
        return loginPage.clickLogin();
    }
}

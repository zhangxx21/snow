package com.framework.pages;

import com.framework.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/14 - 18:07
 * @Copyright lenovo
 */
public class LoginPage extends BasePage {
    //用户名
    private By phoneBy = By.xpath("//input[@placeholder='请输入手机号/用户名']");
    //密码
    private By passwordBy = By.xpath("//input[@placeholder='请输入密码']");
    //登录按钮
    private By loginButton = By.xpath("//a[@class='login-button']");
    //登录失败信息
    private By loginFailBy = By.xpath("//p[@class='el-message__content']");

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public String getErrorAccountPwdText(){return getText(driver,loginFailBy,"获取登录失败文本");}
//    输入手机号
    public void inputPhone(String phone){
        type(driver,phoneBy,phone,"输入手机号");
    }
//    输入密码
    public void inputPassword(String inputPassword){
        type(driver,passwordBy,inputPassword,"输入密码");
    }
//    点击登录按钮
    public HomePage clickLogin(){
        click(driver,loginButton,"点击登录");
        return new HomePage(driver);
    }

}

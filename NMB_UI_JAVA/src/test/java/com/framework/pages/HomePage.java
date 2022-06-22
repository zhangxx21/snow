package com.framework.pages;

import com.framework.common.BasePage;
import org.apache.tools.ant.taskdefs.optional.pvcs.Pvcs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/15 - 14:58
 * @Copyright lenovo
 */
public class HomePage extends BasePage {
    //进入登陆页面
    private By loginBy=By.xpath("//a[@class='link-a'][text()='登录']");
    //登录成功提示
    private By tipsBy=By.xpath("//span[text()='欢迎来到柠檬班']");
    //用户名
    private By nickNameBy = By.xpath("//a[@class='link-name']");
    //退出登录
    private By quitLoginBy = By.xpath("//a[text()='退出登录']");
    //购物车
    private By cartBy = By.xpath("//span[@data-route='cart']");
    WebDriver driver;

    public HomePage(WebDriver driver){this.driver=driver;}
    //登录成功提示
    public Boolean isTipsExist(){
        return waitElementVisible(driver,tipsBy).isDisplayed();
    }
    //用户名
    public Boolean isNickNameExist(){
        return waitElementVisible(driver,nickNameBy).isDisplayed();
    }
    public void quitLogin(){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitElementVisible(driver,nickNameBy)).perform();
        //1-2、点击退出登录
        click(driver,quitLoginBy,"点击退出登录");

    }
    public void login(WebDriver driver){
        click(driver,loginBy,"点击登录");
    }

}

package com.framework.testcases;

import com.framework.businessLogic.LoginFlow;
import com.framework.common.BaseTest;
import com.framework.config.GlobalDatas;
import com.framework.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/14 - 17:14
 * @Copyright lenovo
 */
public class TestCart extends BaseTest {
    @BeforeTest
    public void setup(){
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        maxBrowse();
        //2、进入登录页面
        toUrl(GlobalDatas.INDEX_URL);
        HomePage homePage = new HomePage(driver);
        homePage.login(driver);
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(GlobalDatas.USER_NAME,GlobalDatas.USER_PASSWORD);
    }

    @Test
    public void test_add_cart() throws InterruptedException {

        //用例步骤
        sleepTime(500);
//        waitElementClickable(driver,By.xpath("//a[text()='商品列表']")).click();
//        Thread.sleep(500);
//        waitElementClickable(driver,By.xpath("//div[text()='092949-BXqRZ']")).click();
//
//        //获取商品的名称
//        String goodsTitle = waitElementVisible(driver,By.xpath("//div[@class='name-box']/div[@class='name']")).getText();
//        //2、添加到购物车
//        waitElementClickable(driver,By.xpath("//a[@class='add-cart']")).click();
//        //断言
//        //进入到购物车
//        waitElementClickable(driver,By.xpath("//span[@data-route='cart']")).click();
//        //1、商品的名称
//        String goodsTitleCart = waitElementVisible(driver,By.xpath("//a[@class='name']")).getText();
//        Assert.assertEquals(goodsTitleCart,goodsTitle);


    }

    @AfterTest
    public void teardown(){
        HomePage homePage = new HomePage(driver);
        //退出登录
        homePage.quitLogin();
        //关闭浏览器
        closeBrowse();
    }



}

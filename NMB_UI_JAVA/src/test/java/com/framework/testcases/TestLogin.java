package com.framework.testcases;

import com.framework.businessLogic.LoginFlow;
import com.framework.common.BaseTest;
import com.framework.config.GlobalDatas;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import io.qameta.allure.Description;
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
import org.testng.annotations.*;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/14 - 15:20
 * @Copyright lenovo
 */
public class TestLogin extends BaseTest {

    @BeforeMethod
    public void setup(){
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        driver.manage().window().maximize();
        //2、进入登录页面
        driver.get(GlobalDatas.INDEX_URL);
        HomePage homePage = new HomePage(driver);
        homePage.login(driver);
    }

    @Test
    public void test_login_success(){
        //用例步骤
        LoginFlow loginFlow = new LoginFlow(driver);
        HomePage homePage = loginFlow.login(GlobalDatas.USER_NAME,GlobalDatas.USER_PASSWORD);
        myAssertTrue(homePage.isTipsExist(),"主页的提示->欢迎来到柠檬班");
        myAssertTrue(homePage.isNickNameExist(),"主页的昵称");
        homePage.quitLogin();
    }
    @Test(dataProvider = "loginFailData")
    @Description("手机号码10位/手机号码12位/手机号码未注册")
    public void testLoginFail(String phone,String pwd){
        LoginFlow loginFlow = new LoginFlow(driver);
        HomePage homePage = loginFlow.login(phone,pwd);
        LoginPage loginPage = new LoginPage(driver);
        String actual =  loginPage.getErrorAccountPwdText();
        myAssertEquals(actual,"账号或密码不正确xx","登录失败提示信息");
    }
    @DataProvider
    public Object[][] loginFailData(){
        Object[][] datas = {
                {"1897469276","123456"},
                {"1897469276223","123456"},
                {"15648881680","123456"}
        };
        return datas;
    }

    @AfterMethod
    public void teardown(){
        //用例后置
        //1、退出登录
        //1-1、鼠标移动到用户名上

        //2、关闭浏览器
        driver.quit();
    }


}

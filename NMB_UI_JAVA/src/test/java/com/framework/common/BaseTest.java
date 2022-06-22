package com.framework.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/15 - 14:16
 * @Copyright lenovo
 */
public class BaseTest {
    private static Logger logger = Logger.getLogger(BasePage.class);
    public WebDriver driver;

    /**
     * 打开所有浏览器通用方法封装
     *
     * @param browserName 浏览器名
     */
    public void openBrowser(String browserName) {
        WebDriver webDriver = null;
        if ("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browserName)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略浏览器缩放设置
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            webDriver = new InternetExplorerDriver(capabilities);
        }
        driver=webDriver;
    }
    public void myAssertTrue(Boolean condition,String assertDescription){
        logger.info("断言：【"+assertDescription+"】条件表达式【"+condition+"】");
        Assert.assertTrue(condition);
    }
    public void myAssertEquals(String actual,String expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }
    public static void sleepTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 最大化浏览器
     */
    public void maxBrowse(){
        logger.info("===================最大化浏览器====================");
        driver.manage().window().maximize();
    }
    public void toUrl(String url){
        logger.info("访问网址【"+url+"】");
        driver.get(url);
    }

    /**
     * 关闭浏览器
     * @param
     */
    public void closeBrowse(){
        logger.info("===================关闭浏览器====================");
        driver.quit();
    }
}

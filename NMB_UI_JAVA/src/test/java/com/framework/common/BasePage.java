package com.framework.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author zhangxx
 * @Description coding is everything
 * @date 2022/6/15 - 14:16
 * @Copyright lenovo
 */
public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);
    /**
     * 显式等待元素可见二次封装
     * @param driver
     * @param by
     */
    public WebElement waitElementVisible(WebDriver driver, By by ){
        WebElement webElement = null;
        try {
            //1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.error("定位元素【"+by+"】异常");
        }
        return webElement;
    }

    /**
     * 显式等待元素可被点击二次封装
     * @param driver
     * @param by
     */
    public WebElement waitElementClickable(WebDriver driver, By by ){
       WebElement webElement = null;
        try {
            //1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("定位元素【"+by+"】异常");
        }
        return webElement;
    }

    /**
     * 输入操作通用方法
     * @param driver 驱动对象
     * @param by 元素定位信息
     * @param s 输入文本
     */
    public void type(WebDriver driver,By by,String s,String desc){
        logger.info("对元素【"+desc+"】进行输入文本【"+s+"】");
        waitElementVisible(driver,by).sendKeys(s);
    }
    /**
     * 点击操作通用方法
     * @param driver 驱动对象
     * @param by 元素定位信息
     *
     */
    public void click(WebDriver driver,By by,String desc){
        logger.info("对元素【"+desc+"】进行点击");
        waitElementVisible(driver,by).click();
    }
    /**
     * 获取元素文本信息通用方法
     * @param driver 驱动对象
     * @param by 元素定位信息
     *
     */
    public String  getText(WebDriver driver,By by,String desc){
        String text=waitElementVisible(driver,by).getText();
        logger.info("获取元素【"+desc+"】文本【"+text+"】");
        return text;
    }
}

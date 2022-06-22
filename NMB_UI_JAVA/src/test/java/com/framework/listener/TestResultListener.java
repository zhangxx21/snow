package com.framework.listener;


import com.framework.common.BaseTest;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestResultListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //保证@Test注解标注的测试方法能够正常执行
        callBack.runTestMethod(testResult);
        //判断用例结果是否异常  （不为空表示有异常，为空表示没有异常）
        if(testResult.getThrowable() != null){
            //testResult参数提供了getInstance方法，可以获取当前测试类的实例（对象）
            //通过父类类型接收子类对象
            BaseTest baseTest = (BaseTest) testResult.getInstance();
            //加上当前时间戳解决图片覆盖问题 System.currentTimeMillis()
            //takeScreenhot(baseTest.driver,"testCart_"+System.currentTimeMillis());
            //生成字节类型截图数据
            byte[] data = takeScreenhotAsByte(baseTest.driver);
            saveScreenhotToAllue(data);


        }
    }
    //@Attachment value参数是为你的附件的名字 type参数是为你的附件类型
    @Attachment(value = "screenshot",type = "image/png")
    public byte[] saveScreenhotToAllue(byte[] data){
        //返回字节类型数据，作为附件添加到Allue报表中---》通过@Attachment注解来实现的
        return data;
    }

    /**
     * 生成字节数组截图数据
     * @param driver
     * @return
     */
    public byte[] takeScreenhotAsByte(WebDriver driver){
        // 类型强制转换
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // OutputType.FILE -->返回类型为File(图片)
        byte[] data= takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return data;


    }
    /**
     * 生成截图为普通文件形式，并保存到本地
     * @param driver
     * @param filename
     */
    public void takeScreenhot(WebDriver driver, String filename){
        // 类型强制转换
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // OutputType.FILE -->返回类型为File(图片)
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // 把file（图片）保存到本地
        // 给一个目标地址的File对象
        File destFile = new File(System.getProperty("user.dir")+"\\screenshot\\"+filename+".png");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

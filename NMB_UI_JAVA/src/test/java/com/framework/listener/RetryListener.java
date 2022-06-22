package com.framework.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    private int maxRetryCount = 2;
    private int currentReturyCount = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        //Returns true if the test method has to be retried, false otherwise.
        //如果你的测试方法要重新运行的话，那么当前retry方法返回true即可
        System.out.println("执行到retry方法这里");
        //限制重试的最大次数，否则会进入死循环
        if(currentReturyCount < maxRetryCount){
            //如果当前的重试次数没有达到限制，就去执行重试机制
            currentReturyCount++;
            return true;
        }else {
            return false;
        }
    }
}

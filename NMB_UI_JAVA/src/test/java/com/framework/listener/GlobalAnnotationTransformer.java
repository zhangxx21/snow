package com.framework.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GlobalAnnotationTransformer implements IAnnotationTransformer {
    //This method will be invoked by TestNG to give you a chance to modify a TestNG annotation read
    //   * from your test classes
    //通过实现IAnnotationTransformer接口将会给予你这样的能力：动态的修改@Test注解的属性
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // 获取@Test注解的RetryAnalyzer属性对象
        IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
        if (iRetryAnalyzer == null) {
            annotation.setRetryAnalyzer(RetryListener.class);
        }
    }

}

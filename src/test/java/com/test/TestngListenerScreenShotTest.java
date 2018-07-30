package com.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static org.testng.Assert.*;

public class TestngListenerScreenShotTest extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        takeScreenShot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
    }
    @Override
    public void onStart(ITestContext iTestContext) {
       super.onStart(iTestContext);
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);
    }

    private void takeScreenShot(ITestResult iTestResult){
        LoginTest loginTest = (LoginTest) iTestResult.getInstance();
        loginTest.takeScreenShot();
    }

}
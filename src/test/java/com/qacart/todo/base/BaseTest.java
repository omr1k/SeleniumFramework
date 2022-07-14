package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal <WebDriver> driver = new ThreadLocal<>();


    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    @BeforeMethod
    public void before(){

        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void after(ITestResult result){
        String testCaseName = result.getMethod().getMethodName();
        File desFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName+ ".png");
        takeScreenShot(desFile);
        getDriver().quit();
    }


    public void injectCookiesBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> selCookies =  CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie : selCookies){
            getDriver().manage().addCookie(cookie);
        }
    }


    public void takeScreenShot(File destFile){
        File screenShotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile,destFile);
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookiesUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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

import static java.sql.DriverManager.getDriver;


public class BaseTest {
    protected ThreadLocal<WebDriver> driver=new ThreadLocal<>();
public void setDriver(WebDriver driver){
    this.driver.set(driver);
}
public WebDriver getDrive(){
    return this.driver.get();
}
    @BeforeMethod
    public void setup (){

        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
    }
    @AfterMethod
    public void teardown(ITestResult result){
    String testCaseName =result.getMethod().getMethodName();
    File destFile =new File("target"+File.separator+"screenshoots"+File.separator+testCaseName+".png");
    takeScreenShoot(destFile);

        getDrive().quit();
    }
    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie>seleniumCookies=CookiesUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);

for(org.openqa.selenium.Cookie cookie :seleniumCookies){
    getDrive().manage().addCookie(cookie);
}
    }
    public void takeScreenShoot(File destfile){
        File file =((TakesScreenshot) getDrive()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destfile);
            InputStream is=new FileInputStream(destfile);
            Allure.addAttachment("screenshoot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

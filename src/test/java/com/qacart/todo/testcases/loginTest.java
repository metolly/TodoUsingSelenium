package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature ")
public class loginTest extends BaseTest {
@Story("Login with email and password")
@Description("It will login by using email and password and navigate to the todo page ")
    @Test(description = "Test the login functionality using email and password")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginPage =new LoginPage(getDrive());
        boolean iswelcomed =loginPage
                .load()
                .login(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getPassword())
                .isdisplayed();
        Assert.assertTrue(iswelcomed);


    }
}

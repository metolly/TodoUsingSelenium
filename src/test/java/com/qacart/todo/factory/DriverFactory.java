package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class DriverFactory {


    public WebDriver initializeDriver(){
String browser = System.getProperty("browser" ,"CHROME");
        WebDriver driver;
        switch (browser){
        case "CHROME":
            driver =new ChromeDriver();
            break;
        case "FIREFOX":
        driver =new FirefoxDriver();
            break;
        case "SAFARI":
        driver =new SafariDriver();
            break;
        default:
            throw new RuntimeException("the browser is not supported");
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
}
}

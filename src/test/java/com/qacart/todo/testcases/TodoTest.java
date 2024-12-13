package com.qacart.todo.testcases;

import com.qacart.todo.apis.RegisterApi;
import com.qacart.todo.apis.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {
@Story("Add Todo")
    @Test(description = "Should be able to add new todo correctly ")
    public void shouldBeAbleToAddNewToDo(){
        RegisterApi registerApi =new RegisterApi();
        registerApi.register();
        TodoPage todoPage =new TodoPage(getDrive());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        String actualResult=todoPage.load().clickOnPlusButton().submit_newtask("mostafa").getTodo_ItemText();

        Assert.assertEquals(actualResult ,"mostafa");

    }
    @Story("delete Todo")

    @Test(description = "Should be able to add delete todo correctly ")
    public void shouldBeAbleToDeleteToDo(){
RegisterApi registerApi =new RegisterApi();
registerApi.register();
        TaskApi taskApi =new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());
TodoPage todoPage =new TodoPage(getDrive());
todoPage.load();
injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        boolean isNoTodoMessageDisplayed =todoPage.load().deleteButton().noTodos();
        Assert.assertTrue(isNoTodoMessageDisplayed);

    }
}

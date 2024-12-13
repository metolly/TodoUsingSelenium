package com.qacart.todo.pages;

import com.qacart.todo.apis.RegisterApi;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {


    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;
    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;
    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todo_item;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement no_todos;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;
    public TodoPage deleteButton(){
        deleteButton.click();
        return this;
    }
    @Step
    public TodoPage load(){
        driver.get("https://todo.qacart.com/todo");
        return this;
    }
    @Step
    public boolean isdisplayed (){
        return welcomeMessage.isDisplayed();
    }
    @Step
    public String getTodo_ItemText(){
        return todo_item.getText();
    }
    @Step
    public boolean noTodos(){
        return no_todos.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
}

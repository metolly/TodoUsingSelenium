package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement new_todo;
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submit_newTask;
    @Step
    public TodoPage submit_newtask (String item){
        new_todo.sendKeys(item);
        submit_newTask.click();
        return new TodoPage(driver);
    }

}

package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToDoPage extends BasePage {
    public NewToDoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement toDoText;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement clickAdd;


    public ToDoPage AddToDoText(String text){
        toDoText.sendKeys(text);
        clickAdd.click();
        return new ToDoPage(driver);
    }

    public NewToDoPage newToDoPageLoad(){
        driver.get(ConfigUtils.getInstance().getUrl()+ EndPoints.NEW_TODO_ENDPOINT);
        return this;
    }




}

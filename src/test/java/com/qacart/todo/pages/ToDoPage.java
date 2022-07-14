package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPage extends BasePage {


    public ToDoPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/h2")
    private WebElement afterLoginMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addbutton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement getToDotext;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/button")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/h4")
    private WebElement NoToDosMessage;



    @Step
    public boolean isMessageDisplayed(){
        return afterLoginMessage.isDisplayed();
    }

    public NewToDoPage pressPlus(){

        addbutton.click();
        return new NewToDoPage(driver);
    }

    public String getToDoText(){

        return getToDotext.getText();
    }


    public ToDoPage DeleteToDo(){

        deleteButton.click();
        return this;
    }

    public boolean NoToDoMessage(){

        return NoToDosMessage.isDisplayed();
    }

    public ToDoPage toDoLoad(){
        driver.get(ConfigUtils.getInstance().getUrl()+ EndPoints.TODO_PAGE_ENDPOINT);
        return this;
    }

}

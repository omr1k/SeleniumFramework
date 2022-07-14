package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/button/span[1]")
    private WebElement submit;


    @Step ("load step")
    public LoginPage load(){
        driver.get(ConfigUtils.getInstance().getUrl());
        return this;
    }

    @Step
    public ToDoPage login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new ToDoPage(driver);
    }

}

package com.qacart.todo.testcases;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.Api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.objects.Task;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

@Feature("To do test class")
public class ToDoTest extends BaseTest {




    //Before Dealing with api as test cases
    @Story("Add Method story")
    @Test (description = "Add todo method")
    public void AddToDoTest(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewToDoPage newToDoPage = new NewToDoPage(getDriver());

        newToDoPage.newToDoPageLoad();

        injectCookiesBrowser(registerApi.getRestAssuredCookies());

        String actual = newToDoPage
                .newToDoPageLoad()
                .AddToDoText("Test 1")
                .getToDoText();
        Assert.assertEquals(actual,"Test 1");

//        LoginPage loginPage = new LoginPage(driver);
//        String actual = loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .pressPlus()
//                .AddToDoText("Test 1")
//                .getToDoText();
//        Assert.assertEquals(actual,"Test 1");

    }

    @Story("Delete Method story")
    @Test (description = "delete todo method")
    public void deleteToDo(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        ToDoPage toDoPage = new ToDoPage(getDriver());
        toDoPage.toDoLoad();
        injectCookiesBrowser(registerApi.getRestAssuredCookies());

        boolean noDataWordIsDisplayed =
                toDoPage
                        .toDoLoad()
                        .DeleteToDo()
                        .NoToDoMessage();
        Assert.assertTrue(noDataWordIsDisplayed);



//        LoginPage loginPage = new LoginPage(driver);
//        boolean noDataWordIsDisplayed = loginPage.load()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .pressPlus()
//                .AddToDoText("Test 1")
//                .DeleteToDo()
//                .NoToDoMessage();
//        Assert.assertTrue(noDataWordIsDisplayed);


    }



}

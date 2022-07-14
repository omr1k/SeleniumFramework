package com.qacart.todo.testcases;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.CookieUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static java.lang.Thread.*;

@Feature("LogIn Class")
public class LoginTest extends BaseTest {
    @Story("Login Method story")
    @Description("This decs. text will show on Right hand side on the screen ")
    @Test (description = "Test Login method")
    public void loginWithEmailAndPassword(){

        LoginPage loginPage = new LoginPage(getDriver());
        boolean massageIsDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isMessageDisplayed();
        Assert.assertTrue(massageIsDisplayed);
    }



    @Test (enabled = false , description = "Mutable method")
    public void TestCookiesInjection() throws InterruptedException {

        getDriver().get("https://qacart-todo.herokuapp.com/");

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        injectCookiesBrowser(registerApi.getRestAssuredCookies());

        getDriver().get("https://qacart-todo.herokuapp.com/");

        sleep(3000);
    }

}













//        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("hatem@example.com"); //Fill email failed
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/input")).sendKeys("123456"); //Fill passord failed
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button/span[1]")).click(); // Click login button
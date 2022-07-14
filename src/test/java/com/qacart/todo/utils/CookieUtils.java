package com.qacart.todo.utils;

import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {


    public static List<Cookie> convertRestAssuredCookiesToSeleniumCookies(List<io.restassured.http.Cookie> restAssuredCookies){
        List<Cookie> SeleniumCookies = new ArrayList<>();
        for (io.restassured.http.Cookie cookie : restAssuredCookies){
            org.openqa.selenium.Cookie SeleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            SeleniumCookies.add(SeleniumCookie);
        }
        return SeleniumCookies;
    }

}

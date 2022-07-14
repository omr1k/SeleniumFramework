package com.qacart.todo.testcases;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.objects.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DummyAPi {
    public static void main (String[] args){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println("Token ----->>>> "+registerApi.getAccessToken());
        System.out.println("first name ------>>>>> "+registerApi.getFirstName());
        System.out.println("user ID ------>>>>> "+registerApi.getUserID());
//        System.out.println("cookies ------>>>>> "+registerApi.getRestAssuredCookies());


    }
}

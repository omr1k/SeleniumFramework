package com.qacart.todo.Api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userID;
    private String firstName;


    public String getUserID() {
        return this.userID;
    }

    public String getFirstName() {
        return this.firstName;
    }



    public List<Cookie> getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    public String getAccessToken() {
        return this.accessToken;
    }




    Response response;

    public void register(){

        User user = UserUtils.generateRandomUser();

        response =
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                        .when()
                        .post(EndPoints.API_REGISTER_ENDPOINT)
                        .then()
                        .extract().response();


        restAssuredCookies =  response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");

        if (response.statusCode() != 201){
            System.out.println(response.prettyPrint());
            throw  new RuntimeException("Status code error");

        }

    }

}

package com.qacart.todo.Api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {

    public void addTask(String token){
        Task task = new Task("task 11",false);

        Response response = given()
                .baseUri(ConfigUtils.getInstance().getUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
        .when()
                .post(EndPoints.API_TASK_ENDPOINT)
        .then()
                .log().all().extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Status code error");
        }

    }

}

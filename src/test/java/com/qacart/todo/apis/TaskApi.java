package com.qacart.todo.apis;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.object.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {

    public void addTask(String token){
        Task task =new Task("mostafa",false);
        Response response = given().baseUri("https://todo.qacart.com")
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
                .when().post(EndPoint.API_TASK_ENDPOINT)
                .then().log().all().extract().response();
    if(response.statusCode()!=201){throw new RuntimeException("some thing went wrong ");
    }
    }
}

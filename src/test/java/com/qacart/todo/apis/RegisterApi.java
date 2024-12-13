package com.qacart.todo.apis;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.object.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;

    public String getUserId() {
        return userId;
    }

    private String userId ;

    public String getFirstName() {
        return firstName;
    }

    private String  firstName ;
    public String getAccessToken() {
        return accessToken;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    private String accessToken ;
    public void register(){
        User user =UserUtils.generateRandomUser();
        Response response =given().baseUri("https://todo.qacart.com")
                .header("Content-Type","application/json")
                .body(user)
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                .extract().response();
        restAssuredCookies = response.detailedCookies().asList();
        accessToken =response.path("access_token");
        firstName =response.path("firstName");
        userId =response.path("userId");

    }
}

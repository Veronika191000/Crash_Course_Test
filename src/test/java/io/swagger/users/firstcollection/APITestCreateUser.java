package io.swagger.users.firstcollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestCreateUser {
    @Test
    public void testCodeResponsePostRequest() {
        UserModel userModel = new UserModel(34895, "alex123", "Alex", "Storm", "a.storm@gmail.com",
                "12309", "0660579265", 0);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(userModel).post("https://petstore.swagger.io/v2/user");

        //Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code");
    }
}

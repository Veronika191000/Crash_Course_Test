package io.swagger.users.secondcollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.users.firstcollection.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestsChangeUser {
    @Test
    public void testCodeResponsePutRequest() {
        UserModel userModel = new UserModel(24947, "olivq9", "Olivia", "King",
                "o.smith@gmail.com", "232323", "0660433782", 0);
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(userModel).put("https://petstore.swagger.io/v2/user/" + userModel.getUsername());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code");
    }

}

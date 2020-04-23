package io.swagger.users.firstcollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestRemoveUser {
    @Test
    public void testCodeResponseDeleteRequest() {
        //Delete User
        Response deleteResponse = RestAssured.delete("https://petstore.swagger.io/v2/user/" + "alex123");
        //Verify response 200
        Assert.assertEquals(deleteResponse.getStatusCode(), 200, "Expected response to have status code 200 but got another code");
    }
}

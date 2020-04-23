package io.swagger.users.firstcollection;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITestGetUser {
    @Test
        public void testAllFieldsOfResponseGetRequest() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/user/alex123");

        //Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code");

        //Verify All fields
        SoftAssert softAssert = new SoftAssert();
        int userId = response.jsonPath().getInt("id");
        softAssert.assertTrue(userId > 0);

        String userName = response.jsonPath().getString("username");
        softAssert.assertEquals(userName, "alex123", "username in response is not expected!");

        String userFirstName = response.jsonPath().getString("firstName");
        softAssert.assertEquals(userFirstName, "Alex", "firstName in response is not expected!");

        String userLastName = response.jsonPath().getString("lastName");
        softAssert.assertEquals(userLastName, "Storm", "lastName in response is not expected!");

        String userEmail = response.jsonPath().getString("email");
        softAssert.assertEquals(userEmail, "a.storm@gmail.com", "email in response is not expected!");

        String userPassword = response.jsonPath().getString("password");
        softAssert.assertEquals(userPassword, "12309", "password in response is not expected!");

        String userPhone = response.jsonPath().getString("phone");
        softAssert.assertEquals(userPhone, "0660579265", "phone in response is not expected!");

        int userStatus = response.jsonPath().getInt("userStatus");
        softAssert.assertEquals(userStatus, 0, "userStatus in response is not expected!");

        softAssert.assertAll();
    }
}

package io.swagger.users.secondcollection;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITestsGetUser {
    @Test
    public void testAllFieldsOfResponseGetRequest() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/user/olivq9");

        //Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code");

        //Verify All fields
        SoftAssert softAssert = new SoftAssert();
        int userId = response.jsonPath().getInt("id");
        softAssert.assertTrue(userId > 0);

        String userName = response.jsonPath().getString("username");
        softAssert.assertEquals(userName, "olivq9", "username in response is not expected!");

        String userFirstName = response.jsonPath().getString("firstName");
        softAssert.assertEquals(userFirstName, "Olivia", "firstName in response is not expected!");

        String userLastName = response.jsonPath().getString("lastName");
        softAssert.assertEquals(userLastName, "King", "lastName in response is not expected!");

        String userEmail = response.jsonPath().getString("email");
        softAssert.assertEquals(userEmail, "o.smith@gmail.com", "email in response is not expected!");

        String userPassword = response.jsonPath().getString("password");
        softAssert.assertEquals(userPassword, "232323", "password in response is not expected!");

        String userPhone = response.jsonPath().getString("phone");
        softAssert.assertEquals(userPhone, "0660433782", "phone in response is not expected!");

        int userStatus = response.jsonPath().getInt("userStatus");
        softAssert.assertEquals(userStatus, 0, "userStatus in response is not expected!");

        softAssert.assertAll();

    }
}

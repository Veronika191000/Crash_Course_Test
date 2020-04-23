package io.swagger.users.secondcollection;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITestsRemoveAllUsers {

    @Test
    public void testCodeResponseDeleteRequestFirstUser(){
        //Delete User
        Response response = RestAssured.delete("https://petstore.swagger.io/v2/user/jos321" );
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code ");
        response.print();
    }

    @Test
    public void testCodeResponseDeleteRequestSecondUser(){
        //Delete User
        Response response = RestAssured.delete("https://petstore.swagger.io/v2/user/olivq9" );
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code ");
        response.print();
    }

    @Test
    public void testCodeResponseDeleteRequestThirdUser(){
        //Delete User
        Response deleteResponse3 = RestAssured.delete("https://petstore.swagger.io/v2/user/georg5678" );
        Assert.assertEquals(deleteResponse3.getStatusCode(), 200, "Expected response to have status code 200 but got another code ");
        deleteResponse3.print();
    }
}

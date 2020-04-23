package io.swagger.users.secondcollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.users.firstcollection.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class APITestCreateListUsers {
    @Test
    public void testCodeResponsePostRequestListUser() {
        UserModel userModel1 = new UserModel(24946, "jos321", "Joseph", "Davies",
                "j.davies@gmail.com", "56231", "277801276", 1);
        UserModel userModel2 = new UserModel(24947, "olivq9", "Olivia", "Smith",
                "o.smith@gmail.com", "028gh", "32478239", 0);
        UserModel userModel3 = new UserModel(24948, "georg5678", "Gerorge", "Wilson",
                "g.wilson@gmail.com", "02fc", "3456745", 1);

        List<Object> list = new ArrayList<Object>();
        list.add(userModel1);
        list.add(userModel2);
        list.add(userModel3);

        //Verify response 200
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(list.toString()).post("https://petstore.swagger.io/v2/user/createWithList");
        Assert.assertEquals(response.getStatusCode(), 200, "Expected response to have status code 200 but got another code");
    }
}

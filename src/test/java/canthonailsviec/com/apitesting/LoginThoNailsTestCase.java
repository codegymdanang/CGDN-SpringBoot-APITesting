package canthonailsviec.com.apitesting;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginThoNailsTestCase {

    private static final String API_ROOT = "https://api.canthonailsviet.com/";

    @Test
    public void WhenLoginOkOrNot() {
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("email","lenguyenthanhtuyen97@gmail.com");
        loginCredentials.addProperty("password","tuyen123123");
        loginCredentials.addProperty("role","manicurist");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-type","application/json");
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("/auth/login");
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

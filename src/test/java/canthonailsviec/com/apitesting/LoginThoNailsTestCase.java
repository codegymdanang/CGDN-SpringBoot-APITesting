package canthonailsviec.com.apitesting;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class LoginThoNailsTestCase {

    private static final String API_ROOT = "https://api.canthonailsviet.com";

    @Test
    public void WhenLoginOkOrNot() {
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("email","lenguyenthanhtuyen97@gmail.com");
        loginCredentials.addProperty("password","tuyen123123");
        loginCredentials.addProperty("role","manicurist");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("/auth/login");
        response.getBody().toString();
        System.out.println(response.getBody().prettyPeek());
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}
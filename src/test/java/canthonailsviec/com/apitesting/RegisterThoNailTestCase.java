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
public class RegisterThoNailTestCase {
    private static final String API_ROOT = "https://api.canthonailsviet.com";

    @Test
    public void WhenRegisterOkOrNot(){
        JsonObject registerCrendentials = new JsonObject();
        registerCrendentials.addProperty("email","lenguyenthanhtuyen97+28@gmail.com");
        registerCrendentials.addProperty("firstName","tuyen");
        registerCrendentials.addProperty("lastName","thanh");
        registerCrendentials.addProperty("password","tinhtuyen2501");
        registerCrendentials.addProperty("role","manicurist");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(registerCrendentials.toString());
        Response response = httpRequest.post("/auth/signup");
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

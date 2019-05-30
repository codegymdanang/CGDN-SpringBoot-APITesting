package juniorviec.com.apitesting;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class ContactAdminTestCase {

    private static final String API_ROOT = "https://api.juniorviec.com";

    @Test
    public void whenSearchAJobReturnOKOrNot() {
       /* RestAssured.baseURI = API_ROOT;
        given().urlEncodingEnabled(true)
                .param("email", "levunguyendn@gmail.com")
                .param("password", "Le Vu Nguyen")
                .param("role","student")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/auth/login")
                .then().statusCode(200);
        */

        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("email", "levunguyendn@gmail.com");
        loginCredentials.addProperty("password", "Nguy!n12345");
        loginCredentials.addProperty("role", "student");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("/auth/login");
        Assert.assertEquals(200,response.getStatusCode());
    }


}

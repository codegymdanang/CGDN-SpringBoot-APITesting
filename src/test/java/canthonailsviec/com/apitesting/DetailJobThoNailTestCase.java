package canthonailsviec.com.apitesting;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class DetailJobThoNailTestCase {
    public static final String API_ROOT = "https://api.canthonailsviet.com/jobs";
    @Test
    public void getDetailJob(){
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("can-tho-bot-gNDfLmOWX");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

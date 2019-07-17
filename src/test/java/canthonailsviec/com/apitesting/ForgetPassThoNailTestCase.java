package canthonailsviec.com.apitesting;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class ForgetPassThoNailTestCase {
    String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywiZW1haWwiOiJsZW5ndXllbnRoYW5odHV5ZW45N0BnbWFpbC5jb20iLCJ0b2tlbl90eXBlIjoiUkVTRVRfUEFTU1dPUkRfVE9LRU4iLCJyb2xlIjoibWFuaWN1cmlzdCIsImp3dGlkIjoiYXV0aF90b2tlbl9pZDpYdlJiQ1ZkbzUiLCJpYXQiOjE1NjA3ODcyODgsImV4cCI6MTU2MDc5MDg4OH0.cUzhaRSF3Nb_eSWgveiiDyXPp4NrYokcLnVne4pqBAUwXLB7V3Ff91fic6GK1RG5Vb-4vN0XrEKuHB2daQe2I4Q_YEhe7zQ04GOhMxnjVlzR1LdrpSq-9q4z-EWVyH2PovnCi3ybm52ybKKXIO8Fxj4-IiHZO8huZXcOTrPy40LY7-koAUC3t03FJ9VgjnzG0q_w4HnypaVF2_BG5DF6tfnNR6Nb05rz9pby_k6KSbNjTFUJpeKDu5K-pcRROW6q8I8kvTJ08QTBfDO87ERfHuwOxA9oxgfvtrXp0WyGPmRyU4vth-Hg52AHR1UMErO7lZ7_S140XZprmlgYPlSAnA";
    public static final String API_ROOT = "https://api.canthonailsviet.com/";
    @Test
    public void WhenRequestForgetPassOkOrNot(){
        JsonObject forgetPassProp = new JsonObject();
        forgetPassProp.addProperty("email", "lenguyenthanhtuyen97@gmail.com");
        forgetPassProp.addProperty("role", "manicurist");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type", "Application/json");
        httpRequest.body(forgetPassProp.toString());
        Response response = httpRequest.post("auth/forgot-password");
        response.getBody().prettyPrint();
        System.out.println(response.getBody().prettyPeek());
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSetForgetPasswordOkOrNot(){
        JsonObject prop = new JsonObject();
        prop.addProperty("password","tuyen123123");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        httpRequest.body(prop.toString());
        Response response = httpRequest.post("auth/reset-password?token="+token);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }

}

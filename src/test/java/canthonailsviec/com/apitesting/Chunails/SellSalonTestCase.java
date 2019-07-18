package canthonailsviec.com.apitesting.Chunails;

import canthonailsviec.com.apitesting.TestBase;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SellSalonTestCase extends TestBase {
    @Test
    public void WhenCreateSellSlonOkOrNot() {
        JsonObject createSellSalonProps = new JsonObject();
        JsonArray photoAr = new JsonArray();
        createSellSalonProps.addProperty("title", "yeu em khong anh!");
        createSellSalonProps.addProperty("description", "Chúng tôi đang cần bán tiệm");
        createSellSalonProps.addProperty("price", 400);
        createSellSalonProps.addProperty("city", "Houston");
        createSellSalonProps.addProperty("state", "TX");
        photoAr.add("/photos/0d3c606f-8a2b-4953-859f-e201fb92d82d.png");
        createSellSalonProps.add("photoURLs", photoAr);
        createSellSalonProps.addProperty("dayDuration", 7);
        REQUEST.header("Authorization","Bearer "+ getToken());
        REQUEST.body(createSellSalonProps.toString());
        Response response = REQUEST.post("/selling-shop-posts");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}
package canthonailsviec.com.apitesting.BO;

import canthonailsviec.com.apitesting.TestBase;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SellSalonTestCase extends TestBase {
    //BO approve sell salon is rejected
    Integer idSalonReject = 44;
    Integer idSalonPending = 44;
    Integer idSalonActive = 46;
    //BO reject sell salon
    @Test
    public void WhenRejectSellSalonOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("rejectedReason",  "Not good");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("selling-shop-posts/"+idSalonPending+"/reject");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    // BO approve sell salon is rejected
    @Test
    public void WhenApproveSellSalonRejectedOkOrNot(){
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        Response response = REQUEST.put("/selling-shop-posts/"+idSalonReject+"/approve");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
}

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
    Integer idSalonReject = 48;
    Integer idSalonPending = 48;
    Integer idSalonActive = 44;
    //BO reject sell salon
    @Test
    public void WhenRejectSellSalonOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("rejectedReason",  "can cung cap thong tin chinh sac!");
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
    //BO edit sell salon is pending
    @Test
    public void WhenEditSellSalonPendingOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("title","chu nail edit sell salon dang pending thanh cong");
        props.addProperty("description","Chúng tôi đang cần bán tiệm");
        props.addProperty("price",20000);
        props.addProperty("city","Houston");
        props.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("/selling-shop-posts/"+idSalonPending);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO edit sell salon is reject
    @Test
    public void WhenEditSellSalonRejectOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("title","chu nail edit sell salon dang reject");
        props.addProperty("description","Chúng tôi đang cần bán tiệm gaaos");
        props.addProperty("price",1000);
        props.addProperty("city","Houston");
        props.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("/selling-shop-posts/"+idSalonReject);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO edit sell salon is activing
    @Test
    public void WhenEditSellSalonActiveOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("title","chu nail edit sell salon dang reject");
        props.addProperty("description","Chúng tôi đang cần bán tiệm gaaos");
        props.addProperty("price",11000);
        props.addProperty("city","Houston");
        props.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("/selling-shop-posts/"+idSalonActive);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
}

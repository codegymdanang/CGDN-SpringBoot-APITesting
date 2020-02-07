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
public class HotJobTestCase extends TestBase {
    Integer idHotjobRejected = 14;
    Integer idHotjobPending = 19;
    Integer idHotJobActive = 18;

    //BO approve hot job
    @Test
    public void WhenApproveHotjobOkOrNot(){
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        Response response = REQUEST.put("/hotjobs/"+idHotjobPending+"/approve");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
    //BO Reject hot job
    @Test
    public void WhenRejectHotjobOjkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("rejectedReason","Not good");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("/hotjobs/"+idHotjobPending+"/reject");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }

    //BO approve hot job is rejected
    @Test
    public void WhenApproveHotjobRejectedOkOrNot(){
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        Response response = REQUEST.put("/hotjobs/"+idHotjobRejected+"/approve");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
    //BO Deactive hot job
    @Test
    public void WhenBoDeactiveHotJobOkOrNot(){
        JsonObject props = new JsonObject();
        props.addProperty("deactivatedReason","Deactice hot job");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(props.toString());
        Response response = REQUEST.put("/hotjobs/"+idHotJobActive+"/deactivate");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }

}

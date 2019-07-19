package canthonailsviec.com.apitesting.Chunails;

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
    Integer idJobActive = 311;
    Integer idJobPending = 280;
    @Test
    public void WhenCreateHotJobOkOrNot(){
        JsonObject createHotJobProps = new JsonObject();
        REQUEST.header("Authorization","Bearer "+getToken());
        createHotJobProps.addProperty("jobId",idJobActive);
        REQUEST.body(createHotJobProps.toString());
        Response response = REQUEST.post("/hotjobs");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //Job is not found or not active when active hot job
    @Test
    public void CreateHotJobWhenJobPendingOkOrNot(){
        JsonObject createHotJobProps = new JsonObject();
        REQUEST.header("Authorization","Bearer "+getToken());
        createHotJobProps.addProperty("jobId",idJobPending);
        REQUEST.body(createHotJobProps.toString());
        Response response = REQUEST.post("/hotjobs");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
}

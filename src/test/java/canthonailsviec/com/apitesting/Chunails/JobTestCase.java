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
public class JobTestCase extends TestBase {
    Integer idJobReject = 288;
    Integer idJobPending = 311;
    Integer idJobActive = 310;
    // Chu nail Post job
    @Test
    public void CreateJobOKorNot(){
        JsonObject jobProps = new JsonObject();
        JsonArray skillsAr = new JsonArray();
        jobProps.addProperty("title","em cần anh trai");
        jobProps.addProperty("description","Chúng tôi đang cần tuyển 1 thợ bột có kinh nghiệm > 2 năm");
        skillsAr.add(1);
        skillsAr.add(3);
        jobProps.add("skillIds",skillsAr);
        jobProps.addProperty( "fromSalary",400);
        jobProps.addProperty("toSalary",600);
        jobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        jobProps.addProperty("jobType","FULL_TIME");
        jobProps.addProperty("benefits","Lương tốt");
        jobProps.addProperty("city","Houston");
        jobProps.addProperty("state","TX");
        jobProps.addProperty("dayDuration",7);
        REQUEST.header("Authorization","Bearer "+getToken());
        REQUEST.body(jobProps.toString());
        Response response = REQUEST.post("/jobs");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());

    }
    //Chu nail edit job reject
    @Test
    public void nailOwnerEditJobRejectOkOrNot(){
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "chu nail edit job bi reject");
        editJobProps.addProperty("description","edit job");
        skillAr.add(1);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getToken());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+idJobReject);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());

    }
    //Chu nail edit job pending
    @Test
    public void nailOwnerEditJobPendingOkOrNot(){
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "chu nail edit job bi dang pending");
        editJobProps.addProperty("description","edit job");
        skillAr.add(1);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getToken());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+idJobPending);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    // chu nail edit job active
    @Test
    public void nailOwnerEditJobActive() {
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "chu nail edit job bi dang pending");
        editJobProps.addProperty("description","edit job");
        skillAr.add(1);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getToken());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+idJobActive);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }

}

package canthonailsviec.com.apitesting.BO;

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
    Integer jobIdReject = 312;
    Integer jobIdPending = 312;
    Integer jobIdActiving = 310;

    //BO reject job
    @Test
    public void WhenRejectJobOkOrNot(){
        JsonObject rejectProps = new JsonObject();
        rejectProps.addProperty("rejectedReason","ly do vi chu tiem nail qua xau");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(rejectProps.toString());
        Response response = REQUEST.put("/jobs/"+jobIdPending+"/reject");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO edit job Rejected
    @Test
    public void whenBOEditJobRejectOkOrNot(){
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "Em xấu xí chứ không xấu xa");
        editJobProps.addProperty("description","edit job");
        skillAr.add(6);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+jobIdReject);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO edit job is pending
    @Test
    public void WhenBOEditJobPendingOkOrNot(){
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "Em yêu anh nhiều lắm anh có biết không ");
        editJobProps.addProperty("description","edit job");
        skillAr.add(6);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+jobIdPending);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO edit job is activing
    @Test
    public void WhenBOEditJobActiveOkOrNot(){
        JsonObject editJobProps = new JsonObject();
        JsonArray skillAr = new JsonArray();
        editJobProps.addProperty("title", "Em yêu anh nhiều lắm anh có biết không ");
        editJobProps.addProperty("description","edit job");
        skillAr.add(6);
        editJobProps.add("skillIds",skillAr);
        editJobProps.addProperty("fromSalary",400);
        editJobProps.addProperty("toSalary",600);
        editJobProps.addProperty("requirements","Có kinh nghiệm làm thợ bột hơn 2 năm");
        editJobProps.addProperty("jobType","FULL_TIME");
        editJobProps.addProperty("benefits","Lương tốt");
        editJobProps.addProperty("city","Houston");
        editJobProps.addProperty("state","TX");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(editJobProps.toString());
        Response response = REQUEST.put("/jobs/"+jobIdActiving);
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
    //BO approve job is rejected
    @Test
    public void WhenBOApproveJobRejectOkOrNot(){
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        Response response = REQUEST.put("/jobs/"+jobIdReject+"/approve");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusCode());
    }
    //BO approve job is pending
    @Test
    public void WhenBOApproveJobPendingOkOrNot(){
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        Response response = REQUEST.put("/jobs/"+jobIdPending+"/approve");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    //BO deactive job
    @Test
    public void WhenBODeactiveJobOkOrNot(){
        JsonObject jsProps = new JsonObject();
        jsProps.addProperty("deactivatedReason","job khong dung nen deactive");
        REQUEST.header("Authorization","Bearer "+getTokenBO());
        REQUEST.body(jsProps.toString());
        Response response = REQUEST.put("/jobs/"+jobIdActiving+"/deactivate");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

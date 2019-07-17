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
public class CreateJobTestCase extends TestBase {
    @Test
    public void CreateJobOKorNot(){
        JsonObject jobProps = new JsonObject();
        JsonArray skillsAr = new JsonArray();
        jobProps.addProperty("title","tuyển cún ");
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
}


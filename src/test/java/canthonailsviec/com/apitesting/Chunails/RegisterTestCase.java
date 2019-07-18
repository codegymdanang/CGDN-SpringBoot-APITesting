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
public class RegisterTestCase extends TestBase {
   @Test
    public void WhenRegisterOkOrNot(){
       JsonObject registerProps = new JsonObject();
       registerProps.addProperty("address","da nang");
       registerProps.addProperty("city","Bullhead City");
       registerProps.addProperty("contactName","tuyen");
       registerProps.addProperty("email","lenguyenthanhtuyen97+3@gmail.com");
       registerProps.addProperty("name","tuyen le");
       registerProps.addProperty("password","tuyen123123");
       registerProps.addProperty("phoneNumber","077645358");
       registerProps.addProperty("role","company");
       registerProps.addProperty("state","AZ");
       registerProps.addProperty("website","bjdbf");
       REQUEST.body(registerProps.toString());
       Response response =REQUEST.post("/auth/signup");
       response.getBody().prettyPrint();
       Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
   }
}

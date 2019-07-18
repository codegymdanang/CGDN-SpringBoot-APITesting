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
public class ForgetPassTestCase extends TestBase {
    @Test
    public void WhenForgetPassOkOrNot() {
        JsonObject forgetProps = new JsonObject();
        forgetProps.addProperty("email","tuyen.le@smartdev.vn");
        REQUEST.body(forgetProps.toString());
        Response response = REQUEST.post("/auth/forgot-password?role=manicurist");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

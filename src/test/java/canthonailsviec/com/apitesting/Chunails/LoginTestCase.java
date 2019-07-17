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
public class LoginTestCase extends TestBase {
    @Test
    public void ShouldLoginOkOrNot() {
        JsonObject loginProps = new JsonObject();
        loginProps.addProperty("email", "tuyen.le@smartdev.vn");
        loginProps.addProperty("password","tuyen123123");
        loginProps.addProperty("role", "company");
        REQUEST.body(loginProps.toString());
        Response response = REQUEST.post("/auth/login");
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
}
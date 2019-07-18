package canthonailsviec.com.apitesting.ThoNails;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class CreateSkillThoNailTestCase {
    String token;
    @Before
    public void startTest(){
        token = getTokenWhenLogin();
    }
    public static final String API_ROOT = "https://api.canthonailsviet.com/";
    public String getTokenWhenLogin(){
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("email","lenguyenthanhtuyen97+28@gmail.com");
        loginCredentials.addProperty("password","tinhtuyen2501");
        loginCredentials.addProperty("role","manicurist");
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("auth/login");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("token");
        System.out.println(token);
        return token;
    }
    @Test
    public void WhenCreateSkillOkOrNot(){
      for(int id_Skill=1;id_Skill<=6;id_Skill++) {
          System.out.println(id_Skill);
          RestAssured.baseURI = API_ROOT;
          RequestSpecification httpRequest = given();
          httpRequest.header("Content-type", "application/json");
          httpRequest.header("Authorization", "Bearer " + token);
          Response response = httpRequest.post("skills/" + id_Skill + "/subscriptions");
          response.getBody().prettyPrint();
          Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
      }
    }
    @Test
    public void DeleteSkillOkOrNot(){
        int id_delete = 2;
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        httpRequest.header("Authorization","Bearer "+token);
        Response response = httpRequest.delete("skills/"+id_delete+"/subscriptions");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}

package canthonailsviec.com.apitesting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class CreateCVTestCase {
   String token;
   public static final String API_ROOT = "https://api.canthonailsviet.com";
   @Before
   public void startTest(){
      token = getTokenWhenLogin();
   }
   public String getTokenWhenLogin(){
      JsonObject loginCredentials = new JsonObject();
      loginCredentials.addProperty("email","lenguyenthanhtuyen97@gmail.com");
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
   public void whenAddSkillOkOrNot(){
      JsonObject addSkillProp = new JsonObject();
      JsonArray jsonElements = new JsonArray();
      jsonElements.add("Waxing");
      jsonElements.add("Thợ bột");
      jsonElements.add("Thợ nước");
      jsonElements.add("Thợ bột và nước");
      jsonElements.add("Nail arts");
      jsonElements.add("3d acrylic");
      addSkillProp.add("skills", jsonElements);
      RestAssured.baseURI = API_ROOT;
      RequestSpecification request = given();
      request.header("Content-type","application/json");
      request.header("Authorization","Bearer "+token);
      System.out.println(addSkillProp.toString());
      request.body(addSkillProp.toString());
      Response response = request.put("/profile/me/skills");
      response.getBody().prettyPrint();
   }

}

package canthonailsviec.com.apitesting.ThoNails;

import com.google.gson.JsonArray;
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
   public void whenAddInformationPersionalOkOrNot(){
      JsonObject addProfileProp = new JsonObject();
      addProfileProp.addProperty("city","Đà Nẵng");
      addProfileProp.addProperty("country","viet nam");
      addProfileProp.addProperty("currentAddress","Đống Đa");
      addProfileProp.addProperty("dateOfBirth", "25-01-1997");
      addProfileProp.addProperty("displayEmail","lenguyenthanhtuyen97+28@gmail.com");
      addProfileProp.addProperty("firstName","tuyen");
      addProfileProp.addProperty("gender","MALE");
      addProfileProp.addProperty("lastName","thanh");
      addProfileProp.addProperty("maritalStatus","SINGLE");
      addProfileProp.addProperty("phoneNumber","077645298");
      addProfileProp.addProperty("state","TX");
      addProfileProp.addProperty("jobTitle","Tho cham soc da");
      RestAssured.baseURI = API_ROOT;
      RequestSpecification request = given();
      request.header("Content-type","application/json");
      request.header("Authorization","Bearer "+token);
      request.body(addProfileProp.toString());
      Response response = request.put("/profile/me/personal-info");
      response.getBody().prettyPrint();
      Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
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
      Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
   }
   @Test
   public void whenAddExperienceFromYearToYear(){
      JsonObject experienceProp = new JsonObject();
      experienceProp.addProperty("additionalInformation","concho");
      experienceProp.addProperty("company","concho");
      experienceProp.addProperty("fromMonth","01-1973");
      experienceProp.addProperty("jobTitle","thợ sơn móng tay");
      experienceProp.addProperty("toMonth","04-1975");
      RestAssured.baseURI = API_ROOT;
      RequestSpecification request = given();
      request.header("Content-type","application/json");
      request.header("Authorization","Bearer "+token);
      request.body(experienceProp.toString());
      Response response = request.post("/profile/me/working-experiences");
      response.getBody().prettyPrint();
      Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
   }
   @Test
   public void whenAddExperienceFromYearToNowOKorNot(){
      JsonObject experienceProp = new JsonObject();
      experienceProp.addProperty("additionalInformation","concho");
      experienceProp.addProperty("company","concho");
      experienceProp.addProperty("fromMonth","01-1973");
      experienceProp.addProperty("jobTitle","thợ sơn móng tay");
      experienceProp.addProperty("toMonth","NOW");
      RestAssured.baseURI = API_ROOT;
      RequestSpecification request = given();
      request.header("Content-type","application/json");
      request.header("Authorization","Bearer "+token);
      request.body(experienceProp.toString());
      Response response = request.post("/profile/me/working-experiences");
      response.getBody().prettyPrint();
      Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());

   }
}

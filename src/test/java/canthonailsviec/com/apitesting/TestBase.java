package canthonailsviec.com.apitesting;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase {
    public RequestSpecification REQUEST;
    public TestBase() {
        RestAssured.baseURI = "https://api.canthonailsviet.com";
        REQUEST = RestAssured.given().contentType(ContentType.JSON);
    }
    public String getToken(){
        JsonObject loginProps = new JsonObject();
        loginProps.addProperty("email", "tuyen.le@smartdev.vn");
        loginProps.addProperty("password","tuyen123123");
        loginProps.addProperty("role", "company");
        REQUEST.body(loginProps.toString());
        Response response = REQUEST.post("/auth/login");
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("token");
    }
    public String getTokenBO(){
        JsonObject loginProps = new JsonObject();
        loginProps.addProperty("email", "tuyen.le@smartdev.vn");
        loginProps.addProperty("password","tuyen123123");
        loginProps.addProperty("role", "company");
        REQUEST.body(loginProps.toString());
        Response response = REQUEST.post("/auth/login");
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("token");
    }
}

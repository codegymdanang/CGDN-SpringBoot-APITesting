package canthonailsviec.com.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class SearchJobThoNailTestCase {
    private static final String API_ROOT = "https://api.canthonailsviet.com/";
    @Ignore
    @Test
    public void WhenSearchallfieldOKOrNot() {
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=1&state=AL&city=Alabaster");
        response.getBody().peek();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Ignore
    @Test
    public void WhenSearchOnlySkill(){
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=1&state=&city=");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());

    }
    @Ignore
    @Test
    public void WhenSearchOnlyState(){
        RestAssured.baseURI = API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=&state=NE&city=");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());

    }
    @Ignore
    @Test
    public void WhenSearchOnlyCity(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=&state=&city=Alabaster");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSearchSkillandStateNotCity(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=2&state=NE&city=");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSearchSkillandCityNotState(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=2&state=&city=Alabaster");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSearchStateandCityNotSkill(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=&state=NY&city=Alabaster");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSearchWrongValue(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=&state=NY&city=tuyen");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
    @Test
    public void WhenSearchNullAllField(){
        RestAssured.baseURI= API_ROOT;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-type","application/json");
        Response response = httpRequest.get("jobs/search?size=10&page=0&skill=&state=&city=");
        response.getBody().prettyPrint();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
    }
}
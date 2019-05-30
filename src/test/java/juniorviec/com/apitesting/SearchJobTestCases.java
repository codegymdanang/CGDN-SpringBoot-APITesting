package juniorviec.com.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)

public class SearchJobTestCases {


    private static final String API_ROOT = "https://uat.api.juniorviec.com/jobs/search?qs=java&category=1/\t";

    @Test
    public void whenSearchAJobReturnOKOrNot() {
        Response response = RestAssured.get(API_ROOT);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

}

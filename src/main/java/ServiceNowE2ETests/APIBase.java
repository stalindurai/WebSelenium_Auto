package ServiceNowE2ETests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.basic;

public class APIBase {

    protected IncidentRequestBody payload;
    protected String sysID;
    protected RequestSpecification rs;

    @BeforeTest
    public void setRequestSpec(){
        //Arrange
        rs = new RequestSpecBuilder()
                .setBaseUri("https://dev229753.service-now.com")
                .setBasePath("/api/now/table")
                .setAuth(basic("admin", "t*LwMr/FaI52"))
                .addPathParam("tableName","incident")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    protected ResponseSpecification responseSpec(int statusCode, String statusLine, Long ms){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectStatusLine(Matchers.containsString(statusLine))
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThanOrEqualTo(ms))
                .build();
    }
}

package ServiceNowE2ETests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ServiceNowE2ETests extends APIBase{

    @Test
    public void createNewReacord(){

        payload = new IncidentRequestBody();

        payload.setDescription("Create a new record for E2E test");
        payload.setShort_description("Service Now short description");
        payload.setCategory("Software");

        //Act
        sysID = RestAssured.given()
                        .spec(rs)
                        /*.baseUri("https://dev229753.service-now.com")
                        .basePath("/api/now/table")
                        .auth().basic("admin","t*LwMr/FaI52")
                        .pathParam("tableName", "incident")
                        .header("Content-Type", ContentType.JSON)*/
                    .when()
//                        .body(payload)
                        .body(new Gson().toJson(payload))
                        .post("/{tableName}")
                    //Assert
                    .then()
                    .log().all()
//                    .assertThat().statusCode(201)
                    .spec(responseSpec(201, "Created", 2500L))
                .extract().jsonPath().getString("result.sys_id");
    }

    @Test
    public void getCreatedRecord(){
        //Act
        RestAssured.given()
                .spec(rs)
                /*.baseUri("https://dev229753.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin","t*LwMr/FaI52")
                .pathParam("tableName", "incident")
                .header("Content-Type", ContentType.JSON)*/
                .when()
                .get("/{tableName}/"+sysID)
                //Assert
                .then()
                    .log().all()
                    .spec(responseSpec(200, "OK", 1500L))
                    /*.assertThat().statusCode(201)
                    .statusLine(Matchers.containsString("OK"))
                    .contentType(ContentType.JSON)*/
                    .body("result.sys_id", Matchers.equalTo(sysID));
    }
}

package RestScripts;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateRecordWithRequestBodyAsJSONFile {

    @Test
    public void createRecordWithRequestBodyAsString(){

        String res = given()
                .baseUri("https://dev226816.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin","fr2c$bFU8=VQ")
                .pathParam("tableName","incident")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                    .body(new File("src/main/resources/IncidentCreatePayload/CreateIncident.json"))
                    .post("/{tableName}")
                .then()
                    .log().all()
                    .assertThat().statusCode(201)
                .extract()
                .jsonPath()
                .getString("result.sys_id");
//                .toString();

        System.out.println("The following is the response with sys_id " +res);

    }
}

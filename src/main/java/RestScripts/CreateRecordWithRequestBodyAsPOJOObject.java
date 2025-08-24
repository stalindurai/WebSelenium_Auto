package RestScripts;

import IncidentCreatePayload.CreatePayload;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateRecordWithRequestBodyAsPOJOObject {

    @Test
    public void createRecordWithRequestBodyAsString(){

        CreatePayload payload = new CreatePayload();
        payload.setDescription("Create a new Record for Rob");
        payload.setShort_description("Record Rob");

        String res = given()
                .baseUri("https://dev182289.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin","X3^Mhqk9kLP!")
                .pathParam("tableName","incident")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                    .body(payload)
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

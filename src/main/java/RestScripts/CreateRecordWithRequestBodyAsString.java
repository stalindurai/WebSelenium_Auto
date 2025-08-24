package RestScripts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateRecordWithRequestBodyAsString {

    @Test
    public void createRecordWithRequestBodyAsString(){

        String body = """
                        {
                            "description": "Create a new Record for Stalin",
                            "short_description": "Record_Stalin" 
                        }    
                       """;
        String res = given()
                .baseUri("https://dev226816.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin","fr2c$bFU8=VQ")
                .pathParam("tableName","incident")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                    .body(body)
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

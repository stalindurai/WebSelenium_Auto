package RestScripts;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Rest_Get_TableNameAsPathParameter {

    @Test
    public void getIncident(){

        String res =
        RestAssured.given()
                .baseUri("https://dev226816.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin", "fr2c$bFU8=VQ")
                .pathParam("tableName", "incident")
                .pathParam("sysId", "1c741bd70b2322007518478d83673af3")
                .queryParam("sysparm_limit","1")
                .queryParam("sysparm_fields", "sys_id,short_description,number,description,state")
                .log().all()
                .when()
                .get("/{tableName}/{sysId}")
                .then().log().all()
                .assertThat().statusCode(200)
                .statusLine(containsString("OK"))
                .contentType(ContentType.JSON)
                .body("result.sys_id", equalTo("1c741bd70b2322007518478d83673af3"))
                .toString();

        System.out.println(res);

    }

}

/*sys_id
* short_description
* number
* description
* state
* */

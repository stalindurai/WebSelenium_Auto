package RestScripts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Rest_Get {

    @Test
    public void getIncident(){

        String res =
        RestAssured.given()
                .baseUri("https://dev226816.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin", "fr2c$bFU8=VQ")
                .queryParam("sysparm_limit","3")
                .queryParam("sysparm_fields", "sys_id,short_description,number,description,state")
                .log().all()
                .when()
                .get("/incident")
                .then().log().all()
                .assertThat().statusCode(200).toString();

        System.out.println(res);

    }

}

/*sys_id
* short_description
* number
* description
* state
* */

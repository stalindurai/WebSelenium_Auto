package oAuth;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateOAuthToken {

    @Test
    public void createToken(){

        String rs =
        RestAssured.given()
                        .baseUri("https://dev229753.service-now.com")
                        .basePath("/oauth_token.do")
                        .header("Content-Type","application/x-www-form-urlencoded")
                        .formParam("grant_type","password")
                        .formParam("client_id","8d48daa7c4a54e6db151376dc25170ac")
                        .formParam("client_secret","Y.h5)~9Ldp&KrJ^5-dvG5&+[smI1@+4V")
                        .formParam("username","admin")
                        .formParam("password","t*LwMr/FaI52")
                        .log().all()
                    .when()
                        .post()
                    .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .toString();


    }
}

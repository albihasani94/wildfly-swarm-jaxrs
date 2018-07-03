package io.thorntail.javaee;

import io.restassured.RestAssured;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ApplicationTestIT {

    @Test
    public void testMyService() {
        RestAssured.given()
                .when()
                .get("/hello")
                .then()
                .statusCode(200);
    }

}

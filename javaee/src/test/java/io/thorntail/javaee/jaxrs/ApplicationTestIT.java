package io.thorntail.javaee.jaxrs;

import io.restassured.RestAssured;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.swarm.arquillian.DefaultDeployment;

@RunWith(Arquillian.class)
@DefaultDeployment(testable = false)
public class ApplicationTestIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTestIT.class);

    @Test
    @RunAsClient
    public void testMyService() {
        LOGGER.info("=====Running Integration Testing as a client outside the container=====");
        RestAssured.given()
                .when()
                .get("/hello")
                .then()
                .statusCode(200);
    }

}

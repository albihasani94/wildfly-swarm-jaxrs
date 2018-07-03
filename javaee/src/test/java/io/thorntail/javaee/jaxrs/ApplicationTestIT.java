package io.thorntail.javaee.jaxrs;

import io.restassured.RestAssured;
import io.thorntail.javaee.cdi.ApplicationTest;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.swarm.arquillian.DefaultDeployment;

@RunWith(Arquillian.class)
@DefaultDeployment
public class ApplicationTestIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    @RunAsClient
    public void testMyService() {
        LOGGER.info("=====Running Integration Testing in default deployment: WAR=====");
        RestAssured.given()
                .when()
                .get("/hello")
                .then()
                .statusCode(200);
    }

}

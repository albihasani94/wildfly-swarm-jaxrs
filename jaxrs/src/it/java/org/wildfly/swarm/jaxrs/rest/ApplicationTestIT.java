package org.wildfly.swarm.jaxrs.rest;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ApplicationTestIT {

    @Drone
    WebDriver browser;

    @Test
    public void testMyService() {
        browser.navigate().to("http://localhost:8080/hello");
        assertTrue(browser.getPageSource().contains("Hello"));
    }

}

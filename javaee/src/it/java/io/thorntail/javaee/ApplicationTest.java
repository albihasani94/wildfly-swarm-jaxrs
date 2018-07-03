package io.thorntail.javaee;

import javax.inject.Inject;

import io.thorntail.javaee.cdi.MyCDIBean;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.swarm.arquillian.DefaultDeployment;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class ApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    @Inject
    MyCDIBean myCDIBean;

    @Test
    public void testCDI() {
        LOGGER.info("Testing CDI in a default deployment: JAR");
        Assert.assertEquals("Hello world!", myCDIBean.sayHelloWorld());
    }

}
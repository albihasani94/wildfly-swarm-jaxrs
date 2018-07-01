package org.wildfly.swarm.jaxrs.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

@RunWith(Arquillian.class)
public class ApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    private static final String CREATE_DEPLOYMENT = "=====Create deployment=====";

    private static final String RETURN_DEPLOYMENT_ARCHIVE = "=====Return deployment archive: {}=====";

    private static final String CREATE_SWARM = "=====Create swarm=====";

    @Deployment(name = "arquillian_test_single_deployment")
    public static Archive createDeployment() {
        LOGGER.info(CREATE_DEPLOYMENT);
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

        deployment.addClass(HelloWorldEndpoint.class);
        deployment.addClass(JAXRSConfiguration.class);

        LOGGER.info(RETURN_DEPLOYMENT_ARCHIVE, deployment.getName());
        return deployment;
    }

    @CreateSwarm
    public static Swarm newContainer() throws Exception {
        LOGGER.info(CREATE_SWARM);
        return new Swarm();
    }

    @Test
    public void testMyService() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/hello");
        Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN_TYPE);
        Response response = invocationBuilder.get();

        Assert.assertEquals(200, response.getStatus());
    }

    @Test
    public void doNothing() {
    }

}

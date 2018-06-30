package org.wildlfy.swarm.jaxrs.rest;

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
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jaxrs.rest.HelloWorldEndpoint;
import org.wildfly.swarm.jaxrs.rest.JAXRSConfiguration;

@RunWith(Arquillian.class)
public class ApplicationTest {

    @Deployment
    public static Archive createDeployment() {
        System.out.println("==========Creating deployment==========");
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

        deployment.addClass(HelloWorldEndpoint.class);
        deployment.addClass(JAXRSConfiguration.class);

        return deployment;
    }

    @CreateSwarm
    public static Swarm newContainer() throws Exception {
        System.out.println("==========Creating swarm==========");
        Swarm swarm = new Swarm();

        return swarm;
    }

    @Test
    public void testMyService() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/hello");
        Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN_TYPE);
        Response response = invocationBuilder.get();

        Assert.assertEquals(200, response.getStatus());
    }

}

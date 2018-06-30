package org.wildfly.swarm.jaxrs.rest;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Application {
    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

        deployment.addClass(HelloWorldEndpoint.class);
        deployment.addClass(JAXRSConfiguration.class);

        swarm.start();
        swarm.deploy(deployment);
    }
}

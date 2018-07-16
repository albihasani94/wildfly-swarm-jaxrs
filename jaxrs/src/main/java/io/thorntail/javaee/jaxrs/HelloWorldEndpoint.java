package io.thorntail.javaee.jaxrs;


import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorldEndpoint {

    private static final Logger LOGGER = Logger.getLogger("HelloWorldEndpoint");

    @GET
    @Produces("text/plain")
    public Response doGet() {
        LOGGER.info("Calling hello service");
        return Response.ok("Hello from WildFly Swarm!").build();
    }

}
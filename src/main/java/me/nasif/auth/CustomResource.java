package me.nasif.auth;

import com.codahale.metrics.annotation.Timed;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomResource {


    @GET
    @Timed
    @Path("/")
    @PermitAll // All authenticated users will have access to the method.
    public String test() {
        return "Working!";
    }

}

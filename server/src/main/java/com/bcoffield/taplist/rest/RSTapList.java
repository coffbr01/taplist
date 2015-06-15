package com.bcoffield.taplist.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ontap")
public class RSTapList {
    @GET
    public Response get() {
        String output = "Hello, world!";
        return Response.status(200).entity(output).build();
    }
}

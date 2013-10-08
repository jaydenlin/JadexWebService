package com.rest.test;  
  
import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response;  

@Path("/test")  
public class TestRest {  
   
 @GET  
 @Path("/{name}")  
 public Response getMsg(@PathParam("name") String name) {  
   
  String output = "Hello, " + name;  
   
  return Response.status(200).entity(output).build();  
   
 }  
   
}  
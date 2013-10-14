package com.rest.test;  
  
import jadex.base.Starter;
import jadex.bridge.IExternalAccess;
import jadex.commons.future.IFuture;
import jadex.commons.future.ThreadSuspendable;

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
  String[] newargs =new String[]
		  {
		    "-welcome","false",
		    "-cli","false",
		    "-printpass","false"
		  };
		  IFuture<IExternalAccess> platfut = Starter.createPlatform(newargs);
		  ThreadSuspendable sus =new ThreadSuspendable();
		  IExternalAccess platform = platfut.get(sus);
		  System.out.println("Started platform: "+platform.getComponentIdentifier());
  return Response.status(200).entity(output).build();  
   
 }  
   
}  
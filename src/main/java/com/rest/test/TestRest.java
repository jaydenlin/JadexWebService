package com.rest.test;  
  
import jadex.base.Starter;
import jadex.bridge.IComponentIdentifier;
import jadex.bridge.IExternalAccess;
import jadex.bridge.service.RequiredServiceInfo;
import jadex.bridge.service.search.SServiceProvider;
import jadex.bridge.service.types.cms.IComponentManagementService;
import jadex.commons.future.IFuture;
import jadex.commons.future.ThreadSuspendable;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response;  

import tutorial.HelloAgent;

@Path("/test")  
public class TestRest {  
   
 @GET  
 @Path("/start")  
 public Response startAgent() {  
   
  String[] newargs =new String[]
		  {
		    "-gui","false",
		    "-welcome","false",
		    "-cli","false",
		    "-printpass","false"
		  };
   	      //start jadex platform
		  IFuture<IExternalAccess> platfut = Starter.createPlatform(newargs);
		  ThreadSuspendable sus =new ThreadSuspendable();
		  IExternalAccess platform = platfut.get(sus);
		  //start Agent
		  IComponentManagementService cms = SServiceProvider.getService(platform.getServiceProvider(),IComponentManagementService.class, RequiredServiceInfo.SCOPE_PLATFORM).get(sus);
		  //IComponentIdentifier cid = cms.createComponent(null, HelloAgent.class.getName()+".class", null, null).get(sus);
		  IComponentIdentifier cid = cms.createComponent(null, "tutorial/HelloWorld.agent.xml", null, null).get(sus);
		  
		  System.out.println("Started platform: "+platform.getComponentIdentifier());
		  
  return Response.status(200).entity("start").build();  
   
 }  
   
}  
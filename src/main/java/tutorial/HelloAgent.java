package tutorial;

import jadex.bridge.service.types.publish.IPublishService;
import jadex.commons.future.IFuture;
import jadex.extension.rs.invoke.RestServiceAgent;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.Imports;
import jadex.micro.annotation.NameValue;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.Publish;

/**
 *  A simple agent to be used as a basis for own developments.
 */
@Agent
@ProvidedServices(
		  @ProvidedService(
			type=IWebService.class, 
		  	implementation=@Implementation(WebService.class),
		  	publish=@Publish(publishtype=IPublishService.PUBLISH_RS, 
		  	publishid="http://localhost:8080/getlara/",
		  	properties=@NameValue(name="formats", value="new javax.ws.rs.core.MediaType[]{javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE, javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE}"))))
public class HelloAgent extends RestServiceAgent
{
	/**
	 *  Called when the agent is started.
	 */
//	@AgentBody
//	public IFuture<Void> executeBody()
//	{
//		System.out.println("Hello world!");
//		return IFuture.DONE;
//	}
}

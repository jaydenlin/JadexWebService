package tutorial;

import jadex.bridge.service.annotation.Service;
import jadex.bridge.service.annotation.ServiceStart;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;

@Service
public class WebService implements IWebService{
	
	private String msg;
	@ServiceStart
	public void start(){
		msg = "Hello";
	}
	
	public IFuture<String> getMessage(String pb) {
		// TODO Auto-generated method stub
		return new Future<String>(this.msg);
	}
	
	public IFuture<Void> setMessage(String msg) {
		// TODO Auto-generated method stub
		this.msg = msg;
		return IFuture.DONE;
	}


}

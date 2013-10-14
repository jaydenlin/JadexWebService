package tutorial;

import jadex.commons.future.IFuture;

public interface IWebService {
	public IFuture<String> getMessage(String pb);
	public IFuture<Void> setMessage(String msg);
}

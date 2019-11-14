package conrad.weiser.robinhood.api.endpoint.fundamentals.methods;

import conrad.weiser.robinhood.api.endpoint.fundamentals.Fundamentals;
import conrad.weiser.robinhood.api.endpoint.fundamentals.data.TickerFundamentalElement;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

public class GetTickerFundamental extends Fundamentals {
	
	public GetTickerFundamental(String uuid) {
		
		this.setUrlBase("https://api.robinhood.com/marketdata/fundamentals/" + uuid +"/");
		
		//Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "appliation/json"));
		
		//This method is ran as GET
		this.setMethod(RequestMethod.GET);
		
		//Declare what the response should look like
		this.setReturnType(TickerFundamentalElement.class);
	}

}

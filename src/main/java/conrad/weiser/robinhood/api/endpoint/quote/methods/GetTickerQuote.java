package conrad.weiser.robinhood.api.endpoint.quote.methods;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import conrad.weiser.robinhood.api.endpoint.quote.Quote;
import conrad.weiser.robinhood.api.endpoint.quote.data.TickerQuoteResults;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetTickerQuote extends Quote {

	public GetTickerQuote(String ticker) {

		this.setUrlBase("https://api.robinhood.com/quotes/?instruments="+URLEncoder.encode(ticker, StandardCharsets.UTF_8));
		/*
		UrlParameter param = new UrlParameter("instruments", ticker);
		this.addUrlParameter(param);//
		 */
		// Add the header into the request accepting Json
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "appliation/json"));

		// This method is ran as GET
		this.setMethod(RequestMethod.GET);

		// Declare what the response should look like
		//Type listType = new TypeToken<ArrayList<TickerQuoteElement>>(){}.getType();
		this.setReturnType(TickerQuoteResults.class);

	}
}

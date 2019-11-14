package conrad.weiser.robinhood.api.endpoint.quote.data;

import java.util.List;

public class TickerQuoteResults {
private List<TickerQuoteElement> results;

public List<TickerQuoteElement> getResults() {
	return results;
}

public void setResults(List<TickerQuoteElement> results) {
	this.results = results;
}
}

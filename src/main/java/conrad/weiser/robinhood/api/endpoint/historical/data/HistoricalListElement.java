package conrad.weiser.robinhood.api.endpoint.historical.data;

import java.util.List;
import java.util.function.Function;

import conrad.weiser.robinhood.api.ApiMethod;
import conrad.weiser.robinhood.api.endpoint.fundamentals.data.InstrumentFundamentalElement;
import conrad.weiser.robinhood.api.endpoint.fundamentals.methods.GetInstrumentFundamental;
import conrad.weiser.robinhood.api.request.RequestManager;
import conrad.weiser.robinhood.api.throwables.RobinhoodApiException;

/**
 * Element containing information of a given position which exists on a users
 * watchlist.
 */
public class HistoricalListElement {
	@Override
	public String toString() {
		return "HistoricalElement [symbol=" + symbol + ", interval=" + interval + ", bounds=" + bounds
				+ ", historicals=" + historicals + "]";
	}

	private String symbol;
	private String interval;
	private String bounds;
	private List<HistoricalElement> historicals;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getBounds() {
		return bounds;
	}

	public void setBounds(String bounds) {
		this.bounds = bounds;
	}

	public List<HistoricalElement> getHistoricals() {
		return historicals;
	}

	public void setHistoricals(List<HistoricalElement> historicals) {
		this.historicals = historicals;
	}

}

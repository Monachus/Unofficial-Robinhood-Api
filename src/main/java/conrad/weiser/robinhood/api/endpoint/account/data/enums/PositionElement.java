package conrad.weiser.robinhood.api.endpoint.account.data.enums;

import conrad.weiser.robinhood.api.ApiMethod;
import conrad.weiser.robinhood.api.endpoint.fundamentals.data.InstrumentFundamentalElement;
import conrad.weiser.robinhood.api.endpoint.fundamentals.methods.GetInstrumentFundamental;
import conrad.weiser.robinhood.api.request.RequestManager;
import conrad.weiser.robinhood.api.throwables.RobinhoodApiException;

/**
 * Element containing information of a given position which exists on a users
 * watchlist.
 */
public class PositionElement {

	private float shares_held_for_stock_grants;
	private float intraday_quantity;
	private float intraday_average_buy_price;

	// TODO: created_at and updated_at

	private float shares_held_for_buys;
	private float average_buy_price;
	private float shares_held_for_sells;
	private float quantity;
	private InstrumentFundamentalElement fundamentals;

	private String instrument;

	public String getId() {
		return getId(true);
	}
	
	public String getId(boolean includeBasepath) {
		if(includeBasepath) {
			return instrument;	
		}else {
			return instrument.replaceAll("https://api.robinhood.com/instruments/(.+)/","$1");
		}
	}
		

	public float getShares_held_for_stock_grants() {
		return shares_held_for_stock_grants;
	}

	public float getIntraday_quantity() {
		return intraday_quantity;
	}

	public float getIntraday_average_buy_price() {
		return intraday_average_buy_price;
	}

	public float getShares_held_for_buys() {
		return shares_held_for_buys;
	}

	public float getAverage_buy_price() {
		return average_buy_price;
	}

	public float getShares_held_for_sells() {
		return shares_held_for_sells;
	}

	public float getQuantity() {
		return quantity;
	}

	public InstrumentFundamentalElement getFundamentals() {
		if (fundamentals == null) {
			ApiMethod method = new GetInstrumentFundamental(this.instrument);
			InstrumentFundamentalElement fundamentals;
			try {
				this.fundamentals = RequestManager.getInstance().makeApiRequest(method);
			} catch (RobinhoodApiException e) {
				throw new RuntimeException("unable to obtain fundamentals", e);
			}
		}
		return fundamentals;
	}

	public String getStockName() {
		return getFundamentals().getStockName();
	}
	
	public String getSymbol() {
		return getFundamentals().getSymbol();
	}

	public String getStockTicker() {
		return getSymbol();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof PositionElement && instrument.equals(((PositionElement) obj).getId()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "PositionElement [shares_held_for_stock_grants=" + shares_held_for_stock_grants + ", intraday_quantity="
				+ intraday_quantity + ", intraday_average_buy_price=" + intraday_average_buy_price
				+ ", shares_held_for_buys=" + shares_held_for_buys + ", average_buy_price=" + average_buy_price
				+ ", shares_held_for_sells=" + shares_held_for_sells + ", quantity=" + quantity + ", instrument="
				+ instrument + "]";
	}

}

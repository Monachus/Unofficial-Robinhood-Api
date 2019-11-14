package conrad.weiser.robinhood.api.endpoint.historical.data;

public class HistoricalElement {

	private String begins_at;
	private float open_price;
	private float close_price;
	private float high_price;
	private float low_price;
	private float volume;
	private String session;
	private boolean interpolated;
	
	public HistoricalElement(String begins_at, float open_price, float close_price, float high_price, float low_price,
			float volume, String session, boolean interpolated) {
		super();
		this.begins_at = begins_at;
		this.open_price = open_price;
		this.close_price = close_price;
		this.high_price = high_price;
		this.low_price = low_price;
		this.volume = volume;
		this.session = session;
		this.interpolated = interpolated;
	}
	
	public HistoricalElement() {
		this.begins_at =null;
	}
	
	
	public String getBegins_at() {
		return begins_at;
	}
	public void setBegins_at(String begins_at) {
		this.begins_at = begins_at;
	}
	public float getOpen_price() {
		return open_price;
	}
	public void setOpen_price(float open_price) {
		this.open_price = open_price;
	}
	public float getClose_price() {
		return close_price;
	}
	public void setClose_price(float close_price) {
		this.close_price = close_price;
	}
	public float getHigh_price() {
		return high_price;
	}
	public void setHigh_price(float high_price) {
		this.high_price = high_price;
	}
	public float getLow_price() {
		return low_price;
	}
	public void setLow_price(float low_price) {
		this.low_price = low_price;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public boolean getInterpolated() {
		return interpolated;
	}
	public void setInterpolated(boolean interpolated) {
		this.interpolated = interpolated;
	}
	@Override
	public String toString() {
		return "HistoricalElement [begins_at=" + begins_at + ", open_price=" + open_price + ", close_price="
				+ close_price + ", high_price=" + high_price + ", low_price=" + low_price + ", volume=" + volume
				+ ", session=" + session + ", interpolated=" + interpolated + "]";
	}
	
	
}

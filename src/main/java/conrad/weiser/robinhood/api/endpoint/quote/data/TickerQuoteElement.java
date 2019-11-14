package conrad.weiser.robinhood.api.endpoint.quote.data;

/**
 * Created by SirensBell on 6/19/2017.
 */
/*
 *   "results":[ 
      { 
         "ask_price":"174.290000",
         "ask_size":200,
         "bid_price":"174.280000",
         "bid_size":10500,
         "last_trade_price":"174.310000",
         "last_extended_hours_trade_price":"174.270000",
         "previous_close":"172.550000",
         "adjusted_previous_close":"172.550000",
         "previous_close_date":"2019-10-24",
         "symbol":"BABA",
         "trading_halted":false,
         "has_traded":true,
         "last_trade_price_source":"consolidated",
         "updated_at":"2019-10-25T22:19:45Z",
         "instrument":"https://api.robinhood.com/instruments/b2e06903-5c44-46a4-bd42-2a696f9d68e1/"
      }
   ]
}

 */
public class TickerQuoteElement {


    private float ask_price;
    private int ask_size;
    private float bid_price;
    private int big_size;

    private float last_trade_price;
    private float last_extended_hours_trade_price;

    private float previous_close;
    private float adjusted_previous_close;
    private String previous_close_date;
    private String symbol;
    private boolean trading_halted;
    private String updated_at;

    public float getAsk_price() {
        return ask_price;
    }

    public int getAsk_size() {
        return ask_size;
    }

    public float getBid_price() {
        return bid_price;
    }

    public int getBig_size() {
        return big_size;
    }

    public float getLast_trade_price() {
        return last_trade_price;
    }

    public float getLast_extended_hours_trade_price() {
        return last_extended_hours_trade_price;
    }

    public float getPrevious_close() {
        return previous_close;
    }

    public float getAdjusted_previous_close() {
        return adjusted_previous_close;
    }

    public String getPrevious_close_date() {
        return previous_close_date;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isTrading_halted() {
        return trading_halted;
    }

    public String getUpdated_at() {
        return updated_at;
    }

}

package conrad.weiser.robinhood.api.endpoint.account.methods;

import conrad.weiser.robinhood.api.ConfigurationManager;
import conrad.weiser.robinhood.api.endpoint.account.Account;
import conrad.weiser.robinhood.api.endpoint.account.data.enums.PositionListElement;
import conrad.weiser.robinhood.api.endpoint.historical.data.HistoricalListElement;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetHistoricalData extends Account {

    public GetHistoricalData(String symbol,String interval, String span) {

        //Get the current account ID to be used with the position search
        String accountId = ConfigurationManager.getInstance().getAccountNumber();

        this.setUrlBase("https://api.robinhood.com/marketdata/historicals/"+symbol+"/?bounds=regular&interval="+interval+"&span="+span);

        //Add the headers into the request'
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

        //This method is to be ran as GETe
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(HistoricalListElement.class);

    }
}

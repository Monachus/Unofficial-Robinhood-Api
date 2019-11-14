package conrad.weiser.robinhood.api.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import conrad.weiser.robinhood.api.ApiMethod;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.throwables.RobinhoodApiException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Logger;


public class RequestManager {
	
		
	/**
	 * Singleton instance of this class. 
	 * Only one instance is used for future ratelimiting support
	 */
	private static RequestManager instance = null;
	
	/**
	 * Method to get the active instance of the RequestManager.
	 * If one does not exist, it creates one 
	 */
	public static RequestManager getInstance() {
		
		if(RequestManager.instance == null) {
			
			RequestManager.instance = new RequestManager();
		}
		
		return RequestManager.instance;
	}

	
	public RequestManager(){
		Logger logger=new Logger() {

			@Override
			public void log(String arg0) {
				System.out.println("okhttp:"+arg0);
			}
			
		};
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(logger);
		this.okClient= new OkHttpClient.Builder()
				  .addInterceptor(logging)
				  .build();
	}

	OkHttpClient okClient;
	
	
	public <T> T makeApiRequest(ApiMethod method) throws RobinhoodApiException {
		
		T response = null;
				
		//Which request type are we using? Delegate it to the proper method
		switch(method.getMethod()) {
		case DELETE:
			break;
		case GET: response = this.makeGetRequest(method);
			break;
		case HEAD:
			break;
		case OPTIONS:
			break;
		case POST: response = this.makePostRequest(method);
			break;
		case PUT:
			break;
		case TRACE:
			break;
		default:
			break;
		
		}
		
		return response;
		
	}
	
	/**
	 * Method which uses OKHTTP to send a POST request to the specified URL saved
	 * within the APIMethod class 
	 * @throws MalformedURLException  Request URL is not formatted as a valid HTTP URL
	 */
	@SuppressWarnings("unchecked")
	private <T> T makePostRequest(ApiMethod method) throws RobinhoodApiException {

		RequestBody body = RequestBody.create(method.getMediaType(), method.getBody());
		Request.Builder request = new Request.Builder();
			
		//Append each of the headers for the method
		Iterator<HttpHeaderParameter> headerIterator = method.getHttpHeaderParameters().iterator();
		while(headerIterator.hasNext()) {
			
			HttpHeaderParameter currentHeader = headerIterator.next();
			request.addHeader(currentHeader.getKey(), currentHeader.getValue());
		}

		try {
            //Append the request body
            Request builtRequest = request.url(method.getUrl())
					.post(body)
					.build();

            //Make the request
            Response response = okClient.newCall(builtRequest).execute();

            //Parse the response with Gson
            Gson gson = new Gson();
            String responseJsonString = response.body().string();
            
            //If the response type for this is VOID (Meaning we are not expecting a response) do not
            //try to use Gson
            if(method.getReturnType() == Void.TYPE)
                return (T) Void.TYPE;

            T data = gson.fromJson(responseJsonString, method.getReturnType());
            return data;

        } catch (MalformedURLException ex) {

            System.err.println("[RobinhoodApi] Malformed request URL");

        } catch (IOException e) {
			System.err.println("[RobinhoodAPI] Error connecting to Robinhood servers");
		}

		throw new RobinhoodApiException();
		
	}
	
	/**
	 * Method which uses Unirest to send a GET request to the specified URL saved
	 * within the ApiMethod class 
	 * @throws MalformedURLException Request URL is not formatted as a valid HTTP URL
	 */
	private <T> T makeGetRequest(ApiMethod method) throws RobinhoodApiException {

		RequestBody body = RequestBody.create(method.getMediaType(), method.getUrlParametersAsPostBody());
		Request.Builder request = new Request.Builder();

		//Append each of the headers for the method
		Iterator<HttpHeaderParameter> headerIterator = method.getHttpHeaderParameters().iterator();
		while(headerIterator.hasNext()) {

			HttpHeaderParameter currentHeader = headerIterator.next();
			request.addHeader(currentHeader.getKey(), currentHeader.getValue());
		}

		try {

			//Append the request body
			Request builtRequest = request.url(method.getUrl())
					.get()
					.build();

			//Make the request
			Response response = okClient.newCall(builtRequest).execute();

			//Parse the response with Gson

			GsonBuilder builder=new GsonBuilder();
			ExclusionStrategy strategy=new ExclusionStrategy() {
				
				@Override
				public boolean shouldSkipField(FieldAttributes f) {
					return f.getName().equals("user");
				}
				
				@Override
				public boolean shouldSkipClass(Class<?> clazz) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			builder.addDeserializationExclusionStrategy(strategy);
			String responseJsonString = response.body().string();
			Gson gson = builder.create();
			T data = gson.fromJson(responseJsonString, method.getReturnType());

			return data;

		} catch (MalformedURLException e) {

			System.err.println("[RobinhoodAPI] Malformed request URL");

		} catch (IOException e) {
			System.err.println("[RobinhoodApi] Failed to communicate with Robinhood servers, request failed");
		}

		throw new RobinhoodApiException();

	}
	
	

}

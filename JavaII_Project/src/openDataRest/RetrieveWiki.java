package openDataRest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import wikipedia.MediaWiki;

public class RetrieveWiki implements Runnable  {
	//public static String RetrieveWikipedia(String city) throws  IOException {

	private String city;
	private String Extracts;
		
	public RetrieveWiki( String city) {
		this.city= city;
	}
		
	 public void run() { 
		try
	    { 	
			/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city using Jersey framework.
			* @param city The Wikipedia article and OpenWeatherMap city. 
			* @param country The country initials (i.e. gr, it, de).
			* @param appid Your API key of the OpenWeatherMap.*/ 	
			ClientConfig config = new DefaultClientConfig();
		    Client client = Client.create(config);
		    WebResource service = client.resource(UriBuilder.fromUri("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2").build());      
		    ObjectMapper mapper = new ObjectMapper(); 
		    String json= service.accept(MediaType.APPLICATION_JSON).get(String.class); 
			MediaWiki mediaWiki_obj =  mapper.readValue(json, MediaWiki.class);
			
			Extracts= mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	    } catch (Exception e) { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
			
	 }	
	 
	 public String getExtracts() {
		 return Extracts;
	 }
	 
}

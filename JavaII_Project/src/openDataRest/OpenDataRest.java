package openDataRest;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import OOPII_21829_218105.Business;
import OOPII_21829_218105.City;
import OOPII_21829_218105.Traveller;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

/**Description and weather information using OpenData with Jackson JSON processor and Jersey Client.
* @since 29-2-2020
* @version 1.0
* @author John Violos  */
public class OpenDataRest {

/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city using Jersey framework.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de).
* @param appid Your API key of the OpenWeatherMap.*/ 	
public static void RetrieveOpenWeatherMap(String city, String country, String appid, City thisCity) throws JsonParseException, JsonMappingException, IOException {
	ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(UriBuilder.fromUri("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+"&units=metric"+"").build());      
    ObjectMapper mapper = new ObjectMapper(); 
    String json= service.accept(MediaType.APPLICATION_JSON).get(String.class);
    OpenWeatherMap weather_obj = mapper.readValue(json,OpenWeatherMap.class);
    
    double temp=(weather_obj.getMain()).getTemp();
    if (temp<15) {
    	thisCity.setClime("cold");
    }
    if (temp>=15 && temp<=30) {
    	thisCity.setClime("mild");
    }
    if (temp>30) {
    	thisCity.setClime("hot");
    }
    
    thisCity.setWeather(weather_obj.getWeather().get(0).getMain());
    thisCity.setLat(weather_obj.getCoord().getLat());
    thisCity.setLon(weather_obj.getCoord().getLon());
    
}

//used for specifing lat and lon of a business client
public static void RetrieveOpenWeatherMap(String city, String country, String appid, Traveller thisBusiness) throws Exception {
	ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(UriBuilder.fromUri("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+"&units=metric"+"").build());      
    ObjectMapper mapper = new ObjectMapper(); 
    String json= service.accept(MediaType.APPLICATION_JSON).get(String.class);
    OpenWeatherMap weather_obj = mapper.readValue(json,OpenWeatherMap.class);

    thisBusiness.setLatNow(weather_obj.getCoord().getLat());
    thisBusiness.setLonNow(weather_obj.getCoord().getLon());

}
	
/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city using Jersey framework.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de).
* @param appid Your API key of the OpenWeatherMap.*/ 	
public static String RetrieveWikipedia(String city) throws  IOException {
	ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(UriBuilder.fromUri("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2").build());      
    ObjectMapper mapper = new ObjectMapper(); 
    String json= service.accept(MediaType.APPLICATION_JSON).get(String.class); 
	MediaWiki mediaWiki_obj =  mapper.readValue(json, MediaWiki.class);
	
	return mediaWiki_obj.getQuery().getPages().get(0).getExtract();
}

}
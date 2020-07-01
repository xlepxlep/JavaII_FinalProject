package openDataRest;

import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import OOPII_21829_218105.Traveller;
import weather.OpenWeatherMap;

public class RetrieveOpenWeatherTraveller implements Runnable {

	private String city;
	private String country;
	private String appid;
	private Traveller thisBusiness;
	
	public RetrieveOpenWeatherTraveller(String city, String country, String appid, Traveller thisBusiness) {
		super();
		this.city = city;
		this.country = country;
		this.appid = appid;
		this.thisBusiness = thisBusiness;
	}

	public void run() {
System.out.println("IN THE THREAAAD!!!");		
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(UriBuilder.fromUri("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+"&units=metric"+"").build());      
	    ObjectMapper mapper = new ObjectMapper(); 
		
		String json=null;
		try {
			json= service.accept(MediaType.APPLICATION_JSON).get(String.class);
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "City not found", "Alert", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
  
		OpenWeatherMap weather_obj=null;
	    try {
	    	weather_obj = mapper.readValue(json,OpenWeatherMap.class);
	    } catch (Exception ex) {
	    	System.out.println("cathced this");
	    }
	    thisBusiness.setLatNow(weather_obj.getCoord().getLat());
	    thisBusiness.setLonNow(weather_obj.getCoord().getLon());
	}
	
}

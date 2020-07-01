package weather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"coord",
"weather",
"base",
"main",
"visibility",
"wind",
"rain",
"clouds",
"dt",
"sys",
"timezone",
"id",
"name",
"cod"
})
public class OpenWeatherMap {

@JsonProperty("coord")
public Coord coord;
@JsonProperty("weather")
public List<Weather> weather = null;
@JsonProperty("base")
public String base;
@JsonProperty("main")
public Main main;
@JsonProperty("visibility")
public Integer visibility;
@JsonProperty("wind")
public Wind wind;
@JsonProperty("rain")
public Rain rain;
@JsonProperty("clouds")
public Clouds clouds;
@JsonProperty("dt")
public Integer dt;
@JsonProperty("sys")
public Sys sys;
@JsonProperty("timezone")
public Integer timezone;
@JsonProperty("id")
public Integer id;
@JsonProperty("name")
public String name;
@JsonProperty("cod")
public Integer cod;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Coord getCoord() {
	// TODO Auto-generated method stub
	return coord;
}

public Main getMain() {
	return main;
}

public List<Weather> getWeather() {
	return weather;
}

}
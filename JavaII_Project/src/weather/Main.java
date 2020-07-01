package weather;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"temp",
"feels_like",
"temp_min",
"temp_max",
"pressure",
"humidity"
})
public class Main {

@JsonProperty("temp")
public Double temp;
@JsonProperty("feels_like")
public Double feelsLike;
@JsonProperty("temp_min")
public Double tempMin;
@JsonProperty("temp_max")
public Double tempMax;
@JsonProperty("pressure")
public Integer pressure;
@JsonProperty("humidity")
public Integer humidity;
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

public Double getTemp() {
	return temp;
}

}

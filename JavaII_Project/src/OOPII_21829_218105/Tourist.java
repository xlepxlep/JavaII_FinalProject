package OOPII_21829_218105;

import java.io.IOException;

import openDataRest.OpenDataRest;

public class Tourist extends Traveller {

	@Override
	public int Similarity( City thisCity, Traveller thisTraveller) throws IOException { //λοιπουν καποια πεδία 
		
		int fieldCounter=0;
		OpenDataRest dataGiver=new OpenDataRest();
		int totalFields=countTextWords(dataGiver.RetrieveWikipedia(thisCity.getName()));

		if (thisTraveller.getWeather().equals(thisCity.getWeather())) {
			fieldCounter++;
		}
		if (thisTraveller.getClime().equals(thisCity.getClime())) {
			fieldCounter++;
		}
		if (thisTraveller.getTouristLocation()>0) {
			fieldCounter+=1*thisCity.getTouristLocation();
		}
		if (thisTraveller.getExpensive()>0) {
			fieldCounter+=1*thisCity.getExpensive();
		}
		if (thisTraveller.getLocationAtractions().getBeach()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getBeach();
		}
		if (thisTraveller.getLocationAtractions().getCanyon()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getCanyon();
		}
		if (thisTraveller.getLocationAtractions().getRiver()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getRiver();
		}
		if (thisTraveller.getLocationAtractions().getLake()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getLake();
		}
		if (thisTraveller.getLocationAtractions().getAirport()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getAirport();
		}
		if (thisTraveller.getLocationAtractions().getSeatport()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getSeatport();
		}
		if (thisTraveller.getLocationAtractions().getSubway()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getSubway();
		}
		if (thisTraveller.getLocationAtractions().getTrain()>0) {
			fieldCounter+=1*thisCity.getLocationAtractions().getTrain();
		}
		if (thisTraveller.getActivities().getHiking()>0) {
			fieldCounter+=1*thisCity.getActivities().getHiking();
		}
		if (thisTraveller.getActivities().getSafari()>0) {
			fieldCounter+=1*thisCity.getActivities().getSafari();
		}
		if (thisTraveller.getActivities().getWatersports()>0) {
			fieldCounter+=1*thisCity.getActivities().getWatersports();
		}
		if (thisTraveller.getActivities().getWintersports()>0) {
			fieldCounter+=1*thisCity.getActivities().getWintersports();
		}
		if (thisTraveller.getActivities().getCruise()>0) {
			fieldCounter+=1*thisCity.getActivities().getCruise();
		}
		if (thisTraveller.getDayLife().getChurch()>0) {
			fieldCounter+=1*thisCity.getDayLife().getChurch();
		}
		if (thisTraveller.getDayLife().getCinema()>0) {
			fieldCounter+=1*thisCity.getDayLife().getCinema();
		}
		if (thisTraveller.getDayLife().getOpera()>0) {
			fieldCounter+=1*thisCity.getDayLife().getOpera();
		}
		if (thisTraveller.getDayLife().getMuseum()>0) {
			fieldCounter+=1*thisCity.getDayLife().getMuseum();
		}
		if (thisTraveller.getNightLife().getBar()>0) {
			fieldCounter+=1*thisCity.getNightLife().getBar();
		}
		if (thisTraveller.getAccommodationType().equals(thisCity.getAccommodationType())) {
			fieldCounter+=1*thisCity.getAccomodationTypeCounter();
		}
		
		return fieldCounter;
		
	}
	
	//method from stack overflow to the words of a text count words
	public static int countTextWords(String input) {
		    if (input == null || input.isEmpty()) {
		      return 0;
		    }

		    String[] words = input.split("\\s+");
		    return words.length;
	 }
	
	// searches for the older user with the most similarity
	public Tourist freeTicketGiver ( City thisCity, Tourist touristGuys[]) throws IOException {
		
		Tourist bestTourist=new Tourist();
		bestTourist=touristGuys[0];
		
		for ( int i=0; i<N; i++) {
			if ( Similarity( thisCity, touristGuys[i])>Similarity( thisCity, bestTourist)) {
				bestTourist=touristGuys[i];
			}
		}
		
		return bestTourist; 
		
	}
	
}
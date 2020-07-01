package OOPII_21829_218105;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import com.mysql.jdbc.PreparedStatement;

import OOPII_21829_218105.newMain.usersFileFormat;
import OOPII_21829_218105.userPrefsAndVisit;

import java.awt.*;

import openDataRest.OpenDataRest;
import openDataRest.RetrieveOpenWeatherTraveller;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;  

class RecommendedCity {
	public RecommendedCity(String city, int rank) {
		super();
		City = city;
		this.rank = rank;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	String City;
	int rank;
}

class userPrefsAndVisit implements Serializable {
	//recomended location
		private String visit;
		
		boolean wantsRain;
		
		//about the location
		private String weather;
		private locationAtractionss locationAtractions=new locationAtractionss();
		private String typeOfPlace; //e.g. city, island
		private String clime;
		private String continent;
		private int touristLocation; //0=no 1=yes
		private int expensive; //0=no 1=yes
		
		//about the activities
		private dayLifee getDayLife=new dayLifee();
		private nightLifee nightLife=new nightLifee();
		private String accommodationType; //e.g. camping, hotel
		private activitiess activities=new activitiess();
		
		public userPrefsAndVisit(String visit, String weather,
				locationAtractionss locationAtractions, String typeOfPlace, String clime, String continent,
				int touristLocation, int expensive, dayLifee getDayLife, nightLifee nightLife,
				String accommodationType, activitiess activities) {
			super();
			this.visit = visit;
			this.wantsRain = wantsRain;
			this.weather = weather;
			this.locationAtractions = locationAtractions;
			this.typeOfPlace = typeOfPlace;
			this.clime = clime;
			this.continent = continent;
			this.touristLocation = touristLocation;
			this.expensive = expensive;
			this.getDayLife = getDayLife;
			this.nightLife = nightLife;
			this.accommodationType = accommodationType;
			this.activities = activities;
		}
		public String getVisit() {
			return visit;
		}
		public void setVisit(String visit) {
			this.visit = visit;
		}
		public boolean isWantsRain() {
			return wantsRain;
		}
		public void setWantsRain(boolean wantsRain) {
			this.wantsRain = wantsRain;
		}
		public String getWeather() {
			return weather;
		}
		public void setWeather(String weather) {
			this.weather = weather;
		}
		public locationAtractionss getLocationAtractions() {
			return locationAtractions;
		}
		public void setLocationAtractions(locationAtractionss locationAtractions) {
			this.locationAtractions = locationAtractions;
		}
		public String getTypeOfPlace() {
			return typeOfPlace;
		}
		public void setTypeOfPlace(String typeOfPlace) {
			this.typeOfPlace = typeOfPlace;
		}
		public String getClime() {
			return clime;
		}
		public void setClime(String clime) {
			this.clime = clime;
		}
		public String getContinent() {
			return continent;
		}
		public void setContinent(String continent) {
			this.continent = continent;
		}
		public int getTouristLocation() {
			return touristLocation;
		}
		public void setTouristLocation(int touristLocation) {
			this.touristLocation = touristLocation;
		}
		public int getExpensive() {
			return expensive;
		}
		public void setExpensive(int expensive) {
			this.expensive = expensive;
		}
		public dayLifee getGetDayLife() {
			return getDayLife;
		}
		public void setGetDayLife(dayLifee getDayLife) {
			this.getDayLife = getDayLife;
		}
		public nightLifee getNightLife() {
			return nightLife;
		}
		public void setNightLife(nightLifee nightLife) {
			this.nightLife = nightLife;
		}
		public String getAccommodationType() {
			return accommodationType;
		}
		public void setAccommodationType(String accommodationType) {
			this.accommodationType = accommodationType;
		}
		public activitiess getActivities() {
			return activities;
		}
		public void setActivities(activitiess activities) {
			this.activities = activities;
		}
		
	   public static int[] getCriteria( userPrefsAndVisit theTraveller) {
	    	
	    	//.getVisit(),.getWeather(),.getLocationAtractions(),.getTypeOfPlace(),.getClime(),.getContinent()
				//	,.getTouristLocation(),.getExpensive(),.getDayLife(),.getNightLife(),.getAccommodationType(),.getActivities()
		
	    	int[] criteria= {theTraveller.getLocationAtractions().getAirport(),theTraveller.getLocationAtractions().getBeach(),theTraveller.getLocationAtractions().getCanyon(),theTraveller.getLocationAtractions().getLake(),theTraveller.getLocationAtractions().getRiver(),theTraveller.getLocationAtractions().getSeatport(),theTraveller.getLocationAtractions().getSubway(),theTraveller.getLocationAtractions().getTrain(),
	    			theTraveller.getTouristLocation(),theTraveller.getExpensive(),
	                theTraveller.getGetDayLife().getChurch(),theTraveller.getGetDayLife().getCinema(),theTraveller.getGetDayLife().getOpera(),theTraveller.getGetDayLife().getMuseum(),
	                theTraveller.getNightLife().getBar(),
	                theTraveller.getActivities().getCruise(),theTraveller.getActivities().getHiking(),theTraveller.getActivities().getSafari(),theTraveller.getActivities().getWatersports(),theTraveller.getActivities().getWintersports()};
					
	    	return criteria;
	    	
	    	
	    }
		
}


public class Streams {


	
	public static String cleverSearch(userPrefsAndVisit a) throws IOException { 
    		
    	//real shit
		ArrayList<userPrefsAndVisit> allUsersPrefs=new ArrayList<>();
		allUsersPrefs=newMain.fileReaderPrefs(allUsersPrefs);
		
    	//userPrefsAndVisit a=allUsersPrefs.get(2);
    	
    	int[] candidateTravellerCriteria=a.getCriteria(a);

    	Optional<RecommendedCity> recommendedCity=
    			allUsersPrefs.stream().map(i-> new RecommendedCity(i.getVisit(),innerDot(i.getCriteria(i),candidateTravellerCriteria))).max(Comparator.comparingInt(RecommendedCity::getRank));
    			
    	System.out.println("The Recommended City: "+recommendedCity.get().getCity());
    	
    	return recommendedCity.get().getCity();
    	

	}

	private static int innerDot(int[] currentTraveller, int[] candidateTraveller) {
		int sum=0;
		for (int i=0; i<currentTraveller.length;i++) {
			sum+=currentTraveller[i]*candidateTraveller[i];
		}	
		//System.out.println(sum);
		return sum;
			
	}
	
}	







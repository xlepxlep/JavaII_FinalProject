package OOPII_21829_218105;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import OOPII_21829_218105.userPrefsAndVisit;
import openDataRest.OpenDataRest;
import openDataRest.RetrieveWiki;


class cityNames implements Serializable {
	private String cityName;
	private String countryName;
	
	public cityNames(String cityName, String countryName) {
		this.cityName = cityName;
		this.countryName = countryName;
	}
	

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}

class locationAtractionss implements Serializable 
{
	private int beach; //0=no >0yes
	private int river; //0=no >0yes
	private int canyon; //0=no >0yes
	private int lake; //0=no >0yes
	private int seaport; //0=no >0yes
	private int airport; //0=no >0yes
	private int train; //0=no >0yes
	private int subway; //0=no >0yes
	
	public locationAtractionss(int beach, int river, int canyon, int lake, int seaport, int airport, int train,
			int subway) {
		super();
		this.beach = beach;
		this.river = river;
		this.canyon = canyon;
		this.lake = lake;
		this.seaport = seaport;
		this.airport = airport;
		this.train = train;
		this.subway = subway;
	}
	public locationAtractionss() {
		this.beach = 0;
		this.river = 0;
		this.canyon = 0;
		this.airport = 0;
		this.lake = 0;
		this.subway = 0;
		this.train = 0;
		this.seaport = 0;
	}
	public int getBeach() {
		return beach;
	}
	public void setBeach(int beach) {
		this.beach = beach;
	}
	public int getRiver() {
		return river;
	}
	public void setRiver(int river) {
		this.river = river;
	}
	public int getCanyon() {
		return canyon;
	}
	public void setCanyon(int canyon) {
		this.canyon = canyon;
	}
	public int getSeatport() {
		return seaport;
	}
	public void setSeatport(int seaport) {
		this.seaport = seaport;
	}
	public int getAirport() {
		return airport;
	}
	public void setAirport(int airport) {
		this.airport = airport ;
	}
	public int getTrain() {
		return train;
	}
	public void setTrain(int train) {
		this.train = train;
	}
	public int getSubway() {
	return subway;
  }
	public void setSubway(int subway) {
   this.subway = subway;
 }
	public int getLake() {
  	return lake;
 }
	public void setLake(int lake) {
	this.lake = lake;
}

};

class dayLifee implements Serializable
{
	private int museum; //0=no >0yes
	private int church; //0=no >0yes
	private int opera; //0=no >0yes
	private int cinema; //0=no >0yes

	public dayLifee(int museum, int church, int opera, int cinema) {
		super();
		this.museum = museum;
		this.church = church;
		this.opera = opera;
		this.cinema = cinema;
	}

	public dayLifee() {
		this.museum = 0;
		this.church = 0;
		this.cinema = 0;
		this.opera = 0;

	}
	
	public int getMuseum() {
		return museum;
	}
	public void setMuseum(int museum) {
		this.museum = museum;
	}
	public int getOpera() {
		return opera;
	}
	public void setOpera(int opera) {
		this.opera = opera;
	}
	public int getChurch() {
		return church;
	}
	public void setChurch(int church) {
		this.church = church;
	}
	public int getCinema() {
		return cinema;
	}
	public void setCinema(int cinema) {
		this.cinema = cinema;
	}
};

class nightLifee implements Serializable
{
	private int bar; //0=no >0yes

	public nightLifee(int bar) {
		super();
		this.bar = bar;
	}
	public nightLifee() {
		super();
		this.bar = 0;
	}
	public int getBar() {
		return bar;
	}
	public void setBar(int bar) {
		this.bar = bar;
	}
};

class activitiess implements Serializable
{
	private int watersports; //0=no >0yes
	private int safari; //0=no >0yes
	private int hiking; //0=no >0yes
	private int wintersports; //0=no >0yes
	private int cruise; //0=no >0yes	
	
	public activitiess(int cruise, int hiking, int safari,int watersports, int wintersports) {
		this.watersports = watersports;
		this.safari = safari;
		this.hiking = hiking;
		this.wintersports = wintersports;
		this.cruise = cruise;
	}
	public activitiess() {
		this.watersports = 0;
		this.safari = 0;
		this.hiking =0;
		this.wintersports =0;
		this.cruise = 0;
	}
	public int getWatersports() {
		return watersports;
	}
	public void setWatersports(int watersports) {
		this.watersports = watersports;
	}
	public int getSafari() {
		return safari;
	}
	public void setSafari(int safari) {
		this.safari = safari;
	}

	public int getHiking() {
		return hiking;
	}
	public void setHiking(int hiking) {
		this.hiking = hiking;
	}
	public int getCruise() {
		return cruise;
	}
	public void setCruise(int cruise) {
		this.cruise = cruise;
	}
	public int getWintersports() {
		return wintersports;
	}
	public void setWintersports(int wintersports) {
		this.wintersports = wintersports;
	}

};

class cityPopularity implements Serializable, Comparable<cityPopularity>  
{
	private String cityName;
	private int wordCounter;
	
	public cityPopularity() {
		super();
	}
	public cityPopularity(String cityName, int wordCounter) {
		super();
		this.cityName = cityName;
		this.wordCounter = wordCounter;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getWordCounter() {
		return wordCounter;
	}
	public void setWordCounter(int wordCounter) {
		this.wordCounter = wordCounter;
	}
	
	public int compareTo(cityPopularity m) 
    { 
        return this.wordCounter - m.wordCounter; 
    }
	
};

public class City {
	
	private String name;
	private String countryName;
	
	private cityNames cityNames;
	
	//about the location         //all set for travellers preferences
	private double lat;
	private double lon;
	private String weather;
	private locationAtractionss locationAtractions=new locationAtractionss();
	private String clime; //hot,mild,cold 
	private int touristLocation; //0=no >0yes
	private int expensive; //0=no >0yes
	
	//about the activities    // ***SOOOS*** have to fix the setter for travellers preferences
	private dayLifee dayLife=new dayLifee(); 
	private nightLifee nightLife=new nightLifee();
	private String accommodationType; //e.g. camping, hotel  //set for travellers preferences
	private int accomodationTypeCounter;
	private activitiess activities=new activitiess();
	
	
	
	//CONSTRUCTOR
	
	public City() {
		
		this.lat=0;
		this.lon=0;
		this.name="empty";
		this.weather = "empty";
		this.clime = "empty";
		this.touristLocation = 0;
		this.expensive = 0;
		this.accommodationType = "empty";
			
	}


	//SETTERS, GETTERS
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public cityNames getCityNames() {
		return cityNames;
	}
	public void setCityNames(cityNames cityNames) {
		this.cityNames = cityNames;
	}
	public int getAccomodationTypeCounter() {
		return accomodationTypeCounter;
	}
	public void setAccomodationTypeCounter(int accomodationTypeCounter) {
		this.accomodationTypeCounter = accomodationTypeCounter;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public locationAtractionss getLocationAtractions() {
		return locationAtractions;
	}
	public void setLocationAtractions(locationAtractionss locationAtractions) {
		this.locationAtractions = locationAtractions;
	}
	public dayLifee getDayLife() {
		return dayLife;
	}
	public void setDayLife(dayLifee dayLife) {
		this.dayLife = dayLife;
	}
	public nightLifee getNightLife() {
		return nightLife;
	}
	public void setNightLife(nightLifee nightLife) {
		this.nightLife = nightLife;
	}
	public activitiess getActivities() {
		return activities;
	}
	public void setActivities(activitiess activities) {
		this.activities = activities;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getClime() {
		return clime;
	}
	public void setClime(String clime) {
		this.clime = clime;
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
	public String getAccommodationType() {
		return accommodationType;
	}
	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}
	

	
	//METHODS

	
	public ArrayList<City> setCitiessAtributtes ( Traveller thisTraveller, ArrayList<City> theCities) throws IOException {  //it was void before
		
		for ( int i=0; i<theCities.size(); i++) {
		
			try {
				setCitysAtributesOpenWeatherMap( theCities.get(i));
			} catch (Exception e) {
				System.out.println("City: "+theCities.get(i).getName()+" not found!!!");
				theCities.remove(i);
				continue; 
			} 
			
			//OpenDataRest dataReceiver=new OpenDataRest();
			//String wikiExtracts=dataReceiver.RetrieveWikipedia(theCities.get(i).getName());
			RetrieveWiki rw=new RetrieveWiki(theCities.get(i).getName());
			Thread t = new Thread(rw);			
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant join");
			}
			String wikiExtracts=rw.getExtracts();
			int atributeCounter=0;
			
			//beach setter
			Pattern p = Pattern.compile("beach");
			Matcher m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Beach");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).locationAtractions.setBeach(atributeCounter);;
			atributeCounter=0;
			
			//river setter
			p = Pattern.compile("river");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("River");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).locationAtractions.setRiver(atributeCounter);
			atributeCounter=0;
			
			//canyon setter
			p = Pattern.compile("canyon");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Canyon");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).locationAtractions.setCanyon(atributeCounter);
			atributeCounter=0;
			
			//tourist location setter
			p = Pattern.compile("tourist location");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Tourist location");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).setTouristLocation(atributeCounter);
			atributeCounter=0;
			
			//expensive
			p = Pattern.compile("expensive");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Expensive");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).setExpensive(atributeCounter);
			atributeCounter=0;
	
			//museum
			p = Pattern.compile("museum");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Museum");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).dayLife.setMuseum(atributeCounter);
			atributeCounter=0;
			
			//bar
			p = Pattern.compile("bar");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Bar");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).nightLife.setBar(atributeCounter);
			atributeCounter=0;
			
			//accommodation type
			accommodationType=thisTraveller.getAccommodationType();
			p = Pattern.compile(accommodationType);
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).setAccomodationTypeCounter(atributeCounter);
			atributeCounter=0;
			
			//safari 
			p = Pattern.compile("safari");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Safari");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).activities.setSafari(atributeCounter);
			atributeCounter=0;
			
			//watersports
			p = Pattern.compile("water sports");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			p = Pattern.compile("Water sports");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
			    atributeCounter++;
			}
			theCities.get(i).activities.setWatersports(atributeCounter);
			atributeCounter=0;
		
		

		  	//wintersports
		  	p = Pattern.compile("winter sports");
		  	m= p.matcher(wikiExtracts);
		 	while (m.find()) {
		    atributeCounter++;
			}
			p = Pattern.compile("Winter sports");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
		    	atributeCounter++;
			}
			theCities.get(i).activities.setWintersports(atributeCounter);
			atributeCounter=0;

		  	//hiking
		  	p = Pattern.compile("hiking");
		  	m= p.matcher(wikiExtracts);
		 	while (m.find()) {
		    atributeCounter++;
			}
			p = Pattern.compile("Hiking");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
		    	atributeCounter++;
			}
			theCities.get(i).activities.setHiking(atributeCounter);
			atributeCounter=0;

		  	//cruise
		  	p = Pattern.compile("cruise");
		  	m= p.matcher(wikiExtracts);
		 	while (m.find()) {
		    atributeCounter++;
			}
			p = Pattern.compile("Cruise");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
		    	atributeCounter++;
			}
			theCities.get(i).activities.setCruise(atributeCounter);
			atributeCounter=0;
			
		  	//bar
		  	p = Pattern.compile("bar");
		  	m= p.matcher(wikiExtracts);
		 	while (m.find()) {
		    atributeCounter++;
			}
			p = Pattern.compile("Bar");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
		    	atributeCounter++;
			}
			theCities.get(i).nightLife.setBar(atributeCounter);
			atributeCounter=0;

		  	//opera
		  	p = Pattern.compile("opera");
		  	m= p.matcher(wikiExtracts);
		 	while (m.find()) {
		    atributeCounter++;
			}
			p = Pattern.compile("Opera");
			m = p.matcher(wikiExtracts);
			while (m.find()) {
		    	atributeCounter++;
			}
			theCities.get(i).dayLife.setOpera(atributeCounter);
			atributeCounter=0;
			
			//cinema
			p = Pattern.compile("cinema");
			m= p.matcher(wikiExtracts);
		   while (m.find()) {
		    atributeCounter++;
		   }
		   p = Pattern.compile("Cinema");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).dayLife.setCinema(atributeCounter);
		   atributeCounter=0;

		  //church
		  p = Pattern.compile("church");
		  m= p.matcher(wikiExtracts);
		  while (m.find()) {
		   atributeCounter++;
		  }
		  p = Pattern.compile("Church");
		  m = p.matcher(wikiExtracts);
		  while (m.find()) {
		 	atributeCounter++;
		  }
		  theCities.get(i).dayLife.setChurch(atributeCounter);
		  atributeCounter=0;
		
		   //seaport
		   p = Pattern.compile("seaport");
		   m= p.matcher(wikiExtracts);
		   while (m.find()) {
			atributeCounter++;
		   }
		   p = Pattern.compile("Seaport");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).locationAtractions.setSeatport(atributeCounter);
		   atributeCounter=0;

		   //airport
		   p = Pattern.compile("airport");
		   m= p.matcher(wikiExtracts);
		   while (m.find()) {
			atributeCounter++;
		   }
		   p = Pattern.compile("Airport");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).locationAtractions.setAirport(atributeCounter);
		   atributeCounter=0;
		   
		   //train
		   p = Pattern.compile("train");
		   m= p.matcher(wikiExtracts);
		   while (m.find()) {
			atributeCounter++;
		   }
		   p = Pattern.compile("Train");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).locationAtractions.setTrain(atributeCounter);
		   atributeCounter=0;

		   //subway
		   p = Pattern.compile("subway");
		   m= p.matcher(wikiExtracts);
		   while (m.find()) {
			atributeCounter++;
		   }
		   p = Pattern.compile("Subway");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).locationAtractions.setSubway(atributeCounter);
		   atributeCounter=0;

		   //lake
		   p = Pattern.compile("lake");
		   m= p.matcher(wikiExtracts);
		   while (m.find()) {
			atributeCounter++;
		   }
		   p = Pattern.compile("Lake");
		   m = p.matcher(wikiExtracts);
		   while (m.find()) {
			  atributeCounter++;
		   }
		   theCities.get(i).locationAtractions.setLake(atributeCounter);
		   atributeCounter=0;
	
		
		}	
			
		if ( theCities.size()==0) {
			System.out.println("No real cities were found");
			System.exit(0);
		}
		
		return theCities;
		
	}
	
	//συμπληρωνει τα χαρακτηριστικα μιας πολης με βαση το Open Weather Map
	public void setCitysAtributesOpenWeatherMap ( City thisCity) throws Exception {
		
		OpenDataRest OpenWeatherMapsData=new OpenDataRest();
		String appid ="42f49873c6d0aabc9bf0f7d818da6ec9"; 

		
		
		OpenWeatherMapsData.RetrieveOpenWeatherMap( thisCity.getName(), thisCity.getCountryName(), appid, thisCity); 
		
	}

	public static void perfectCityFinder( Traveller theTraveller, JFrame fff) {
		
		//Traveller theTraveller=new Traveller();
		
		fff.setVisible(false);
		
		ArrayList<City> selectedCities=new ArrayList<City>();
		
		JFrame f= new JFrame("Destination Finder");  
		
	    JLabel l1,l2,l3;  
	    l1=new JLabel("Please give us some cities that you intent to visit!");  
	    l1.setBounds(0,5, 400,40);  
	    l2=new JLabel("City");  
	    l2.setBounds(0,60, 50,30);  
	    l3=new JLabel("Country(s.n.)");  
	    l3.setBounds(0,100, 100,30);  
	    f.add(l1);  f.add(l2); f.add(l3);
	    
	    JTextField t1,t2;  
	    t1=new JTextField();  
	    t1.setBounds(130,60, 150,25);  
	    t2=new JTextField();  
	    t2.setBounds(130,100, 150,25);  
	    f.add(t1); f.add(t2);  
	    
	    JButton b=new JButton("Submit");  
	    b.setBounds(170,140,125,35);  
	    b.addActionListener(new ActionListener(){ 
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		try {	    			
	    			City newCity=new City();
	    			newCity.setName(t1.getText());
	    			newCity.setCountryName(t2.getText());	    			
		    		OpenDataRest OpenWeatherMapsData=new OpenDataRest();
		    		String appid ="42f49873c6d0aabc9bf0f7d818da6ec9"; 
		    		OpenWeatherMapsData.RetrieveOpenWeatherMap( newCity.getName(), newCity.getCountryName(), appid, newCity); 
		    		
		    		selectedCities.add(newCity);
		    		
		    		l1.setText(t1.getText()+" succesfully added");
	    		}catch (Exception ex) {
	    			l1.setText("We could not find the city: "+t1.getText());
	    		}

	    		t1.setText(null);
	    		t2.setText(null);
	    		
	        }  
	    });
	    f.add(b);
	    
	    JButton b1=new JButton("See Results");  
	    b1.setBounds(170,180,125,35); 
	    b1.setBackground(Color.green);
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		if (selectedCities.size()==0) {
	    		    JOptionPane.showMessageDialog(f,"We will try to find you a city based only on your preferences","",JOptionPane.INFORMATION_MESSAGE);    
	    		    
					userPrefsAndVisit hisPrefs=new userPrefsAndVisit(theTraveller.getVisit(),theTraveller.getWeather(),theTraveller.getLocationAtractions(),theTraveller.getTypeOfPlace(),theTraveller.getClime(),theTraveller.getContinent()
							,theTraveller.getTouristLocation(),theTraveller.getExpensive(),theTraveller.getDayLife(),theTraveller.getNightLife(),theTraveller.getAccommodationType(),theTraveller.getActivities());

					String cityName=null;
					try {
						cityName=Streams.cleverSearch(hisPrefs);
						
		    		    JOptionPane.showMessageDialog(f,"Your perfect destination is: "+cityName,"",JOptionPane.INFORMATION_MESSAGE);    

					} catch (IOException e1) {
						// TODO Auto-generated catch block
		    		    JOptionPane.showMessageDialog(f,"We could not find anything! We are sorry!","Alert",JOptionPane.INFORMATION_MESSAGE); 
		    		    System.exit(0);
					}
					
					theTraveller.setVisit(cityName);
					
					try {
						
						userPrefsAndVisit hisPrefs1=new userPrefsAndVisit(theTraveller.getVisit(),theTraveller.getWeather(),theTraveller.getLocationAtractions(),theTraveller.getTypeOfPlace(),theTraveller.getClime(),theTraveller.getContinent()
								,theTraveller.getTouristLocation(),theTraveller.getExpensive(),theTraveller.getDayLife(),theTraveller.getNightLife(),theTraveller.getAccommodationType(),theTraveller.getActivities());
						
						ArrayList<userPrefsAndVisit> allUsersPrefs=new ArrayList<>();
						allUsersPrefs=newMain.fileReaderPrefs(allUsersPrefs);
						
						allUsersPrefs.add(hisPrefs1);
//System.out.println(allUsersPrefs.get(allUsersPrefs.size()-1).getVisit());
//System.out.println(allUsersPrefs.size());
						newMain.fileWriterPrefs(allUsersPrefs);

						
					}catch (Exception ex) {
						System.out.println("smth wrong");
					}
					
					System.exit(0);
					
	    		}else {
	    			
	    			City testCity=new City();
	    			
	    			try {
						testCity.setCitiessAtributtes( theTraveller, selectedCities);
						newMain.DBWriter( selectedCities);
						
						City chosenOne=new City();

						chosenOne=theTraveller.CompareCities(selectedCities, theTraveller, theTraveller.isWantsRain());								
						
						JOptionPane.showMessageDialog(f, "Your perfect destination is: "+chosenOne.getName(), "FOUND IT", JOptionPane.INFORMATION_MESSAGE);
						
						theTraveller.setVisit(chosenOne.getName());
						
						try {
							
							userPrefsAndVisit hisPrefs=new userPrefsAndVisit(theTraveller.getVisit(),theTraveller.getWeather(),theTraveller.getLocationAtractions(),theTraveller.getTypeOfPlace(),theTraveller.getClime(),theTraveller.getContinent()
									,theTraveller.getTouristLocation(),theTraveller.getExpensive(),theTraveller.getDayLife(),theTraveller.getNightLife(),theTraveller.getAccommodationType(),theTraveller.getActivities());
							
							ArrayList<userPrefsAndVisit> allUsersPrefs=new ArrayList<>();
							allUsersPrefs=newMain.fileReaderPrefs(allUsersPrefs);
							
							allUsersPrefs.add(hisPrefs);
//System.out.println(allUsersPrefs.get(allUsersPrefs.size()-1).getVisit());
//System.out.println(allUsersPrefs.size());
							newMain.fileWriterPrefs(allUsersPrefs);

							
						}catch (Exception ex) {
							System.out.println("smth wrong");
						}
						
						System.exit(0);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//System.out.println("Something is up!!!");
					}
	    		}
	    		
	    		
	    		
	        }  
	    }); 
	    f.add(b1);
	    
	    JButton b2=new JButton("Popular Location Search");  
	    b2.setBounds(110,220,235,35); 
	    b2.setBackground(Color.red);
	    b2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		if (selectedCities.size()==0) {
	    		    JOptionPane.showMessageDialog(f,"Please insert at least one city!","Alert",JOptionPane.INFORMATION_MESSAGE);     
	    		}else {
	    			ArrayList<cityPopularity> popularityCities=new ArrayList<>();

	    			Iterator itr=selectedCities.iterator();
	    			
	    			while (itr.hasNext()) {  //δημιουργω arraylist( popularityCities) που το format του ειναι: {ονομα πολης, αριθμος λεξεων στη wikipedia}  *γραμμη 262 κλαση: City
	    				
	    				City cityTemp=new City();

	    				cityTemp=(City) itr.next();
	    				
	    				OpenDataRest dataReceiver=new OpenDataRest();	    				
	    				String wikiExtracts = null;
						try {
							wikiExtracts = dataReceiver.RetrieveWikipedia(cityTemp.getName());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    				
	    				cityPopularity popularityTemp=new cityPopularity(cityTemp.getName(), countTextWords(wikiExtracts));
	    				
	    				popularityCities.add(popularityTemp);
	    			}
    				List<cityPopularity> l1=new ArrayList<>();

    				l1=popularityCities.stream().sorted().collect(Collectors.toList()); //κανω αυξουσα ταξινομηση  				   				
    				
    				// παρακατω κοματι κωδικα μπορει να χρησιμοποιηθει για να επαληθευσει τη σωστη επεξεργασια των δεδομενων
    				/* Iterator itr1=l1.iterator();
    				
    				while (itr1.hasNext()) {
    					
    					cityPopularity temp=new cityPopularity();
    					
    					temp=(cityPopularity) itr1.next();
    					
    					System.out.println("city name: "+temp.getCityName()+"  total words: "+temp.getWordCounter());
    					
    				}*/
    				
	    		    JOptionPane.showMessageDialog(f,"Your perfect destination is: "+l1.get(l1.size()-1).getCityName(),"",JOptionPane.INFORMATION_MESSAGE); //διαλεγω το τελευταιο στοιχειο γιατι εχει το μεγαλυτερο αριθμο λεξεων
    					    		    
	    		    ArrayList<String> popularityCitiesNames=new ArrayList<>();
	    		    
	    		    Iterator itr10=popularityCities.iterator();
	    		    
	    		    while (itr10.hasNext()) {  //δημιουργω ενα arraylist μονο με τα ονοματα των πολεων για να τα αποθηκευσω στο αρχειο
	    		    	
	    		    	cityPopularity temp=(cityPopularity) itr10.next();
	    		    	
	    		    	popularityCitiesNames.add(temp.getCityName());
	    		    	
	    		    }

    		    	try {
    				ArrayList<String> theCities=new ArrayList<>();
    				theCities=fileReaderCities(theCities);
    		//System.out.println(theCities.size());  			//αυτες οι δυο γραμμες println μπορουν να χρησιμοποιηθουν για να επαληθευτει οτι οι πολεις αποθηκευονται στο αρχειο
    				theCities.addAll(popularityCitiesNames);
    		//System.out.println(theCities.size());
    			
    				fileWriterCities(theCities);
	    			} catch (IOException ex) {
	    				// TODO Auto-generated catch block
	    				ex.printStackTrace();
	    			}
	    		    
    				System.exit(0);
	    				  				    				    				    			
	    		}
	    	}
	    });	
	    f.add(b2);
	    
	    f.setSize(450,340);  
	    f.setLayout(null);  
	    f.setVisible(true); 
		
	}
	
	//method from stack overflow that counts words
	public static int countTextWords(String input) {
		    if (input == null || input.isEmpty()) {
		      return 0;
		    }

		    String[] words = input.split("\\s+");
		    return words.length;
	 }
	
	public static ArrayList<String> fileReaderCities ( ArrayList<String> theCities) {
		//για να διαβασει απο το file
		File file = new File("Cities.tmp");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("Cities.tmp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream ois = null ;
		if (file.length()>0) {
			try {
				ois = new ObjectInputStream(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				theCities = (ArrayList<String>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return theCities;
		
	}
	
	public static void fileWriterCities ( ArrayList<String> theCities) throws IOException {
		FileOutputStream fos = new FileOutputStream("Cities.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(theCities);
		oos.close();
	}
	
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof City)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        City c = (City) o; 
          
        // Compare the data members and return accordingly  
        return name.equals(c.name);
        
    }


	
	
}










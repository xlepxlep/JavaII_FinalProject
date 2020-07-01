package OOPII_21829_218105;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import OOPII_21829_218105.userPrefsAndVisit;
import openDataRest.OpenDataRest;

public class Traveller implements Comparable<Traveller>,Serializable{
	
	static final int N=10; //number of travelers to get in the lottery for the free ticket

	int type; //1=traveller 2=tourist 3=business
	int index; //where he is in the arraylist
	
	//users' personal information
	private int gender; // 1=Mr 2=Mrs 3=other
	private String fullName;
	private String fathersName;
	private String identityNumber;
	private int age;
	private String nationality;
		
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
	
	//only used for business
	private String cityNow;
	private String countryNow;
	double latNow;
	double lonNow;

	//CONTRUCTORS
	
	public Traveller() {	
		this.gender = -1;
		this.fullName = "empty";
		this.fathersName = "empty";
		this.identityNumber = "empty";
		this.age = -1;
		this.nationality = "empty";
		this.weather = "empty";
		this.typeOfPlace = "empty";
		this.clime = "empty";
		this.continent = "empty";
		this.touristLocation = 0;
		this.expensive = 0;
		this.accommodationType = "empty";
		
	}

	//Constructor που περεχει τα πεδια που αφορουν τα προσωπικα στοιχεια του χρηστη
	public Traveller(int gender, String fullName, String fathersName, String identityNumber, int age,
			String nationality) {
		super();
		this.gender = gender;
		this.fullName = fullName;
		this.fathersName = fathersName;
		this.identityNumber = identityNumber;
		this.age = age;
		this.nationality = nationality;
	}

	//Constructor που περεχει τα στοιχεια που αφορουν τα prefs του χρηστη
	public Traveller(String weather, locationAtractionss locationAtractions, String typeOfPlace, String clime,
			String continent, int touristLocation, int expensive, dayLifee dayLife, nightLifee nightLife,
			String accommodationType, activitiess activities, String cityNow, String countryNow, double latNow,
			double lonNow) {
		super();
		this.weather = weather;
		this.locationAtractions = locationAtractions;
		this.typeOfPlace = typeOfPlace;
		this.clime = clime;
		this.continent = continent;
		this.touristLocation = touristLocation;
		this.expensive = expensive;
		this.getDayLife = dayLife;
		this.nightLife = nightLife;
		this.accommodationType = accommodationType;
		this.activities = activities;
		this.cityNow = cityNow;
		this.countryNow = countryNow;
		this.latNow = latNow;
		this.lonNow = lonNow;
	}

	//SETTERS, GETTERS
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getCityNow() {
		return cityNow;
	}
	public void setCityNow(String cityNow) {
		this.cityNow = cityNow;
	}
	public String getCountryNow() {
		return countryNow;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setCountryNow(String countryNow) {
		this.countryNow = countryNow;
	}
	public double getLatNow() {
		return latNow;
	}
	public void setLatNow(double latNow) {
		this.latNow = latNow;
	}
	public double getLonNow() {
		return lonNow;
	}
	public void setLonNow(double lonNow) {
		this.lonNow = lonNow;
	}
	public dayLifee getDayLife() {
		return getDayLife;
	}
	public void setDayLife(dayLifee dayLife) {
		this.getDayLife = dayLife;
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
	public locationAtractionss getLocationAtractions() {
		return locationAtractions;
	}
	public void setLocationAtractions(locationAtractionss locationAtractions) {
		this.locationAtractions = locationAtractions;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
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
	public String getAccommodationType() {
		return accommodationType;
	}
	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	//METHODS
	
	//adds a new users personal info
	static void addNewTravellersInfo( Traveller newTraveller, ArrayList<ArrayList<Traveller>> theTravellers) { 
		
		Scanner myInput=new Scanner(System.in);		
		System.out.print("Please choose your gender: \n\n1.Mr \n2.Mrs \n3.Other \n");
		int choice;
		while (true) {
			try {
				choice=myInput.nextInt();
				while (choice<1 || choice>3) {
					System.out.println("Please type a valid option!");
					choice=myInput.nextInt();
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please type a valid option!");
				myInput.nextLine(); //χωρις αυτο ετρεχε συνεχεια το catch σαν loop
			}
		}
		newTraveller.setGender(choice);
		myInput.nextLine();
		
		while (true) {
		
			System.out.println("Please type your Name: \n");
			newTraveller.setFullName(myInput.nextLine());
			
			
			Iterator itr1=theTravellers.iterator();
			
			while (itr1.hasNext()) {
				
				ArrayList<Traveller> aTraveller=(ArrayList<Traveller>) itr1.next();
				
				if (aTraveller.get(0).getFullName().equals(newTraveller.fullName)) {
					System.out.println("This name is already used!!!");
					newTraveller.fullName="superMario";
					break;
				}
				
			}
		
			if (!newTraveller.fullName.equals("superMario")) {
				break;
			}
			
			
		}
		
/*		System.out.print("\nPlease type your fathers' Name: \n");
		newTraveller.setFathersName(myInput.nextLine());
		
		System.out.print("\nPlease type your Identity Number: \n");
		newTraveller.setIdentityNumber(myInput.nextLine());
		
*/
		System.out.print("\nPlease type your age: \n");
		int age;
		while (true) {
			try {
				age=myInput.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please type a valid option!");
				myInput.nextLine(); //χωρις αυτο ετρεχε συνεχεια το catch σαν loop
			}
		}
		myInput.nextLine(); //without it the next myInput.nextLine wouldnt work
		if( age<15 || age>130) {
			System.out.println("You can't use our program due to age restriction rules!");
			System.out.println("You can use it with your parents though!!!");
			System.exit(0);
		}
		
		newTraveller.setAge(age);
/*		
		System.out.print("\nPlease type your Nationality: \n");
		newTraveller.setNationality(myInput.nextLine());
*/		  
		
		while (true) {
			try {

				System.out.print("Please type your current location! \nCity: ");
				newTraveller.setCityNow(myInput.nextLine());
				System.out.println("Country(short name): ");
				newTraveller.setCountryNow(myInput.nextLine());
				
				OpenDataRest OpenWeatherMapsData=new OpenDataRest();
				String appid ="42f49873c6d0aabc9bf0f7d818da6ec9"; 
				
				OpenWeatherMapsData.RetrieveOpenWeatherMap( newTraveller.getCityNow(), newTraveller.getCountryNow(), appid, newTraveller); 
				
				break;
			} catch (Exception e) {
				System.out.println("Please type a city that exists!!!");
			}
		}
		
	}
	
	//sets the preferences of an already existing user
	public void settingTravellersPreferences( Traveller thisTraveller) throws Exception {  //να βαλω και τα υπολοιπα πεδια
		
		int choice;
		Scanner myInput=new Scanner(System.in);
		
		
		System.out.println("Choose the prefered weather: 1.sun 2.rain 3.snow 4.clouds");
		choice=myInput.nextInt();
		while (choice<1 || choice>4) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setWeather("Sun");}
		if(choice==2) {thisTraveller.setWeather("Rain");}
		if(choice==3) {thisTraveller.setWeather("Snow");}
		if(choice==4) {thisTraveller.setWeather("Clouds");}

		
		System.out.println("Choose character of place: 1.city 2.island 3.mountain 4.village");
		choice=myInput.nextInt();
		while (choice<1 || choice>4) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setTypeOfPlace("city");}
		if(choice==2) {thisTraveller.setTypeOfPlace("island");}
		if(choice==3) {thisTraveller.setTypeOfPlace("mountain");}
		if(choice==4) {thisTraveller.setTypeOfPlace("village");}
		
		
/*		System.out.println("Choose type of climate: 1.hot 2.mild 3.cold");
		choice=myInput.nextInt();
		while (choice<1 || choice>3) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setClime("hot");}
		if(choice==2) {thisTraveller.setClime("mild");}
		if(choice==3) {thisTraveller.setClime("cold");}		
	
		
		System.out.println("Do you want to go to a tourist location?  1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setTouristLocation(1);}
		if(choice==2) {thisTraveller.setTouristLocation(0);}
		
		
		System.out.println("Do you want a cheap vacation?   1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setExpensive(0);}
		if(choice==2) {thisTraveller.setExpensive(1);}
			
		
		System.out.println("Are you intersted in location atractions?  1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if (choice==1) {
			System.out.println("Do you want to be near a beach?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setBeach(1);}
			if(choice==2) {thisTraveller.locationAtractions.setBeach(0);}
			
			System.out.println("Do you want to be near a river?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setRiver(1);}
			if(choice==2) {thisTraveller.locationAtractions.setRiver(0);}
			
			System.out.println("Do you want to be near a canyon?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setCanyon(1);}
			if(choice==2) {thisTraveller.locationAtractions.setCanyon(0);}
			System.out.println("Do you want to be near a airport?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setAirport(1);}
			if(choice==2) {thisTraveller.locationAtractions.setAirport(0);}
			System.out.println("Do you want to be near a lake?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setLake(1);}
			if(choice==2) {thisTraveller.locationAtractions.setLake(0);}
			System.out.println("Do you want to be near a train?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setTrain(1);}
			if(choice==2) {thisTraveller.locationAtractions.setTrain(0);}
			System.out.println("Do you want to be near a subway?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.locationAtractions.setSubway(1);}
			if(choice==2) {thisTraveller.locationAtractions.setSubway(0);}
			
		}// else, it leaves them empty -> -1
		
		System.out.println("Are you intersted for morning/day life?  1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if (choice==1) {
			System.out.println("Do you want to be near a church?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.dayLife.setChurch(1);}
			if(choice==2) {thisTraveller.dayLife.setChurch(0);}
			
			System.out.println("Do you want to be near a cinema?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.dayLife.setCinema(1);}
			if(choice==2) {thisTraveller.dayLife.setCinema(0);}
			
			System.out.println("Do you want to be near a opera?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.dayLife.setOpera(1);}
			if(choice==2) {thisTraveller.dayLife.setOpera(0);}
			System.out.println("Do you want to be near a museum?   1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.dayLife.setMuseum(1);}
			if(choice==2) {thisTraveller.dayLife.setMuseum(0);}
			
		}// else, it leaves them empty -> -1
		System.out.println("Are you intersted for night life?  1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if (choice==1) {
			System.out.println("Do you want to be near a bar?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.nightLife.setBar(1);}
			if(choice==2) {thisTraveller.nightLife.setBar(0);}
		}// else, it leaves them empty -> -1	
		
		System.out.println("Are you intersted for activites?  1.Yes 2.No");
		choice=myInput.nextInt();
		while (choice<1 || choice>2) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if (choice==1) {
			System.out.println("Do you want to do hiking?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.activities.setHiking(1);}
			if(choice==2) {thisTraveller.activities.setHiking(0);}
			System.out.println("Do you want to do a cruise?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.activities.setCruise(1);}
			if(choice==2) {thisTraveller.activities.setCruise(0);}
			System.out.println("Do you want to do safari?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.activities.setSafari(1);}
			if(choice==2) {thisTraveller.activities.setSafari(0);}
			System.out.println("Do you want to do winter sports?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.activities.setWintersports(1);}
			if(choice==2) {thisTraveller.activities.setWintersports(0);}
			System.out.println("Do you want to do water sports?  1.Yes 2.No");
			choice=myInput.nextInt();
			while (choice<1 || choice>2) {
				System.out.println("Please type a valid option!");
				choice=myInput.nextInt();
			}
			if(choice==1) {thisTraveller.activities.setWatersports(1);}
			if(choice==2) {thisTraveller.activities.setWatersports(0);}
		}// else, it leaves them empty -> -1		
		System.out.println("Please choose accomodation type: 1.Hotel 2.Camping "
				+ "3.Ski Chalet 4.Resort");
		choice=myInput.nextInt();
		while (choice<1 || choice>4) {
			System.out.println("Please type a valid option!");
			choice=myInput.nextInt();
		}
		if(choice==1) {thisTraveller.setAccommodationType("hotel");}
		if(choice==2) {thisTraveller.setAccommodationType("camping");}
		if(choice==3) {thisTraveller.setAccommodationType("ski chalet");}
		if(choice==4) {thisTraveller.setAccommodationType("resort");}
*/		
		
		//εχω να βαλω και: dayLifee, nightLifee, activitiess
		
		//myInput.close();
		
	}
	
	public int Similarity ( City thisCity, Traveller thisTraveller) throws IOException {	
		
		int fieldCounter=0;
		int totalFields=0;
		
		if (thisTraveller.getWeather().equals(thisCity.getWeather())) { //if user weather preference is the same with the weather at this city
			fieldCounter++;
		}
		totalFields++;
		if (thisTraveller.getClime().equals(thisCity.getClime())) {
			fieldCounter++;
		}
		totalFields++;
		if (thisTraveller.getTouristLocation()>0 && thisCity.getTouristLocation()>0) { //if user wanted the city to be tourist location AND the city is tourist location
			fieldCounter++;
		}
		if (thisTraveller.getTouristLocation()>0) { //if user wanted the atribute tourist location, it is taken into consideration in our similarity percentage, if not it isnt
			totalFields++;
		}
		if (thisTraveller.getExpensive()>0 && thisCity.getExpensive()>0) {
			fieldCounter++;
		}
		if (thisTraveller.getExpensive()>0) {
			totalFields++;
		}	
		if (thisTraveller.locationAtractions.getBeach()>0 && thisCity.getLocationAtractions().getBeach()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getBeach()>0) {
			totalFields++;
		}
		if (thisTraveller.locationAtractions.getCanyon()>0 && thisCity.getLocationAtractions().getCanyon()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getCanyon()>0) {
			totalFields++;
		}
		if (thisTraveller.locationAtractions.getRiver()>0 && thisCity.getLocationAtractions().getRiver()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getRiver()>0) {
			totalFields++;
		}	
		if (thisTraveller.locationAtractions.getLake()>0) {
			totalFields++;
		}
		if (thisTraveller.locationAtractions.getLake()>0 && thisCity.getLocationAtractions().getLake()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getAirport()>0) {
			totalFields++;			
		}
		if (thisTraveller.locationAtractions.getAirport()>0 && thisCity.getLocationAtractions().getAirport()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getSeatport()>0) {
			totalFields++;			
		}	
		if (thisTraveller.locationAtractions.getSeatport()>0 && thisCity.getLocationAtractions().getSeatport()>0) {
			fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getSubway()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.locationAtractions.getSubway()>0 && thisCity.getLocationAtractions().getSubway()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.locationAtractions.getTrain()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.locationAtractions.getTrain()>0 && thisCity.getLocationAtractions().getTrain()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.activities.getCruise()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.activities.getCruise()>0 && thisCity.getActivities().getCruise()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.activities.getHiking()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.activities.getHiking()>0 && thisCity.getActivities().getHiking()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.activities.getSafari()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.activities.getSafari()>0 && thisCity.getActivities().getSafari()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.activities.getWatersports()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.activities.getWatersports()>0 && thisCity.getActivities().getWatersports()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.activities.getWintersports()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.activities.getWintersports()>0 && thisCity.getActivities().getWintersports()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.getDayLife.getChurch()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.getDayLife.getChurch()>0 && thisCity.getDayLife().getChurch()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.getDayLife.getCinema()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.getDayLife.getCinema()>0 && thisCity.getDayLife().getCinema()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.getDayLife.getMuseum()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.getDayLife.getMuseum()>0 && thisCity.getDayLife().getMuseum()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.getDayLife.getOpera()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.getDayLife.getOpera()>0 && thisCity.getDayLife().getOpera()>0) {
		   fieldCounter++;
		}
		if (thisTraveller.nightLife.getBar()>0) {
			totalFields++;			
	    }	
	    if (thisTraveller.nightLife.getBar()>0 && thisCity.getNightLife().getBar()>0) {
		   fieldCounter++;
		}
	    if (thisTraveller.getDayLife.getChurch()>0 && thisCity.getDayLife().getChurch()>0) {
		   fieldCounter++;
	    }
		if (thisTraveller.getAccommodationType().equals(thisCity.getAccommodationType())) {
			fieldCounter++;
		}
		totalFields++;
		
		int matchingPercentage=(fieldCounter*100)/totalFields;
		
		return matchingPercentage; 
		
	}
	
	public City CompareCities ( ArrayList<City> thoseCities, Traveller thisTraveller) throws IOException { //used if traveller isnt bothered by rain
		
		int cityCounter=0;
		City bestFit=new City(); //the city that suits the best the preferences of the traveller
		//bestFit=thoseCities.get(cityCounter);
		int bestFitPercent=0;//Similarity( thoseCities.get(cityCounter), thisTraveller); //percent of similarity, of the best suited city
		
		Iterator i=thoseCities.iterator();
		while (i.hasNext()) {
		
			City thisCity=new City();
			thisCity=(City)i.next();
			int currentFitPercent=Similarity( thisCity,thisTraveller);
//System.out.println("Comparing: "+thisCity.getName()+"   CurFit: "+currentFitPercent+"   BestFit"+bestFitPercent);			
			if (currentFitPercent>bestFitPercent) {
				bestFit=thisCity;
				bestFitPercent=currentFitPercent;
			}

			
		}
//System.out.println("Sending back: "+bestFit.getName());		
		return bestFit;
		
	}
	
	//στη συνεχεια να συγκρινει μονομε πολεις που δεν εχουν rain
	public City CompareCities ( ArrayList<City> thoseCities, Traveller thisTraveller, boolean rain) throws IOException { //if rain is true->cities with rain are not taken into consideration
		
		boolean check=thoseCities.isEmpty();
		if (check==true) {
			// ***return smthing for ALARM
		}
		
		if (!rain) { // if traveller isnt bothered about the rain
			City returningCity=new City();
			returningCity=CompareCities( thoseCities, thisTraveller);
			return returningCity;
		}
		
		int cityCounter=0;
		City bestFit=new City(); //the city that suits the best the preferences of the 
		int bestFitPercent=-1; 
		
		Iterator<City> i=thoseCities.iterator();
		while (i.hasNext()) {

			if (!"rain".equals(thoseCities.get(cityCounter).getWeather())) {
			
				bestFit=thoseCities.get(cityCounter);
				bestFitPercent=Similarity( thoseCities.get(cityCounter), thisTraveller); //percent of similarity, of the best suited city
				//to be deleted
				cityCounter++;
				i.next();
				break;
			}	
			
			cityCounter++;
			i.next();
			
		}
		
		while (i.hasNext()) {
			
			if (!"rain".equals(thoseCities.get(cityCounter).getWeather())) {
				int currentFitPercent=Similarity( thoseCities.get(cityCounter), thisTraveller);

				if (currentFitPercent>bestFitPercent) {
					bestFit=thoseCities.get(cityCounter);
					bestFitPercent=currentFitPercent;
				}
			}		
			cityCounter++;
			i.next();
		}
		
		//if it rains at every city
		if ( bestFitPercent==-1) { // ***Return something for alarm!!!
			JOptionPane.showMessageDialog(null, "Its raining everywhere!!!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		return bestFit;
		
	}
	
	// searches for the older user with the maximum similarity
	public Traveller freeTicketGiver ( City thisCity, Traveller travellerGuys[]) throws IOException {
		
		Traveller bestTraveller=new Traveller();
		bestTraveller=travellerGuys[0];
		
		for ( int i=0; i<N; i++) {
			if ( Similarity( thisCity, travellerGuys[i])>Similarity( thisCity, bestTraveller)) {
				bestTraveller=travellerGuys[i];
			}
		}
		
		return bestTraveller; // ***Alarm for not finding anything
		
	}

	public static void prefsSetter(JFrame f, Traveller theTraveller) {
		Traveller newUser=new Traveller();

		f.getContentPane().removeAll();
		f.repaint();
		
	    JLabel l1,l2,l3,l4;  
	    l1=new JLabel("Choose weather");  
	    l1.setBounds(0,0, 200,30);  
	    l2=new JLabel("Choose Clime");  
	    l2.setBounds(0,40, 200,30);  
	    l3=new JLabel("Choose Accomodation Type");  
	    l3.setBounds(0,80, 200,30);  
	    l4=new JLabel("Choose Type of Place");  
	    l4.setBounds(0,120, 200,30);  
	    f.add(l1); f.add(l2); f.add(l3); f.add(l4);   
	    
	    JRadioButton r1=new JRadioButton("Sun");    
	    JRadioButton r2=new JRadioButton("Rain");    
	    JRadioButton r3=new JRadioButton("Snow");  
	    JRadioButton r4=new JRadioButton("Clouds");
	    r1.setBounds(0,20,100,30);    
	    r2.setBounds(100,20,100,30);    
	    r3.setBounds(200,20,100,30);
	    r4.setBounds(300,20,100,30);
	    ButtonGroup bg1=new ButtonGroup();    
	    bg1.add(r1);bg1.add(r2); bg1.add(r3);  bg1.add(r4);     
	    f.add(r1);f.add(r2); f.add(r3); f.add(r4);
        
	    JRadioButton r11=new JRadioButton("Hot");    
	    JRadioButton r21=new JRadioButton("Mild");    
	    JRadioButton r31=new JRadioButton("Cold");  
	    r11.setBounds(0,60,100,30);    
	    r21.setBounds(100,60,100,30);    
	    r31.setBounds(200,60,100,30);
	    ButtonGroup bg11=new ButtonGroup();    
	    bg11.add(r11);bg11.add(r21); bg11.add(r31);      
	    f.add(r11);f.add(r21); f.add(r31);
	    
	    JRadioButton r111=new JRadioButton("Hotel");    
	    JRadioButton r211=new JRadioButton("Camping");    
	    JRadioButton r311=new JRadioButton("Ski Chalet");  
	    JRadioButton r411=new JRadioButton("Resort");
	    r111.setBounds(0,100,100,30);    
	    r211.setBounds(100,100,100,30);    
	    r311.setBounds(200,100,100,30);
	    r411.setBounds(300,100,100,30);
	    ButtonGroup bg111=new ButtonGroup();    
	    bg111.add(r111);bg111.add(r211); bg111.add(r311);  bg111.add(r411);     
	    f.add(r111);f.add(r211); f.add(r311); f.add(r411);
	    
	    JRadioButton r1111=new JRadioButton("City");    
	    JRadioButton r2111=new JRadioButton("Island");    
	    JRadioButton r3111=new JRadioButton("Mountain");  
	    JRadioButton r4111=new JRadioButton("Village");
	    r1111.setBounds(0,140,100,30);    
	    r2111.setBounds(100,140,100,30);    
	    r3111.setBounds(200,140,100,30);
	    r4111.setBounds(300,140,100,30);
	    ButtonGroup bg1111=new ButtonGroup();    
	    bg1111.add(r1111);bg1111.add(r2111); bg1111.add(r3111);  bg1111.add(r4111);     
	    f.add(r1111);f.add(r2111); f.add(r3111); f.add(r4111);
	    
	    JLabel l10,l20,l30;  
	    l10=new JLabel("Daily Life");  
	    l10.setBounds(0,180, 166,30);
	    l20=new JLabel("Transportation");  
	    l20.setBounds(166,180, 166,30);
	    l30=new JLabel("Location Atractions");  
	    l30.setBounds(332,180, 166,30);
	    f.add(l10); f.add(l20); f.add(l30);
	    
        JCheckBox cB1 = new JCheckBox("Church");  
        cB1.setBounds(0,210, 75,30);  
        JCheckBox cB2 = new JCheckBox("Cinema");  
        cB2.setBounds(0,235, 78,30);  
        JCheckBox cB3 = new JCheckBox("Museum");  
        cB3.setBounds(75,210, 85,30);  
        JCheckBox cB4 = new JCheckBox("Opera");  
        cB4.setBounds(75,235, 85,30);  
        f.add(cB1);  
        f.add(cB2); 
        f.add(cB3);  
        f.add(cB4); 
	    
        JCheckBox cB5 = new JCheckBox("Airport");  
        cB5.setBounds(160,210, 80,30);  
        JCheckBox cB6 = new JCheckBox("Subway");  
        cB6.setBounds(240,210, 85,30);  
        JCheckBox cB7 = new JCheckBox("Seaport");  
        cB7.setBounds(160,235, 82,30);  
        JCheckBox cB8 = new JCheckBox("Train");  
        cB8.setBounds(240,235, 88,30);  
        f.add(cB5);  
        f.add(cB6); 
        f.add(cB7);  
        f.add(cB8); 
        
        JCheckBox cB10 = new JCheckBox("Beach");  
        cB10.setBounds(330,210, 72,30);  
        JCheckBox cB11 = new JCheckBox("Canyon");  
        cB11.setBounds(400,210, 85,30);  
        JCheckBox cB12 = new JCheckBox("Lake");  
        cB12.setBounds(330,235, 72,30);  
        JCheckBox cB13 = new JCheckBox("River");  
        cB13.setBounds(400,235, 88,30);  
        f.add(cB10);  
        f.add(cB11); 
        f.add(cB12);  
        f.add(cB13);  
        
	    JLabel l15;  
	    l15=new JLabel("Activities & Nightlife");  
	    l15.setBounds(50,280, 166,30);
	    f.add(l15);
        
        JCheckBox cB14 = new JCheckBox("Cruise");  
        cB14.setBounds(50,320, 72,30);  
        JCheckBox cB15 = new JCheckBox("Hiking");  
        cB15.setBounds(50,360, 85,30);  
        JCheckBox cB16 = new JCheckBox("Safari");  
        cB16.setBounds(50,400, 72,30);  
        JCheckBox cB17 = new JCheckBox("Bar");  
        cB17.setBounds(140,320, 88,30);  
        JCheckBox cB18 =new JCheckBox("Watersports");  
        cB18.setBounds(140,360, 140,30);  
        JCheckBox cB19 = new JCheckBox("Wintersports");  
        cB19.setBounds(140,400, 140,30);  
        f.add(cB14);  
        f.add(cB15); 
        f.add(cB16);  
        f.add(cB17);  
        f.add(cB18);  
        f.add(cB19); 
	    
        JCheckBox cB20 = new JCheckBox("Exclude cities with rain");  
        cB20.setBounds(50,430, 272,30);  
        f.add(cB20);
        
        JButton b=new JButton("Submit");    
        b.setBounds(335,330,100, 100);    
        f.add(b); 
        
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			
        			if (r1.isSelected()) {theTraveller.setWeather("sun");}
        			if (r2.isSelected()) {theTraveller.setWeather("rain");}
        			if (r3.isSelected()) {theTraveller.setWeather("snow");}
        			if (r4.isSelected()) {theTraveller.setWeather("clouds");}
        			
        			if (r11.isSelected()) {theTraveller.setClime("hot");}
        			if (r21.isSelected()) {theTraveller.setClime("mild");}
        			if (r31.isSelected()) {theTraveller.setClime("cold");}
        			
        			if (r111.isSelected()) {theTraveller.setAccommodationType("hotel");}
        			if (r211.isSelected()) {theTraveller.setAccommodationType("camping");}
        			if (r311.isSelected()) {theTraveller.setAccommodationType("ski chalet");}
        			if (r411.isSelected()) {theTraveller.setAccommodationType("resort");}
        			
        			if (r1111.isSelected()) {theTraveller.setTypeOfPlace("city");}
        			if (r2111.isSelected()) {theTraveller.setTypeOfPlace("island");}
        			if (r3111.isSelected()) {theTraveller.setTypeOfPlace("mountain");}
        			if (r4111.isSelected()) {theTraveller.setTypeOfPlace("village");}
        			
        			if (cB1.isSelected()) {theTraveller.getDayLife().setChurch(1);;}
        			if (cB2.isSelected()) {theTraveller.getDayLife().setCinema(1);}
        			if (cB3.isSelected()) {theTraveller.getDayLife().setMuseum(1);}
        			if (cB4.isSelected()) {theTraveller.getDayLife().setOpera(1);}
        			if (cB5.isSelected()) {theTraveller.getLocationAtractions().setAirport(1);}
        			if (cB6.isSelected()) {theTraveller.getLocationAtractions().setSubway(1);}
        			if (cB7.isSelected()) {theTraveller.getLocationAtractions().setSeatport(1);}
        			if (cB8.isSelected()) {theTraveller.getLocationAtractions().setTrain(1);}
        			if (cB10.isSelected()) {theTraveller.getLocationAtractions().setBeach(1);}
        			if (cB11.isSelected()) {theTraveller.getLocationAtractions().setCanyon(1);}
        			if (cB12.isSelected()) {theTraveller.getLocationAtractions().setLake(1);}
        			if (cB13.isSelected()) {theTraveller.getLocationAtractions().setRiver(1);}
        			if (cB14.isSelected()) {theTraveller.getActivities().setCruise(1);}
        			if (cB15.isSelected()) {theTraveller.getActivities().setHiking(1);}
        			if (cB16.isSelected()) {theTraveller.getActivities().setSafari(1);}
        			if (cB17.isSelected()) {theTraveller.getNightLife().setBar(1);}
        			if (cB18.isSelected()) {theTraveller.getActivities().setWatersports(1);}
        			if (cB19.isSelected()) {theTraveller.getActivities().setWintersports(1);}
        			
        			if (cB20.isSelected()) {
        				theTraveller.setWantsRain(true);
        			} else {
        				theTraveller.setWantsRain(false);
        			}

        			
        			City.perfectCityFinder(theTraveller, f);
        			
                	//adding user to the file
        		/*	try {
        				
    				ArrayList<ArrayList<Traveller>> theTravellers= new ArrayList<ArrayList<Traveller>>();
    				theTravellers=newMain.fileReader(theTravellers);
    				
    				theTravellers.get(newUser.getIndex()).add(newUser);
    										
    				newMain.fileWriter(theTravellers);
    				    				
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					System.out.println("Could not save the preferences of " + newUser.getFullName());
    				}
        		*/	
        		}catch(Exception ex) {
    				JOptionPane.showMessageDialog(null, "Fields not properly filled", "Alert", JOptionPane.WARNING_MESSAGE);
    				System.exit(0);
    				System.exit(0);
        		}        		
        	}
        });
        
	}
	
    public int compareTo(Traveller t) 
    { 
        return this.age - t.age; 
    } 

  /*  public static int[] getCriteria( userPrefsAndVisit theTraveller) {
    	
    	//.getVisit(),.getWeather(),.getLocationAtractions(),.getTypeOfPlace(),.getClime(),.getContinent()
			//	,.getTouristLocation(),.getExpensive(),.getDayLife(),.getNightLife(),.getAccommodationType(),.getActivities()
	
    	int[] criteria= {theTraveller.getLocationAtractions().getAirport(),theTraveller.getLocationAtractions().getBeach(),theTraveller.getLocationAtractions().getCanyon(),theTraveller.getLocationAtractions().getLake(),theTraveller.getLocationAtractions().getRiver(),theTraveller.getLocationAtractions().getSeatport(),theTraveller.getLocationAtractions().getSubway(),theTraveller.getLocationAtractions().getTrain(),
    			theTraveller.getTouristLocation(),theTraveller.getExpensive(),
                theTraveller.getGetDayLife().getChurch(),theTraveller.getGetDayLife().getCinema(),theTraveller.getGetDayLife().getOpera(),theTraveller.getGetDayLife().getMuseum(),
                theTraveller.getNightLife().getBar(),
                theTraveller.getActivities().getCruise(),theTraveller.getActivities().getHiking(),theTraveller.getActivities().getSafari(),theTraveller.getActivities().getWatersports(),theTraveller.getActivities().getWintersports()};
				
    	return criteria;
    	
    	
    }
  */  
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Traveller)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Traveller c = (Traveller) o; 
          
        // Compare the data members and return accordingly  
        return fullName.equals(c.fullName); 
        
    }
	
}

class NameCompare implements Comparator<ArrayList<Traveller>> {
    
    @Override
    public int compare(ArrayList<Traveller> o1, ArrayList<Traveller> o2) {
        return o1.get(0).compareTo(o2.get(0));
    }

}












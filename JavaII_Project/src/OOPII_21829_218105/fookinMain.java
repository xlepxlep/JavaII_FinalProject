package OOPII_21829_218105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysql.jdbc.PreparedStatement;

public class Main {

	newCity.setAccomodationTypeCounter(rs.getInt("accomodationTypeCounter"));
	newCity.setClime(rs.getString("clime"));
	newCity.setCountryName(rs.getString("countryName"));
	newCity.setExpensive(rs.getInt("expensive"));
	newCity.setLat(rs.getDouble("lat"));
	newCity.setLon(rs.getDouble("lon"));
	newCity.setName(rs.getString("name"));
	newCity.setWeather(rs.getString("weather"));
	
	theCities.add(newCity);

}

} catch (Exception e) {
System.out.println(e);
}

//για να διαβασει απο το file
File file = new File("destFinder1001.tmp");

if (!file.exists()) {
file.createNewFile();
}

FileInputStream fis = new FileInputStream("destFinder1001.tmp");
ObjectInputStream ois = null ;
if (file.length()>0) {
ois = new ObjectInputStream(fis);
theTravellers = (ArrayList<ArrayList<Traveller>>) ois.readObject();
ois.close();
}

while (true) {

//returns: 1->createAccount  2->login
int loginOrCreate=loginOrCreate(); 

Traveller newTraveller=new Traveller();
Tourist newTourist=new Tourist();
Business newBusiness=new Business();
int usersClass=-1;
int thisTravellerIndex=-1;
if ( loginOrCreate==1) { //if->login
	thisTravellerIndex=login( theTravellers);
	
	if (thisTravellerIndex>=0) {
		usersClass=theTravellers.get(thisTravellerIndex).get(0).getType();
	} else {
		continue;
	}
	
	if (usersClass==1) {
		newTraveller=theTravellers.get(thisTravellerIndex).get(0);
		newTraveller.settingTravellersPreferences(newTraveller);
	}
	if (usersClass==2) {
		newTourist=(Tourist) theTravellers.get(thisTravellerIndex).get(0);
		newTourist.settingTravellersPreferences(newTourist);
	}
	if (usersClass==3) {
		newBusiness=(Business) theTravellers.get(thisTravellerIndex).get(0);
	}
	
} else { //if->create account

	//asks the user if he is a traveller->1/ tourist->2/ business->3
	usersClass=welcomeUser();	
	
	//if he is a traveller
	if (usersClass==1) {
		newTravellerHandler( newTraveller, theTravellers); 
		newTraveller.setType(1);
		theTravellers.add(new ArrayList<Traveller>());
		thisTravellerIndex=theTravellers.size()-1;
		
		theTravellers.get(thisTravellerIndex).add(newTraveller);
	}										
	//if he is a tourist
	if (usersClass==2) {
		newTouristHandler( newTourist, theTravellers);
		newTourist.setType(2);
		theTravellers.add(new ArrayList<Traveller>());
		thisTravellerIndex=theTravellers.size()-1;
		
		theTravellers.get(thisTravellerIndex).add(newTourist);
	}
	//if he is a "business"
	if (usersClass==3) {
		while (true) {
			try {
				newBusinessHandler( newBusiness, theTravellers);
				newBusiness.setType(3);
				theTravellers.add(new ArrayList<Traveller>());
				thisTravellerIndex=theTravellers.size()-1;
				
				theTravellers.get(thisTravellerIndex).add(newBusiness);
				break;
			} catch (Exception e) {
				System.out.println("Please type a city that exists!!!");
			}
		}
	}
	
}

//creates an object type City in order to have access to Citys' methods
City citiesHandler=new City();
//creates the arraylist with the cities that the user gives 
ArrayList<City> selectedCities=new ArrayList<City>();
askForCities( selectedCities);

//ψαχνουμε αν εχουμε ξαναδει την ιδια πολη
Iterator<City> itr1=selectedCities.iterator();
ArrayList<City> newCities=new ArrayList<>();//cities that appear for the first time

while (itr1.hasNext()) {
	Iterator<City> itr2=theCities.iterator();

	City aSelectedCity=itr1.next();
	
	boolean exists=false;
	while (itr2.hasNext()) {
		City aCity=itr2.next();
		if (aCity.equals(aSelectedCity)) {
			exists=true;
			break;
		}
		
	}
	
	if ( !exists) {
		theCities.add(aSelectedCity);
		newCities.add(aSelectedCity);
	}
	
}

Iterator<City> itrr=theCities.iterator();
while(itrr.hasNext()) {
	City oneCity=itrr.next();
}

//if user is a traveller or a tourist aks for his preferences
	
if (usersClass == 1) {
	selectedCities=citiesHandler.setCitiessAtributtes( newTraveller, selectedCities); //that = is a new custamaziation
} 
if (usersClass==2) {
	selectedCities=citiesHandler.setCitiessAtributtes(newTourist, selectedCities);
}			

if (usersClass == 3){
	selectedCities=citiesHandler.setCitiessAtributtes(newBusiness, selectedCities);
}


City chosenCity=new City();
boolean noRain=false;
if (usersClass != 3 && (!newTraveller.getWeather().equals("Rain") &&!newTraveller.getWeather().equals("empty") ||
		!newTourist.getWeather().equals("Rain") && !newTourist.getWeather().equals("empty"))) {	 //if user is traveller/tourist AND he has not chosen weather:Rain as his preference
	
	System.out.println("Do you want to exclude cities with rain? 1.Yes 2.No");
	int rainSelector;
	while (true) {
		try {
			rainSelector=myInput.nextInt();
			while (rainSelector<1 || rainSelector>2) {
				System.out.println("Please type a valid option!");
				rainSelector=myInput.nextInt();
			}
			break;
		} catch (InputMismatchException e) {
			System.out.println("Please type a valid option!");
			myInput.nextLine(); //χωρις αυτο ετρεχε συνεχεια το catch σαν loop
		}
	}	
	
	if (rainSelector==1) {
		noRain=true;
	}
	
	if (usersClass == 1) {
		chosenCity=newTraveller.CompareCities(selectedCities, newTraveller, noRain);
		System.out.printf("The perfect destination for you is: %s \n\n", chosenCity.getName());
	}
	if (usersClass == 2) {
		chosenCity=newTourist.CompareCities(selectedCities, newTourist, noRain);
		System.out.printf("The perfect destination for you is: %s \n\n", chosenCity.getName());
	}
}
if (usersClass == 3) {
	chosenCity=newBusiness.CompareCities(selectedCities, newBusiness);
	System.out.printf("The perfect destination for you is: %s \n\n", chosenCity.getName());
}

System.out.print("\n\nWe hope we were helpfull!!! \nWe are looking forword to advise you on your next trip!!! \n\n");

//adding users to the arraylist
if (usersClass==1) {
	theTravellers.get(thisTravellerIndex).add(newTraveller);
}
if (usersClass==2) {
	theTravellers.get(thisTravellerIndex).add(newTourist);
}
if (usersClass==3) {
	theTravellers.get(thisTravellerIndex).add(newBusiness);
}

//Sorting and printing
NameCompare nameCompare=new NameCompare();
Collections.sort(theTravellers, nameCompare);

Iterator itr10=theTravellers.iterator();

System.out.print("These are the names of our users: \n\n");
while (itr10.hasNext()) {
	
	ArrayList<Traveller> aTraveller=(ArrayList<Traveller>) itr10.next();
	
	System.out.println(aTraveller.get(0).getFullName());
	
}

//printing new cities
Iterator itr11=newCities.iterator();
System.out.println("Those are the new cities!");
while (itr11.hasNext()) {
	City aCity=(City) itr11.next();
	System.out.println(aCity.getName());
}

//για να γραφει στη βαση δεδομενων
Iterator itrD=newCities.iterator();

while (itrD.hasNext()) {
	
	City aCity=(City)itrD.next();
/*			String SQL="INSERT INTO city VALUES('" + aCity.getActivities().getCruise() + "','" + aCity.getActivities().getHiking() + "','" + aCity.getActivities().getSafari() + "','" + aCity.getActivities().getWatersports() + "','" + aCity.getActivities().getWintersports() + "','" + aCity.getAccommodationType() + "','" + aCity.getAccomodationTypeCounter() + "','" + aCity.getClime() + "','" + aCity.getCountryName() + "','" + aCity.getExpensive() + "','" + aCity.getLat() + "','" + aCity.getLon() + "','" + aCity.getName() + "','" + aCity.getWeather() + "','" + aCity.getDayLife().getChurch() + "','" + aCity.getDayLife().getCinema() + "','" + aCity.getDayLife().getMuseum() + "','" + aCity.getDayLife().getOpera() + "','" + aCity.getLocationAtractions().getAirport() + "','" + aCity.getLocationAtractions().getBeach() + "','" + aCity.getLocationAtractions().getCanyon() + "','" + aCity.getLocationAtractions().getLake() + "','" + aCity.getLocationAtractions().getRiver() + "','" + aCity.getLocationAtractions().getSeatport() + "','" + aCity.getLocationAtractions().getSubway() + "','" + aCity.getLocationAtractions().getTrain() + "','" + aCity.getNightLife().getBar();         

	try {
	stmt.executeUpdate(SQL);
	}catch(Exception e) {
		System.out.println(e);
	}
*/			
	try {
	PreparedStatement ps=(PreparedStatement) con.prepareStatement("INSERT INTO city VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setInt(1,aCity.getActivities().getCruise());
	ps.setInt(2,aCity.getActivities().getHiking());
	ps.setInt(3,aCity.getActivities().getSafari());
	ps.setInt(4,aCity.getActivities().getWatersports());
	ps.setInt(5,aCity.getActivities().getWintersports() );
	ps.setString(6,aCity.getAccommodationType());
	ps.setInt(7,aCity.getAccomodationTypeCounter());
	ps.setString(8,aCity.getClime());
	ps.setString(9,aCity.getCountryName());
	ps.setInt(10,aCity.getExpensive());
	ps.setDouble(11,aCity.getLat());
	ps.setDouble(12,aCity.getLon());
	ps.setString(13,aCity.getName());
	ps.setString(14,aCity.getWeather());
	ps.setInt(15,aCity.getDayLife().getChurch());
	ps.setInt(16,aCity.getDayLife().getCinema());
	ps.setInt(17,aCity.getDayLife().getMuseum());
	ps.setInt(18,aCity.getDayLife().getOpera());
	ps.setInt(19,aCity.getLocationAtractions().getAirport() );
	ps.setInt(20,aCity.getLocationAtractions().getBeach());
	ps.setInt(21,aCity.getLocationAtractions().getCanyon());
	ps.setInt(22,aCity.getLocationAtractions().getLake());
	ps.setInt(23,aCity.getLocationAtractions().getRiver());
	ps.setInt(24,aCity.getLocationAtractions().getSeatport());
	ps.setInt(25,aCity.getLocationAtractions().getSubway());
	ps.setInt(26,aCity.getLocationAtractions().getTrain());
	ps.setInt(27,aCity.getNightLife().getBar());
	
	ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
}

//για να γραφει στο file
FileOutputStream fos = new FileOutputStream("destFinder1001.tmp");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(theTravellers);
oos.close();

}	

}

//OTHER METHODS

/**Welcomes the user and finds out if he is traveller/tourist/business
* returns:
* 1->traveller
* 2->tourist
* 3->business*/
public static int welcomeUser() {

Scanner myInput=new Scanner(System.in);
	
System.out.println("Please choose your class: 1.Traveller 2.Tourist 3.Business");
int choice=-1;
while (true) {
try {
	choice=myInput.nextInt();
	while (choice<1 || choice>3) {
		System.out.println("Please type a valid option!");
		choice=myInput.nextInt();
	}
	break;
} catch (InputMismatchException e) {
	System.out.println("Please type a valid option1!");
	myInput.nextLine(); //χωρις αυτο ετρεχε συνεχεια το catch σαν loop
}
}

return choice;

}

/*Asks the new traveller his personal information and his personal preferences
* Methods that are used:
* addNewTravellersInfo-> asks traveller for his personal information(name, birthday, ...)
* settingTravellerPreferences-> sets travellers preferences about his destination
* 
* @param thisTraveller-> the traveller that is being asked for the information
*/
public static void newTravellerHandler ( Traveller thisTraveller, ArrayList<ArrayList<Traveller>> theTravellers) throws Exception {

//thisTraveller.setUserType(1);
thisTraveller.addNewTravellersInfo(thisTraveller, theTravellers);

while(true) {
try {
	thisTraveller.settingTravellersPreferences(thisTraveller);
	break;
} catch (Exception e) {
	System.out.println("Due to your invalid choice, please set your preferences again!");			
	//thisTraveller.settingTravellersPreferences(thisTraveller);
}
}
}

/*Asks the new tourist his personal information and his personal preferences
* Methods that are used:
* addNewTravellersInfo-> asks tourist for his personal information(name, birthday, ...)
* settingTravellerPreferences-> sets tourist preferences about his destination
* 
* @param thisTourist-> the tourist that is being asked for the information
*/
public static void newTouristHandler ( Tourist thisTourist, ArrayList<ArrayList<Traveller>> theTravellers ) throws Exception {
//thisTourist.setUserType(2);
thisTourist.addNewTravellersInfo(thisTourist, theTravellers);

try {
thisTourist.settingTravellersPreferences(thisTourist);
} catch (Exception e) {
System.out.println("Due to your invalid choice, please set your preferences again!");			
thisTourist.settingTravellersPreferences(thisTourist);
}
}

/*Asks the new business his personal information and his current location
* Methods that are used:
* addNewBusiness-> asks tourist for his personal information(name, birthday, currentLocation,...)
* 
* @param thisBusiness-> the business that is being asked for the information
*/
public static void newBusinessHandler ( Business thisBusiness, ArrayList<ArrayList<Traveller>> theTravellers) throws Exception {
//thisBusiness.setUserType(3);
thisBusiness.addNewBusiness(thisBusiness, theTravellers);
}

/*Asks the user the cities he/she intends to visit
* 
* @param selectedCities-> the arrayList with the cities
*/

public static ArrayList<City> askForCities ( ArrayList<City> selectedCities) {

Scanner myInput=new Scanner(System.in);

System.out.print("Please give some cities that you intend to visit! \nPlease note that any invalid input may lead to unknown results! \n\n");
System.out.println("City name: ");
String cityName=myInput.nextLine();
System.out.println("Country short name( eg Greece-> gr): ");
String countryName=myInput.nextLine();

City newCity=new City();
newCity.setName(cityName);
newCity.setCountryName(countryName);
selectedCities.add(newCity);

boolean alarm=true;
System.out.println("Do you want to add another city? (y/n)");
String choice=myInput.nextLine();
while ( !choice.equals("y") && !choice.equals("n")) {
System.out.println("Please type a valid option!");
choice=myInput.nextLine();
}
if (choice.equals("n")) {
alarm=false;
}

while ( alarm) {

System.out.println("City name: ");
cityName=myInput.nextLine();
System.out.println("Country short name: ");
countryName=myInput.nextLine();

City newCity1=new City();
newCity1.setName(cityName);
newCity1.setCountryName(countryName);
selectedCities.add(newCity1);
		
System.out.println("Do you want to add another city? (y/n)");
choice=myInput.nextLine();
while ( !choice.equals("y") && !choice.equals("n")) {
	System.out.println("Please type a valid option!");
	choice=myInput.nextLine();
}

if ( choice.equals("n")) {
	alarm=false;
}

}

return selectedCities;

}


public static void freeTicketGiver ( City thisCity, Traveller theUsers[]) throws IOException {

for ( int i=0; i<theUsers.length; i++) {
theUsers[i].freeTicketGiver(thisCity, theUsers);
}

} 

//returns where a traveler is in the arraylist or -1(if he doesnt exist)
public static int login ( ArrayList<ArrayList<Traveller>> theTravellers) {

Scanner myInput=new Scanner(System.in);

System.out.println("Please type your name: ");
String hisName=myInput.next();

Iterator itr1=theTravellers.iterator();

while (itr1.hasNext()) {

ArrayList<Traveller> aTraveller=(ArrayList<Traveller>) itr1.next();

if (aTraveller.get(0).getFullName().equals(hisName)) {
	System.out.print("Welcome to findYourDestination!!! \nWe are working hard to find the most suitable destination for your needs! \n\n");
	return aTraveller.get(0).getIndex();
}

}

System.out.println("This name is not registered!");
return -1;

}

//returns: 1->createAccount  2->login
public static int loginOrCreate () throws IOException {

Scanner myInput=new Scanner(System.in);

System.out.println("Choose an option: 1.Login 2.CreateAccount");

int choice=-1;
try {
choice=myInput.nextInt();
while (choice>2 || choice<1) {
	System.out.println("Please type a valid option!");
	choice=myInput.nextInt();
}
} catch (InputMismatchException e) {
System.out.println("Please type a valid option!");
myInput.nextLine();
}

return choice;

}
	
}





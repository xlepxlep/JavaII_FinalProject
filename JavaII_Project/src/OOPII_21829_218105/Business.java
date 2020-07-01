package OOPII_21829_218105;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import openDataRest.OpenDataRest;

public class Business extends Traveller {

	@Override
	public int Similarity( City thisCity,  Traveller thisUser) {
	
		double lat1=thisUser.getLatNow();
		double lon1=thisUser.getLonNow();
		double lat2=thisCity.getLat();
		double lon2=thisCity.getLon();
		
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
						
			return ((int)dist);
		}
		
	}
	
	// searches for the older user with the maximum similarity
	public Business freeTicketGiver ( City thisCity, Business businessGuys[]) throws IOException {
		
		Business bestBusiness=new Business();
		bestBusiness=businessGuys[0];
		
		for ( int i=0; i<N; i++) {
			if ( Similarity( thisCity, businessGuys[i])>Similarity( thisCity, bestBusiness)) {
				bestBusiness=businessGuys[i];
			}
		}
		
		return bestBusiness; 
		
	}
	
	public void addNewBusiness ( Business newBusiness, ArrayList<ArrayList<Traveller>> theTravellers) throws Exception { //ισως να χρειασετ να κανω ελεγχο γιατο αν υπαρχει η χωρα/πολη που μου ζηταει
		
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
		newBusiness.setGender(choice);
		myInput.nextLine();
	
		while (true) {
			
			System.out.println("Please type your Name: \n");
			newBusiness.setFullName(myInput.nextLine());
			
			
			Iterator itr1=theTravellers.iterator();
			
			while (itr1.hasNext()) {
				
				ArrayList<Traveller> aTraveller=(ArrayList<Traveller>) itr1.next();
				
				if (aTraveller.get(0).getFullName().equals(newBusiness.getFullName())) {
					System.out.println("This name is already used!!!");
					newBusiness.setFullName("superMario");
					break;
				}
				
			}
		
			if (!newBusiness.getFullName().equals("superMario")) {
				break;
			}
			
			
		}
		
		System.out.print("\nPlease type your fathers' Name: \n");
		newBusiness.setFathersName(myInput.nextLine());
		
		System.out.print("\nPlease type your Identity Number: \n");
		newBusiness.setIdentityNumber(myInput.nextLine());

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
		
		newBusiness.setAge(age);
		
		System.out.print("\nPlease type your Nationality: \n");
		newBusiness.setNationality(myInput.nextLine());
		
		System.out.print("Please type your current location! \nCity: ");
		newBusiness.setCityNow(myInput.nextLine());
		System.out.println("Country(short name): ");
		newBusiness.setCountryNow(myInput.nextLine());
		
		OpenDataRest OpenWeatherMapsData=new OpenDataRest();
		String appid ="42f49873c6d0aabc9bf0f7d818da6ec9"; 
		
		OpenWeatherMapsData.RetrieveOpenWeatherMap( newBusiness.getCityNow(), newBusiness.getCountryNow(), appid, newBusiness); 
				
	}

	public City CompareCities ( ArrayList<City> thoseCities, Business thisBusiness) { 
		
		int cityCounter=0;
		City bestFit=new City(); //the city that suits the best the preferences of the traveller
		bestFit=thoseCities.get(cityCounter);
		int bestFitPercent=Similarity( thoseCities.get(cityCounter), thisBusiness); //percent of similarity, of the best suited city
		
		Iterator i=thoseCities.iterator();
		while (i.hasNext()) {
		
			int currentFitPercent=Similarity( thoseCities.get(cityCounter), thisBusiness);
			
			if (currentFitPercent<bestFitPercent) {
				bestFit=thoseCities.get(cityCounter);
				bestFitPercent=currentFitPercent;
			}
			cityCounter++;
			i.next();
			
		}
		return bestFit;
		
	}
	
	public static void perfectCityFinder(JFrame fff, Traveller theTraveller) {
		
		//Traveller theTraveller=new Traveller();
		
		fff.setVisible(false);
		
		ArrayList<City> selectedCities=new ArrayList<>();
		
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
	    		    JOptionPane.showMessageDialog(f,"Please insert at least one city!","Alert",JOptionPane.INFORMATION_MESSAGE);     
	    		}else {
	    			
	    			City testCity=new City();
	    			Business testBusiness=new Business();
	    			testBusiness.setLatNow(theTraveller.getLatNow());
	    			testBusiness.setLonNow(theTraveller.getLonNow());
	    			
	    			try {
						testCity.setCitiessAtributtes( theTraveller, selectedCities);
						newMain.DBWriter( selectedCities);
						
						City chosenOne=new City();
					 
						chosenOne=testBusiness.CompareCities(selectedCities, testBusiness);												
						
							
						JOptionPane.showMessageDialog(f, "Your perfect destination is: "+chosenOne.getName(), "FOUND IT", JOptionPane.INFORMATION_MESSAGE);
						
						System.exit(0);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Something is up!!!");
					}
	    			
	    		}
	    		
	    		
	    		
	        }  
	    }); 
	    f.add(b1);
	    	    
	    f.setSize(450,270);  
	    f.setLayout(null);  
	    f.setVisible(true); 
		
	}
	
	
}
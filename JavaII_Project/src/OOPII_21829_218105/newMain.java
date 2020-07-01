package OOPII_21829_218105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import java.text.NumberFormat;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysql.jdbc.PreparedStatement;

import OOPII_21829_218105.userPrefsAndVisit;
import openDataRest.OpenDataRest;
import openDataRest.RetrieveOpenWeatherTraveller;


//newMain 180,181->thread: OpenW		City410:Thread2-> RetrW		City810-> lamdaExpr
public class newMain {

	static int userID;
	ArrayList<City> usersCities;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public ArrayList<City> getUsersCities() {
		return usersCities;
	}
	public void setUsersCities(ArrayList<City> usersCities) {
		this.usersCities = usersCities;
	}

	static class usersFileFormat implements Serializable {
		String userName;
		int userType;
		
		
		public usersFileFormat(String userName, int userType) {
			super();
			this.userName = userName;
			this.userType = userType;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getUserType() {
			return userType;
		}
		public void setUserType(int userType) {
			this.userType = userType;
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Traveller newUser=new Traveller();
		
	    JFrame f=new JFrame("Destination Finder/Registration");  

	    //Labels
	    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;  
	    l1=new JLabel("Select class");  
	    l1.setBounds(0,10, 150,30);  
	    l2=new JLabel("Select Gender");  
	    l2.setBounds(0,50, 150,30);  
	    l3=new JLabel("Type username");  
	    l3.setBounds(0,90, 150,30); 
	    l4=new JLabel("Type age");  
	    l4.setBounds(0,130, 150,30); 
	    l5=new JLabel("Type ID");  
	    l5.setBounds(0,170, 150,30); 
	    l6=new JLabel("Type nationality");  
	    l6.setBounds(0,210, 150,30); 
	    l7=new JLabel("Type current city");  
	    l7.setBounds(0,250, 150,30); 
	    l8=new JLabel("Type Current");  
	    l8.setBounds(0,290, 150,30); 
	    l9=new JLabel("Countrys' short name");
	    l9.setBounds(0,320,170,30);
	    f.add(l1); f.add(l2); f.add(l3); f.add(l4); f.add(l5); f.add(l6);  f.add(l7); f.add(l8); f.add(l9);
	    
	    //radioButtons
	    JRadioButton r1=new JRadioButton("Traveller");    
	    JRadioButton r2=new JRadioButton("Tourist");    
	    JRadioButton r3=new JRadioButton("Business"); 
	    r1.setBounds(150,10,100,30);    
	    r2.setBounds(250,10,100,30); 
	    r3.setBounds(350, 10, 100, 30);
	    ButtonGroup bg=new ButtonGroup();    
	    bg.add(r1);bg.add(r2); bg.add(r3);   
	    f.add(r1); f.add(r2); f.add(r3);
	    
	    JRadioButton r10=new JRadioButton("Mr");    
	    JRadioButton r20=new JRadioButton("Ms");    
	    JRadioButton r30=new JRadioButton("Other"); 
	    r10.setBounds(150,50,100,30);    
	    r20.setBounds(250,50,100,30); 
	    r30.setBounds(350,50, 100, 30);
	    ButtonGroup bg1=new ButtonGroup();    
	    bg1.add(r10);bg1.add(r20); bg1.add(r30);   
	    f.add(r10); f.add(r20); f.add(r30);
	    
	    //textAreas
	    JTextField tf1,tf3,tf4,tf5,tf6;
	    tf1=new JTextField();  
        tf1.setBounds(150,95,150,20);  
        
        //numberField
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
	    JFormattedTextField field;
	    field= new JFormattedTextField(formatter);
		field.setBounds(150,135,150,20);
		
        tf3=new JTextField();  
        tf3.setBounds(150,175,150,20);  
        tf4=new JTextField();  
        tf4.setBounds(150,215,150,20);  
        tf5=new JTextField();  
        tf5.setBounds(150,255,150,20);
        tf6=new JTextField();  
        tf6.setBounds(150,305,150,20);
        f.add(tf1);f.add(field);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);
          
        //JButton
        JButton b=new JButton("Register"); 
        b.setBounds(180,370,100,30);  
        b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  //ΕΓΓΡΑΦΗ
        		try {
	        		if(r1.isSelected()) {newUser.setType(1);};
	        		if(r2.isSelected()) {newUser.setType(2);};
	        		if(r3.isSelected()) {newUser.setType(3);};
	        		
	        		if(r10.isSelected()) {newUser.setGender(1);;};
	        		if(r20.isSelected()) {newUser.setGender(2);};
	        		if(r30.isSelected()) {newUser.setGender(3);};
	        		
	        		newUser.setFullName(tf1.getText());
	        		newUser.setAge((int) field.getValue());
	        		if (newUser.getAge()<18) {
	    				JOptionPane.showMessageDialog(null, "Users cant be under 18 years old!", "Alert", JOptionPane.WARNING_MESSAGE);
	    				System.exit(0);
	        		}
	        		newUser.setIdentityNumber(tf3.getText());
	        		newUser.setNationality(tf4.getText());
        		}catch (Exception ex) {
    				JOptionPane.showMessageDialog(null, "Fields not properly filled", "Alert", JOptionPane.WARNING_MESSAGE);
    				System.exit(0);
        		}
            	while (true) {
        			try {
        				
        				OpenDataRest OpenWeatherMapsData=new OpenDataRest();
        				String appid ="42f49873c6d0aabc9bf0f7d818da6ec9"; 
        				
        				Thread t = new Thread(new RetrieveOpenWeatherTraveller(tf5.getText(),tf6.getText(),appid,newUser));
        				t.start();
        				//OpenWeatherMapsData.RetrieveOpenWeatherMap( tf5.getText(), tf5.getText(), appid, newUser); 
        				        				
        				break;
        			} catch (Exception ex) {
        				JOptionPane.showMessageDialog(null, "City not found", "Alert", JOptionPane.WARNING_MESSAGE);
        				System.exit(0);
        			}
        		}	
            	
            	//adding user to the file
            	try {
				ArrayList<usersFileFormat> usersNames= new ArrayList<>();
				usersNames=fileReader1(usersNames);

				usersFileFormat newUser1=new usersFileFormat(newUser.getFullName(), newUser.getType());
				usersNames.add(newUser1);
				fileWriter1(usersNames);
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	if (newUser.getType()==3) {
            		Business.perfectCityFinder(f, newUser);
            	} else {
            		Traveller.prefsSetter(f,newUser);
            	}
        	}  
        }); 
        f.add(b);
        
	    JLabel l10;  
	    l10=new JLabel("Already Registered?");  
	    l10.setBounds(160,440, 150,30); 
	    f.add(l10);
        
	    JButton bLogin=new JButton("Login");  //ΣΥΝΔΕΣΗ
	    bLogin.setBounds(180,480,100,30);  
	    bLogin.addActionListener( new ActionListener(){
	    	public void actionPerformed( ActionEvent e) {
	    		String username=JOptionPane.showInputDialog("Enter Username");
	    		int userExists=doesHeExist(username);
	    		if (userExists!=0) {
	            	if (userExists==3) {
	            		Business.perfectCityFinder(f,newUser);
	            	} else {
	            		Traveller.prefsSetter(f,newUser);
	            	}
	    		}
	    	}
	    });
	    f.add(bLogin);
        
	    f.setSize(500,600);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	}
	
	public static void idk(JFrame f) {
		f.getContentPane().removeAll();
		f.repaint();
	}
	
	public static int doesHeExist ( String hisName) {
		
		ArrayList<usersFileFormat> usersNames= new ArrayList<>();
		usersNames=fileReader1(usersNames);
		
		Iterator itr1=usersNames.iterator();
		
		while (itr1.hasNext()) {
			
			usersFileFormat aUser= (usersFileFormat) itr1.next();
			
			if (aUser.getUserName().equals(hisName)) {
				//userID=aUser.get(0).getIndex();
				return aUser.getUserType();
			}
			
		}
	
		JOptionPane.showMessageDialog(null, "User not found", "Alert", JOptionPane.ERROR_MESSAGE);
		return 0;
		
	}
	
	public static ArrayList<ArrayList<Traveller>> fileRader ( ArrayList<ArrayList<Traveller>> theTravellers) {
		//για να διαβασει απο το file
		File file = new File("destFinder111.tmp");
		
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
			fis = new FileInputStream("destFinder111.tmp");
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
				theTravellers = (ArrayList<ArrayList<Traveller>>) ois.readObject();
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
		
		return theTravellers;
		
	}
	
	public static void fileWiter( ArrayList<ArrayList<Traveller>> theTravellers) throws IOException {
		FileOutputStream fos = new FileOutputStream("destFinder111.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(theTravellers);
		oos.close();
	}

	public static ArrayList<City> DBReader() {
		
		ArrayList<City> theCities=new ArrayList<City>(); //ArrayList with all the cities that have been searched
		
		//για να συνδεθει με db
		Connection con=null;
		Statement stmt=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/javaII","xlep","tab010163");  
			stmt=con.createStatement();  
		}catch(Exception e) {
			System.out.println(e);
		}  
		
		//για να διαβασει απο τη βαση δεδομενων
		String query="SELECT * FROM city";

	    try { 
	    	ResultSet rs = stmt.executeQuery(query);
	    	
	        while (rs.next()) {
	        	int cruise=rs.getInt("cruise");
	        	int hiking=rs.getInt("hiking");
	        	int safari=rs.getInt("safari");
	        	int watersports=rs.getInt("watersports");
	        	int wintersports=rs.getInt("wintersports");
	        	City newCity=new City();	        	
	        	activitiess activities=new activitiess(cruise,hiking,safari,watersports,wintersports);
	        	newCity.setActivities(activities);
	        	dayLifee dayLife=new dayLifee(rs.getInt("museum"),rs.getInt("church"),rs.getInt("opera"),rs.getInt("cinema"));
	        	newCity.setDayLife(dayLife);
	        	locationAtractionss locationAtractions=new locationAtractionss(rs.getInt("beach"),rs.getInt("river"),rs.getInt("canyon"),rs.getInt("lake"),rs.getInt("seaport"),rs.getInt("airport"),rs.getInt("train"),rs.getInt("subway"));
	        	newCity.setLocationAtractions(locationAtractions);
	        	nightLifee nightLife=new nightLifee(rs.getInt("bar"));
	        	newCity.setNightLife(nightLife);
	        	newCity.setAccommodationType(rs.getString("accomodationType"));
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
	    	System.out.println("Could not read from DB");
	    }
	    
	    return theCities;
	    
	}

	public static void DBWriter( ArrayList<City> Cities) {
		
		Iterator itr0=Cities.iterator();
		
		while (itr0.hasNext()) {
			
			City oneCity=(City) itr0.next();
		
			//ψαχνουμε αν εχουμε ξαναδει την ιδια πολη
			ArrayList<City> theCities=new ArrayList<City>();//cities that appear for the first time
			theCities=DBReader();
			
			Iterator itr1=theCities.iterator();
			
			boolean exists=false;
			while (itr1.hasNext()) {
				City aSelectedCity=(City) itr1.next();			
				exists=false;
				if (oneCity.equals(aSelectedCity)) {
					exists=true;
					break;
				}		
			}
			if (!exists) {
				theCities.add(oneCity);
				
				//για να συνδεθει με db
				Connection con=null;
				Statement stmt=null;
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/javaII","xlep","tab010163");  
					stmt=con.createStatement();  
				}catch(Exception e) {
					System.out.println(e);
				}  
				
				//για να γραφει στη βαση δεδομενων
				Iterator itrD=theCities.iterator();
				
				while (itrD.hasNext()) {
					
					City aCity=(City)itrD.next();
			
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
						System.out.println("Could not write to DB!");
					}
				}
			}
		}		
	}
	
	public static ArrayList<usersFileFormat> fileReader1 ( ArrayList<usersFileFormat> theTravellers) {
		//για να διαβασει απο το file
		File file = new File("destFinderNames.tmp");
		
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
			fis = new FileInputStream("destFinderNames.tmp");
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
				theTravellers = (ArrayList<usersFileFormat>) ois.readObject();
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
		
		return theTravellers;
		
	}
	
	public static void fileWriter1 ( ArrayList<usersFileFormat> theTravellers) throws IOException {
		FileOutputStream fos = new FileOutputStream("destFinderNames.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(theTravellers);
		oos.close();
	}
	
	public static ArrayList<userPrefsAndVisit> fileReaderPrefs ( ArrayList<userPrefsAndVisit> theTravellers) {
		//για να διαβασει απο το file
		File file = new File("destFinderPrefs.tmp");
		
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
			fis = new FileInputStream("destFinderPrefs.tmp");
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
				theTravellers = (ArrayList<userPrefsAndVisit>) ois.readObject();
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
		
		return theTravellers;
		
	}
	
	public static void fileWriterPrefs ( ArrayList<userPrefsAndVisit> theTravellers) throws IOException {
		FileOutputStream fos = new FileOutputStream("destFinderPrefs.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(theTravellers);
		oos.close();
	}
	
}








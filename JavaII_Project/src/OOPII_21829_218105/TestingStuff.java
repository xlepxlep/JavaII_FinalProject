package OOPII_21829_218105;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import openDataRest.OpenDataRest;


public class TestingStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ArrayList<String> theCitiess=new ArrayList<>();
		
		theCitiess=fileReaderCities(theCitiess);
		
		Iterator itr1=theCitiess.iterator();
		
		while (itr1.hasNext()) {
			
			String temp=new String();
			
			temp=(String) itr1.next();
			
			System.out.println(temp);
			
		}
		
		System.out.println(theCitiess.size());
		System.out.println("All good aea aea");*/
		
		
		OpenDataRest dataReceiver=new OpenDataRest();
		String wikiExtracts1=null,wikiExtracts2=null,wikiExtracts3=null,wikiExtracts4=null;
		
		try {
			
			//ArrayList<cityPopularity> a1=new ArrayList<>();
			
			wikiExtracts1=dataReceiver.RetrieveWikipedia("Miami");
			wikiExtracts2=dataReceiver.RetrieveWikipedia("Athens");
			wikiExtracts3=dataReceiver.RetrieveWikipedia("Rome");
			wikiExtracts4=dataReceiver.RetrieveWikipedia("Voula");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int c1,c2,c3,c4;
		
		c1=countTextWords(wikiExtracts1);
		c2=countTextWords(wikiExtracts2);
		c3=countTextWords(wikiExtracts3);
		c4=countTextWords(wikiExtracts4);
		
		cityPopularity city1=new cityPopularity("Miami",c1);
		cityPopularity city2=new cityPopularity("Athens",c2);
		cityPopularity city3=new cityPopularity("Rome",c3);
		cityPopularity city4=new cityPopularity("Voula",c4);
		
		ArrayList<cityPopularity> a1=new ArrayList<>();
		
		a1.add(city1);
		a1.add(city2);
		a1.add(city3);
		a1.add(city4);

		List<cityPopularity> l1=new ArrayList<>();
		l1=a1.stream().sorted().collect(Collectors.toList());
		
		Collections.reverse(l1);
		
		Iterator itr=l1.iterator();
		
		while (itr.hasNext()) {
			
			cityPopularity temp=new cityPopularity();
			
			temp=(cityPopularity) itr.next();
			
			System.out.println(temp.getCityName()+" "+temp.getWordCounter());
			
		}
		
		System.out.println("And the one for you is: "+l1.get(0).getCityName());
		
		try {
			ArrayList<String> theCities=new ArrayList<>();
			theCities=fileReaderCities(theCities);
	System.out.println(theCities.size());
			theCities.add(l1.get(0).getCityName());
	System.out.println(theCities.size());
		
			fileWriterCities(theCities);
			System.out.println("Data Saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//method from stack overflow to the words of a text count words
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
	
}

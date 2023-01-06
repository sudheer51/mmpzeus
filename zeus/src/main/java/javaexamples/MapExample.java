package javaexamples;

import java.util.HashMap;
import java.util.Set;

public class MapExample {
	
	public static void main(String[] args) {
		
			//Integer
		//Float
		//Double
		//String
		//Integer,Name
	 
				
				HashMap<String,String> hMap = new HashMap<String,String>();
				hMap.put("From","MUM");
				hMap.put("From","MUM1");
				hMap.put("To","DEL");
				hMap.put("From Date ","10-12-2022");
				hMap.put("To Date","12-12-2022");
				  
				System.out.println("Map Elements ::" + hMap);
				System.out.println("Value is     ::" + hMap.get(null));
				System.out.println("Keys are     ::"+ hMap.keySet());
				System.out.println("Values are   ::"+ hMap.values());
				
				System.out.println(hMap.get("From"));
				
				Set<String> keys = hMap.keySet();
				System.out.println("*************Printing all the values from HMAP ************************");
				for(String s: keys)
				{
					System.out.println(hMap.get(s));
				}
				
				
				
				//Data displayed in teh website should be validated against the database
				//Fetch the data from website -> hashmap
				//fetch the data from database->excel
				//REad the Excel -> hashmap
				//compare the hashmap
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		}

	}
 

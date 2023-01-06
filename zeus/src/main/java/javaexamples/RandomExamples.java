package javaexamples;

import java.util.Random;

public class RandomExamples {

	
	public static void main(String[] args) {
		
		Random rand = new Random();
//		for(int j=0;j<20;j++)
//		{
//			int i = rand.nextInt(100);
//			System.out.println(i);
//		}
		int randNumber = rand.nextInt(100);
 		System.out.println(randNumber);
		
		int upperCase= 65+rand.nextInt(26);
		char upperCh =		(char)upperCase;
		System.out.println(upperCh);
		
		int lowerCase=97+rand.nextInt(26);
		char lowerCh= (char)lowerCase;
		System.out.println(lowerCh);
		String emailID= "AUTEmail"+	randNumber + upperCh+	lowerCh+"@gmail.com";
		System.out.println(emailID);
	}
}
//FirstName : AUTFNAME+randomnumber+randomlowercasechar+randomuppercase
//EmailID:AUTFNAME+randomnumber+randomlowercasechar+randomuppercase@gmail.com
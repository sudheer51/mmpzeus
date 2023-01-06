package javaexamples;

import java.util.Random;

public class DynamicInputData{
	 
	public static void main(String args[])
	{
		Random rand = new Random();
		int uLimit = 9999;
		int lLimit =1000;
		int val = lLimit + rand.nextInt(uLimit -lLimit );
		System.out.println("3 digit Random Number:"+ val);
 
	}
}
package org.iit.mmp.patientmodule.tests;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfileTests {
	/**
	 * 1. Open the browser and login 
	 * 2. Click on profile tab
	 * 3. Click on Edit Button
	 * 4. Modify the FirstName Field Value
	 * 5. Click on Save button
	 * 6. Click on OK in pop-up
	 * 7. Validate the updated information is displayed and matching with the value 
	 *    entered in the Step 4
	 */
	
	@Test
	public void validateEditFNAme()
	{
		//Invoking Application URL
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		

		//Login
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		//Profile Tab
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		driver.findElement(By.id("Ebtn")).click();
		String expectedfName = generateRandomString("AUTFName");
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(expectedfName);
		driver.findElement(By.id("Sbtn")).click();
		
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
		String actualfName = driver.findElement(By.id("fname")).getAttribute("value");
		Assert.assertEquals(expectedfName,actualfName);
		
		
		  
		  
	}
	public String generateRandomString(String str)
	{
		Random rand = new Random();
		int upperCase= 65+rand.nextInt(26);
		char upperCh =		(char)upperCase;
		System.out.println(upperCh);
		
		int lowerCase=97+rand.nextInt(26);
		char lowerCh= (char)lowerCase;
		System.out.println(lowerCh);
		String randomString= str + upperCh+lowerCh+upperCh+lowerCh;
		System.out.println(randomString);
		return randomString;
	}

}

package org.iit.mmp.patientmodule.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SendMessagesTest {

	public HashMap<String,String> patientMsgMap = new HashMap<String,String>();
	public HashMap<String,String> adminMsgMap = new HashMap<String,String>();
	
	@Test
	public void validateSendMessages()
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
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		patientMsgMap.put("fName", fName);
		
		//Messages Tab
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		patientMsgMap.put("subject", "Monthly Visit");
		driver.findElement(By.id("subject")).sendKeys("Monthly Visit");
		patientMsgMap.put("message", "To meet the Doctor Charlie");
		driver.findElement(By.id("message")).sendKeys("To meet the Doctor Charlie");
		
		
		patientMsgMap.put("date", getFutureDate(0,"dd-MM-YYYY"));
		
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		String expected ="Messages Successfully sent.";
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();

		Assert.assertEquals(actual, expected);
		
		System.out.println("Patient Msg Map" + patientMsgMap);
		/*
		 * login to admin module
		 * navigate to messages
		 * fetch the values 
		 * compare the values with patient module
		 */
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");


		//Login
		driver.findElement(By.id("username")).sendKeys("Ben@123");
		driver.findElement(By.id("password")).sendKeys("Frank@123");
		driver.findElement(By.name("admin")).click();
		
	
		//Profile Tab
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();

		//table[@class='table']//tr[2]/td[1]/b-> getText() Patient Name
		  //table[@class='table']//tr[2]/td[2]/b ->getText()  Reason
		  //table[@class='table']//tr[2]/td[3]/b ->getText()  Date
		  //table[@class='table']//tr[2]/following-sibling::tr[1] -> getText 
		

	}
	public String getFutureDate(int noofdays,String pattern)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		
		Date d = cal.getTime();
		System.out.println("Current Date :" + d);
				
		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);
		
		sdf = new SimpleDateFormat(pattern);
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}

}

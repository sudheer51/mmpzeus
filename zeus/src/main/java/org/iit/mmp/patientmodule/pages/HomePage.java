package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void navigateToAModule(String moduleName)
	{
		 
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	public HashMap<String, String> fetchAppointmentDetails()
	{
		//Validation Logic
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		String actualAppointment= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		String actualDoctor=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("date", actualDate);
		actualHMap.put("time", actualTime);
		actualHMap.put("appointment", actualAppointment);
		actualHMap.put("doctor", actualDoctor);
		return actualHMap;

		 
	}
}

package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.mmp.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javaexamples.DateFunctionality;

public class ScheduleAppointmentPage {

	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public HashMap<String, String> bookAppointment(String doctorName,int noofDays)
	{
		//book Appointment
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();

		expectedHMap.put("doctor", doctorName);
		driver.findElement(By.xpath("//h4[text()='Dr."+doctorName+"']/following-sibling::div/p[contains(text(),'Orthopedic')]/ancestor::ul/following-sibling::button")).
		click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		DateFunctionality df = new DateFunctionality();
		String result = AppLibrary.getFutureDate(noofDays,"d/MMMMM/yyyy");
		expectedHMap.put("date", AppLibrary.getFutureDate(noofDays,"MM/d/yyyy"));
		System.out.println(result);
		String dateArr[]=result.split("/");
		String expectedDate = dateArr[0];//dd
		String expectedMonth=dateArr[1];//MMMMM
		String expectedYear=dateArr[2];//yyyy

		String actualYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(actualYear.equals(expectedYear)))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			actualYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}

		String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		while(!(actualMonth.equals(expectedMonth)))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			actualMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}

		driver.findElement(By.linkText(expectedDate)).click();

		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText("10Am");
		expectedHMap.put("time", timeSelect.getFirstSelectedOption().getText());
		driver.findElement(By.id("ChangeHeatName")).click();
		String appointment="To Meet the doctor";
		driver.findElement(By.id("sym")).sendKeys(appointment );
		expectedHMap.put("appointment",appointment);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println("expectedHashMap:: " + expectedHMap);
		return expectedHMap;

	}
	 

}

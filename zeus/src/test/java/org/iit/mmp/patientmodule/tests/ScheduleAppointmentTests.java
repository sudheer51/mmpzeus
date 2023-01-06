package org.iit.mmp.patientmodule.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaexamples.DateFunctionality;
 

public class ScheduleAppointmentTests {

	/**
	 * 1. Open the browser and login to the MMP
	 * 2. Click on ScheduleAppointment Tab
	 * 3. Click on "create new appointment" button
	 * 4. Select the doctor and click on "book appointment" button
	 * 5. Select the future date from date picker : 30 days from now
	 * 6. Select the time as "10 Am"
	 * 7. Click on continue button
	 * 8. Enter the text in the textbox
	 * 9. Click on submit button
	 * 10. Validate the details entered during the appointment are added to the Patient Portal table 
	 * 	   as a first row in the Home  page.
	 */
	@Test
	public void validateBookAppointment()
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

		 
		//Schedule Appointment Tab
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		
		
		//book Appointment
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		String doctor = "Smith";
		expectedHMap.put("doctor", doctor);
		driver.findElement(By.xpath("//h4[text()='Dr."+doctor+"']/following-sibling::div/p[contains(text(),'Orthopedic')]/ancestor::ul/following-sibling::button")).
			  click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		DateFunctionality df = new DateFunctionality();
		String result = getFutureDate(30,"dd/MMMMM/yyyy");
		expectedHMap.put("date", getFutureDate(30,"MM/dd/yyyy"));
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
		
		Assert.assertEquals(actualHMap, expectedHMap);
	 

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
	public String getFutureDate(int noofdays)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);

		Date d = cal.getTime();
		System.out.println("Current Date :" + d);

		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);

		sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}

}

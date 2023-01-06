package org.iit.mmp.patientmodule.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientSanityTests {
	
	@Test
	public void validatePatientModule()
	{
		
		//Invoking Application URL
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		//Login
		String expected="Patient Portal";
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		
		expected="Personal Details";
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		sa.assertEquals(actual, expected);
		
		
		expected="Current Appointments";
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		sa.assertEquals(actual, expected);
		
		
	
		expected="Information";
		driver.findElement(By.xpath("//span[contains(text(),'Information')]")).click();
		actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		sa.assertEquals(actual, expected);
		
		expected="Search Symptoms";
		driver.findElement(By.xpath("//span[contains(text(),'Search Symptoms')]")).click();
		actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		sa.assertEquals(actual, expected);
		
		sa.assertAll();
	}

}

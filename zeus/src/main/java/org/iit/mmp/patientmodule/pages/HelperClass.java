package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.WebDriver;

public class HelperClass {

	WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver=driver;
	}
	public void launchBrowser(String url)
	{
		driver.manage().window().maximize();
		driver.get(url );
	}
 
}

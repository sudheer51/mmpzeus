package org.iit.mmp.util;

import java.io.IOException;
import java.util.Properties;

import org.iit.mmp.patientmodule.pages.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	protected Properties pro;

	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		ProjectConfiguration projectConfig = new ProjectConfiguration();
		 pro = projectConfig.loadProperties();

		if(pro.getProperty("browserType").equals("Chrome")) 
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(pro.getProperty("browserType").equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		HelperClass helper = new HelperClass(driver);
		helper.launchBrowser(pro.getProperty("patientURL"));

	}

}

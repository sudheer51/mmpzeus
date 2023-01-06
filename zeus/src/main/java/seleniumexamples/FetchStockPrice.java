package seleniumexamples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStockPrice {
	
	public static void main(String args[])
	{
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		Selenium Jar version
//		Chrome Browser Version
//		Chromedriver.exe version 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		
		String stockName ="JaiprakashAssociates";
		
		//Fetching the stock price
		String currentPrice = driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[3]")).getText();
		System.out.println("The stock current price is ::: " + currentPrice);
		
		String previousClose = driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[2]")).getText();
		System.out.println("The previous current price is ::: " + previousClose);
		
		double expectedValue = (Double.parseDouble(currentPrice.replace(",", ""))-Double.parseDouble(previousClose.replace(",", "")))/Double.parseDouble(previousClose) * 100;
		System.out.println("expected" + expectedValue);
		double expected = Math.round( expectedValue*100.0 ) /100.0;
		System.out.println(expected);
		
		String changePercentage=  driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[4]")).getText();
		System.out.println("The %change is ::: " + changePercentage);
		
		double actual = Double.parseDouble(changePercentage.replace("+", ""));
		System.out.println("actual " + actual);
		if(actual==expected)
		{
			System.out.println("%change is displayed correctly");
		}
		else 
		{
			System.out.println("%change is not displayed correctly");
		}
		
		/*
		 * 
		 * Formula:
		 * 
		 * 	(Currentprice- PreviousClose)
		 * -----------------------------------  X 100
		 * 		(PreviousClose)
		 * 
		 */
		
		
	}

}

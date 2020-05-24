package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAClickHome {
	WebDriver driver;

	public QAClickHome(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By NoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public WebElement NoThanks()
	{
		return driver.findElement(NoThanks);
		
	}
	

}

package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By NoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");
	By LoginHome = By.xpath("//*[contains(text(),'Login')]");
	
	
	
	public WebElement NoThanks()
	{
		return driver.findElement(NoThanks);
		
	}
	public WebElement LoginHome() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(LoginHome);
	}
	

}

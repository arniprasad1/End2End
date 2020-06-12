package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By Email = By.id("user_email");
	By Password = By.id("user_password");
	By ForgotPwd = By.xpath("//a[contains(text(),'Forgot Password?')]");
	By Login = By.xpath("//*[@name='commit']");
	By courses = By.linkText("My Courses");
	
	
	public WebElement SetEmail()
	{
		return driver.findElement(Email);
		
	}
	public WebElement SetPassword() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(Password);
	}
	public WebElement CheckForgotPwd() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(ForgotPwd);
	}
	public WebElement Login() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(Login);
	}
	public WebElement MyCourses() 
	{
		// TODO Auto-generated method stub
		return driver.findElement(courses);
	}

}

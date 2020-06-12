package Sample.End2EndProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import resources.Base;
import resources.HomePage;
import resources.LoginPage;
import resources.ReadExcelData;
import resources.dataDriven;
	public class HomePageTest extends Base {
		
		public static Logger Log =LogManager.getLogger(Base.class.getName());
		
		@BeforeTest
		public void initialize() throws IOException
		{	
			driver = initializeDriver();
			Log.debug("driver is initialized");
			driver.manage().window().maximize();
			
			
		}

		@Test
		public static void ValidateHomePage() throws IOException
		{
			
			driver.get(prop.getProperty("url1"));
			Log.debug("Navigated to Home page");
			HomePage Home = new HomePage(driver);
			Home.NoThanks().click();
			Log.debug("User clicked on default pop up as No Thanks");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Home.LoginHome().click();
			Log.debug("Check whether user navigated to Login page");
		}
		@DataProvider (name = "LoginTest1")
		public Object[][] getData()
		{
			String exelPath = "E:\\SELENIUM\\End2EndProject\\exel\\UALData.xlsx";
			Object data[][] = loginTest(exelPath, "E2E");
			return data;
			
		}
		@Test(dataProvider = "LoginTest1" )
		public static void ValidateLogin(String username,String password, String runmode) throws InterruptedException 
		{
			System.out.println(username + " | "+ password + " | "+ runmode);
			
				if(runmode.equalsIgnoreCase("Y")) {
					LoginPage Login = new LoginPage(driver);
					Login.CheckForgotPwd().isDisplayed();
					System.out.println("text is: " + Login.CheckForgotPwd().getText());
					Login.SetEmail().click();
					
					Login.SetEmail().sendKeys(username);
					Log.debug("Accepted username");
					Login.SetPassword().click();
					
					Login.SetPassword().sendKeys(password);
					Log.debug("Entered password");
					//Thread.sleep(5000);
					Login.Login().click();
					String actualUrl="https://courses.rahulshettyacademy.com/";
			        String expectedUrl= driver.getCurrentUrl();
			        
			        if(actualUrl.equalsIgnoreCase(expectedUrl))
			        {
			            System.out.println("Test passed");
			            driver.findElement(By.xpath("//span[@class='navbar-current-user']")).click();
						WebElement element = driver.findElement(By.partialLinkText("Log Out"));
						Actions action = new Actions(driver);
						action.moveToElement(element).click().perform();

						Thread.sleep(5000);
						driver.findElement(By.xpath("//a[@class='theme-btn']")).click();
						Thread.sleep(5000);
			        }
			        else
			        {
			            System.out.println("Test failed as invalid user login");
			            Log.debug("Check whether user logged in or not");
			            String actualError = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			            String expectedError = "Invalid email or password.";
						Assert.assertEquals(actualError, expectedError);
						System.out.println(actualError);
						Log.info("matches with the result");
			        }
				}
				
			}
		public static Object[][] loginTest(String exelPath, String sheetName)
		{
			ReadExcelData exeldata = new ReadExcelData(exelPath, sheetName);
			int rowCount = exeldata.getRowCount();
			int colCount = exeldata.getColCount();
			
			Object [][] data = new Object[rowCount-1][colCount];
			
			for(int i=1;i<rowCount;i++)
			{
				for(int j=0;j<colCount;j++)
				{
					String cellData = exeldata.getCellDataString(i,j);
					//System.out.print(cellData+" | ");
					data[i-1][j] = cellData;
					
				}
				System.out.println();
				
				
			}
			
			return data;

			
		}
			

		@AfterTest
		public void teardown()
		{
			driver.close();
			driver=null;
		}
}

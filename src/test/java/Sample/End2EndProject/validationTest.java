package Sample.End2EndProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import resources.QAClickHome;



	public class validationTest extends Base {
		@BeforeTest
		public void initialize() throws IOException
		{
			driver = initializeDriver();
			
		}
		@Test
		public void ValidateHomePage() throws IOException
		{
			driver.get(prop.getProperty("url1"));
			QAClickHome Home = new QAClickHome(driver);
			Home.NoThanks().click();
			}
		
		@AfterTest
		public void teardown()
		{
			driver.close();
			driver=null;
		}




}

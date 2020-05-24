package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\SELENIUM\\End2EndProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("WebDriver.firefox.driver", "C:\\Users\\arnip\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equals("firefox"))
		{
			//System.setProperty("WebDriver.firefox.driver", "C:\\Users\\arnip\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			//System.setProperty("WebDriver.InternetExplorer.driver", "C:\\Users\\arnip\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
	

}

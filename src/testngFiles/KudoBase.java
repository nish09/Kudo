package testngFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import objectRepository.KudoMyDrawingPage;

public class KudoBase {
	
	public WebDriver driver = null;
	Properties prop = new Properties(); //to interpret with the Properties file
	KudoMyDrawingPage kmdp=new KudoMyDrawingPage(driver);
	
	public void BrowserOpen() throws IOException
	{
		//Properties prop = new Properties(); //to interpret with the Properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\Nishant\\Dropbox\\Selenium\\Selenium\\Kudo_TestNG\\src\\testngFiles\\datadrive.properties"); //to tell Selenium where file is located
		prop.load(fis); //to load file with proeprties class
		
		//System.out.println(prop.getProperty("email"));
		
		if(prop.getProperty("browser").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			FirefoxProfile prof = new FirefoxProfile();
			prof.setAcceptUntrustedCertificates(false);
			driver = new FirefoxDriver(prof);
		}
		else 
		{
				 System.out.println("Browser doesn't match");
		}
		
		driver.get(prop.getProperty("url"));
		
		/*long start = System.currentTimeMillis();
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Start time - "+totalTime); 
		//System.out.println("Total Time for page load - "+totalTime); */
	}

}

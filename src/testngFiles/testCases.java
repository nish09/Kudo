package testngFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.KudoMyDrawingPage;

public class testCases {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Nishant\\Dropbox\\Selenium\\Selenium\\Kudo_TestNG\\src\\testngFiles\\datadrive.properties"); //to tell Selenium where file is located
		prop.load(fis);
		
		//Properties prop = new Properties(); //to interpret with the Properties file
		//FileInputStream fis = new FileInputStream("C:\\Users\\Nishant\\Dropbox\\Selenium\\Selenium\\Kudo_TestNG\\src\\testngFiles\\datadrive.properties"); //to tell Selenium where file is located
		//prop.load(fis); //to load file with proeprties class
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		KudoMyDrawingPage kmd = new KudoMyDrawingPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//prop.getProperty("url");
		driver.get("https://fluorine-master-latest-ue1.dev.graebert.com/");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div[3]/form/div[1]/input")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(".//*[@id='loginForm']/div[3]/form/div[2]/input")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@id='loginForm']/div[3]/form/button")).click();
		System.out.println("Logged IN successfully");
		
		
		//driver.findElement(By.xpath(".//*[@id='react']/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div/button[3]")).click();
		driver.findElement(By.xpath("//*[@id='react']/shortcuts/div/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div/button[3]")).click();
		kmd.CNDNameField().sendKeys(prop.getProperty("dwgName"));
		kmd.CreateSubmit().click();
		String drawingname = driver.findElement(By.xpath(".//*[@id='react']/shortcuts/div/div[3]/header/nav/div/div[2]/ul[2]/li/a/div/span")).getText();
		if(drawingname == prop.getProperty("dwgName"))
		{
			System.out.println("Drawing name successfully created with entered name");
		}
		else
		{
			System.out.println("Drawing name created with" + " " + drawingname);
		}
		//div[@class='toolbarRightSwitch col-lg-4 col-md-6 col-sm-8 col-xs-12']/div/div/div/div[2]/div/div[1]
		
	}	
		
		/*int number = switchtoFrame(driver, By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/span[2]/div/img"));
		driver.switchTo().frame(number);
		
		
	}
	
	public static int switchtoFrame(WebDriver driver, By by) // In case we have multiple frames on a page then this code can be used
	{
		int i;
		int framecount = driver.findElements(By.tagName("iframe")).size();
		for (i=0; i<framecount; i++)
		{
			driver.switchTo().frame(i);
			
			@SuppressWarnings("unchecked")
			int count=((Hashtable<Object,Object>) driver.findElement(by)).size();
			if(count>0)
			{
				System.out.println("Toolbar is populating.." + driver.findElement(by).isDisplayed());
				break;
			}
			else
			{
			System.out.println("Continue looping");	
			}
		}
		driver.switchTo().defaultContent();
		return i;
		
	}*/
	

}

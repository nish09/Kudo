package testngFiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import objectRepository.KudoLoginPage;

public class LoginStart extends KudoBase
{
	KudoLoginPage klp=new KudoLoginPage(driver);
	@BeforeMethod																																		
	public void kudoLogin() throws IOException, InterruptedException
	{	
		
		BrowserOpen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='loginForm']//div[3]//form//div[1]//input")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(".//*[@id='loginForm']//div[3]//form//div[2]//input")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@id='loginForm']//div[3]//form//button")).click();
		System.out.println("Logged IN successfully");
		Thread.sleep(3000);
		
		
	}
	
	@AfterMethod
	public void kudoLogout() throws IOException
	{
		try
		{
		
			driver.findElement(By.xpath("(//div[@id='react']//div//div//header//nav//div//div[2]//ul[3]//li//a//span)[1]")).click();
			if(prop.getProperty("logout1")!=prop.getProperty("logout2"))
			{
			driver.findElement(By.xpath("//*[@id='react']/div/div/header/nav/div/div[2]/ul[3]/li/ul/div[2]/li/a/span")).click();
			}
			else
			{
			driver.findElement(By.xpath("//*[@id='react']/div/div/header/nav/div/div[2]/ul[4]/li/ul/div[2]/li/a/span")).click();
			}
			System.out.println("Successfully Logged out from Kudo");
		}
			catch (Exception e)
		{
				driver.quit();
		}
		driver.quit();
	}
	
	@DataProvider(name="TestData")
	public Object[][] getData()
	{
		Object[][] data= new Object[3][3];
		
		data[0][0]="nishant.singh@graebert.com";
		data[0][1]="1809@nish";
		
		data[1][0]="graebertkudo@graebert.com";
		data[1][1]="graebertkudo@1";
		
		data[2][0]="nishant.singh@graebert.com";
		data[2][1]="1809@nish";
		return data;
		
	}
	
	public void screenshot() throws IOException
	{
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\screenshot.png"));
	}
	
	
	
}


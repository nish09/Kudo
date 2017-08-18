package testngFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.KudoTemplatePage;

public class TemplatePage extends LoginStart {
	
	
	@Test(dataProvider="SearchProvider")
	public void Upload(String drwgnme) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		KudoTemplatePage temp = new KudoTemplatePage(driver);
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[3]//li//a")).click(); //to open Name Panel on top right of the page
		driver.findElement(By.xpath("//a[@href='/templates']")).click();
		//driver.findElement(By.xpath(".//*[@id='react']/shortcuts/div/div[3]/div/div[1]/div/div/div/div/button")).click();
		System.out.println(temp.Upload().isDisplayed());
		temp.Upload().click();
		System.out.println("Template label is displayin on menu bar -"+temp.TemplateLabel().isDisplayed());
		System.out.println("Upload template label in dialog is displayed -"+ temp.UploadTemplateLabel().isDisplayed());
		System.out.println("Template file label in dialog is displayed -"+ temp.TemplateFileLabel().isDisplayed());
		System.out.println("Name label in dialog is displayed -"+ temp.NameLabel().isDisplayed());
		System.out.println("Description label in dialog is displayed -"+ temp.DescriptionLabel().isDisplayed());
		System.out.println("Upload button in dialog is displayed -"+ temp.UploadSubmit().isDisplayed());
		System.out.println("Cancel button in dialog is displayed -"+ temp.Cancel().isDisplayed());
		temp.Choose().sendKeys(drwgnme);
	
		temp.UploadSubmit().click();
	
		
	}
	
	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromProvider()
	{
		return new Object[][]
				{
			{ "07-04-17 Geral Final - Campo Grande.dwg" },
			{ "100a.dwg" },
			{"18000 Brookhurst st (1)" }
				
			
			};
	}
	
	

}

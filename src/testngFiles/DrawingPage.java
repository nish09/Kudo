package testngFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.KudoMyDrawingPage;
import objectRepository.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class DrawingPage extends LoginStart{
	
	
	@Test(enabled=false)
	public void drawingLoad() throws IOException  //To open a drawing from the drawing list
	{
		try
		{
			//kudoLogin();
		Actions Action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement tbl =driver.findElement(By.xpath("//div[@class='container-fluid noPadding']//div[2]//div[3]//div[1]//div[1]//div[1]//table"));
		List<WebElement> rows = tbl.findElements(By.xpath("//tr[@class='tableRow file disabled']"));
		
		//.//tr[@class='tableRow file disabled']    //div[@class='container-fluid noPadding']//div[2]//div[3]//div[1]//div[1]//div[1]//table[1]//tbody//tr
		
		System.out.println("No. of Rows-" + rows.size());
		
			for(int i=0;i<=rows.size();i++)
			{
				List<WebElement> columns = rows.get(i).findElements(By.xpath("//tr[@class='tableRow file disabled']//td//div[2]//div//span"));
				System.out.println(columns.get(i).getText());
				
				WebDriverWait d = new WebDriverWait(driver, 10);
				columns.get(i).click();
				d.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("draw"))));
				Thread.sleep(10000L);
				driver.switchTo().defaultContent();
				
				
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\screenshot.png"));
			
		}
		
	}
	
	
	@Test
	public void noofDrawings() throws IOException  //No. of drawings available in list
	{
		try
		{
					
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement tbl =driver.findElement(By.xpath("//div[@class='container-fluid noPadding']//div[2]//div[3]//div[1]//div[1]//div[1]//table"));
		List<WebElement> rows = tbl.findElements(By.xpath("//tr[@class='tableRow file disabled']"));
		
		//.//tr[@class='tableRow file disabled']    //div[@class='container-fluid noPadding']//div[2]//div[3]//div[1]//div[1]//div[1]//table[1]//tbody//tr
		
		System.out.println("No. of Rows-" + rows.size());
		
			for(int i=0; i<=rows.size(); i++)
			{
				List<WebElement> columns = rows.get(i).findElements(By.xpath("//tr[@class='tableRow file disabled']//td//div[2]//div//span"));
				System.out.println(columns.get(i).getText());
									
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\screenshot1.png"));
				
		}
		
	}
	
	
	@Test
	public void validationElements() throws IOException
	{
		try
		{
		
		System.out.println("Search TextBox is displaying on UI- "+driver.findElement(By.xpath(".//*[@id='searchInputField']")).isEnabled());
		System.out.println("Create Folder button is displaying on UI- "+driver.findElement(By.xpath(".//*[@id='createFolderButton']")).isEnabled());
		System.out.println("Create file button is displaying on UI- "+driver.findElement(By.xpath(".//*[@id='createFileButton']")).isEnabled());
		System.out.println("Upload button is displaying on UI- "+driver.findElement(By.xpath(".//*[@id='uploadFileButton']")).isEnabled());
		System.out.println("Delete Link is displaying on UI- "+driver.findElement(By.xpath(".//*[@id='react']/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div/a/span")).isEnabled());
		System.out.println("Filter dropdown is displaying on UI- "+driver.findElement(By.xpath(" //div[@class='navbar-collapse collapse']//ul[2]//li//a")).isEnabled());
		
		
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\UI elements.png"));	
		}
		
	}
	
	
	@Test
	public void switchToModes() throws IOException, InterruptedException
	{
		try
		{
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[3]//li//a")).click(); //to open Name Panel on top right of the page
		driver.findElement(By.xpath("//div[@href='/storages']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[4]//li//a")).click();
		driver.findElement(By.xpath("//a[@href='/profile']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@id='react']/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div[2]")).click();
		
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[4]//li//a")).click();
		driver.findElement(By.xpath("//a[@href='/users']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[4]//li//a")).click();
		driver.findElement(By.xpath("//a[@href='/templates']")).click();
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("prop.getProperty(imglocation)+switchtomodes.png"));	
		}
		
		
	}
	
	@Test(enabled=false)
	public void filters() throws IOException
	{
		try
		{
		WebDriverWait webwait = new WebDriverWait(driver, 5);
		
		Thread.sleep(3000L);
		driver.findElement(By.xpath(".//*[@id='react-select-6--value']/div[1]")).click();
		webwait.until(ExpectedConditions.elementToBeClickable(By.xpath("div[@class='Select-menu-outer']")));
				//driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]")).click();
		driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div[1]")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]")).click();
		driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div[2]")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]")).click();
		driver.findElement(By.xpath("//div[@id='react']/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div[3]")).click();
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\Filters.png"));	
		}
		

	}
	
	
	@Test
	public void storagePageValidation() throws IOException, InterruptedException
	{
		try
		{
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[3]//li//a")).click(); //to open Name Panel on top right of the page
		driver.findElement(By.xpath("//div[@href='/storages']")).click();
		Thread.sleep(2000L);
		
		System.out.println("Storage label is visible - "+driver.findElement(By.xpath("//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li")).isDisplayed());
		System.out.println("ARES Kudo logo image is visible - "+driver.findElement(By.xpath("//*[@id='react']/div/div/header/nav/div/div[1]/div/img")).isDisplayed());
		System.out.println("Connect to your cloud storage label is visible - "+driver.findElement(By.xpath("//*[@id='storagesPage']/div/div/div/div[1]/div/span")).isDisplayed());
		System.out.println("GDrive icon is visible - "+driver.findElement(By.xpath("//*[@id='storagesPage']/div/div/div/div[1]/div/img[1]")).isDisplayed());
		System.out.println("Box icon is visible - "+driver.findElement(By.xpath("//*[@id='storagesPage']/div/div/div/div[1]/div/img[2]")).isDisplayed());
		System.out.println("Trmible icon is visible - "+driver.findElement(By.xpath("//*[@id='storagesPage']/div/div/div/div[1]/div/img[3]")).isDisplayed());
		System.out.println("Dropbox icon is visible - "+driver.findElement(By.xpath("//*[@id='storagesPage']/div/div/div/div[1]/div/img[4]")).isDisplayed());
		
		System.out.println("Gdrive Section is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[1]/div[1]")).isDisplayed());
		System.out.println("Gdrive Section Add account button is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[1]/div[1]/div/img")).isDisplayed());
		
		System.out.println("Box section is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[2]/div[1]")).isDisplayed());
		System.out.println("Box Section Add account button is visible - "+driver.findElement(By.xpath(".//*[@id='storagesSection']/div[2]/div[1]/div/img")).isDisplayed());
		
		System.out.println("Trimble connect section is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[3]/div[1]")).isDisplayed());
		System.out.println("Trimble connect Section Add account button is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[3]/div[1]/div/img")).isDisplayed());
		
		System.out.println("Dropbox icon is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[4]/div[1]")).isDisplayed());
		System.out.println("Dropbox  Section Add account button is visible - "+driver.findElement(By.xpath("//*[@id='storagesSection']/div[4]/div[1]/div/img")).isDisplayed());
		
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\Storagepage.png"));	
		}
		
		
	}
	
	
	@Test
	public void profilePageValidation() throws IOException, InterruptedException
	{
		try
		{
		
		//driver.findElement(By.xpath(".//*[@id='nav-dropdown']")).click();
		driver.findElement(By.xpath("//div[@id='react']//div//div//header//nav//div//div[2]//ul[3]//li//a")).click();
		driver.findElement(By.xpath("//a[@href='/profile']")).click();
		Thread.sleep(2000L);
		
		System.out.println("Profile Label is visible - "+driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a")).isDisplayed());
		System.out.println("Select language Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[1]/label/span")).isDisplayed());
		System.out.println("Account Data Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[2]/span")).isDisplayed());
		System.out.println("First name Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[3]/label/span")).isDisplayed());
		System.out.println("Last name Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[4]/label/span")).isDisplayed());
		System.out.println("Last name Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[5]/label/span")).isDisplayed());
		System.out.println("Current password Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[6]/label/span")).isDisplayed());
		System.out.println("New password Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[7]/label/span")).isDisplayed());
		System.out.println("New password Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[8]/label/span")).isDisplayed());
		System.out.println("Linked account Label is visible - "+driver.findElement(By.xpath("//*[@id='profilePage']/div/div/div/div/div/form/div[9]/div/label/span")).isDisplayed());
		System.out.println("Sign In with Google account button is visible - "+driver.findElement(By.xpath(".//*[@id='g-signin2']")).isEnabled());
		
		
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\Profilepage.png"));	
		}
		
		
	}
	
	@Test
	public void termsAndPrivacy() throws IOException
	{
		try{
			
			String winParentHandle = driver.getWindowHandle();
			driver.findElement(By.linkText("Terms of Use")).click();
			driver.switchTo().window(winParentHandle);
			driver.findElement(By.linkText("Privacy policy")).click();
			Thread.sleep(2000L);		
			
			String title= "ARES Kudo";
			String title1= "Gräbert - Customer Portal";
			Set<String> handles = driver.getWindowHandles();
					for(String handle :handles)
					{
						driver.switchTo().window(handle);
						
						System.out.println(driver.getTitle());
						if(driver.getTitle().equals(title))
						{
							String wholeText = driver.findElement(By.className("c12")).getText();
							System.out.println(wholeText);
						}
						else if(driver.getTitle().equals(title1))
						{
							System.out.println("Successfully opens Graebert Customer portal page");
						}
						
					}
					driver.switchTo().window(winParentHandle);
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\termsandPrivacy.png"));
		}
	}
	
	@Test
	public void createDrawing() throws IOException, TestLinkAPIException
	{
		String result = " ";
		String exception =" ";
		TestLinkIntegration tli =  new TestLinkIntegration();
		try
		{
			
		KudoMyDrawingPage kmd = new KudoMyDrawingPage(driver);
		kmd.CreateNewDrawing().click();
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
		
		//To place Pass/Fail result in TESTLINK project 
		result= TestLinkAPIResults.TEST_PASSED;
		tli.updateTestLinkResult("XEN-1", null, result);
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\CreateDrawing.png"));
			//To place Pass/Fail result in TESTLINK project 
			result=TestLinkAPIResults.TEST_FAILED;
			exception = e.getMessage();
			tli.updateTestLinkResult("XEN-1", exception, result);
			
		}
		/*driver.findElement(By.xpath(".//*[@id='react']/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div/button[3]")).click();
		driver.findElement(By.xpath(".//*[@id='createFileModal']/form/div[2]/input")).sendKeys(prop.getProperty("dwgName"));
		driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[2]")).click();
		String drawingname = driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/div/span")).getText();
		if(drawingname == prop.getProperty("dwgName"))
		{
			System.out.println("Drawing name successfully created with entered name");
		}
		else
		{
			System.out.println("Drawing name created with" + " " + driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/div/span")).getText());
		}*/
		
	}
	
	@Test
	public void lineCmdUsingCW() throws InterruptedException, IOException
	{
		try
		{
		driver.findElement(By.xpath(".//*[@id='react']/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div/button[3]")).click();
		driver.findElement(By.xpath(".//*[@id='createFileModal']/form/div[2]/input")).sendKeys(prop.getProperty("dwgName"));
		driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[2]")).click();
		String drawingname = driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/div/span")).getText();
		if(drawingname == prop.getProperty("dwgName"))
		{
			System.out.println("Drawing name successfully created with entered name");
		}
		else
		{
			System.out.println("Drawing name created with" + " " + driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/div/span")).getText());
		}
		System.out.println("Share this file icon is populating.." + driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/span[1]/div/img")).isDisplayed());
		System.out.println("Change editor URL icon is populating.." + driver.findElement(By.xpath(".//*[@id='react']/div/div/header/nav/div/div[2]/ul[2]/li/a/span[2]/div/img")).isDisplayed());
		Thread.sleep(8000);
	
		WebElement frame =driver.findElement(By.id("draw"));
		Actions draw = new Actions(driver);
		driver.switchTo().frame(frame);
		//driver.findElement(By.xpath(".//body[@class=' Wt-layout Wt-ltr']/div/div[2]/div/div/div/div/div/div/div/div/div/div[1]")).click();
		//driver.findElement(By.xpath(".//*[@id='navBar_ID_NavBarDefault']/div/div")).click();
		System.out.println("Run LINE Command");
		driver.findElement(By.xpath(".//*[@id='navBar_ID_NavBarDefault']/div/div")).sendKeys("Line" + Keys.ENTER);
		
		draw.moveByOffset(100, 100).click().build().perform();
		draw.moveByOffset(200, 200).click().build().perform();
		draw.sendKeys("" + Keys.ENTER).build().perform();
		System.out.println("Line successfully created on GA");
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\Line.png"));
		}
		catch (Exception e)
		{
			System.out.println("Test case failed need to be checked");
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\Lineerror.png"));
		}
	}
	
	@Test(dataProvider ="imglocation")
	public void screenshot(String location) throws IOException
	{
		System.out.println("firstlineofcode-"+"-secondlineofcode");
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File(location+"Lineerror.png"));
	
	}
	
	@DataProvider(name = "imglocation")
	public Object[][] imagelocation()
	{
		
		return new Object[][] 
			{
				{"C:\\Users\\Nishant\\Desktop\\UXUI\\1.65\\"}
			};
		
	}

	
	@Test
	public void fileUpload()
	{
		kmdp.Upload().sendKeys("C:\\Users\\Nishant\\Downloads\\100a.dwg");
	}
	
	@DataProvider(name="imglocation")
	@Test
	public void CreateFolder(String location) throws IOException
	{
		try
		{
		KudoMyDrawingPage mdp = new KudoMyDrawingPage(driver);
		mdp.CreateNewDFolder().click();
		mdp.Folderfield().sendKeys(prop.getProperty("foldername"));
		mdp.CreateFolder().click();
		System.out.println("Folder created successfully");
		
	}
	catch(Exception e)
		{
		System.out.println("Test case failed need to be checked");
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		File ScrFile = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScrFile, new File(location+"CreateFolderissue"));
		}
	}
} 
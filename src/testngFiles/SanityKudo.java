package testngFiles;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class SanityKudo extends LoginStart {
	
@Test
public void loginKudo()
{
	System.out.println("Successfully Login In to Kudo");
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
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("C:\\Users\\Nishant\\Desktop\\UXUI\\termsandPrivacy.png"));
	}
}

}

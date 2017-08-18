package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudoLoginPage {
	WebDriver driver;
	public KudoLoginPage(WebDriver driver){
		
		this.driver=driver;
	}

	By email=By.xpath(".//*[@id='loginForm']//div[3]//form//div[1]//input");
	By password=By.xpath(".//*[@id='loginForm']//div[3]//form//div[2]//input");
	By login=By.xpath("//*[@id='loginForm']//div[3]//form//button");

public WebElement Email()
{
	return driver.findElement(email);
}

public WebElement Password()
{
	return driver.findElement(password);
}

public WebElement LoginClick()
{
	return driver.findElement(login);
}

}



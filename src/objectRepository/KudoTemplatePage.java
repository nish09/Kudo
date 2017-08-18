package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KudoTemplatePage {
	
	WebDriver driver;
	public KudoTemplatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By Upload=By.xpath(".//*[@id='react']/shortcuts/div/div[3]/div/div[1]/div/div/div/div/button");
	
	//@FindBy(xpath="//*[@id='uploadFileButton']")
	//WebElement Upload;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/header/nav/div/div[2]/ul[2]/li")
	WebElement TempLabel;
	
	@FindBy(xpath=".//*[@id='CS_ca5eab6f-1c7d-58a4-3f6b-503f655ab0f9']/thead/tr/th[1]/span")
	WebElement NameHeader;
	
	@FindBy(xpath=".//*[@id='CS_ca5eab6f-1c7d-58a4-3f6b-503f655ab0f9']/thead/tr/th[2]/span")
	WebElement CommentHeader;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[1]/h4/div/span")
	WebElement UploadTemplateDialog;
	
	@FindBy(xpath="//body[@class='modal-open']//div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[1]/span/span/div/button")
	WebElement Choose;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[2]")
	WebElement UploadSubmit;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[1]")
	WebElement Cancel;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[1]/label/span")
	WebElement TemplateFileLabel;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[2]/label/span")
	WebElement NameLabel;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[3]/input")
	WebElement DescriptionField;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[3]/label/span")
	WebElement DescriptionLabel;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/form/div[2]/input")
	WebElement NameField;
	
	public WebElement Upload()
	{
		return driver.findElement(Upload);
	}

	public WebElement TemplateLabel()
	{
		return TempLabel;
	}
	
	public WebElement NameHeader()
	{
		return NameHeader;
	}
	
	public WebElement CommentHeader()
	{
		return CommentHeader;
	}
	
	public WebElement UploadTemplateLabel()
	{
		return UploadTemplateDialog;
	}

	public WebElement Choose()
	{
		return Choose;
	}
	
	public WebElement UploadSubmit()
	{
		return UploadSubmit;
	}
	
	public WebElement Cancel()
	{
		return Cancel;
	}
	
	public WebElement TemplateFileLabel()
	{
		return TemplateFileLabel;
	}
	
	public WebElement NameLabel()
	{
		return NameLabel;
	}
	
	public WebElement DescriptionField()
	{
		return DescriptionField;
	}
	
	public WebElement DescriptionLabel()
	{
		return DescriptionLabel;
	}
	
	public WebElement NameField()
	{
		return NameField;
	}
}

package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KudoMyDrawingPage {
	WebDriver driver;
	public KudoMyDrawingPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//By upload = By.xpath(".//*[@id='uploadFileButton']");
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/header/nav/div/div[1]/div/img")
	WebElement KudoLogo;
	
	@FindBy(xpath=".//*[@id='uploadFileButton']")
	WebElement upload;
	
	@FindBy(xpath=".//*[@id='react']/div/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div/button[2]")
	WebElement Folder;
	
	@FindBy(xpath=".//*[@id='createFolderModal']/form/div/input")
	WebElement FolderField;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[2]")
	WebElement CreateFolder;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div/button[3]")
	WebElement CreateNewDrawing;
	
	@FindBy(xpath=".//*[@id='createFileModal']/form/div[2]/input")
	WebElement CNDNameField;
	
	@FindBy(xpath="html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/button[2]")
	WebElement CreateSubmit;
	
	@FindBy(xpath=".//*[@id='searchInputField']")
	WebElement Searchfield;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/a/span")
	WebElement Trash;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/span[2]")
	WebElement ShowFiles;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/footer/div/a[1]/span")
	WebElement termsofuse;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/footer/div/a[2]/span")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath=".//*[@id='react']/shortcuts/div/div[3]/div/div[2]/footer/div/span")
	WebElement RevisionNumber;
	
	public WebElement Upload()
	{
		return upload;
	}
	
	public WebElement CreateNewDrawing()
	{
		return CreateNewDrawing;
	}
	
	public WebElement CreateNewDFolder()
	{
		return Folder;
	}
	
	public WebElement Folderfield()
	{
		return FolderField;
	}
	
	public WebElement CreateFolder()
	{
		return CreateFolder;
	}

	public WebElement CNDNameField() 
	{
		return CNDNameField;
	}
	

	public WebElement CreateSubmit()
	{
		return CreateSubmit;
	}
	
	public WebElement KudoLogo()
	{
		return KudoLogo;
	}
	
	public WebElement Search()
	{
		return Searchfield;
	}
	
	public WebElement Trash()
	{
		return Trash;
	}
	
	public WebElement ShowAllFiles()
	{
		return ShowFiles;
	}
	
	public WebElement termsofuse()
	{
		return termsofuse;
	}
	
	public WebElement PrivacyPolicy()
	{
		return PrivacyPolicy;
	}
	
	public WebElement RevisionNumber()
	{
		return RevisionNumber;
	}
}


package KeywordDriven_pois;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trelo_actions {
	
	public WebDriver driver;
	
	public WebElement Waitforfield(By locator,int seconds)
	{
		return(new WebDriverWait(driver, seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void Openbrowser(String s, String d)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suresh\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		//driver= new FirefoxDriver();
		driver= new ChromeDriver();
	}
	
	public void Navigate_to(String s, String d)
	{
		driver.get("https://trello.com/login");
		driver.manage().window().maximize();
	}
	public void  Waitforpage(String s , String d) throws InterruptedException
	{
       Thread.sleep(5000);
	}
	
	public void Enterusername(String s, String d)
	{
		//System.out.println("user name is :"+s);
		Waitforfield(By.id(s), 2000).sendKeys(d);
	}
    
	public void Enterpassword(String s, String d)
	{
		Waitforfield(By.id(s), 4000).sendKeys(d);
	}
	public void Clicksignin(String s, String d)
	{
		Waitforfield(By.id(s), 4000).click();
	}
	public void  Waitfor(String s , String d) throws InterruptedException
	{
       Thread.sleep(5000);
	}
	public void Validate_login(String s, String d)
	{
		Waitforfield(By.xpath(s), 2000).isDisplayed();
	}
	public void Clickprofile(String s, String d)
	{
		Waitforfield(By.xpath(s), 2000).click();
	}
	
	public void Clicklogout(String s,String d)
	{
		Waitforfield(By.xpath(s), 2000).click();
	}






}

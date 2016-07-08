package TrelloLogin_jxl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trello_Login {
	
	
	public static WebDriver driver;
	
	public static  WebElement  Waitforfield(By locator,int seconds){
		
		return(new WebDriverWait(driver, seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public static void Openbrowser(String s, String d)
	{
	 //driver= new FirefoxDriver();	
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\suresh\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver= new ChromeDriver();
	 
	}
	
	public static void Navigate_to(String s,String d)
	{
		driver.get("https://trello.com/login");
		driver.manage().window().maximize();
	}
	
	public static void   Enterusername(String s,String d)
	{
	 Waitforfield(By.id(s), 2000).sendKeys(d);	
	}
	
	public  static void  Enterpassword(String s ,String d)
	{
		Waitforfield(By.id(s), 2000).sendKeys(d);
	}
	
	public static void Clicksignin(String s,String d )
	{
	Waitforfield(By.id(s), 2000).click();	
	}
	
	public static void Waitfor(String s,String d) throws InterruptedException
	{
		Thread.sleep(3000);
	}
	public static void Clickprofile(String s, String d)
	{
	Waitforfield(By.xpath(s), 2000).click();
	}
	
	public static void Clicklogout(String s, String d)
	{
		Waitforfield(By.xpath(s), 4000).click();
		
	}
	
	public static void CloseBrowser(String s,String d){
		driver.quit();
		
	}

}

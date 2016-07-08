package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mercury_tours {
	
	WebDriver driver;
	
//	public Mercury_tours(WebDriver driver){
//		this.driver=driver;
//	}
	
	public void Navigate_to_Mercury()
	{   
		//driver=new FirefoxDriver();
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\suresh\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("http://newtours.demoaut.com/");
		//driver.manage().window().maximize();
		String MercuryTours_homepage_Title=driver.getTitle();
		System.out.println("MercuryTours_homepage_Title :"+MercuryTours_homepage_Title);
	}
	
	
	public void login()
	{
		driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("mercury");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("mercury");
		driver.findElement(By.cssSelector("input[name='login']")).click();
	}
	
	public void Flightfinder()
	{
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		driver.findElement(By.xpath("//select[@name='passCount']/option[3]")).click();
		
	}

	public static void main(String[] args) throws InterruptedException {
		Mercury_tours mt=new Mercury_tours();
		mt.Navigate_to_Mercury();
		mt.login();
		Thread.sleep(5000);
		mt.Flightfinder();

	}

}

package MercuryTours.KeywrdDrivnMavn;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MercuryyLinksTest {
	
	WebDriver driver;
	ExcelReaderandWriter filereaderclass;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suresh\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.Driver", "C:\\Users\\suresh\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		//driver= new FirefoxDriver();
		driver= new ChromeDriver();
		filereaderclass= new ExcelReaderandWriter();
	}
	
	@After
	public void Cls(){
		driver.quit();
	}
	
	@Test
	public  void LinksTest(){
	List<List<String>>	data=filereaderclass.ReadFile("Kywrds.xls");
	
	List<String> results=new ArrayList<String>();
	
	results.add("Results");
	
	for(int i=1;i<data.size();i++){
		for(int j=0;j<data.get(i).size();j++){
			driver.get("http://www.thetestroom.com/webapp/");
			driver.findElement(By.id(data.get(i).get(j))).click();
			if(driver.getTitle().contains(data.get(i).get(++j))){
				System.out.println(data.get(i).get(j));
				results.add("pass");
			}else{
				System.out.println("fail");
			}
				j++;
		}
	}
	System.out.println("now printing from results :");
	for(int i=0;i<results.size();i++){
		System.out.println(results.get(i));
	}
	}
	

}

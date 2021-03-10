package CPSAT.PracticalMockExams;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ndtv {
	
	@Test()
	public void testing() throws InterruptedException {	
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Drivers\\chromedriver.exe");
	 ChromeDriver driver=new ChromeDriver();
	//open the Website
	 driver.get("https://www.ndtv.com/business"); 
	 Thread.sleep(6000);
	 driver.findElement(By.cssSelector("div[class='widcont_topstories']"));
	
	
	}

}

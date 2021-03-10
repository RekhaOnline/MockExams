package CPSAT.PracticalMockExams;

/*
 * Using TestNG and WebDriver script Please try to cover the following. This question
carries 15 marks. You are free to use any of the browsers (Chrome or Firefox)
a. Open the website https://www.rediff.com/ (1/2 mark)
b. Click on the menu for News (1/2 mark)
c. Take a screenshot (showing that the News is clicked) (1/2 mark)
d. Get the Href’s of all the submenu items (e.g headlines, defence etc) (2 marks)
e. Assert that the tool tip of the adjacent menu item Business is “Business
Headlines” (1.5 marks)
f. Hover the mouse on the adjacent menu item (Business) showing the tool tip
“Business Headlines”. Take a screenshot showing the tooltip (4 marks)
g. Assert that the background colour of the submenu items for News is having the
following RGB (188, 62, 49) value. ( 2 Marks)
h. Assert that the value of RGB in above step maps to the following colour name
(Grenadier) – Hint use the following website to get the colour name from RGB
values https://www.color-blindness.com/color-name-hue/ (4 Marks)
*/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Rediff {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='NEWS']")).click();
		WebElement submenu = driver.findElement(By.xpath("//div[@class='subnavbar news']"));
		
		
		//Get the Href’s of all the submenu items (e.g headlines, defence etc)
		for(int i=0;i<submenu.findElements(By.tagName("a")).size();i++)

		{
		
			System.out.println(submenu.findElements(By.tagName("a")).get(i).getText());
		}
		// Hover the mouse on the adjacent menu item (Business) showing the tool tip
		//“Business Headlines”. Take a screenshot showing the tooltip (4 marks)
		Actions a = new Actions(driver);
		//moves to specific element
		 a.moveToElement(driver.findElement(By.cssSelector("a[title='Business headlines']"))).build().perform();
		 Thread.sleep(5000);
		// WebDriverWait wait = new WebDriverWait(driver, 5); 
		 //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Business headlines']")));  
		 System.out.println(driver.findElement(By.cssSelector("a[title='Business headlines']")).getAttribute("title"));
		 String tooltip = driver.findElement(By.cssSelector("a[title='Business headlines']")).getAttribute("title");
		 String Expectedtooltip = "Business headlines";
		 
		 Assert.assertEquals(tooltip, Expectedtooltip);
		 
		 System.out.println("Actual Title of Tool Tip"+tooltip);							
	        if(tooltip.equals(Expectedtooltip)) {							
	            System.out.println("Test Case Passed");				
	        }		
		 
		 
		 
		 

	}
}



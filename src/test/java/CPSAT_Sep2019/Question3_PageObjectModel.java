package CPSAT_Sep2019;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question3_PageObjectModel {

	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// Constructor
		// Accessing Rediff login Page in Page Object Pattern style

		String parentWindow = driver.getWindowHandle();
		driver.switchTo().frame("moneyiframe");

		RediffHomePage_PageFactory rh = new RediffHomePage_PageFactory(driver);
		System.out.println(rh.bse.getText());
		System.out.println(rh.nse.getText());
		rh.searchtext.sendKeys("“Reliance Industries");
		rh.searchbutton.click();
		String Expected = "RELIANCE";

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String actualTitle = driver.getTitle();
			// System.out.println(driver.getTitle());
			if (actualTitle.contains(Expected)) {
				System.out.println(driver.getTitle());
				Assert.assertTrue(true);
			}

		}

		driver.switchTo().window(parentWindow);
		// System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Rediff")) {

			System.out.println(driver.getTitle());
			Assert.assertTrue(true);

		}

	}

}

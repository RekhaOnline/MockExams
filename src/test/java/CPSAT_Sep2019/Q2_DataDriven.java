package CPSAT_Sep2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Q2_DataDriven {
	
	WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	 
    @BeforeTest
	public void initialization(){
	    // To set the path of the Chrome driver.
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/news");	  
	    // To maximize the browser
	    driver.manage().window().maximize();
	    // implicit wait
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


		@Test
		public void submenu() throws IOException
		{
			driver.findElement(By.xpath("//div[@class='subnavbar news']//li[1]")).click();
			String Actualurl=driver.findElement(By.xpath("//div[@class='subnavbar news']//li[1]")).getAttribute("href");
			System.out.println(Actualurl);
		}
		
		
		
		
		
		
	}


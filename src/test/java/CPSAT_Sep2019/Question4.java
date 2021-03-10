package CPSAT_Sep2019;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Using JUnit and WebDriver do the following. You are free to use any of the browsers
(Chrome or Firefox) (7 marks)
a. Open the website https://www.rediff.com/ (0 mark)
b. Find out href of all the TopStories on the Rediff.com page using findElements (3
marks)
c. Store all the href’s in either a Text file, or an Excel file (You have to submit the
file created) (3 marks)
 */
public class Question4 {

	WebDriver driver;

	@BeforeTest

	public void firststep() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "data")
	public void DataDrivenTest1(String Menu, String SubMenu, String Href) {

		System.out.println(Menu + " " + SubMenu + " " + Href);

		/*
		 * 
		 * driver.findElement(By.xpath("//*[@id='frm-emi']/p[1]/input")).sendKeys(
		 * LoanAmount);
		 * driver.findElement(By.xpath("//*[@id='frm-emi']/p[2]/input")).sendKeys(
		 * InterestRate);
		 * driver.findElement(By.xpath("//*[@id='frm-emi']/div/div/input")).sendKeys(
		 * Tenure);
		 * driver.findElement(By.xpath("//*[@id='frm-emi']/p[3]/input")).click();
		 */

		driver.close();

	}

	@DataProvider(name = "data")
	public Object[][] testDataSupplier() throws Exception {
		// file path where excel file placed, containing test data.
		String filePath = "C:\\Users\\rekha\\OneDrive\\Desktop\\CP- SAT\\Screenshot\\Rediffdata.xlsx";

		// read excel file using file input stream, using Apache POI
		FileInputStream fis = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		// calculate total number of rows and columns so that we can iterate over it.
		int totalNumberOfRows = sheet.getLastRowNum()+1 ;
		int totalNumberOfCols = sheet.getRow(0).getLastCellNum();

		// create an object array. which will store the test data from excel file
		Object[][] testdata1 = new Object[totalNumberOfRows][totalNumberOfCols];

		for (int i = 1; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfCols; j++) {

				testdata1[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return testdata1;
	}

}

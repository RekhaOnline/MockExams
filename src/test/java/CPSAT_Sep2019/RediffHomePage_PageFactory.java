package CPSAT_Sep2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage_PageFactory {
	

	WebDriver driver;
	public  RediffHomePage_PageFactory(WebDriver driver)
	{
		this.driver=driver; // this keyword means local driver object
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[@id='bseindex']")
	WebElement bse;
	
	@FindBy(xpath="//span[@id='nseindex']")
	WebElement nse;
	
	@FindBy(xpath="//input[@id='query']")
	WebElement searchtext;
	
	@FindBy(className="getqbtn")
	WebElement searchbutton;
	
	public WebElement BSE()
	{
		return bse;
	}
	
	public WebElement NSE()
	{
		return bse;
	}
	
	public WebElement SearchText()
	{
		return searchtext;
	}
	
	public WebElement Searchbutton()
	{
		return searchbutton;
	}
	

}

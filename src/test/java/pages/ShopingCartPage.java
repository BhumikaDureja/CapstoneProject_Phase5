package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import user.UserBaseClass;

public class ShopingCartPage {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	
	@FindBy(xpath="//a[@href='/medicare/cart/validate']")
	WebElement checkOut;
	
	
	
	public ShopingCartPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	
	public void ClickCheckOutBtn() throws Throwable {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkOut);
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Click Checkout", "User is checked out");
	}
	

}

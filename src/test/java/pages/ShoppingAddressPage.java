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

public class ShoppingAddressPage {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	
	@FindBy(xpath="//a[text()='Select']")
	WebElement SelectBtn;
	
	
	
	public ShoppingAddressPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	
	public void ClickSelectBtn() throws Throwable {
		
		SelectBtn.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Click Select button", "Select button is clicked successfully");
			
	}
	

}

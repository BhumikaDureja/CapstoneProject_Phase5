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

public class PaymentPage {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	
	@FindBy(xpath="//a[text()='Pay']")
	WebElement Pay;
	
	
	
	public PaymentPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	
	public void ClickPayBtn() throws Throwable {
		
		Pay.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Pay Button", "Pay Button clicked successfully");
			
	}
	

}

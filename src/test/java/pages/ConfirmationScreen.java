package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import user.UserBaseClass;

public class ConfirmationScreen {
	
	WebDriver driver = UserBaseClass.driver;
	
	
	//-------------------------- WebElements -------------------------------
	
	@FindBy(xpath="//h3[text()='Your Order is Confirmed!!']")
	WebElement ConfirmationMsg;
	
	
	
	public ConfirmationScreen() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	
	public String returnConfirmationMsg() throws Throwable {
		
		String ConfirmMsg = ConfirmationMsg.getText();
		return ConfirmMsg;
		
			
	}
	

}

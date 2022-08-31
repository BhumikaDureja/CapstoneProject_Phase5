package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import user.UserBaseClass;

public class LoginPageClass {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	
	@FindBy(id="login")
	WebElement LoginBtn;
	
	//WebElement LoginBtn = driver.findElement(By.id("login"));
			//driver.findElement(By.id("login"));
			//driver.findElement(By.xpath("//ul/li[2]/a[text()='Login']"));
			//driver.findElement(By.xpath("//a[text()='Login']"));

	@FindBy(id = "username")
	WebElement Username;
	
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit;
	
//	WebElement Submit = driver.findElement(By);
			//By.cssSelector("input[type=’submit’]"));
		//"//input[@class='btn btn-primary']
	
	
	public LoginPageClass() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	
	public void UserLogin(String UserNameVal, String PasswordVal) throws Throwable {
		
		System.out.println("RESULT ------- " +LoginBtn.isDisplayed());
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click Login Button", "Login Button clicked successfully");
		
		Username.sendKeys(UserNameVal);
		test.log(LogStatus.PASS,"Enter username", "Username entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS,"Enter password", "Password entered successfully");
		
		Submit.click();
		test.log(LogStatus.PASS,"Click submit/login button ", "User logged in successfully");
		Thread.sleep(2000);
	}
	

}

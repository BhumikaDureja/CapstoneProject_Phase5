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

public class HomePageClass {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	

	@FindBy(id = "a_Antipyretics")
	WebElement AntipyreticsCategory ;
	
	@FindBy(id = "a_Analgesics")
	WebElement AnalgesicsCategory ;
	
	@FindBy(id = "a_Antibiotics")
	WebElement AntibioticsCategory ;
	
	@FindBy(xpath="//a[text()='Manage Product']")
	WebElement MangPrdIcon;
	

	@FindBy(xpath="//a[text()='View Products']")
	WebElement ViewPrdIcon;

	
	@FindBy(xpath="//a[@href='/medicare/manage/1/product']")
	WebElement EditProdIcon;
	
	public HomePageClass() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	

	
	public void SelectCategory(String CategoryName) {
		
		if(CategoryName.equalsIgnoreCase("Antipyretics")) {
		AntipyreticsCategory.click();
		}
		
		else if (CategoryName.equalsIgnoreCase("Analgesics")) {
			AnalgesicsCategory.click();
		}
		
		else if(CategoryName.equalsIgnoreCase("Antibiotics")) {
			AntibioticsCategory.click();
		}
		
		else {
			System.out.println("No such category");
		}
	}
	
	public void clickMangPrdIcon () {
		MangPrdIcon.click();
		test.log(LogStatus.PASS, "Click Manage Product tab", "Manage product tab clicked successfully");
	}

	
	public void ViewPrdIcon () {
		ViewPrdIcon.click();
		test.log(LogStatus.PASS, "Click View Product tab", "View product tab clicked successfully");
	}
	
	
	public void ClickEditProductIcon() throws Throwable {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", EditProdIcon);
		Thread.sleep(2000);
		
		test.log(LogStatus.PASS, "Click Edit Product icon", "Edit product icon clicked successfully");
	}
}

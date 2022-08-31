package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import user.UserBaseClass;

public class AddProductPage {
	
	WebDriver driver = UserBaseClass.driver;
	ExtentTest test = UserBaseClass.test;
	
	//-------------------------- WebElements -------------------------------
	

	@FindBy(id = "name")
	WebElement PrdctName ;
	
	@FindBy(id = "brand")
	WebElement BrandName ;
	
	@FindBy(id = "description")
	WebElement desc ;
	
	@FindBy(id="unitPrice")
	WebElement unitPrice;
	
	@FindBy(id="quantity")
	WebElement qty;
	
	@FindBy(id="file")
	WebElement FilePath;
	
	@FindBy(xpath="//buton[@type='button']")
	WebElement AddNewCategory;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//*[@class='alert alert-info fade in']")
	WebElement SuccProdSubmitMsg;
	

	
	public AddProductPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//------------------- Functions --------------------------
	

	
	public void EnterProductName (String Pname) {
		PrdctName.sendKeys(Pname);	
		test.log(LogStatus.PASS, "Enter Product Name", "Product Name entered successfully");
	}

	public void EnterBrandName (String Bname) {
		BrandName.sendKeys(Bname);	
		test.log(LogStatus.PASS, "Enter Brand Name", "Brand Name entered successfully");
	}

	public void EnterDescription (String description) {
		desc.sendKeys(description);	
		test.log(LogStatus.PASS, "Enter Product description", "Product description entered successfully");
	}
	
	public void EnterUnitPrice (String up) {
		unitPrice.clear();
		unitPrice.sendKeys(up);	
		test.log(LogStatus.PASS, "Enter Unit Price", "Unit price entered successfully");
	}
	
	public void EnterQuantity (String qnty) {
		qty.clear();
		qty.sendKeys(qnty);	
		test.log(LogStatus.PASS, "Enter Quantity Name", "Product Name entered successfully");
	}
	
	public void giveFilePath() {
		
		FilePath.sendKeys("C:\\Users\\bhumika.dureja\\Desktop\\TestPic.png");
		test.log(LogStatus.PASS, "Five Filepath", "Filepath entered successfully");
	}
	
	public void clickSave() throws Throwable {
		SaveBtn.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Click Save button", "Save button clicked successfully");
	}
	
	public String returnSUccessMsgText() {
		String ActualMsg = SuccProdSubmitMsg.getText();
		return ActualMsg;
	}
}

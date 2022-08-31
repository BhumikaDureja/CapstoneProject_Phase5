package admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductPage;
import pages.HomePageClass;
import pages.LoginPageClass;
import user.UserBaseClass;

public class adminTestCases extends UserBaseClass {
	
	@Test
	public void addProduct() throws Throwable {
		LoginPageClass login = new LoginPageClass();
		HomePageClass home = new HomePageClass();
		AddProductPage ppage = new AddProductPage();
		
		login.UserLogin("vk@gmail.com", "admin");
		home.clickMangPrdIcon();
		ppage.EnterProductName("MedTest1");
		ppage.EnterBrandName("Cipla");
		ppage.EnterDescription("Antobiotic for Cold");
		ppage.EnterUnitPrice("10");
		ppage.EnterQuantity("1");
		ppage.giveFilePath();
		ppage.clickSave();
		
		Assert.assertEquals(ppage.returnSUccessMsgText(), "Product submitted successfully!");
	}

	
	@Test
	public void editProduct() throws Throwable {
		
		LoginPageClass login = new LoginPageClass();
		HomePageClass home = new HomePageClass();
		AddProductPage ppage = new AddProductPage();
		
		login.UserLogin("vk@gmail.com", "admin");
		home.ViewPrdIcon();
		home.ClickEditProductIcon();
		ppage.EnterUnitPrice("20");
		ppage.clickSave();
		
		Assert.assertEquals(ppage.returnSUccessMsgText(), "Product submitted successfully!");
	}
	
}

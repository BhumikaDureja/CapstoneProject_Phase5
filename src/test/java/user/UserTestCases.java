package user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ConfirmationScreen;
import pages.HomePageClass;
import pages.LoginPageClass;
import pages.PaymentPage;
import pages.ShopingCartPage;
import pages.ShoppingAddressPage;

public class UserTestCases extends UserBaseClass {
	
	
	@Test(priority=1)
	public void ListCategories () throws Throwable {
		Thread.sleep(5000);
		
		System.out.println("User is going to login");
//		WebElement LoginBtn = driver.findElement(By.id("login"));
				//xpath("//a[@href='/medicare/login']"));
	//	LoginBtn.click();
		
		LoginPageClass login = new LoginPageClass();
       login.UserLogin("kn@gmail.com", "12345");
       
       HomePageClass home = new HomePageClass();
 
		Thread.sleep(5000);
		
		//Listing the Categories
		
		List<WebElement> categories =driver.findElements(By.className("list-group"));
		
		System.out.println("Total categories are "+categories.size());
		
		for(WebElement elm : categories) {
			System.out.println(elm.getText());
		//	System.out.println(elm.getAttribute("href"));
		}
		
		System.out.println("Test 1 ended");

	}
	
	@Test
	public void ViewCategory() throws Throwable {
		
		LoginPageClass login = new LoginPageClass();
		HomePageClass home = new HomePageClass();
		login.UserLogin("kn@gmail.com", "12345");
		Thread.sleep(2000);
		home.SelectCategory("Antipyretics");
		Thread.sleep(2000);
		Assert.assertEquals("Medicare - Antipyretics", driver.getTitle());
		
		WebElement viewIcon = driver.findElement(By.xpath("//a[@href='/medicare/show/1/product']"));
		viewIcon.click();
		String MedName = driver.findElement(By.xpath("//h3")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(MedName, "Paracetamol");
	}

	
@Test
	public void AddCategoryToCart() throws Throwable {
		
		LoginPageClass login = new LoginPageClass();
		HomePageClass home = new HomePageClass();
		
		login.UserLogin("kn@gmail.com", "12345");
		Thread.sleep(2000);
		home.SelectCategory("Antibiotics");
		Thread.sleep(2000);
		Assert.assertEquals("Medicare - Antibiotics", driver.getTitle());
	
		WebElement addToCartIcon = driver.findElement(By.xpath("//a[@href='/medicare/cart/add/5/product']"));
	//	System.out.println("addToCartIcon is clickable " +addToCartIcon.isEnabled());
		addToCartIcon.click();
		Thread.sleep(2000);
	
    }


@Test
public void E2ETestUser() throws Throwable {
	LoginPageClass login = new LoginPageClass();
	HomePageClass home = new HomePageClass();
	ShopingCartPage cart = new ShopingCartPage();
	ShoppingAddressPage address = new ShoppingAddressPage();
	PaymentPage paym = new PaymentPage();
	ConfirmationScreen confirm = new ConfirmationScreen();
	
	login.UserLogin("kn@gmail.com", "12345");
	Thread.sleep(2000);
	home.SelectCategory("Antibiotics");
	Thread.sleep(2000);
	WebElement addToCartIcon = driver.findElement(By.xpath("//a[@href='/medicare/cart/add/5/product']"));
		addToCartIcon.click();
		Thread.sleep(2000);
		cart.ClickCheckOutBtn();
		address.ClickSelectBtn();
		paym.ClickPayBtn();
		Assert.assertEquals("Your Order is Confirmed!!", confirm.returnConfirmationMsg());
}
}
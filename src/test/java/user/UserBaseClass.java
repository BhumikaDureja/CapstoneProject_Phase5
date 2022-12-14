package user;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class UserBaseClass {
	
	public static WebDriver driver;

	  // objects of Extent report
    public static ExtentReports report;
    public static ExtentTest test;
    
    
    @BeforeTest
    public void DataSetUP() throws IOException {
    	report = new ExtentReports("ExtentReport.html");
    }
    
    @AfterTest
    public void DataTearDown() throws IOException {

		report.flush();
		report.close();
    }
    
	
	@BeforeMethod
	public void SetUp(Method method) {
		
	
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8082/medicare/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			
	}
	
	
	@AfterMethod
	public void TearDown() {
		
		report.endTest(test);
		driver.quit();
		
	}
}

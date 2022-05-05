package Generic;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Base_test extends KhataBook_UAT{
	
	public static WebDriver driver;
	public WebDriverWait wait;
	

	@BeforeClass
	public void openBrowser()
	{
	
		POST_Create();
		GET_Eligibility();
		POST_generateLink();
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(UtilityMethods.acceptAlert());
	    driver.get(URL);
	//	driver.get("https://lendingwebuat.finbox.in/session/e586cd4d-554d-4f82-ba6b-731c14b19c6e");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
	
	}

	
/*	@AfterClass
	public void close()
	{
		driver.close();
	}
	*/

}



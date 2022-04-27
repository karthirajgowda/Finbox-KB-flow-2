package Generic;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Base_test extends KhataBook_UAT{
	
	public static WebDriver driver;
	

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
	}

	
/*	@AfterClass
	public void close()
	{
		driver.close();
	}
	*/

}



package Generic;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KYC extends Base_test{
	
	@Test
	public static void skipKYC() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://platformuat.finbox.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your user email ID\"]")).sendKeys("shiva@khatabook.com");//USERNAME
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys("9TUYX5Gtxipa");//PASSWORD
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"sc-jrQzUz sc-bLdsei glxjHL rulci\"]")).click();//LOGIN
		Thread.sleep(1000);
		String Xpath1="//div[text()=\"";
		String Xpath2="\"]/../..//td[2]";
		String Xpath=Xpath1+CustomerID+Xpath2;
		System.out.println(Xpath);
		driver.findElement(By.xpath("//span[text()=\"Applications\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Xpath)).click();//CLICK ON CUSTOMER ID
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),\"Approve KYC\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"Approve\"]")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}

}


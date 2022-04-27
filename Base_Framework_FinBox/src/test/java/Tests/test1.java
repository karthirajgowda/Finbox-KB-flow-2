package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class test1 {
	
	public void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	 //   driver.get(URL);
		driver.get("https://lendingwebuat.finbox.in/session/20248353-a60f-4caa-9de4-05df1f9cec69");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your PAN number\"]")).sendKeys("DUOPK4809");
		driver.findElement(By.xpath("//input[@placeholder=\"DD\"]")).sendKeys("09");
		driver.findElement(By.xpath("//input[@placeholder=\"MM\"]")).sendKeys("08");
		driver.findElement(By.xpath("//input[@placeholder=\"YYYY\"]")).sendKeys("199");
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Pincode (as per KYC records)\"]")).sendKeys("573201");
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		//WebDriverWait wait =new WebDriverWait()
	}

}

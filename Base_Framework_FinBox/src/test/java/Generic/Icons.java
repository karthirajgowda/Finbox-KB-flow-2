package Generic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Icons extends Base_test {
	
	
	public static void isFAQiconDisplayed()
	{
		if(driver.findElements(By.xpath("((//*[local-name()='svg'])[2])/*[local-name()='rect']")).size()==0)
		{
			System.out.println("FAQ icon is not displayed");
		}
		else
		{
			System.out.println("FAQ icon is displayed");
		}
	}
	
	public static void isCloseIconDisplayed()
	{
		if(driver.findElements(By.xpath("((//*[local-name()='svg'])[4])/*[local-name()='rect']")).size()==0)
		{
			System.out.println("Close icon is not displayed");
		}
		else
		{
			System.out.println("Close icon is displayed");
		}
	}
	
	
	public static void isProfileIconDisplayed()
	{
		if(driver.findElements(By.xpath("((//*[local-name()='svg'])[3])/*[local-name()='rect']")).size()==0)
		{
			System.out.println("Profile icon is not displayed");
		}
		else
		{
			System.out.println("Profile icon is displayed");
		}
	}
	

	public static void isBackIconDisplayed()
	{
		if(driver.findElements(By.xpath("((//*[local-name()='svg'])[1])/*[local-name()='rect']")).size()==0)
		{
			System.out.println("Back icon is not displayed");
		}
		else
		{
			System.out.println("Back icon is displayed");
		}
	}
	
	
}

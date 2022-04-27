package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Phone_Number_Verification_2 extends UtilityMethods{
	
	public Phone_Number_Verification_2(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//button[contains(text(),'Send OTP')]")
	WebElement SendOTP;
	public void clickOnSendOTP()
	{
	 clickAction(SendOTP);
	 System.out.println("Clicked on Send OTP");
	}

}

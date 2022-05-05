package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Phone_Number_Verification_2 extends UtilityMethods{
	
	//CONSTRUCTOR
	public Phone_Number_Verification_2(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//FINBOX LOGO
	@FindBy(xpath = "//img[@src=\"/static/media/finBoxDark.88f38f8f.svg\"]")
	List<WebElement> FinboxLogo;
	public void isFinboxlogoDisplayed()
	{
		isDisplayed(FinboxLogo, "FinBox Logo ");
	}
	
	//FETCHED PHONE NUMBER
	@FindBy(xpath="//b")
	WebElement PhoneNumber;
	public String fetchedPhoneNumber(WebDriverWait wait)
	{
		waitUntillVisibility(wait, PhoneNumber);
		String FetchedPhoneNumber = PhoneNumber.getText();
		System.out.println("Phone number fetched from existing profile data > "+FetchedPhoneNumber);
		return FetchedPhoneNumber;
	}
    
	//SEND OTP BUTTON
	@FindBy(xpath="//button[contains(text(),'Send OTP')]")
	WebElement SendOTP;
	public void clickOnSendOTP()
	{
	 clickAction(SendOTP);
	 System.out.println("Clicked on Send OTP");
	}

}

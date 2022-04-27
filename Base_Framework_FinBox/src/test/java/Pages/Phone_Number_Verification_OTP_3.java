package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Phone_Number_Verification_OTP_3 extends UtilityMethods {
	
	      //CONSTRUCTOR 
	public Phone_Number_Verification_OTP_3(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	      //OTP TEXT FIELD
	@FindBy(xpath="//input[@placeholder='000000']")
	WebElement otpTextField;
	
	public void enterOTP(String otp)
	{
		clearAndEnterValue(otpTextField, otp);
	}
	
	
	     //RESEND
	@FindBy(xpath="//div[text()=\"Resend\"]")
	WebElement resend;
	
	public void clickOnResend()
	{
		clickAction(resend);
	}
	
	
          //VERIFY NUMBER	
	@FindBy(xpath="//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement verifyButton;
	
	public void clickOnVerifyNumberButton()
	{
		clickAction(verifyButton);
	}
	
	
	//TOAST MESSAGE
	@FindBy(id = "__react-alert__")
	WebElement otptoast;
	
	public void isOtpToastDisplayed()
	{
		boolean toastmsg = otptoast.isDisplayed();
		if(toastmsg==true)
		{
			String msg=otptoast.getText();
			System.out.println("Toast Message > "+msg);
		}
		else
		{
			System.out.println("Toast Message  > Not Displayed");
		}
	}

}

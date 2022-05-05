package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Phone_Number_Verification_OTP_3 extends UtilityMethods {
	
	      //CONSTRUCTOR 
	public Phone_Number_Verification_OTP_3(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//FINBOX LOGO
		@FindBy(xpath = "//img[@src=\"/static/media/finBoxDark.88f38f8f.svg\"]")
		List<WebElement> FinboxLogo;
		public void isFinboxlogoDisplayed()
		{
			isDisplayed(FinboxLogo, "FinBox Logo  ");
		}
	
	//OTP SENT PHONE NUMBER
	@FindBy(xpath = "//div[@class=\"sc-crHmcD kSyJqQ\"]")
	WebElement OTPsentPhoneNUmber;
	public void isFetchedAndOtpSentNumberSame(WebDriverWait wait,String FetchedPhoneNumber)
	{
		waitUntillVisibility(wait, OTPsentPhoneNUmber);
		System.out.println("Fetched phone number > "+ FetchedPhoneNumber +"  - - - - " +"OTP Sent Phone Number > " +OTPsentPhoneNUmber.getText() );
	}
	
	//OTP TEXT FIELD
	@FindBy(xpath="//input[@placeholder=\"000000\"]")
	WebElement otpTextField;
	public void enterOTP(WebDriverWait wait,String otp)
	{
		waitUntillElementToBeClickable(wait, otpTextField);
		clearAndEnterValue(otpTextField, otp);
	}
	

	
	     //RESEND
	@FindBy(xpath="//div[text()=\"Resend\"]")
	WebElement Resend;
	
	public void clickOnResend(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, Resend);
		clickAction(Resend);
	}
	
	
          //VERIFY NUMBER	
	@FindBy(xpath="//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement verifyButton;
	
	public void clickOnVerifyNumberButton()
	{
		clickAction(verifyButton);
	}
	
	@FindBy(id = "__react-alert__")
	WebElement OTPToast;
	
	
	//TOAST MESSAGE
	@FindBy(id = "__react-alert__")
	List<WebElement> OTPtoast;
	public void isOtpToastDisplayed(WebDriverWait wait)
	{
		waitUntillVisibility(wait, OTPToast);
		isDisplayed(OTPtoast, OTPToast.getText()+" [Tost Message]  ");
	}
	
	

}

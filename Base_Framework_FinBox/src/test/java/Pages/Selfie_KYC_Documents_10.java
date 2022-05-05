package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Selfie_KYC_Documents_10 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Selfie_KYC_Documents_10(WebDriver driver)
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
	
	//UPLOAD YOUR SELFIE
	@FindBy(xpath="//div[contains(text(),\"Upload your Selfie\")]")
	WebElement UploadYourSelfie;
	public void clickOnUploadYourSelfie( )
	{
		clickAction(UploadYourSelfie);
		System.out.println("Clicked on > UPLOAD YOUR SELFIE");
	}
	
	//wait till page loads
		public void waitTillPageGetLoad(WebDriverWait wait)
		{
			waitUntillElementToBeClickable(wait, UploadYourSelfie);
		}
	
		
		//TAKE PHOTO
	@FindBy(xpath = "//button[contains(text(),\"Take Photo\")]")
	WebElement TakePhoto;
	public void clickOnTakePhoto(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, TakePhoto);
		clickAction(TakePhoto);
		System.out.println("Clicked on > TAKE PHOTO");
	}
	
	//CAPTURE SELFIE
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureSelfie;
	public void captureSelfie(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, CaptureSelfie);
		clickAction(CaptureSelfie);
		System.out.println("Clicked on > CAPTURE SELFIE");
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeSelfie;
	public void clickOnSelfieRetakeButton(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, RetakeSelfie);
		clickAction(RetakeSelfie);
		System.out.println("Clicked on > RETAKE SELFIE");
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitSelfie;
	public void clickOnSelfieSubmitButton(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, SubmitSelfie);
		clickAction(SubmitSelfie);
		System.out.println("Clicked on >  SUBMIT SELFIE");
	}
	
	//****************************
	
	
}

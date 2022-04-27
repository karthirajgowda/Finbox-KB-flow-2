package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Selfie_KYC_Documents_10 extends UtilityMethods {
	
	public Selfie_KYC_Documents_10(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),\"Upload your Selfie\")]")
	WebElement UploadYourSelfie;
	public void clickOnUploadYourSelfie()
	{
		clickAction(UploadYourSelfie);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Take Photo\")]")
	WebElement TakePhoto;
	public void clickOnTakePhoto()
	{
		clickAction(TakePhoto);
	}
	
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureSelfie;
	public void captureSelfie()
	{
		clickAction(CaptureSelfie);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeSelfie;
	public void clickOnSelfieRetakeButton()
	{
		clickAction(RetakeSelfie);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitSelfie;
	public void clickOnSelfieSubmitButton()
	{
		clickAction(SubmitSelfie);
	}
	
	//****************************
	
	
}

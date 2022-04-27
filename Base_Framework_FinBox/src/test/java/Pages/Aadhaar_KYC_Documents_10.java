package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Aadhaar_KYC_Documents_10 extends UtilityMethods {
	
	public Aadhaar_KYC_Documents_10(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),\"Upload your Address Proof\")]")
	WebElement UploadYourAddressProof;
	public void clickOnUploadYourAddressProof()
	{
		clickAction(UploadYourAddressProof);
	}
	
	@FindBy(xpath = "//div[contains(text(),\"AADHAAR\")]")
	WebElement Aadhaar;
	public void clickOnAadhaar() {
		clickAction(Aadhaar);
	}
	
	@FindBy(xpath = "//div[contains(text(),\"Front\")]")
	WebElement Front;
	public void clickOnFront() {
		clickAction(Front);
	}
	
	
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureAadhaarFront;
	public void captureAadhaarFront()
	{
		clickAction(CaptureAadhaarFront);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeAadhaareFront;
	public void clickOnAadhaarRetakeButtonFront()
	{
		clickAction(RetakeAadhaareFront);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaarFront;
	public void clickOnAadhaarSubmitButtonFront()
	{
		clickAction(SubmitAadhaarFront);
	}
	
	//---
	
	@FindBy(xpath = "//div[contains(text(),\"Back\")]")
	WebElement Back;
	public void clickOnBack() {
		clickAction(Back);
	}
	
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureAadhaarBack;
	public void captureAadhaarBack()
	{
		clickAction(CaptureAadhaarFront);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeAadhaareBack;
	public void clickOnAadhaarRetakeButtonBack()
	{
		clickAction(RetakeAadhaareBack);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaarBack;
	public void clickOnAadhaarSubmitButtonBack()
	{
		clickAction(SubmitAadhaarBack);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaar;
	public void clickOnAadhaarSubmitButton()
	{
		clickAction(SubmitAadhaar);
	}


}

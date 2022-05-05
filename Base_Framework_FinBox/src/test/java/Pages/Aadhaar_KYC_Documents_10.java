package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Aadhaar_KYC_Documents_10 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Aadhaar_KYC_Documents_10(WebDriver driver)
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
	
    //UPLOAD YOUR ADDRESS PROOF
	@FindBy(xpath="//div[contains(text(),\"Upload your Address Proof\")]")
	WebElement UploadYourAddressProof;
	public void clickOnUploadYourAddressProof(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, UploadYourAddressProof);
		clickAction(UploadYourAddressProof);
		System.out.println("Clicked on > UPLOAD YOUR ADDRESS PROOF");
	}
	

	//wait till page loads
		public void waitTillPageGetLoad(WebDriverWait wait)
		{
			waitUntillElementToBeClickable(wait, UploadYourAddressProof);
		}
	
	//AADHAAR
	@FindBy(xpath = "//div[contains(text(),\"AADHAAR\")]")
	WebElement Aadhaar;
	public void clickOnAadhaar(WebDriverWait wait) {
		waitUntillElementToBeClickable(wait, Aadhaar);
		clickAction(Aadhaar);
		System.out.println("Clicked on > AADHAAR ");
	}
	
	//FRONT
	@FindBy(xpath = "//div[contains(text(),\"Front\")]")
	WebElement Front;
	public void clickOnFront(WebDriverWait wait) {
		waitUntillElementToBeClickable(wait, Front);
		clickAction(Front);
		System.out.println("Clicked on > FRONT");
	}
	
	//CAPTURE AADHAAR FRONT
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureAadhaarFront;
	public void captureAadhaarFront(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, CaptureAadhaarFront);
		clickAction(CaptureAadhaarFront);
		System.out.println("Clicked on > CAPTURE AADHAAR FRONT");
	}
	
	//RETAKE AADHAAR FRONT
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeAadhaareFront;
	public void clickOnAadhaarRetakeButtonFront(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, RetakeAadhaareFront);
		clickAction(RetakeAadhaareFront);
		System.out.println("Clicked on > RETAKE AADHAAR FRONT");
	}
	
	//SUBMIT AADHAAR FRONT
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaarFront;
	public void clickOnAadhaarSubmitButtonFront(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, SubmitAadhaarFront);
		clickAction(SubmitAadhaarFront);
		System.out.println("Clicked on >SUBMIT AADHAAR FRONT ");
	}
	
	//BACK
	@FindBy(xpath = "//div[contains(text(),\"Back\")]")
	WebElement Back;
	public void clickOnBack(WebDriverWait wait) {
		waitUntillElementToBeClickable(wait, Back);
		clickAction(Back);
		System.out.println("Clicked on > BACK");
	}
	
	//CAPTURE AADHAAR BACK
	@FindBy(xpath = "//button[@class=\"sc-bdvvtL brAXwi\"]")
	WebElement CaptureAadhaarBack;
	public void captureAadhaarBack(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, CaptureAadhaarBack);
		clickAction(CaptureAadhaarFront);
		System.out.println("Clicked on > CAPTURE AADHAAR BACK ");
	}
	
	//RETAKE AADHAAR BACK
	@FindBy(xpath = "//button[contains(text(),\"Retake\")]")
	WebElement RetakeAadhaareBack;
	public void clickOnAadhaarRetakeButtonBack(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, RetakeAadhaareBack);
		clickAction(RetakeAadhaareBack);
		System.out.println("Clicked on > RETAKE AADHAAR BACK");
	}
	
	//SUBMIOT AADHAAR BACK
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaarBack;
	public void clickOnAadhaarSubmitButtonBack(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, SubmitAadhaarBack);
		clickAction(SubmitAadhaarBack);
		System.out.println("Clicked on > SUBMIOT AADHAAR BACK");
	}
	
	//SUBMIT AADHAAR
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitAadhaar;
	public void clickOnAadhaarSubmitButton(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, SubmitAadhaar);
		clickAction(SubmitAadhaar);
		System.out.println("Clicked on > SUBMIT AADHAAR");
	}


}

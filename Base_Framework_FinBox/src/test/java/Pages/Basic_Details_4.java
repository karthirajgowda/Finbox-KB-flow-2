package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Basic_Details_4 extends UtilityMethods{
	
	
	//CONSTRUCTOR 
	public Basic_Details_4(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//GENDER MALE 
	@FindBy(xpath="(//input[@type=\"radio\"])[2]")
	WebElement GenderM;
	public void clickOnGenderMandVerify() throws InterruptedException
	{
		clickAction(GenderM);
		Thread.sleep(1000);
		isSelected(GenderM,"Male");	
	}
	
	//GENDER FEMALE
	@FindBy(xpath="(//input[@type=\"radio\"])[1]")
	WebElement GenderF;
	public void clickOnGenderFandVerify() throws InterruptedException
	{
		clickAction(GenderF);
		Thread.sleep(1000);
		isSelected(GenderF,"Female");
	}
	
	//GENDER OTHERS
	@FindBy(xpath="(//input[@type=\"radio\"])[3]")
	WebElement GenderO;
	public void clickOnGenderOandVerify() throws InterruptedException
	{
		clickAction(GenderO);
		Thread.sleep(1000);
		isSelected(GenderO,"Others");
	}
	
	//NEXT BUTTON
	@FindBy(xpath="//button[text()=\"Next\"]")
	WebElement nextButton;
	public void verifyAndClickOnNextButton()
	{
		verifyAndClick(nextButton, "Verifing Next button is enabled or not after clicking on Radio button");	
	}
	
	//PAN 
	@FindBy(xpath = "//input[@placeholder=\"Enter your PAN number\"]")
	WebElement yourPANNumber;
	public void enterYourPANNumber(String pan)
	{
		clearAndEnterValue(yourPANNumber,pan);
	}
	
	//DD
	@FindBy(xpath = "//input[@placeholder=\"DD\"]")
	WebElement DD;
	public void enterYourDateOfBirthDD(String DATE)
	{
		clearAndEnterValue(DD,DATE);
	}
	
	//MM
	@FindBy(xpath = "//input[@placeholder=\"MM\"]")
	WebElement MM;
	public void enterYourDateOfBirthMM(String MONTH)
	{
		clearAndEnterValue(MM,MONTH);
	}
	
	//YYYY
		@FindBy(xpath = "//input[@placeholder=\"YYYY\"]")
		WebElement YYYY;
		public void enterYourDateOfBirthYYYY(String MONTH)
		{
			clearAndEnterValue(YYYY,MONTH);
		}
		
	//PINCODE
		@FindBy(xpath = "//input[@placeholder=\"Pincode (as per KYC records)\"]")
		WebElement Pincode;
		public void enterPincode(String pincode)
		{
			clearAndEnterValue(Pincode, pincode);
		}
	
	//VALIDATION FOR PAN
		@FindBy(xpath = "//div[text()=\"Please enter valid PAN\"]")
		List<WebElement> panValidation;
		public void panValidationMessage()
		{
			isDisplayed(panValidation, "PAN Validation > ");
		}
		
		
	//VALIDATION FOR DOB
		@FindBy(xpath = "//div[text()=\"Please enter a valid date of birth\"]")
		List<WebElement> dobValidate;
		public void dobValidationMessage()
		{
			isDisplayed(dobValidate, "DOB Validation > ");
		}
		
	//VALIDATION FOR PINCODE	
		@FindAll(@FindBy(xpath = "//div[text()=\"Please enter a valid pincode\"]"))
		List<WebElement> pincodeValidate;
		public void pincodeValidationMessage()
		{
			isDisplayed(pincodeValidate, "PIN Validation > ");
		}

		
}


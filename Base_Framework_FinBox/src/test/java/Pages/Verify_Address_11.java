package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Verify_Address_11 extends UtilityMethods {
	public Verify_Address_11(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder=\"Line1 of Address\"]")
	WebElement AddressLine1;
	public void enterAddressLine1()
	{
		clearAndEnterValue(AddressLine1, "Jayanagara");
	}
	
	
	@FindBy(xpath="//input[@placeholder=\"Line2 of Address\"]")
	WebElement AddressLine2;
	public void enterAddressLine2()
	{
		clearAndEnterValue(AddressLine2, "Hassan");
	}
	

	
		@FindBy(xpath="//input[@placeholder=\"Enter your Pin Code\"]")
	WebElement EnterYourPinCode;
	public void enterYourPinCode()
	{
		clearAndEnterValue(EnterYourPinCode, "573201");
	}
	
	@FindBy(xpath="//input[@placeholder=\"Enter your City\"]")
	WebElement EnterYourCity;
	public void enterYourCity()
	{
		clearAndEnterValue(EnterYourCity, "Hassan");
	}
	
	
	@FindBy(xpath="//input[@placeholder=\"Enter your State\"]")
	WebElement EnterYourState;
	public void enterYourState()
	{
		clearAndEnterValue(EnterYourState, "Karnataka");
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement Submit;
	public void clickOnSubmitButton()
	{
		clickAction(Submit);
	}
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement checkBox;
	public void clickOnCheckBox() throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(checkBox);
	}
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	WebElement Continue;
	public void clickOnContinue()
	{
		clickAction(Continue);
	}

}

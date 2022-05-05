package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Verify_Address_11 extends UtilityMethods {
	public Verify_Address_11(WebDriver driver)
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
	
	
	@FindBy(xpath="//input[@placeholder=\"Line1 of Address\"]")
	WebElement AddressLine1;
	public void enterAddressLine1()
	{
		clearAndEnterValue(AddressLine1, "Jayanagara");
	}

	//wait till page loads
		public void waitTillPageGetLoad(WebDriverWait wait)
		{
			waitUntillElementToBeClickable(wait, AddressLine1);
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
	
	//SUBMIT
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement Submit;
	public void clickOnSubmitButton(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, Submit);
		clickAction(Submit);
		System.out.println("Clicked on >SUBMIT ");
	}
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement checkBox;
	public void clickOnCheckBox(WebDriverWait wait) throws InterruptedException
	{
		waitUntillVisibility(wait, checkBox);
		clickAction(checkBox);
	}
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	WebElement Continue;
	public void clickOnContinue()
	{
		clickAction(Continue);
	}

}

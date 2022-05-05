package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Business_Details_7 extends UtilityMethods{
	
	//CONSTRUCTOR
	public Business_Details_7(WebDriver driver)
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
	
	//Name of the firm
	@FindBy(xpath="//input[@placeholder=\"Enter your firm name\"]")
	WebElement NameOfThefirm;
	public void enterNameOfThefirm(WebDriverWait wait ,String name)
	{
		waitUntillElementToBeClickable(wait, NameOfThefirm);
		clearAndEnterValue(NameOfThefirm, name);
	}
	
	//	WAITING TO PAGE GET LOAD
	public void waitTillPageGetLoad(WebDriverWait wait )
	{
		waitUntillElementToBeClickable(wait, NameOfThefirm);
	}
	
	//GSTIN
	@FindBy(xpath = "//input[@placeholder=\"Enter your GSTIN\"]")
	WebElement EnterYourGSTIN;
	public void enterGSTIN(String name)
	{
		clearAndEnterValue(EnterYourGSTIN, name);
	}
	
	//GST VALIDATION
	@FindBy(xpath = "//div[text()=\"invalid GSTIN\"]")
	List<WebElement> GSTvalidation;
	public void isGSTValidationDisplayed()
	{
		isDisplayed(GSTvalidation, "GST Validation > ");
	}
	
	//NEXT BUTTON
	@FindBy(xpath = "//button[text()=\"Next\"]")
	WebElement NextButton;
	public void clickOnNextButton()
	{
		clickAction(NextButton);
	}
}

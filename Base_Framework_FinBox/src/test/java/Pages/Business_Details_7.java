package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Business_Details_7 extends UtilityMethods{
	
	public Business_Details_7(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder=\"Enter your firm name\"]")
	WebElement NameOfThefirm;
	public void enterNameOfThefirm(String name)
	{
		clearAndEnterValue(NameOfThefirm, name);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Enter your GSTIN\"]")
	WebElement EnterYourGSTIN;
	public void enterGSTIN(String name)
	{
		clearAndEnterValue(EnterYourGSTIN, name);
	}
	
	@FindBy(xpath = "//button[text()=\"Next\"]")
	WebElement NextButton;
	public void clickOnNextButton()
	{
		clickAction(NextButton);
	}
}

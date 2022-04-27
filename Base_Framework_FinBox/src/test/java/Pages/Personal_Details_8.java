package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;


public class Personal_Details_8 extends UtilityMethods {
	public Personal_Details_8(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Enter your father's full name\"]")
	WebElement FathersName;
	public void enterFatherName(String name)
	{
		clearAndEnterValue(FathersName, name);
	}
	
	
	@FindBy(xpath="//div[@id=\"__react-alert__\"]")
	List<WebElement> Toastmessege;
	public void isToastMessegedisplayed()
	{
		isDisplayed(Toastmessege, "Toast Messege Validation > ");
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitButton;
	public void clickOnSubmitButton()
	{
		clickAction(SubmitButton);
	}
	

}

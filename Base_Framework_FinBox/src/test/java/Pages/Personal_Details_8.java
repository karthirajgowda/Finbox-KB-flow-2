package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;


public class Personal_Details_8 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Personal_Details_8(WebDriver driver)
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
	
	//FATHERS NAME
	@FindBy(xpath = "//input[@placeholder=\"Enter your father's full name\"]")
	WebElement FathersName;
	public void enterFatherName(WebDriverWait wait,String name)
	{
		waitUntillElementToBeClickable(wait, FathersName);
		clearAndEnterValue(FathersName, name);
	}
	
	public void waitTillPageGetLoad(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, FathersName);
	}
	
	//FATHER NAME VALIDATION
	@FindBy(xpath = "//div[text()=\"only alphabets and space allowed\"]")
	List<WebElement> FatherNameValidation;
	public void isFatherNameValidationDisplayed()
	{
		isDisplayed(FatherNameValidation, "Father Name Validation > ");
		printFathersNameValidation();
	}
	
	//PRINT FATHER NAME VALIDATION
	@FindBy(xpath = "//div[text()=\"only alphabets and space allowed\"]")
	WebElement FatherNameValidation1;
    public void printFathersNameValidation()
    {
    	System.out.println(FatherNameValidation1.getText());
    }
	
	//FATHER NAME TOAST MESSAGE
	@FindBy(xpath="//div[@id=\"__react-alert__\"]")
	List<WebElement> Toastmessege;
	public void isToastMessegedisplayed()
	{
		isDisplayed(Toastmessege, "Toast Messege Validation > ");
	}
	
	
	//SUBMIT BUTTON
	@FindBy(xpath = "//button[contains(text(),\"Submit\")]")
	WebElement SubmitButton;
	public void clickOnSubmitButton()
	{
		clickAction(SubmitButton);
	}
	

}

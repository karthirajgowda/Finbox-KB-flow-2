package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Personal_Information_1 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Personal_Information_1(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);  //INITIALIZE THE ELEMENTS EVERY TIME THE PAGE GETS LOADED
	} 
	
	//FINBOX LOGO
	@FindBy(xpath = "//img[@src=\"/static/media/finBoxDark.88f38f8f.svg\"]")
	List<WebElement> FinboxLogo;
	public void isFinboxlogoDisplayed()
	{
		isDisplayed(FinboxLogo, "FinBox Logo  ");
	}
	
	//YOUR FULL NAME
     @FindBy(xpath ="//input[@placeholder=\"Enter your full name as per PAN\"]")
     WebElement yourFullName; 
	public void enterYourFullName(String name)
	{
		clearAndEnterValue(yourFullName, name);
	}
	
	
	//EMAIL ADDRESS
	 @FindBy(xpath ="//input[@placeholder=\"Enter your email address\"]")
     WebElement email_Address;
	 public void enterEmailAddress(String email)
		{
			clearAndEnterValue(email_Address, email);
		}
	
	//CHECK BOX 
	 @FindBy(xpath ="//input[@type=\"checkbox\"]")
     WebElement checkBox;
	 public void clickCheckBox(WebDriverWait wait)
		{
		 waitUntillVisibility(wait, checkBox);
			clickAction(checkBox);
		}
	             
	//NEXT BUTTON 
	 @FindBy(xpath ="//button[contains(text(),'Next')]")
     WebElement nextButton;
	 public void clicknextButton(WebDriverWait wait)
		{
			wait.until(ExpectedConditions.elementToBeClickable(nextButton));
			clickAction(nextButton);
			
		}
	 
	 //NAME VALIDATION
	 @FindBy(xpath = "//div[contains(text(),'Invalid Name')]")
	 List<WebElement> nameValidation;
	 public void isNameValidationdisplayed()
	 {
		 isDisplayed(nameValidation,"Name Validation > " );
	 }
	 
	 //EMAIL VALIDATION
	 @FindBy(xpath = "//div[contains(text(),'Invalid Email id')]")
	 List<WebElement> emailValidation;
	 public void isEmailValidationDisplayed()
	 {
		 isDisplayed(emailValidation,"Email Validation >");
	 }
	 
	
}

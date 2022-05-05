package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Documents_for_KYC_9 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Documents_for_KYC_9 (WebDriver driver)
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
	
	
	//UploadDocumentsManually
	@FindBy(xpath = "(//*[local-name()='svg'])[5]")
	WebElement UploadDocumentsManually;
	public void clickOnUploadDocumentsManually()
	{
		clickAction(UploadDocumentsManually);
		System.out.println("Clicked on > UPLOAD DOCUMENTS MANUALLY");
	}
	
	//wait till page loads
	public void waitTillPageGetLoad(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, UploadDocumentsManually);
	}

}

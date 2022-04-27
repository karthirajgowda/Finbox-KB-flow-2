package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Documents_for_KYC_9 extends UtilityMethods {
	
	public Documents_for_KYC_9 (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[local-name()='svg'])[5]")
	WebElement UploadDocumentsManually;
	public void clickOnUploadDocumentsManually()
	{
		clickAction(UploadDocumentsManually);
	}

}

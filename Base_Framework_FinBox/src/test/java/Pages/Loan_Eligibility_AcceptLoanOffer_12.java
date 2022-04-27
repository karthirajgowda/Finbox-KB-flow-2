package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Loan_Eligibility_AcceptLoanOffer_12 extends UtilityMethods{
	
	
	public Loan_Eligibility_AcceptLoanOffer_12(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath ="//span[text()=\"View Loan Offer\"]")
	WebElement ViewLoanOffer;
	public void clickOnViewLoanOffer()
	{
		clickAction(ViewLoanOffer);
	}
	

}

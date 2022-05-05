package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Loan_Eligibility_AcceptLoanOffer_12 extends UtilityMethods{
	
	
	public Loan_Eligibility_AcceptLoanOffer_12(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//FINBOX LOGO
		@FindBy(xpath = "//img[@src=\"/static/media/finBoxDark.88f38f8f.svg\"]")
		List<WebElement> FinboxLogo;
		public void isFinboxlogoDisplayed()
		{
			isDisplayed(FinboxLogo, "FinBox Logo  ");
		}
		

		//wait till page loads
			public void waitTillPageGetLoad(WebDriverWait wait)
			{
				waitUntillElementToBeClickable(wait, ViewLoanOffer);
			}
		
	//VIEW LOAN OFFER
	@FindBy(xpath ="//span[text()=\"View Loan Offer\"]")
	WebElement ViewLoanOffer;
	public void clickOnViewLoanOffer(WebDriverWait wait)
	{
		waitUntillElementToBeClickable(wait, ViewLoanOffer);
		clickAction(ViewLoanOffer);
		System.out.println("Clicked on > VIEW LOAN OFFER");
	}
	

}

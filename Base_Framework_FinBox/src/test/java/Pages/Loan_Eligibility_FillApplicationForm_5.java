package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Loan_Eligibility_FillApplicationForm_5 extends UtilityMethods{
	//CONSTRUCTOR
	public Loan_Eligibility_FillApplicationForm_5(WebDriver driver)
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
			
	//ELIGIBLE AMOUNT
	@FindBy(xpath = "//div[text()=\"2,50,000\"]")
	 WebElement EligibleAmount;
	public String displayEligibleAmount(WebDriverWait wait)
	{
	    wait.until(ExpectedConditions.visibilityOf(EligibleAmount));
		System.out.println("EligibleAmount > "+getloanamount1(EligibleAmount));
		return getloanamount1(EligibleAmount);
	}

	
	//WHY SHOULD I TAKE THIS LOAN
	@FindBy(xpath = "//span[text()=\"Why should I take this loan?\"]")
	WebElement WhyShouldITakeThisLoan;
	public void WhyTakeThisLoan(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(WhyShouldITakeThisLoan));
	  clickAction(WhyShouldITakeThisLoan);
	}
	
	
	//INTREST
	@FindBy(xpath = "//div[text()=\"Upto \"]")
	WebElement Interest;
	public String displayIntrest()
	{
		String intrest= Interest.getText();
		//intrest.subSequence(5, intrest.length()-1);
		System.out.println("Interest rate > " + intrest.substring(5, intrest.length()-1));
		return intrest.substring(5, intrest.length()-1);
	}
	
	
		
	//TENURE
	@FindBy(xpath = "(//div[text()=\"Upto \"])[2]")
	WebElement TenureMonth;
    public void displayTenure()
    {
    	System.out.println("Tenure Month > " + TenureMonth.getText());
    }
	
	//FILL APPLICATION
		@FindBy(xpath = "//span[text()=\"Fill Application Form\"]")
		WebElement FillApplicationForm;
		public void FillApplicationForm()
		{
			verifyAndClick(FillApplicationForm, "Fill Application Form");
		}
		


}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Loan_Eligibility_FillApplicationForm_5 extends UtilityMethods{
	
	public Loan_Eligibility_FillApplicationForm_5(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//ELIGIBLE AMOUNT
	@FindBy(xpath = "//div[@class=\"sc-iCfMLu dWJFSF\"]")
	 WebElement EligibleAmount;
/*	public  String EligibleAmount()
	{
         String eligibleamount = getloanamount(EligibleAmount); 
		return eligibleamount;
	} */
	
	public void displayEligibleAmount()
	{
		System.out.println("EligibleAmount > "+getloanamount(EligibleAmount));
	}

	
	//WHY SHOULD I TAKE THIS LOAN
	@FindBy(xpath = "(//*[local-name()='svg'])[5]")
	WebElement WhyShouldITakeThisLoan;
	public void WhyTakeThisLoan()
	{
	  clickAction(WhyShouldITakeThisLoan);
	}
	
	
	//INTREST
	@FindBy(xpath = "//div[text()=\"Upto \"]")
	WebElement Interest;
/*	public String Interest()
	{
		String interest = Interest.getText();
		return interest;
	} */
	
	public void displayIntrest()
	{
		System.out.println("Interest rate > " + Interest.getText());
	}
	
	
		
	//TENURE
	@FindBy(xpath = "(//div[text()=\"Upto \"])[2]")
	WebElement TenureMonth;
/*	public String Tenure()
	{
		String tenure = TenureMonth.getText();
		return tenure;
	}*/
	
    public void displayTenure()
    {
    	System.out.println("Tenure Month > " + TenureMonth.getText());
    }
	
	//FILL APPLICATION
		@FindBy(xpath = "//span[text()=\"Fill Application Form\"]")
		WebElement FillApplicationForm;
		public void FillApplicationForm()
		{
			clickAction(FillApplicationForm);
		}
		


}

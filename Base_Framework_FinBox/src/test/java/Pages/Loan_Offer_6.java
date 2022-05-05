package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;

public class Loan_Offer_6 extends UtilityMethods {
	//CONSTRUCTOR
	public Loan_Offer_6(WebDriver driver)
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

	//MINIMUM AMOUNT VALIDATION
	@FindBy(xpath = "//div[text()=\"Loan amount cannot be less than ₹ 25,000\"]")
	List<WebElement> MinimumValidation;
	public void minimumAmountValidation()
	{
		isDisplayed(MinimumValidation, "For 2500 Amount Validation > ");
	}

	//MAXIMUM AMOUNT VALIDATION
	@FindBy(xpath = "//div[text()=\"Loan amount cannot be more than ₹ 2,50,000\"]")
	List<WebElement> MaximumValidation;
	public void maximumAmountValidation()
	{
		isDisplayed(MaximumValidation, "For 2500012 Amount Validation > ");
	}

	//LOAN AMOUNT TEXT FILED
	@FindBy(xpath = "//div[5]/input")
	WebElement loanAmountTextField;
	public void clearAndEntereAmount1(WebDriverWait wait ,String amount)
	{
		waitUntillElementToBeClickable(wait, loanAmountTextField);
		clearAndEnterValue(loanAmountTextField, amount);
	}
	
	public void clearAndEntereAmount(String amount)
	{
		clearAndEnterValue(loanAmountTextField, amount);
	}

	//SLIDER
	@FindBy(xpath = "(//div[text()=\"|\"]/../../../div/div/div)[1]")
	WebElement Slider;
	public void slide(WebDriver driver) throws InterruptedException
	{
		slideTheBar(Slider,driver);
		System.out.println("*Side bar selected the  amount*");
	}



	//TENEURE 3RD MONTH
	@FindBy(xpath ="(//span[text()='months'])[1]")
	WebElement Tenure3Months;
	public void clickOn3MonthTenure()
	{
		clickAction(Tenure3Months);
	}

	//TENEURE 6TH MONTH
	@FindBy(xpath ="(//span[text()='months'])[2]")
	WebElement Tenure6Months;
	public void clickOn6MonthTenure()
	{
		clickAction(Tenure6Months);
	}

	//TENEURE 12TH MONTH
	@FindBy(xpath ="(//span[text()='months'])[3]")
	WebElement Tenure12Months;
	public void clickOn12MonthTenure()
	{
		clickAction(Tenure12Months);
	}

	//TENEURE 24TH MONTH
	@FindBy(xpath ="(//span[text()='months'])[4]")
	WebElement Tenure24Months;
	public void clickOn24MonthTenure()
	{
		clickAction(Tenure24Months);
	}

	//EDI
	@FindBy(xpath = "(//div[@class=\"sc-fXEqDS bIILmN\"]/div/span)[2]")
	WebElement EDI;
	public String EDI(String amount)
	{
		System.out.println("EDI FOR "+amount+" > "+getValueForPage6_13(EDI));
		return getValueForPage6_13(EDI);

	}

	//TAKEN LOAN AMOUNT
	@FindBy(xpath = "((//div)[46]/div)[2]")
	WebElement TakenLoanAmount;
	public String takenLoanAmount()
	{
		System.out.println("TakenLoanAmount > "+getValueForPage6_13(TakenLoanAmount));
		return getValueForPage6_13(TakenLoanAmount);
	}

	//SELECTED TENURE MONTH
	@FindBy(xpath = "((//div)[46]/div)[3]")
	WebElement SelectedTenure;
	public String selectedTenure()
	{
		System.out.println("Selected Tenure > "+getValueForPage6SelectedLoan(SelectedTenure));
		return getValueForPage6SelectedLoan(SelectedTenure);
	}


	//APPLAY FOR LOAN
	@FindBy(xpath = "//button[text()=\"Apply for Loan\"]")
	WebElement ApplyForLoan;
	public void clickOnApplyForLoan()
	{
		verifyAndClick(ApplyForLoan, "APPLY FOR LOAN >");
	}
	
	public void isApplyForLoanButtonEnabled(String month,String amount)
	{
		String text="For "+amount+" Amount and "+month+" Month Tenure, APPLY FOR LOAN Button is ";
		isEnabled(ApplyForLoan, text);
	}

}

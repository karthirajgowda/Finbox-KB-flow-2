package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;

public class Loan_Offer_6 extends UtilityMethods {
	
	public Loan_Offer_6(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value=\"₹ 2,50,000\"]")
	WebElement loanAmountTextField;
	public void clearAndEntereAmount(String amount)
	{
		clearAndEnterValue(loanAmountTextField, amount);
		
	}
	
	@FindBy(xpath = "//div[@class=\"css-e8am04\"]")
	WebElement Slider;
	public void slide(WebDriver driver)
	{
		slideTheBar(Slider,driver);
	}
	
	@FindBy(xpath = "//span[text()='months']")
	List<WebElement> TenureMonths;
	public void tenureMonths()
	{
		clickOnListOfWebelemnts(TenureMonths);
	}
	
	@FindBy(xpath ="(//span[text()='months'])[3]")
	WebElement Tenure12Months;
	public void clickON12MonthTenure()
	{
		clickAction(Tenure12Months);
	}
	
	@FindBy(xpath = "//button[text()=\"Apply for Loan\"]")
	WebElement ApplayForLoan;
	public void clickOnApplayForLoan()
	{
		verifyAndClick(ApplayForLoan, "APPLAY FOR LOAN >");
	}

}

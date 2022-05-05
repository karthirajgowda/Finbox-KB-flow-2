package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.UtilityMethods;


public class Youve_Got_A_Loan_Of_13 extends UtilityMethods {
	
	//CONSTRUCTOR
	public Youve_Got_A_Loan_Of_13(WebDriver driver)
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
	
	//LOAN AMOUNT
	@FindBy(xpath="//div[contains(text(),\"Arthan Finance\")]/../div[1]")
	WebElement LoanAmount;
	public String loanAmount()
	{
		System.out.println("Sanctioned Loan Amount > "+getValueForPage6_13(LoanAmount));
      return  getValueForPage6_13(LoanAmount);
	}

	//wait till page loads
		public void waitTillPageGetLoad(WebDriverWait wait)
		{
			waitUntillElementToBeClickable(wait,LoanAmount);
		}
	
	//ARTHAN FINANCE LOGO
	@FindBy(xpath="//img[@src=\"https://finbox-cdn.s3.ap-south-1.amazonaws.com/assets/ic_arthan_logo.webp\"]")
	List<WebElement> ArthanFinanceLogo;
	public void isArthanFinanceLogoDisplayed()
	{
		isDisplayed(ArthanFinanceLogo, "Arthan Finance Logo > ");
	}
	
	//INTREST
	@FindBy(xpath="//div[text()=\"EMI\"]/../../div/div[2]")
	WebElement Intrest;
	public String intrest()
	{
		return Intrest.getText();
	}
}

package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.UtilityMethods;


public class Youve_Got_A_Loan_Of_13 extends UtilityMethods {
	
	public Youve_Got_A_Loan_Of_13(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"sc-iCfMLu dWJFSF\"]")
	WebElement LoanAmount;
	public String loanAmount()
	{
     return  getloanamount(LoanAmount);
	}
	
	@FindBy(xpath="//img[@src=\"https://finbox-cdn.s3.ap-south-1.amazonaws.com/assets/ic_arthan_logo.webp\"]")
	List<WebElement> ArthanFinanceLogo;
	public void isArthanFinanceLogoDisplayed()
	{
		isDisplayed(ArthanFinanceLogo, "Arthan Finance Logo > ");
	}
	
	@FindBy(xpath="//div[@class=\"sc-crHmcD sc-fWCJzd kSyJqQ bAthNV\"]")
	WebElement Intrest;
	public String intrest()
	{
		return Intrest.getText();
	}
}

package Tests;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Icons;
import Generic.KYC;
import Generic.UtilityMethods;
import Pages.Aadhaar_KYC_Documents_10;
import Pages.Basic_Details_4;
import Pages.Business_Details_7;
import Pages.Documents_for_KYC_9;
import Pages.Loan_Eligibility_AcceptLoanOffer_12;
import Pages.Loan_Eligibility_FillApplicationForm_5;
import Pages.Loan_Offer_6;
import Pages.Personal_Details_8;
import Pages.Personal_Information_1;
import Pages.Phone_Number_Verification_2;
import Pages.Phone_Number_Verification_OTP_3;
import Pages.Selfie_KYC_Documents_10;
import Pages.Verify_Address_11;
import Pages.Youve_Got_A_Loan_Of_13;

public class KB_Flow extends Icons
{
	String FetchedPhoneNumber;
	String MaximunLoanAmount;
	String IntrestPage5;
	String SelectedTenure;
	String TakenLoanAmount;
	String SanctionedLoanAmount;

	@DataProvider(name="PI")
	public Object[][] PersonalInfo() throws Exception{
		Object[][] data = UtilityMethods.getExcelData("PersonalDetails1");
		return data;

	}

	@Test
	public void checkbox()
	{
		Personal_Information_1 pi=new Personal_Information_1(driver);
		pi.clickCheckBox(wait);
		System.out.println("_________________________________Personal_Information_PAGE(1)______________________________________________");
		pi.isFinboxlogoDisplayed();
		isFAQiconDisplayed();
		isCloseIconDisplayed();
	}
	//Executing 1st page Scripts
	@Test(dataProvider = "PI",dependsOnMethods = "checkbox")
	public void personalInformationScripts(String name,String email) throws InterruptedException
	{

		Personal_Information_1 pi=new Personal_Information_1(driver);
		System.out.println("Name  > "+name+"      "+"Email > "+email);
		pi.enterYourFullName(name);
		pi.enterEmailAddress(email);
		pi.clicknextButton(wait);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		pi.isNameValidationdisplayed();
		pi.isEmailValidationDisplayed(); 
		System.out.println("**********");

	}

	//Executing 2nd page
	@Test(dependsOnMethods = "personalInformationScripts")
	public void phoneNumberVerification()
	{
		System.out.println("_________________________________Phone_Number_Verification_PAGE(2)______________________________________________");
		Phone_Number_Verification_2 pn=new Phone_Number_Verification_2(driver);
		FetchedPhoneNumber=pn.fetchedPhoneNumber(wait);
		pn.isFinboxlogoDisplayed();
		isBackIconDisplayed();
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		pn.clickOnSendOTP();
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}

	//Executing 3rd page
	@Test(dependsOnMethods = "phoneNumberVerification")
	public void phoneNumberVerificationOTP() throws Exception
	{
		System.out.println("_________________________________Phone_Number_Verification_OTP_PAGE(3)______________________________________________");
		Phone_Number_Verification_OTP_3 pnv=new Phone_Number_Verification_OTP_3(driver);
	//	pnv.isFetchedAndOtpSentNumberSame(wait, FetchedPhoneNumber);
		pnv.enterOTP(wait,"000009");
		pnv.clickOnVerifyNumberButton();
		System.out.println("OTP ENTERED > 000009");
		pnv.isOtpToastDisplayed(wait);
		//pnv.clickOnResend(wait);
		pnv.enterOTP(wait,"000000");
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		pnv.isFinboxlogoDisplayed();
		Thread.sleep(1000);
		pnv.clickOnVerifyNumberButton();
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}  


	//EXECUTING 4TH PAGE RADIO BUTTON
	@Test(dependsOnMethods = "phoneNumberVerificationOTP")
	public void basicDetailsRadio() throws InterruptedException
	{
		System.out.println("_________________________________Basic_Details_PAGE(4)______________________________________________");
		Basic_Details_4 bd=new Basic_Details_4(driver);
		bd.clickOnGenderFandVerify(wait);
		bd.clickOnGenderOandVerify();
		bd.clickOnGenderMandVerify();
		System.out.println("**********");
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		bd.isFinboxlogoDisplayed();
		System.out.println("**********");
		bd.verifyAndClickOnNextButton();

	}

	@DataProvider(name="BD")
	@Test(dependsOnMethods = "basicDetailsRadio")
	public Object[][] BasicDetailsExcel() throws Exception{
		Object[][] data = UtilityMethods.getExcelData("BasicDetails4");
		return data;
	}


	//EXECUTING 4TH PAGE TEXT FIELD
	@Test(dataProvider = "BD",dependsOnMethods = "basicDetailsRadio")
	public void basicDetails(String pan,String dd,String mm,String yyyy,String pincode) throws InterruptedException
	{
		Basic_Details_4 bd=new Basic_Details_4(driver);
		bd.enterYourPANNumber(pan);
		bd.enterYourDateOfBirthDD(dd);
		bd.enterYourDateOfBirthMM(mm);
		bd.enterYourDateOfBirthYYYY(yyyy);
		bd.enterPincode(pincode);
		bd.clickOnNextButton();
		Thread.sleep(1000);
		System.out.println("PAN > "+pan +"   "+"DOB > "+dd+"-"+mm+"-"+yyyy+"   "+"PIN > "+pincode);
		bd.panValidationMessage();
		bd.dobValidationMessage();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		bd.pincodeValidationMessage();	
		System.out.println("----------------------------------------------------------------------------------------------------------");
	} 


	//EXECUTING Loan_Eligibility_5 PAGE
	@Test(dependsOnMethods ="basicDetails")
	//@Test
	public void loanEligibility() throws InterruptedException
	{
		System.out.println("_________________________________Loan_Eligibility_PAGE(5)______________________________________________");

		Loan_Eligibility_FillApplicationForm_5 le=new Loan_Eligibility_FillApplicationForm_5(driver);
		le.WhyTakeThisLoan(wait);
		MaximunLoanAmount=le.displayEligibleAmount(wait);
		Thread.sleep(500);
		IntrestPage5=le.displayIntrest();
		le.displayTenure();
		isFAQiconDisplayed();
		isProfileIconDisplayed();
		isCloseIconDisplayed();
		le.isFinboxlogoDisplayed();
		le.FillApplicationForm();
		System.out.println("----------------------------------------------------------------------------------------------------------");
	} 

	@DataProvider(name="LoanAmount")
	public Object[][] amount() throws Exception
	{
		Object[][] data=UtilityMethods.getExcelData("LoanOffer6");
		Loan_Offer_6 lf=new Loan_Offer_6(driver);
		System.out.println("_________________________________Loan_Offer_PAGE(6)______________________________________________");
		lf.clearAndEntereAmount1(wait, "2500");
		lf.minimumAmountValidation();
		lf.clearAndEntereAmount1(wait,"2500012");
		lf.maximumAmountValidation();
		return data;

	}      

	//EXECUTING LOAN OFFER PAGE_6
	@Test(dataProvider = "LoanAmount" ,dependsOnMethods = "loanEligibility")
	//	@Test
	public void loanOffer1(String amount) throws Exception
	{
		Loan_Offer_6 lf=new Loan_Offer_6(driver);
		lf.clearAndEntereAmount( amount);
		lf.clickOn3MonthTenure();
		lf.isApplyForLoanButtonEnabled("3 ",amount);
		lf.clickOn6MonthTenure();
		lf.isApplyForLoanButtonEnabled("6 ",amount);
		lf.clickOn12MonthTenure();
		lf.isApplyForLoanButtonEnabled("12",amount);
		lf.clickOn24MonthTenure();
		lf.isApplyForLoanButtonEnabled("24",amount);
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
	@Test(dependsOnMethods = "loanOffer1")
	public void loanOffer2() throws InterruptedException
	{
		Loan_Offer_6 lf=new Loan_Offer_6(driver);
		lf.slide(driver);
		TakenLoanAmount=lf.takenLoanAmount();
		lf.EDI(TakenLoanAmount);
		SelectedTenure=lf.selectedTenure();
		lf.clickOnApplyForLoan();
	}
	
	@DataProvider(name="businessDetailspage")
	public Object[][] businessDetailspage() throws Exception
	{
		System.out.println("__________________________________Business_Details_PAGE(7)______________________________________________");
		Object[][] data = UtilityMethods.getExcelData("BusinessDetails7");
		Business_Details_7 bd=new Business_Details_7(driver);
		bd.waitTillPageGetLoad(wait);
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		bd.isFinboxlogoDisplayed();
		System.out.println("************");
		return data;	
	}

	//EXECUTING Business_Details_7
	@Test(dependsOnMethods = "loanOffer2",dataProvider = "businessDetailspage")
	public void businessDetails(String name,String GST) throws InterruptedException {
		
		Business_Details_7 bd=new Business_Details_7(driver);
		bd.enterNameOfThefirm(wait,name);
		System.out.println("Name of the firm  > "+ name+"   GSTIN  > "+GST);
		bd.enterGSTIN(GST);
		bd.clickOnNextButton();
		Thread.sleep(1000);
		bd.isGSTValidationDisplayed();
		System.out.println("-----------------");
	}

	@DataProvider(name="personalDetailspage")
	public Object[][] personalDetailspage() throws Exception
	{
		System.out.println("__________________________________Personal_Details_PAGE(8)______________________________________________");
		Object[][] data = UtilityMethods.getExcelData("PersonalDetails8");
		Personal_Details_8 pd=new Personal_Details_8(driver);
		pd.waitTillPageGetLoad(wait);
		pd.isFinboxlogoDisplayed();
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		pd.enterFatherName(wait, "1");	
		pd.clickOnSubmitButton();
		pd.isFatherNameValidationDisplayed();
		return data;
		
	}
	//EXECUTING Personal_Details_8
	@Test(dependsOnMethods = "businessDetails",dataProvider = "personalDetailspage")
	public void personalDetails(String name) throws InterruptedException
	{
		Personal_Details_8 pd=new Personal_Details_8(driver);
		System.out.println("Father Name > "+name);
		pd.enterFatherName(wait,name);
		pd.clickOnSubmitButton();
		Thread.sleep(1000);
		pd.isToastMessegedisplayed();
		System.out.println("-----------------");
	}  

	//EXECUTING Documents_for_KYC_9
	@Test(dependsOnMethods = "personalDetails" )
	//  @Test
	public void documentsForKYC() throws InterruptedException
	{
		System.out.println("__________________________________Documents_for_KYC_PAGE(9)______________________________________________");
		Documents_for_KYC_9 dk=new Documents_for_KYC_9(driver);	
		dk.waitTillPageGetLoad(wait);
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		dk.isFinboxlogoDisplayed();
		dk.clickOnUploadDocumentsManually();
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}

	//EXECUTING Selfie_KYC_Documents_10
	@Test(dependsOnMethods = "documentsForKYC")
	public void uploadSelfie() throws Exception
	{
		System.out.println("___________________________________Selfie_KYC_Documents_PAGE(10)______________________________________________");
		Selfie_KYC_Documents_10 skyc=new Selfie_KYC_Documents_10(driver);
		skyc.waitTillPageGetLoad(wait);
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		skyc.isFinboxlogoDisplayed();
		skyc.clickOnUploadYourSelfie();
		skyc.clickOnTakePhoto(wait);
		Thread.sleep(4000);
		skyc.captureSelfie(wait);
		//Thread.sleep(2000);
		skyc.clickOnSelfieRetakeButton(wait);
		Thread.sleep(4000);
		skyc.captureSelfie(wait);
	//	Thread.sleep(1000);
		skyc.clickOnSelfieSubmitButton(wait);

		System.out.println("----------------------------------------------------------------------------------------------------------");

	}

	//EXECUTING Aadhaar_KYC_Documents_10
	@Test(dependsOnMethods = "uploadSelfie")
	public void uploadAadhaar() throws Exception
	{
		System.out.println("___________________________________Aadhaar_KYC_Documents_PAGE(10)______________________________________________");
		
		Aadhaar_KYC_Documents_10 akyc=new Aadhaar_KYC_Documents_10(driver);
		akyc.waitTillPageGetLoad(wait);
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		akyc.isFinboxlogoDisplayed();
	//	Thread.sleep(2000);
		akyc.clickOnUploadYourAddressProof(wait);
		akyc.clickOnAadhaar(wait);
		akyc.clickOnFront(wait);
		Thread.sleep(4000);
		akyc.captureAadhaarFront(wait);
		akyc.clickOnAadhaarRetakeButtonFront(wait);
		Thread.sleep(4000);
		akyc.captureAadhaarFront(wait);
		akyc.clickOnAadhaarSubmitButtonFront(wait);
		akyc.clickOnBack(wait);
		Thread.sleep(4000);
		akyc.captureAadhaarBack(wait);
		akyc.clickOnAadhaarRetakeButtonBack(wait);
		Thread.sleep(4000);
		akyc.captureAadhaarBack(wait);
		akyc.clickOnAadhaarSubmitButtonBack(wait);
		akyc.clickOnAadhaarSubmitButton(wait);
	//	Thread.sleep(2000);
     	System.out.println("----------------------------------------------------------------------------------------------------------");

	}

	//Executing Verify_Address_11
	@Test(dependsOnMethods = "uploadAadhaar")
	public void verifyAddress() throws InterruptedException, AWTException
	{
		System.out.println("___________________________________Verify_Address_PAGE(11)______________________________________________");
		Verify_Address_11 va=new Verify_Address_11(driver);
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		isBackIconDisplayed();
		va.isFinboxlogoDisplayed();
		va.waitTillPageGetLoad(wait);
		//Thread.sleep(2000);
		va.enterAddressLine1();
		va.enterAddressLine2();
		va.enterYourPinCode();
	//	Thread.sleep(2000);
		va.clickOnSubmitButton(wait);
	//	Thread.sleep(2000);
		va.clickOnCheckBox(wait);
	//	Thread.sleep(1000);
		va.clickOnContinue();
		Thread.sleep(3000);
		KYC.skipKYC();
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}  

	//EXECUTING Loan_Eligibility_AcceptLoanOffer_12
	@Test(dependsOnMethods = "verifyAddress")
	//	@Test
	public void loanEligibilityAcceptLoanOffer() throws InterruptedException
	{
		driver.get(URL);
		System.out.println("___________________________________Loan_Eligibility_AcceptLoanOffer_PAGE(12)______________________________________________");
		Loan_Eligibility_AcceptLoanOffer_12 al=new Loan_Eligibility_AcceptLoanOffer_12(driver);
		al.waitTillPageGetLoad(wait);
		al.isFinboxlogoDisplayed();
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		al.clickOnViewLoanOffer(wait);
		System.out.println("----------------------------------------------------------------------------------------------------------");

	}

	//Executing Youve_Got_A_Loan_Of_13
	@Test(dependsOnMethods = "loanEligibilityAcceptLoanOffer")
	public void youveGotALoanOf() throws InterruptedException
	{
		System.out.println("__________________________________Youve_Got_A_Loan_Of_PAGE(13)______________________________________________");
		Youve_Got_A_Loan_Of_13 ygl=new Youve_Got_A_Loan_Of_13(driver);
		ygl.waitTillPageGetLoad(wait);
		ygl.isFinboxlogoDisplayed();
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		SanctionedLoanAmount=ygl.loanAmount();
		ygl.isArthanFinanceLogoDisplayed();

		




	}
}



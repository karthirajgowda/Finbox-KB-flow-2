package Tests;

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
        /*      Loan_Eligibility_FillApplicationForm_5 le=new Loan_Eligibility_FillApplicationForm_5(driver);
             String selectedAmount=le.EligibleAmount();
             String selctedintrest=le.Interest();
             String selectedtenure=le.Tenure();  */
             
	
	@DataProvider(name="PI")
	public Object[][] PersonalInfo() throws Exception{
		Object[][] data = UtilityMethods.getExcelData("PersonalDetails1");
		return data;
		
	}
	
	@Test
	public void checkbox()
	{
		Personal_Information_1 pi=new Personal_Information_1(driver);
		pi.clickCheckBox();
		System.out.println("_________________________________Personal_Information_PAGE(1)______________________________________________");
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
		pi.clicknextButton();
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
		isFAQiconDisplayed();
		isCloseIconDisplayed();
		Phone_Number_Verification_2 pn=new Phone_Number_Verification_2(driver);
		pn.clickOnSendOTP();
	}
	
	//Executing 3rd page
		@Test(dependsOnMethods = "phoneNumberVerification")
		public void phoneNumberVerificationOTP() throws Exception
		{
			System.out.println("_________________________________Phone_Number_Verification_OTP_PAGE(3)______________________________________________");
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			Phone_Number_Verification_OTP_3 pnv=new Phone_Number_Verification_OTP_3(driver);
			pnv.enterOTP("000009");
			pnv.clickOnVerifyNumberButton();
			System.out.println("OTP ENTERED > 000009");
			Thread.sleep(1000);
			pnv.isOtpToastDisplayed();
			pnv.clickOnResend();
			pnv.enterOTP("000000");
			pnv.clickOnVerifyNumberButton();
		}  
		
		
		//EXECUTING 4TH PAGE RADIO BUTTON
		@Test(dependsOnMethods = "phoneNumberVerificationOTP")
		public void basicDetailsRadio() throws InterruptedException
		{
			System.out.println("_________________________________Basic_Details_PAGE(4)______________________________________________");
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			Basic_Details_4 bd=new Basic_Details_4(driver);
			
			bd.clickOnGenderFandVerify();
			bd.clickOnGenderOandVerify();
			bd.clickOnGenderMandVerify();
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
			bd.verifyAndClickOnNextButton();
			Thread.sleep(1000);
			System.out.println("PAN > "+pan +"   "+"DOB > "+dd+"-"+mm+"-"+yyyy+"   "+"PIN > "+pincode);
			bd.panValidationMessage();
			bd.dobValidationMessage();
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			bd.pincodeValidationMessage();	
		} 
		
	
		//EXECUTING Loan_Eligibility_5 PAGE
		@Test(dependsOnMethods ="basicDetails")
    	//@Test
		public void loanEligibility() throws InterruptedException
		{
			System.out.println("_________________________________Loan_Eligibility_PAGE(5)______________________________________________");
			isFAQiconDisplayed();
			isProfileIconDisplayed();
			isCloseIconDisplayed();
			Loan_Eligibility_FillApplicationForm_5 le=new Loan_Eligibility_FillApplicationForm_5(driver);
			Thread.sleep(13000);
			le.displayEligibleAmount();
			le.WhyTakeThisLoan();
			Thread.sleep(500);
			le.displayIntrest();
			le.displayTenure();
			le.FillApplicationForm();
			System.out.println("----------------------------------------------------------------------------------------------------------");
		} 
		
		
		//EXECUTING LOAN OFFER PAGE_6
		@Test(dependsOnMethods = "loanEligibility")
	//	@Test
		public void loanOffer() throws Exception
		{
			driver.findElement(By.xpath("//span[text()=\"Fill Application Form\"]")).click();
			System.out.println("_________________________________Loan_Offer_PAGE(6)______________________________________________");
			Loan_Offer_6 lf=new Loan_Offer_6(driver);
			Thread.sleep(2000);
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			lf.clearAndEntereAmount("150500");
			lf.slide(driver);
			//lf.tenureMonths();
			lf.clickON12MonthTenure();
			lf.clickOnApplayForLoan();
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		
		//EXECUTING Business_Details_7
		@Test(dependsOnMethods = "loanOffer")
		public void businessDetails() throws InterruptedException {
			System.out.println("__________________________________Business_Details_PAGE(7)______________________________________________");
			Business_Details_7 bd=new Business_Details_7(driver);
			Thread.sleep(2000);
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			bd.enterNameOfThefirm("Parth Bhandari");
		//	bd.enterGSTIN("45bqgpm6876m4h6");
			bd.clickOnNextButton();
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		
		//EXECUTING Personal_Details_8
		@Test(dependsOnMethods = "businessDetails")
		public void personalDetails() throws InterruptedException
		{
			System.out.println("__________________________________Personal_Details_PAGE(8)______________________________________________");
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			Personal_Details_8 pd=new Personal_Details_8(driver);
			Thread.sleep(2000);
			pd.enterFatherName("THI");
			pd.clickOnSubmitButton();
			Thread.sleep(1000);
			pd.isToastMessegedisplayed();
			pd.enterFatherName("THIRUMALE GOWDA");
			pd.clickOnSubmitButton();
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}  
		
		//EXECUTING Documents_for_KYC_9
		@Test(dependsOnMethods = "personalDetails" )
	//  @Test
		public void documentsForKYC() throws InterruptedException
		{
			System.out.println("__________________________________Documents_for_KYC_PAGE(9)______________________________________________");
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			Documents_for_KYC_9 dk=new Documents_for_KYC_9(driver);	
			Thread.sleep(2000);
			dk.clickOnUploadDocumentsManually();
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		
		//EXECUTING Selfie_KYC_Documents_10
		@Test(dependsOnMethods = "documentsForKYC")
		public void uploadSelfie() throws Exception
		{
			System.out.println("___________________________________Selfie_KYC_Documents_PAGE(10)______________________________________________");
			isFAQiconDisplayed();
			isCloseIconDisplayed();
			
			Selfie_KYC_Documents_10 skyc=new Selfie_KYC_Documents_10(driver);
			Thread.sleep(2000);
			skyc.clickOnUploadYourSelfie();
			Thread.sleep(1000);
			skyc.clickOnTakePhoto();
			Thread.sleep(3000);
			skyc.captureSelfie();
			Thread.sleep(2000);
			skyc.clickOnSelfieRetakeButton();
			Thread.sleep(3000);
			skyc.captureSelfie();
			Thread.sleep(1000);
			skyc.clickOnSelfieSubmitButton();
			
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
		}
		
		//EXECUTING Aadhaar_KYC_Documents_10
				@Test(dependsOnMethods = "uploadSelfie")
				public void uploadAadhaar() throws Exception
				{
					System.out.println("___________________________________Aadhaar_KYC_Documents_PAGE(10)______________________________________________");
					isFAQiconDisplayed();
					isCloseIconDisplayed();
					Aadhaar_KYC_Documents_10 akyc=new Aadhaar_KYC_Documents_10(driver);
					Thread.sleep(2000);
					akyc.clickOnUploadYourAddressProof();
					akyc.clickOnAadhaar();
					akyc.clickOnFront();
					Thread.sleep(3000);
					akyc.captureAadhaarFront();
					akyc.clickOnAadhaarRetakeButtonFront();
					Thread.sleep(3000);
					akyc.captureAadhaarFront();
					akyc.clickOnAadhaarSubmitButtonFront();
					akyc.clickOnBack();
					Thread.sleep(3000);
					akyc.captureAadhaarBack();
					akyc.clickOnAadhaarRetakeButtonBack();
					Thread.sleep(3000);
					akyc.captureAadhaarBack();
					akyc.clickOnAadhaarSubmitButtonBack();
					akyc.clickOnAadhaarSubmitButton();
					Thread.sleep(2000);
					
					
					System.out.println("----------------------------------------------------------------------------------------------------------");
					
				}
				
				//Executing Verify_Address_11
				@Test(dependsOnMethods = "uploadAadhaar")
				public void verifyAddress() throws InterruptedException
				{
					System.out.println("___________________________________Verify_Address_PAGE(11)______________________________________________");
					isFAQiconDisplayed();
					isCloseIconDisplayed();
					isBackIconDisplayed();
					Verify_Address_11 va=new Verify_Address_11(driver);
					Thread.sleep(2000);
					va.enterAddressLine1();
					va.enterAddressLine2();
					va.enterYourPinCode();
					Thread.sleep(2000);
					va.clickOnSubmitButton();
					Thread.sleep(1000);
					va.clickOnCheckBox();
					Thread.sleep(2000);
					va.clickOnContinue();
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
					Thread.sleep(3000);
					al.clickOnViewLoanOffer();
					System.out.println("----------------------------------------------------------------------------------------------------------");
					
				}
				
				//Executing Youve_Got_A_Loan_Of_13
				@Test(dependsOnMethods = "loanEligibilityAcceptLoanOffer")
				public void youveGotALoanOf()
				{
					Youve_Got_A_Loan_Of_13 ygl=new Youve_Got_A_Loan_Of_13(driver);
					String amount=ygl.loanAmount();
					System.out.println(ygl.loanAmount());
					
					ygl.isArthanFinanceLogoDisplayed();
					
					String intrest=ygl.intrest();
					System.out.println(intrest.contains(intrest));
					
					
					
				}
}

		

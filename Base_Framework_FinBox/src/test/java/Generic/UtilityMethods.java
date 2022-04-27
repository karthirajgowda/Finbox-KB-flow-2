package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 


public class UtilityMethods {



	public WebDriver driver;	
	public static Sheet sheet;
	
	
	//Accept Alert
	public static  ChromeOptions acceptAlert()
	{
		 ChromeOptions options=new ChromeOptions();
			
			HashMap<String,Integer> contentSettings=new HashMap<String,Integer>();
			HashMap<String,Object> profile= new HashMap<String,Object>();
			HashMap<String,Object> prefs= new HashMap<String,Object>();
			
			contentSettings.put("media_stream", 1);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs",prefs); 
			
			return options ;
	}
	
	//loan amount 
	public String getloanamount(WebElement element)
	{
		String amount = element.getText();
		String lm = amount.substring(2, 8);
		return lm;
	}
	
	//Alert Text
		public void alertText()
		{
			System.out.println("Alert TEXT > "+ driver.switchTo().alert().getText());
		}
	
	
	//CLICK ON LIST OF WEBELEMENTS
	public void clickOnListOfWebelemnts(List<WebElement> element)
	{
		for (WebElement webElement : element) {
			webElement.click();
		}
		
	}
	
	//Slide
	public void slideTheBar(WebElement element ,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.dragAndDropBy(element, -200,0).build().perform();
	}
	
	//VERIFY AND CLICK
	public void verifyAndClick(WebElement element, String text) {
		boolean selected = element.isEnabled();
		System.out.println("******");
		if (selected==true) {
		System.out.println(text+" is ENABLED and CLICKED");
			clickAction(element);
		}
		else
		{
			System.out.println(text +"\n"+ " > ELEMENT IS NOT ENABLED      ----EXPECTED----");
		}

	}
	
	
	//TO CHECK ELEMENT IS SELECTED OR NOT
	public void isSelected(WebElement element, String text)
	{
		boolean selected = element.isSelected();
		if(selected==true)
		{
			System.out.println( text + "> selected");
		}
		else
		{
			System.out.println( text + "> Not selected(Error)");
		}
	}
	
	//TO CHECK ELEMENT IS DISPLAYED OR NOT
		public void isDisplayed(List<WebElement> element, String text)
		{
		
			 int size=element.size();
			 
			if(size==0)
			{
				System.out.println(text+" not displayed");
			}
			else
			{
				System.out.println(text+"is displayed");
			}	
		}
    
	//GET TITLE
	public void get_title() {
		String title= driver.getTitle();
		System.out.println(title);
	}
    
	//GET URL
	public void get_url() {		
		String CurrentURL=driver.getCurrentUrl();
		System.out.println(CurrentURL);
	}
	
	
	//CLEAR TEXT FIELD
	public void clearTextField(WebElement elementToClear)
	{
		elementToClear.clear();
	}
	
	
    //CLICK
	public void clickAction(WebElement element_To_Click) {
		element_To_Click.click();
	}
	
	
    //CLEAR AND ENTER VALUE
	public void clearAndEnterValue(WebElement TextField,String value) {		
		clearTextField(TextField);
		TextField.sendKeys(value);
	}
	
	//ENTER VALUE
	public void enterValue(WebElement TextField,String value) {		
			TextField.sendKeys(value);
		}
    
	//SELECT CLASS OBJECT
	public Select selectClassObject(WebElement DropDown){		
		Select select= new Select(DropDown);		
		return select;		
	}
	
	
   //ACTION CLASS OBJECT
	public Actions actionsClassObject(WebDriver driver) {		
		Actions action=new Actions(driver);
		return action;
	}
	
	//
	public void switchToASpecificTitledWindow(String title) { 
		String parentWindowId = driver.getWindowHandle(); 

		Set<String> allWindowIds = driver.getWindowHandles(); allWindowIds.remove(parentWindowId); 
		for(String windowId:allWindowIds){ driver.switchTo().window(windowId);
		if(driver.getTitle().equalsIgnoreCase(title)){ 
			break; 
		} 
		} 
	} 
	
	//
	public void switchToASpecificWindow(WebElement element) {

		String parent=driver.getWindowHandle(); 
		Set<String> allWid=driver.getWindowHandles(); 
		allWid.remove(parent); 
		for(String sessionID:allWid){ 
			driver.switchTo().window(sessionID);

			if(element.isDisplayed()){ 
				break; 
			} 
		} 
	}
	            
	
	//GETTING DATA FROM EXCEL SHEET
	public static Object[][] getExcelData(String Sheetname) throws Exception
	{
		File f=new File("./Test_Data/KhataBookData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fis);
	    Sheet sheet = book.getSheet(Sheetname);
	    int r = sheet.getPhysicalNumberOfRows();
		int c = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println(r);
		//System.out.println(c);
		
		Row row=sheet.getRow(0);
		short lr = row.getLastCellNum();
		//System.out.println(lr);

		Object[][] data=new Object[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<lr;j++)
			{
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=value;
				//System.out.println(value);
				
			}
		}
		return data;	
	}
}

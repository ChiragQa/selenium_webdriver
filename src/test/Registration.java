package stepDefination;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Registration {
	WebDriver driver;
	
	public String U_name="cucumber_10@localmail.com";
	public String U_Pass="auction@123";
	/*
	public void generateuniqNo(){

	DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
	Date dateobj = new Date();
	//String Str = (String)dateobj;
	//String sUniqNo=Str.replaceAll(/:,"");
	System.out.println(dateobj);
	}*/
	@Given("^User Open Browser$")
	public void user_Open_Browser(){

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Given("^Navigate to URL Domain$")
	public void navigate_to_Domain(){

		String sUrl = "https://nonpki1.abcprocure.com/EPROC/";
		driver.get(sUrl);
		
	}

	@Given("^User click on Bidder registration Page$")
	public void click_bidder_reg()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
		WebElement wRegistrationlink = driver.findElement(By.linkText("Register"));
		wRegistrationlink.click();
		
	}
	@Given("^User is on Registration Page\\.$")
	public void user_is_on_Registration_Page() 
	{
		String Exp_PageTitle="Bidder registration - bidder";
		String Act_PageTitle=driver.getTitle();
		if(Act_PageTitle == Exp_PageTitle)
		{
			System.out.println("Title Match And Bidder is on :"+Exp_PageTitle+" Page " );
		}else
		System.out.println("Bidder is on :"+Act_PageTitle+" Page " );

	}

	@When("^bidder Enter Email Id As \"([^\"]*)\"$")
	public void bidder_Enter_Email_Id_As(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmailId")));
		WebElement wEmailid=driver.findElement(By.id("txtEmailId"));
		wEmailid.sendKeys(email);
		wEmailid.sendKeys(Keys.TAB);

	}

	@Then("^System Validate with Message As \"([^\"]*)\"$")
	public void system_Validate_with_Message_As(String Validation) {
		WebElement Email_val_field=driver.findElement(By.id("verifyMail"));
		String Act_Email_val=Email_val_field.getText();
		
		if(Validation.equals(Act_Email_val))
		{
		System.out.println("Test case Passed and Validation Is :"+Act_Email_val);
		}else
		{
			System.out.println("Actual is:"+Act_Email_val);
			System.out.println("Expected is:"+Validation);
		}	
		driver.quit();
	    
	}


	@Then("^System Validate with Error Message As \"([^\"]*)\"$")
	public void system_Validate_with_Error_Message_As(String Validation) throws Throwable {
		WebElement Email_val_field=driver.findElement(By.className("errtxtEmailId"));
		String Act_Email_val=Email_val_field.getText();
		
		if(Validation.equals(Act_Email_val))
		{
		System.out.println("Actual And Expected Validation are Same and It is:"+Act_Email_val);
		}else
		{
			System.out.println("Actual is:"+Act_Email_val);
			System.out.println("Expected is:"+Validation);
		}	
		driver.quit();
	}
	@When("^bidder Register with Valid Detail$")
	public void Register_bidder()
	{
			
			
			// Bidder Registration page Element.
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmailId")));
			WebElement wEmailid=driver.findElement(By.id("txtEmailId"));
			WebElement wPass=driver.findElement(By.id("txtUserPassword"));
			WebElement wCon_pass=driver.findElement(By.id("txtConfirmPassword"));
			WebElement wHintQue=driver.findElement(By.id("selHintQue"));
			WebElement wHintans=driver.findElement(By.id("txtHintAns"));
			WebElement wPerson_name=driver.findElement(By.id("txtFullName"));
			WebElement wCom_name=driver.findElement(By.id("txtCompanyName"));
			WebElement wAddress=driver.findElement(By.id("txtaAddress"));
			WebElement wCountry=driver.findElement(By.id("selCountry"));
			WebElement wState=driver.findElement(By.id("selState"));
			WebElement wCity=driver.findElement(By.id("txtCity"));
			WebElement wMobileNo=driver.findElement(By.id("txtMobileNo"));
			WebElement wTimezone=driver.findElement(By.id("selTimezone"));
			WebElement wBus_keyword=driver.findElement(By.id("txtaBusCatKeywords"));
			WebElement wReg_type=driver.findElement(By.id("selgrouplst"));
			WebElement wPinNo=driver.findElement(By.id("txtFieldId431"));
			WebElement wPanNo=driver.findElement(By.id("txtFieldId432"));
			WebElement wTinNo=driver.findElement(By.id("txtFieldId433"));
			WebElement wIagreeCheck=driver.findElement(By.id("iAgree"));
			WebElement wsubmitBtn=driver.findElement(By.id("btnSubmit"));
		
			//Bidder Registration Page Action
			wEmailid.sendKeys(U_name);
			wPass.sendKeys(U_Pass);
			wCon_pass.sendKeys(U_Pass);
			new Select(wHintQue).selectByIndex(2);
			wHintans.sendKeys("Blue");
			wPerson_name.sendKeys("Cucumber Demo bidder");
			wCom_name.sendKeys("ETL - Cucumebr Demo Bidder");
			wAddress.sendKeys("Ellishbridge,Ahmedabad");
			new Select(wCountry).selectByValue("105");
			new Select(wState).selectByVisibleText("Gujarat");
			wCity.sendKeys("Ahmedabad");
			wMobileNo.sendKeys("7894561237");
			new Select(wTimezone).selectByIndex(42);
			wBus_keyword.sendKeys("ZMRSD");
			new Select(wReg_type).selectByIndex(1);
			wPinNo.sendKeys("ASDF123456");
			wTinNo.sendKeys("ASDF123456");
			wPanNo.sendKeys("CDM234535SDF");
			
			//Wait For Capcha
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='vericode' and contains(text(),'Valid')]")));
			
			wIagreeCheck.click();
			wsubmitBtn.click();
			
			String sReg_comp_msg="Your registration process is completed successfully.Please contact the concerned authority to get the approval on your profile.";
			WebElement wSuc_msgbody=driver.findElement(By.xpath("//*[@class='successMsg m-bottom']"));
			String sGetmsg=wSuc_msgbody.getText();
			System.out.println(sGetmsg);
						
			if(!sReg_comp_msg.equals(sGetmsg))
			{
				System.out.println("Bidder Registration is Pending");
				
				// Bidder Login For complete Registration
				WebElement wLoginlink = driver.findElement(By.linkText("Login"));
				wLoginlink.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
				
			   WebElement L_username=driver.findElement(By.id("j_username"));
			   WebElement L_Password=driver.findElement(By.id("j_password"));
			   WebElement L_submitbtn=driver.findElement(By.name("btnlogin"));
			   L_username.sendKeys(U_name);
			   L_Password.sendKeys(U_Pass);
			   L_submitbtn.click();
				
				// Upload Document Page
				String Uploaddoc_Act_title=driver.getTitle();
				String Uploaddoc_exp_title="Upload registration supporting document";
				   if(Uploaddoc_Act_title.equals(Uploaddoc_exp_title))
				   {
					//Complete Registration
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Upload')]")));
					WebElement complete_reg_btn=driver.findElement(By.xpath(".//button[contains(text(),'Complete Registration')]"));
					complete_reg_btn.submit();
					System.out.println("Document Upload Successfully");
				   }
				
			}
			
	}
	@Then("^Registration Complete with successful message$")
	public void registration_Complete_with_successful_message()
	{
		String sReg_comp_exp_msg="Your registration process is completed successfully.Please contact the concerned authority to get the approval on your profile.";
		WebElement wSuc_msgbody=driver.findElement(By.className("successMsg m-bottom"));
		String sReg_comp_act_msg=wSuc_msgbody.getText();
		
		if(sReg_comp_act_msg.equals(sReg_comp_exp_msg)) {
		System.out.println("Registration complete Successfully , Now login with Officer and Approve this Bidder");
	
		} 
	}
	@Given("^User click on Login Page$")
	public void user_click_on_Login_Page(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		WebElement wLoginlink = driver.findElement(By.linkText("Login"));
		wLoginlink.click();
	    
	}

	@When("^bidder Login with Username and Password\\.$")
	public void bidder_Login_with_Username_and_Password(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
		
	   WebElement L_username=driver.findElement(By.id("j_username"));
	   WebElement L_Password=driver.findElement(By.id("j_password"));
	   WebElement L_submitbtn=driver.findElement(By.name("btnlogin"));
	   L_username.sendKeys(U_name);
	   L_Password.sendKeys(U_Pass);
	   L_submitbtn.click();
	   
	}

	@Then("^Login successful and Redirecting to Homepage\\.$")
	public void loginsuccessful_and_Redirecting_to_Homepage(){
		String Exp_PageTitle="Search RFX/Tender";
		String Act_PageTitle=driver.getTitle();
		if(Act_PageTitle == Exp_PageTitle)
		{
			System.out.println("Title Match And Bidder is on :"+Exp_PageTitle+" Page " );
		}else
		System.out.println("Bidder is on :"+Act_PageTitle+" Page " );
	}
	

	
}

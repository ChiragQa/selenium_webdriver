package stepDefination;

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

public class Registration {
	WebDriver driver;
	
	
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
			WebDriverWait wait = new WebDriverWait(driver, 30);
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
			
			wEmailid.sendKeys("cucumber_2@localmail.com");
			wPass.sendKeys("auction@123");
			wCon_pass.sendKeys("auction@123");
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
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vericode")));
			
			wIagreeCheck.click();
			wsubmitBtn.click();
	}
	@Then("^Registration Complete with successful message\\.$")
	public void registration_Complete_with_successful_message()
	{
	    // Write code here that turns the phrase above into concrete actions
	}

	
}

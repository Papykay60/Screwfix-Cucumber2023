package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage{
	
	public loginPage(WebDriver driver)
	{
		super(driver);
		
	}

	
	@FindBy (id="email-existing")
	 WebElement txtyouremail;
	
	@FindBy (xpath="//input[@id='password-field']")
	WebElement txtpassword;
	
	@FindBy(id="sign-in-btn")
	WebElement btnSignin;
	
	@FindBy (id="email-existing")
	WebElement Cemail;
	
	@FindBy (xpath="//input[@id='password-field']")
	WebElement Cpassword;
	
	
	public  String Clearemail()
	{
		Cemail.clear();
		return null;
	}
	
	public String Clearpassword()
	{
		Cpassword.clear();
		return null;
	}
	
	
	public void Enteryouremail(String mail)
	{
		txtyouremail.sendKeys(mail);
	}
	
	
	public void Enterpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void Clicksignin()
	{
		btnSignin.click();
	}

	
	
}

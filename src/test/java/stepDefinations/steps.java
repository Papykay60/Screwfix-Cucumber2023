package stepDefinations;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import utilities.DataReader;




public class steps {
	
	WebDriver driver;
	Logger logger;
	ResourceBundle rb;
	myAccountPage mypg;
	
	String br;
	
	List<HashMap<String,String>> datamap;// Data driven
	
	
	  @Before
	  public void setup()    //Junit hook - executes once before starting
	    {
	        logger= LogManager.getLogger(this.getClass());
	        rb=ResourceBundle.getBundle("config");
	        br=rb.getString("browser");
	     
	    }


	  
	  @After
	  public void tearDown(Scenario scenario) {
	        System.out.println("Scenario status ======>"+scenario.getStatus());
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	       driver.quit();
	    }


@Given("user lunch the browser")
public void user_lunch_the_browser() {

	{
		
		//To launch browser
		if(br.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(br.equalsIgnoreCase("edge")) {
			
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}else if(br.equalsIgnoreCase("firefox ")){
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	    
	   
			
		
		
	}
			 
	
}

@Given("user open the application url{string}")
public void user_open_the_application_url(String url) {
	
	driver.get(url);
	driver.manage().window().maximize();
   
}


@Given("user navigate to your account menu")
public void user_navigate_to_your_account_menu() throws InterruptedException {
	homePage hp=new homePage(driver);
	hp.switchToFrameByElement();
	hp.DefaultContentiframe();
	
	Thread.sleep(2000);
	
	hp.Clickyouraccount();
	   
  
}

@When("user entered Email as {string} and Password as {string}")
public void user_entered_email_as_and_password_as(String email, String pwd) throws InterruptedException {
	loginPage lp=new loginPage(driver);
	 
	lp.Enteryouremail(email);
	 Thread.sleep(2000);
	lp.Enterpassword(pwd);
	
}

@When("user click on login button")
public void user_click_on_login_button() {
	loginPage lp=new loginPage(driver);
	lp.Clicksignin();
    
}

@Then("user navigate to successful signed in page")
public void user_navigate_to_successful_signed_in_page() {
   
    mypg=new myAccountPage(driver);
	boolean targetpage=mypg.IsMySuccessfulsigninExist();
	
	if(targetpage)
	{
	Assert.assertTrue(true);
	}
    
	else	
	{
     Assert.assertTrue(false);
	}
}




// Data driven using excel method



@Then("user navigate to your account page by passing Email and Password with excel row {string}")
public void user_navigate_to_your_account_page_by_passing_email_and_password_with_excel_data(String rows) throws InterruptedException {
  
	datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\SrewfixLogin_Data1.xlsx","Sheet1");
	
	int index=Integer.parseInt(rows)-1;
	String email=datamap.get(index).get("Uname");
	String pwd  =datamap.get(index).get("Pword");
	String Expected= datamap.get(index).get("Expected");
	
	loginPage lp=new loginPage(driver);
	 
	lp.Enteryouremail(email);
	 Thread.sleep(2000);
	lp.Enterpassword(pwd);
	lp.Clicksignin();
	
	   mypg=new myAccountPage(driver);
	   try {
		   
		    boolean targetpage=mypg.IsMySuccessfulsigninExist();
		    System.out.println("targetpage: "+ targetpage);
		
		    if(Expected.equals("valid"))
		    {
		    
		      if(targetpage==true)
		      {	  
		    	 myAccountPage  mypg=new myAccountPage(driver); 
		    	 mypg.ClicktxtyourAcct();
			     mypg.ClickLogOutbtn();
		    	 Assert.assertTrue(true);
		      }
		      else
		      {
		    	  Assert.assertFalse(false);
		      }
		    
		    if(Expected.equals("invalid"))
		    	
		    	if(targetpage==true)
		    	{
		    		mypg.ClicktxtyourAcct();
			        mypg.ClickLogOutbtn();
		    		Assert.assertFalse(false);
		    	}
		    	else
		    	{
		    		Assert.assertTrue(true);
		    	}
		    }  
		    
	   } 
	   catch(Exception e)
	   {
		   Assert.assertTrue(false);
		   
	   }
		
	   driver.quit();
		    
		    
}

}
		    
		    
		    
		    
		    

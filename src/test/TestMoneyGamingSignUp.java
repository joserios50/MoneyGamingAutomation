package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageFactory.MoneyGamingHome;
import pageFactory.MoneyGamingSignUp;
import pageFactory.MoneyGamingSignUpWithErrors;

public class TestMoneyGamingSignUp {
	// Current directory
	String userDir=System.getProperty("user.dir");

	// Web Driver
	String driverPath = userDir+"\\driver\\chromedriver.exe";
    WebDriver driver;

    // Pages
    MoneyGamingHome MoneyGamingHomePage;
    MoneyGamingSignUp MoneyGamingSignUpPage;
    MoneyGamingSignUpWithErrors MoneyGamingSignUpWithErrorsPage;
    
    @Before
    public void setUp(){

    	// Init Web Driver
        System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to base URL
        driver.get("https://moneygaming.qa.gameaccount.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
      //driver.quit();
    }

    @Test
    public void dobIsRequiredMessageWhenDobIsMissing(){

      // Create Home Page
      MoneyGamingHomePage = new MoneyGamingHome(driver);
      
      // Select Join Now (New User) to go to the Sign Up page
      MoneyGamingHomePage.clickNewUserBtn();
      
      // Create Sign Up Page
      MoneyGamingSignUpPage = new MoneyGamingSignUp(driver);
      
      // Fill out form
      MoneyGamingSignUpPage.selectTitle("Mr");
      MoneyGamingSignUpPage.setFirstName("Jose");
      MoneyGamingSignUpPage.setLastName("Rios");
      MoneyGamingSignUpPage.clickAccept();
      MoneyGamingSignUpPage.clickSubmitForm();
      
      // Create Sign Up With Errors Page
      MoneyGamingSignUpWithErrorsPage = new MoneyGamingSignUpWithErrors(driver);    
      
      // Verification
      String expectedResult = "This field is required";
      String actualResult = MoneyGamingSignUpWithErrorsPage.getDobError();

      assertEquals(expectedResult, actualResult); 

    }
 
}

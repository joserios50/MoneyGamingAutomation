package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyGamingSignUpWithErrors {

	// Web Driver and Elements
	WebDriver driver;

	// Date of Birth Error label
	@FindBy(xpath="//form[@id=\'signupForm\']/fieldset/label[@for=\'dob\']")
	WebElement dobErrorLbl;
	
    public MoneyGamingSignUpWithErrors(WebDriver driver){

        this.driver = driver;

        // Create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    // Get Date Of Birth Error label
    public String getDobError(){
    	return dobErrorLbl.getText();
    } 
    
}	
	
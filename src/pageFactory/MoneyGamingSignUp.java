package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyGamingSignUp {

	// Web Driver and Elements
	WebDriver driver;

	// Title drop-down list
	@FindBy(id="title")
	WebElement titleDdl;
	
	// First Name
	@FindBy(id="forename")
	WebElement foreName;

	// Last Name
	@FindBy(name="map(lastName)")
	WebElement lastName;
	
	// Accept Terms and Conditions checkbox
	@FindBy(className="terms")
	WebElement acceptCbox;

	// Submit Form button
	@FindBy(id="form")
	WebElement submitFormBtn;
	
    public MoneyGamingSignUp(WebDriver driver){

        this.driver = driver;

        // Create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Select on Title drop-down
    public void selectTitle(String option){
    	titleDdl.findElement(By.xpath("//option[. = '"+option+"']")).click();
    } 
    
    // Set First Name
    public void setFirstName(String firstNameStr){
    	foreName.sendKeys(firstNameStr);     
    }
    
    // Set Last Name
    public void setLastName(String lastNameStr){
    	lastName.sendKeys(lastNameStr);     
    }  
    
    // Select Accept Terms and Conditions checkbox
    public void clickAccept(){
    	acceptCbox.click();
    } 
    
    // Select Submit Form button
    public void clickSubmitForm(){
    	submitFormBtn.click();
    } 
}

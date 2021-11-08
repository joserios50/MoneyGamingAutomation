package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyGamingHome {

	// Web Driver and Elements
	WebDriver driver;

	// Join Now button
    @FindBy(className="newUser")
    WebElement newUserBtn;

    public MoneyGamingHome(WebDriver driver){

        this.driver = driver;

        // Create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Click on Join Now button
    public void clickNewUserBtn(){
    	newUserBtn.click();
    } 
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email")
	WebElement email_field;
	
	@FindBy(id = "pass")
	WebElement password_field;
	
	@FindBy(name = "login")
	WebElement login_button;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")
	WebElement create_new_account_button;
	
	public void Login(String user_email , String user_password)
    {
        email_field.sendKeys(user_email);
        password_field.sendKeys(user_password);
        login_button.click();
    }
	
	public void CreateNewAccount() {
		create_new_account_button.click();
	}

}

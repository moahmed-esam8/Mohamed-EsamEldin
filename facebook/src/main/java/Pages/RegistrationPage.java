package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(name = "lastname")
	WebElement surname;
	
	@FindBy(name = "reg_email__")
	WebElement email_address;
	
	@FindBy(name = "reg_email_confirmation__")
	WebElement confirmation_email_Address;
	
	@FindBy(name = "reg_passwd__")
	WebElement password;

	@FindBy(id = "day")
	WebElement day;
	
	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input")
	WebElement gender;
	
	@FindBy(name = "websubmit")
	WebElement sign_up_button;
	
	public void RegisterNewAccount(String user_firstname , String user_lastname 
			, String  user_email , String  confirm_email , String user_password) {
		
		firstname.sendKeys(user_firstname);
		surname.sendKeys(user_lastname);
		email_address.sendKeys(user_email);
		confirmation_email_Address.sendKeys(confirm_email);
		password.sendKeys(user_password);
		Select select_day = new Select(day);
		select_day.selectByIndex(5);
		Select select_month = new Select(month);
		select_month.selectByIndex(5);
		Select select_year = new Select(year);
		select_year.selectByIndex(25);
		gender.click();
		sign_up_button.click();
	}
}

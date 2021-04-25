package Tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.RegistrationPage;

public class RegistrationTest extends TestBase {
	
	HomePage homepage;
	RegistrationPage register;
	
	Faker fakedata = new Faker();
    String firstname = fakedata.name().firstName();
    String lastname = fakedata.name().lastName();
    String email = fakedata.internet().emailAddress();
    String password = fakedata.number().digits(8);

	@Test(priority = 1)
	public void OpenRegistrationForm() {

		homepage = new HomePage(driver);
		homepage.CreateNewAccount();
		
	}
	@Test(priority = 2, dependsOnMethods = "OpenRegistrationForm")
	public void CreateNewUser() {
		register = new RegistrationPage(driver);
		register.RegisterNewAccount(firstname, 
				lastname, email, email , password);
	}
}

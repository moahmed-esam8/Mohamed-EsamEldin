package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import TestData.DataReaderFromExcel;

public class LoginTest extends TestBase{
	
	HomePage homepage;
	
	@DataProvider(name = "data")
	public Object[][] Get_TestData () throws IOException
	{
		DataReaderFromExcel obj = new DataReaderFromExcel();
		return obj.GetDataFromExcel();
	}
	
	@Test(priority = 1 , dataProvider = "data")
	public void UserLogin(String email , String password) throws InterruptedException {

		homepage = new HomePage(driver);
		Thread.sleep(2000);
		homepage.Login(email, password);
		
	}

}

package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	String url = "https://www.facebook.com/";

	@BeforeTest
	@Parameters({ "browser" })
	public void StartDriver(@Optional("chrome") String browsername) {
		if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void StopDriver() {
		// driver.quit();
	}

	@AfterMethod
	public void TakeScreenShotOnFail(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test case failed");
			System.out.println("Taking Screenshot .......");
			Helper.Help.takescreenshot(driver, result.getName());
		}
	}

}
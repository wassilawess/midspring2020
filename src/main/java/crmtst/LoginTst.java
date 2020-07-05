package crmtst;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTst {
	
	WebDriver driver;
	String browser = null;

	public void readCinfig() {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("./src/main/java/config/config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used: " + browser);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	
	@BeforeMethod
	public void init() {

		String browser = "firefox";

		if (browser.equalsIgnoreCase("chrome")) {

			// setting up the property
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

			// creating web driver instance
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			// setting up the property
			System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");

			// creating web driver instance
			driver = new FirefoxDriver();

		}

		// maximizing browser
		driver.manage().window().maximize();

		// get to the site
		driver.get("http://techfios.com/ibilling/?ng=admin/");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	
	
	
	@Test
	public void loginTest() throws InterruptedException {

		// element library

		By USER_FIELD_LOCATOR = By.id("username");
		By PASSWORD_FIELD_LOCATOR = By.id("password");
		By SIGNIN_BUTTON_LOCATOR = By.name("login");
		By DASHBOARD_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Dashboard')]");

		// Data
		String loginID = "demo@techfios.com";
		String password = "abc123";

		driver.findElement(USER_FIELD_LOCATOR).sendKeys(loginID);
		driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_LOCATOR).click();

		Thread.sleep(2000);

		waitForElement(driver, 3, DASHBOARD_BUTTON_LOCATOR);

		String DASHBOARD_VALIDATION_TEST = driver.findElement(DASHBOARD_BUTTON_LOCATOR).getText();
		Assert.assertEquals("Dashboard", DASHBOARD_VALIDATION_TEST, "wrong page!");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public void waitForElement(WebDriver driver, int TimeInSeconds, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, TimeInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

}

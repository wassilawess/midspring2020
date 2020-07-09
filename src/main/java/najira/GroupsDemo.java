package najira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupsDemo {
	WebDriver driver;
	// xmlGroups(BeforeMethod , BeforeTest , AfterMethod, AfterTest Not working here!figureOut???)
	@Test(groups = { "correct" })
	
	public void correctLogin() {
		System.out.println("correctLogin");

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

		By USERNAME_lOCATOR = (By.id("username"));
		driver.findElement(USERNAME_lOCATOR).sendKeys("demo@techfios.com");

		By PASSWORD_LOCATOR = By.id("password");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");

		driver.findElement(By.name("login")).click();

		driver.close();
	}

	@Test(groups = { "correct" })
	public void correctLogin2() {
		System.out.println("correctLogin2");

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		PASSWORD_ELEMENT.sendKeys("abc123");

		driver.findElement(By.name("login")).click();

		driver.close();
	}

	@Test(groups = { "inCorrect" })
	public void incorrectUserName() {
		System.out.println("incorrectUserName");

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demon@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		PASSWORD_ELEMENT.sendKeys("abc123");

		driver.findElement(By.name("login")).click();
		driver.close();
	}

	@Test(groups = { "inCorrect" })
	public void incorrectPassword() {
		System.out.println("incorrectPassword");

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		PASSWORD_ELEMENT.sendKeys("abc12345");

		driver.findElement(By.name("login")).click();
		driver.close();
	}

}

package zlistenerextentproject.zlistenerextentproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(zlistenerextentproject.zlistenerextentproject.ExtentReportManager.class)
public class NewTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		// Thread.sleep(3000);
	}

	@Test
	public void testLogo() {
		boolean status = driver.findElement(By.xpath("//*[@id='nava']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test(priority = 2)
	public void verifyelements() throws InterruptedException {
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		Thread.sleep(2222);

		boolean usernameexists = driver
				.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[2]/form/div[1]/label")).isDisplayed();
		System.out.println(usernameexists);
		Assert.assertEquals(usernameexists, true);
		boolean PasswordExists = driver
				.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[2]/form/div[2]/label")).isDisplayed();
		Assert.assertEquals(PasswordExists, true);
	}

	@AfterMethod
	public void closesetup() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://www.demoblaze.com/");
		driver.quit();
	}

}

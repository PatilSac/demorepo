package GITPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArshiTestClasses {
	@Test
	public void AutoCompleteProgram() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Drivers\\Chrome Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println("URL entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Entering text in the google search
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("my");

		// explicit wait - to wait for the Google button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='gLFyf gsfi']")));

		// getting the list of elements
		List<WebElement> totalitems = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		System.out.println("total size" + totalitems);

		// getting the total size to iterate
		int size = totalitems.size();

		// iterating the loop to find the searched text
		for (int i = 1; i < size; i++) {
			String item = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span")).getText();
			// checking each text and comparing it with searched text
			if (item.equals("myntra")) {
				// clicking on the searched text
				driver.findElement(By.xpath("//ul[@class='erkvQe']/li[" + i + "]//span")).click();
				System.out.println("Clicked on Myntra");
			}
			break;
		}

		// clicking on the searched text link
		driver.findElement(By.xpath("//cite[@class='UdQCqe']")).click();

		// testing the logo of the website to verify if it is a correct website
		boolean Logopresent = driver.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-logo']"))
				.isDisplayed();
		System.out.println("Logo is present : " + Logopresent);
		Assert.assertTrue(Logopresent);
		driver.close();
	}

}

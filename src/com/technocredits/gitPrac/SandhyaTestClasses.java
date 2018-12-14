package gitPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SandhyaTestClasses {
	@Test
	public void autoCompleteDemo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("browser launch successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		System.out.println("Google page loaded");
		
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		System.out.println("search field located");
		searchField.click();
		System.out.println("Cliked on search field of the google page");
		
		searchField.sendKeys("am");
		System.out.println("send am to the search field");
		
		
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		int listSize = suggestedList.size();
		System.out.println("get size of the displayed list");
		System.out.println("listSize is: "+listSize);
		
		for(int i = 1; i<=listSize; i++) {
			System.out.println("into For loop");
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("suggestedValue: "+suggestedValue);
			if(suggestedValue.equals("amazon")) {
				System.out.println("if suggested value is equals to amazon then click on it");
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("Clicked on amazon");
				break;
			}
		}
		
		
	}
}

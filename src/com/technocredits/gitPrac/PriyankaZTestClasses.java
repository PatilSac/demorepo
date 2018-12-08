package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PriyankaZTestClasses {
	@Test
	public void verifyAutoCompleteFunctionality() {
		System.setProperty("webdriver.chrome.driver", "D:\\TECHNO_CREDITS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Browser launch successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");
		System.out.println("Successfully navigation to URL");

		WebElement searchBoxInput = driver.findElement(By.name("q"));
		searchBoxInput.sendKeys("am");
		System.out.println("Entered text");

		List<WebElement> autoSuggestionList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		int listSize = autoSuggestionList.size();
		System.out.println("List size is: " + listSize);

		for (int i = 1; i <= listSize; i++) {
			WebElement optionEle = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"));
			String option = optionEle.getText();
			System.out.println("Option is:" + option);
			if (option.equals("amazon")) {
				optionEle.click();
				System.out.println("Clicked on expected option");
				break;
			}
		}

		driver.findElement(By.cssSelector("div[id='rcnt']")).isDisplayed();
		System.out.println("amazon search list displayed successfully.");

		driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();
		System.out.println("Clicked on Amazon link.");

		driver.close();
	}
}

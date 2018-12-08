package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoCompleteAmazon {
	@Test
	public void AutoCompleteFunctionality() {
		 //Launching the browser
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Browser launch successfully");

		driver.manage().window().maximize();//maximize the browser
		driver.manage().deleteAllCookies();//delete cache of browser
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //will wait 30 secs to load the page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//will wait after action to complete.
		driver.get("https://www.google.com");//open google.com

		System.out.println("Navigate URL");

		//Text enter in google search box
		driver.findElement(By.name("q")).sendKeys("am");

		System.out.println("Text entered");

		//size of List displayed after searching am in google text box
		List<WebElement> autoSuggestionList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		int listSize = autoSuggestionList.size();

		System.out.println("Number of options in the list are: " + listSize);

		//iterating the loop to search expected result
		for (int i = 1; i <= listSize; i++) {
			
			WebElement optionElement = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"));
			String option = optionElement.getText();
			System.out.println("Option is:" + option);
			if (option.equals("amazon")) {
				optionElement.click();
				System.out.println("Expected option selected");
				break;
			}
		}
		
		
		driver.findElement(By.cssSelector("div[id='rcnt']")).isDisplayed();
		System.out.println("Search list displayed for Amazon");
		
		//open expected result
		driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();
		System.out.println("Open Amazon");
		
		driver.close();
	}

}

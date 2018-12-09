package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KalyaniTestAutocomplete {
	@Test
	public void autocompleteCode() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("GoogleChrome Browser is launched");

		// implicit wait of 15 seconds will be applied while finding each element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");
		System.out.println("GoogleChrome Browser is launched with the expected url");

		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("clicked on searchfield");

		searchField.sendKeys("fl");
		System.out.println("fl has been enetered in search field");
		
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		int suggestedListSize = suggestedList.size();
		
		System.out.println("suggestedListSize is: " + suggestedListSize);
		
		for (int i = 1; i <= suggestedListSize; i++) {
			System.out.println("We have entered in for loop when i = " + i);
			String suggestedWord = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]")).getText();
			System.out.println(i + "no. SuggestedWord is " + suggestedWord);

			if (suggestedWord.equals("flex")) {
				System.out.println("We have enetered in if condition as we have got the expected word");
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]")).click();
				System.out.println("Clicked on the expected searched word");
				break;
			}
		}

	}

}

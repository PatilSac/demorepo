package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NileshTestClass {

	@Test
	public void autoCompleteDemo() throws InterruptedException {

		// Set Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver",
				"E:\\Technocredits Class\\Selenium Jar\\Chrome Driver JAR\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Wait is define 
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;

		// Hit URL
		driver.get("https://www.google.co.in/");
		System.out.println("On Goolgle page");

		// Find Search box on google page
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");

		// Entered string in search box
		searchField.sendKeys("am");
		System.out.println("Entered text");
		//Thread.sleep(3000);

		// Store all Web element in List
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));

		// Print Size of Web Element in List
		int listSize = suggestedList.size();
		System.out.println("listSize: " + listSize);
		//Thread.sleep(2000);

		// For Loop to select value Amazon from list
		for (int i = 1; i <= listSize; i++) {
			System.out.println("For loop");
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"))
					.getText();
			System.out.println("suggestedValue: " + suggestedValue);
			if (suggestedValue.equals("amazon")) {
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span")).click();
				System.out.println("Clicked on result");
				break;
			}
		}

		// Click on Amazon Link
		driver.findElement(By.xpath(".//a[@id='vn1s0p1c0']")).click();

		// Get the Page title
		String Title = driver.getTitle();

		System.out.println("Page Title is : " + Title);

		// Assert page title.
		Assert.assertEquals(Title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

		// Close Window.
		driver.close();

	}

}

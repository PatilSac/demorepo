package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class anjaniTestClass {
	
	@Test
	public void autoCompleteDemo() throws InterruptedException {
		/*Launching browser*/
		WebDriver driver = new FirefoxDriver();
		System.out.println("Browser launched");
		
		/*Using wait for the life of the WebDriver object instance*/
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Driver is waiting...");
		
		/*Opening URL in browser*/
		driver.get("https://www.google.co.in/");
		System.out.println("Opened Google page");
		
		/*Locating search field and assigning it to a WebElement*/
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		System.out.println("Located search field");
		
		/*Clicking on search field*/
		searchField.click();
		System.out.println("Cliked on search field");
		
		/*Sending search input to search field*/
		searchField.sendKeys("am");
		System.out.println("Entered search input");
		
		/*Finding the list of WebElements*/
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		System.out.println("List of WebElements found");
		
		/*Assigning the size of WebElements list to integer type variable*/
		int listSize = suggestedList.size();
		System.out.println("listSize: "+listSize);
		
		/*Running a for loop through the WebElements list*/
		for(int i = 1; i<=listSize; i++) {
			System.out.println("Running a for loop through the WebElements list");
			
			/*Locating every item from the list and assigning to a String variable*/
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("suggestedValue: "+suggestedValue);
			
			/*Checking if the suggestedValue is equal to text amazon*/
			if(suggestedValue.equals("amazon")) {
				System.out.println("Checking if the suggestedValue is equal to text amazon");
				
				/*Locating and clicking the value matching suggestedValue*/
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("Clicked on result");
				
				/*Breaking the loop if the matching value is searched*/
				break;
			}
		}
		
		
	}

}

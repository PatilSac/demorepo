package com.technocredits.gitPrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KrishnaTestClasses {
	
	@Test
	public void autoCompleteDemo() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		System.out.println("On Goolgle page");
		
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");
		
		searchField.sendKeys("am");
		System.out.println("Entered text");
		Thread.sleep(3000);
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		int listSize = suggestedList.size();
		System.out.println("listSize: "+listSize);
		Thread.sleep(2000);
		for(int i = 1; i<=listSize; i++) {
			System.out.println("For loop");
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("suggestedValue: "+suggestedValue);
			if(suggestedValue.equals("amazon")) {
				System.out.println("If");
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("Clicked on result");
				break;
			}
		}
		
		
	}

}

package com.technocredits.gitPrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class AutoCompleteNikhil 
{
	public void autoComplete () throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		System.out.println("Going to Google");
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		searchBox.sendKeys("ame");
		System.out.println("Entered search value...");
		
		Thread.sleep(3000);
		
		List<WebElement> suggested = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		int suggestedSize = suggested.size();
		
		System.out.println("Suggestion List size is: " +suggestedSize);
		
		for (int i=1; i<=suggestedSize; i++)
		{
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("Suggested Value: " +suggestedValue);
			
			if (suggestedValue.equals("american express"))
			{
				System.out.println("in IF");
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("clicked AMEX");
				break;
			}
		}
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//cite[@class='iUh30']")).click();
		System.out.println("Clicked AMEX link");
		Thread.sleep(5000);
		
		if (driver.getTitle().equals("American Express India | Log in | Credit Cards, Travel & Rewards"))
			System.out.println("Reached correct website!");	
		
		Thread.sleep(3000);
		driver.close();
		System.out.println("Exiting the browser!");
	}
	
}

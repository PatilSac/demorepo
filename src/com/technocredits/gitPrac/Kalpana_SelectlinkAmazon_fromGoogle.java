package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Kalpana_SelectlinkAmazon_fromGoogle

{

	@Test
	public void selectlinkAmazon_fromGoogle() throws InterruptedException {
		// set properties after firefox version 46
		System.setProperty("webdriver.gecko.driver", "C:\\Firefox gecko_v023\\geckodriver.exe");
	
		//to open browser create object
		WebDriver driver = new FirefoxDriver();
		
		//Open Googel.com using object
		driver.get("https://www.google.com/");
		System.out.println("Google page opned");
		
		// implicit wait for element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// find a element for search text
		
		
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");
		
		// type initial characters of amazon
		searchField.sendKeys("am");
		System.out.println("Entered text 'am'");
		// find a element for suggested items in search and save it in list to get size later on

		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		
		//find the size of list
		int sizeofList = suggestedList.size();
		System.out.println("listSize: "+sizeofList);
	
		
		// iterate for loop till list size
		for(int i = 1; i<=sizeofList; i++)
		{
			System.out.println("enter into For loop to search extact match");
			
			// get the element text of each span match with our text 
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("showing all suggestedValue: "+suggestedValue);
			
			// to find exact match find the text in each span and if found go to if loop and break the program saying match is found
			if(suggestedValue.equals("amazon"))
			{
				// if matched then click on that link and break it 
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("Extact Match found please click on it");
				break;
			}
		}
		// close the driver after clicking on the appropriate match
		driver.close();
	
}
		
	

}

package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JeevikaTestClasses {
	static WebDriver driver;
	
		@Test
		public void autoCompleteSession() throws InterruptedException {
					//calling start function to open google page
			start("https://www.google.co.in/");
			
			System.out.println("Navigation completed to Google page");
			
					//sending test to search box
			driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("am");
			
	 		System.out.println("am entered in search box");
	 		
	 				//Fetching List size in variable suggestionlistSize ,displayed after entering 'am' test in search box
	 		int suggestionlistSize = driver.findElements(By.xpath("//ul[@role='listbox']//li//span")).size();
	 		System.out.println("No of Suggestions available with test 'am' is-" + suggestionlistSize);
	 		
	 				//For Loop for iterating all elements present in search box
			for (int i = 1; i <= suggestionlistSize; i++) 
			{
				String SuggestedOption = driver.findElement(By.xpath("//ul[@role='listbox']//li[" + i + "]//span")).getText();
				System.out.println("Sugeested Option is:" + SuggestedOption);
				
				  		//Verifying if Suggested Option matching with 'amazon' ,which is Target SIte
				if (SuggestedOption.equals("amazon")) 
				{
						//When Suggested Option matches with Amazon,click on test link
					driver.findElement(By.xpath("//ul[@role='listbox']//li[" + i + "]//span")).click();
					System.out.println("Selected option Amazon");
					break;
				}
			}
			
					//Click the Amazon website link ,Once Amazon related Links are displayed after clicking on Amamzon
			driver.findElement(By.xpath("//h3[@style='display:inline-block']")).click();
			System.out.println("On the Amazon WebSite");
			
					//Verifying if the Amazon page is opened
			if(driver.findElement(By.xpath("//div[@id='nav-logo']")).isDisplayed())
			System.out.println("Test Case Pass!");
			else
			System.out.println("Test Case Failed!");			
			
					//Closing the Driver
			driver.close();
			
		}
		
		public static WebDriver start(String url)
		{
					//setting path for Chrome driver
			System.setProperty("webdriver.chrome.driver","G:\\Softwares\\chromedriver.exe");
					//Creating Chrome Object
			driver = new ChromeDriver();
			driver.get(url);
					//Maximize browser window
			driver.manage().window().maximize();
					//Applying wait 
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
		}

	

}

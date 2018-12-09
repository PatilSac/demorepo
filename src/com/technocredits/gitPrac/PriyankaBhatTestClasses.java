package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriyankaBhatTestClasses {
	private String searchText = "Amazon";
	private WebDriver driver;

	
	@Test
	//This method will click the search text from autocomplete suggestion list 
	public void autocomplete() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Browser Launched");
		driver.get("https://www.google.com/");
		System.out.println("URL opened");
		//Added wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Send keys to search field
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("am");
		System.out.println("am sent on search field");
		//Autosuggestion list for the searchtext
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		System.out.println("Suggestion list-----");
		for (WebElement option : optionsToSelect) {
			//Print suggested list
			System.out.println(option.getText());
			
			if (option.getText().equalsIgnoreCase(searchText)) {
				System.out.println("Trying to select: " + searchText);
				//Click on the searchtext if available
				option.click();
				System.out.println("Clicked on " + searchText);
				break;
			}

		}
	}
	@Test(dependsOnMethods= {"autocomplete"})
	//This method will verify the title of Amazon page
	public void verifyTitle()
	{
		String expTitle="amazon - Google Search";
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("Titles matched");
		
	}
}

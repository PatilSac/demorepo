package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HarikaTest {
    
	//Enter partial text in google search kk engine and select "selenium webdriver" option from auto populated list.
	@Test
	public void AutoComplete()
	{   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARIKA\\Desktop\\TechnoCredits_JavaProgram\\softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Navigate to google page and enter selenium in search text box
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		List<WebElement> autoCompeteListOptions = driver.findElements(By.xpath("//ul[@class='erkvQe']//child::li"));
		//iterate through the list of all the elements which are auto-populated
		for(WebElement element:autoCompeteListOptions )
		{   
			//if the text is matched while iterating, then select it and validate the title of the new page.
			if(element.getText().equals("selenium webdriver"))
			{   
				String elementText = element.getText();
				element.click();
				System.out.println(elementText + " was selected from the options.");	
				break;
			}	
		}
		//Validate the title of the new page
		Assert.assertEquals(driver.getTitle(), "selenium webdriver - Google Search");
		System.out.println("Required option was selected from auto-populate and opened successfully");
		driver.close();
		
	}
}

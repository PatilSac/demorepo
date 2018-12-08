package com.technocredits.gitPrac;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTestSachin {
	private WebDriver driver;
	@Test
	public void flip() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Downloads\\Compressed\\chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Browser lunch successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");
		
		searchField.sendKeys("flipkart");
		searchField.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		List<WebElement> suggestedList = driver.findElements(By.xpath("//*[@class='LC20lb']"));
		int listSize = suggestedList.size();
		System.out.println("listSize: "+listSize);
		Thread.sleep(2000);
		for(int i = 1; i<=listSize; i++) 
		{
			
			String suggestedValue = driver.findElement(By.xpath("//*[@class='LC20lb']")).getText();
			System.out.println("suggestedValue: "+suggestedValue);
			if(suggestedValue.equals("Flipkart")) 
			{
				driver.findElement(By.xpath("//*[@class='LC20lb']")).click();
				System.out.println("Clicked on result");
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
			WebElement e = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		
		Assert.assertEquals(e.isDisplayed(), true);
		

}
}

package com.technocredits.gitPrac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTestSachin {
	private WebDriver driver;
	@Test
	public void flip() throws InterruptedException 
	{
		
		//Set chromedriver location and launching google.com in chrome browser
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Downloads\\Compressed\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Browser lunch successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		//Find search field and clicking on it
		
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");
		
		//Enter text flipkart in search box
		searchField.sendKeys("flipkart");
		
		//Wait for autocomplete box
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='aajZCb']")));
		
		//Find correct option from autocomplete box and click on it.
		int x = driver.findElements(By.xpath("//div[@class='sbl1']/span")).size();
		for(int j =1; j<x; j++)
		{
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+j+"]//div//div//span")).getText();
			System.out.println(suggestedValue);
			if(suggestedValue.equals("flipkart"))
			{
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+j+"]//div//div//span")).click();
				break;
			}
		}
		
		//Find correct website from the google search result
		List<WebElement> suggestedList = driver.findElements(By.xpath("//*[@class='LC20lb']"));
		int listSize = suggestedList.size();
		System.out.println("listSize: "+listSize);
		Thread.sleep(2000);
		for(int i = 1; i<=listSize; i++) 
		{
			//Get text of every option in search result
			String suggestedValue = driver.findElement(By.xpath("//*[@class='LC20lb']")).getText();
			System.out.println("suggestedValue: "+suggestedValue);
			if(suggestedValue.equals("Flipkart")) 
			{
				driver.findElement(By.xpath("//*[@class='LC20lb']")).click();
				System.out.println("Clicked on result");
				break;
			}
		}
		
		
		// Close user login frame on Flipkart
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		// Identify unique text from the Flipkart website
		WebElement e = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		
		//Assert for test
		Assert.assertEquals(e.isDisplayed(), true);
		
		//Browser-driver close
		driver.quit();

}
}

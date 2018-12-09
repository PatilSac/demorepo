package com.technocredits.gitPrac;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ayushtestclass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("launch browser");
		//maximize	
		driver.manage().window().maximize();
		//deleting cookies
		driver.manage().deleteAllCookies();
		//waiting for page to load
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//opening google chrome
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("am");
		System.out.println("two alphabet entered ");
		
		//finding the size of list
		int listsize = driver.findElements(By.xpath("//ul[@class='erkvQe']/li//span")).size();
		
		System.out.println(listsize);
		//printing the size\
		for(int i=1;i<=listsize;i++)
		{
		WebElement element_name = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"));
			//WebElement element_name = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"));
			String name =  element_name.getText();
			System.out.println(name);
			if(name.equals("amazon prime"));
			element_name.click();
			System.out.println("amazon opened ");
		}
		//hitting on amazon url
		driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();
		String hometext = driver.findElement(By.xpath("//div[@id='nav-logo']")).getText();
		//verifying home page amazon.in
		if(hometext.equals("amazon.in"))
			System.out.println("verified home page");
		else 
			System.out.println("not verified");
		
	
	}

}

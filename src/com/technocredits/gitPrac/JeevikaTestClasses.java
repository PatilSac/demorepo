package com.technocredits.gitPrac;



import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JeevikaTestClasses {
	static WebDriver driver;
	
		public void autoCompleteSessionAmazon() throws InterruptedException {
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
		
		
		
		
		
		public static void getClass(String classname)
		{
			
			if(classname.equals("Economy"))
				driver.findElement(By.xpath("//option[@value='E']")).click();
			
			else if(classname.equals("Business"))
				driver.findElement(By.xpath("//option[@value='B']")).click();
			
			else if(classname.equals("First class"))
				driver.findElement(By.xpath("//option[@value='F']")).click();
			
			else if(classname.equals("Premium Economy"))
				driver.findElement(By.xpath("//option[@value='W']")).click();
		}
		
		
		
		
	
		public static void dateSelectorHelper(int year,int month,int day)
		{
			if(month<10 && day<10)
				driver.findElement(By.xpath("//div[@id='fare_"+year+"0"+month+"0"+day+"']")).click();
			else if(month>=10 && day<10)
				driver.findElement(By.xpath("//div[@id='fare_"+year+month+"0"+day+"']")).click();
			else if(month<10 && day>=10)
				driver.findElement(By.xpath("//div[@id='fare_"+year+"0"+month+day+"']")).click();
			else
				driver.findElement(By.xpath("//div[@id='fare_"+year+month+day+"']")).click();
		}
		
		
		
		
		public static void clickOnDepartDate(int year,int month,int day) throws InterruptedException
		{			
			LocalDate startdate = LocalDate.of(year,month,day);
		     LocalDate currentDate = LocalDate.now();
		     long diffInMonths = ChronoUnit.MONTHS.between(currentDate,startdate );
		     System.out.println("diffInMonths"+diffInMonths);
			
			if(diffInMonths>1)
			{
				for(int i=2;i<=diffInMonths;i++)
				{
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				}
				dateSelectorHelper(year, month, day);
			}
			else
			{	
				dateSelectorHelper(year, month, day);
			}
		}
		
		
		
		
		
		public static void clickOnReturnDate(int year,int month,int day) throws InterruptedException
		{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				dateSelectorHelper(year, month, day);
		}

		
			
		@Test
		public void goibiboAutoComplete() throws InterruptedException 
		{
			//calling start function to open Goibibo page
			start("https://www.goibibo.com/");
			System.out.println("Navigation completed to Goibibo page");
			
			//Click on Round trip
			driver.findElement(By.xpath("//input[@id='gi_roundtrip_label']")).click();
			System.out.println("Clicked on Round Trip");
			
			//select Pune as Departure city
			driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys("pun");
			driver.findElement(By.xpath("//span[text()='Pune']")).click();
			System.out.println("selected Pune location");
			
			
			//select Ahmedabad as Destination city
			driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).sendKeys("ahme");
			driver.findElement(By.xpath("//span[text()='Ahmedabad']")).click();
			System.out.println(" selected Ahmedabad location");
			
			//select Depart date tab
			driver.findElement(By.xpath("//input[@class='form-control inputTxtLarge widgetCalenderTxt'][1]")).click();
			System.out.println("Clicked on Start Date");
			
			
			//method for selecting Depart date
			WebElement element = driver.findElement(By.xpath("//input[@class='form-control inputTxtLarge widgetCalenderTxt'][1]"));
			element.click();
			clickOnDepartDate(2019,03,29);
			System.out.println("Selected start date ....");
			
			//method for selecting Return Date
			element.sendKeys(Keys.TAB);
			clickOnReturnDate(2019,04,05);
			System.out.println("Selected Departure date ....");
			
			
			//select number of travelers
			driver.findElement(By.xpath("//span[@id='pax_label']")).click();
			driver.findElement(By.xpath("//input[@id='adultPaxBox']")).clear();
			driver.findElement(By.xpath("//input[@id='adultPaxBox']")).sendKeys("2");
			System.out.println("Number of Travelers-2");
			
			//select the Flyer class
			driver.findElement(By.xpath("//select[@id='gi_class']"));
			getClass("Business");
			System.out.println("Clicked on Business Class");
			
			//click on search button
			driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
			System.out.println("Clicked on 'Get set go' button.");
			
			 }  

}

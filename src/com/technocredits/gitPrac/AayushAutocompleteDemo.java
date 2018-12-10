package com.technocredits.gitPrac;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;


public class AayushAutocompleteDemo{

	@Test
		public void AutoCompleteFunctionality() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocredits\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			System.out.println("Browser launch successfully");//Browser Launch
			driver.manage().window().maximize();//Maximize Window
			driver.manage().deleteAllCookies();// For deleting all cookies
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("https://www.google.com");
			System.out.println("Successfully navigated to URL");

			WebElement searchBoxInput = driver.findElement(By.name("q"));
			searchBoxInput.sendKeys("am");//To give the text as "am" in the textbox
			System.out.println("Text Entered");
			
			//To get the xpath of all the suggestions in a list using collections
			List<WebElement> autoSuggestionList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
			int listSize = autoSuggestionList.size();//To get the size of the list
			System.out.println("No. of options in the list: " + listSize);
			
			//for loop to iterate among the list
			for (int i = 1; i <= listSize; i++) {
				WebElement optionEle = driver.findElement(By.xpath("//ul[@class='erkvQe']//li[" + i + "]//span"));
				String option = optionEle.getText();
				System.out.println("Option is:" + option);
				
				//to select option if it matches with the given if condition
				if (option.equals("amazon")) {
					optionEle.click();
					System.out.println("Clicked on expected option");
					break;
				}
			}

			driver.findElement(By.cssSelector("div[id='rcnt']")).isDisplayed();
			System.out.println("Amazon search list displayed successfully.");

			driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();
			System.out.println("Clicked on Amazon link");

			driver.close();
		
	}
}



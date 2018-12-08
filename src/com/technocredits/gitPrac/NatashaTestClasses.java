
package seleniumpract;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NatashaTestClasses

{

	@Test
	public void SelectLinkAmazon_fromGoogle() throws InterruptedException {

		//------------Open Browser-------------------------//
		System.setProperty("webdriver.chrome.driver", "F:\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//--------------Open google home page--------------//
		driver.get("https://www.google.com/");
		System.out.println("Google page opned");
		
		//--------------Click on search text box-----------//
		WebElement searchField = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		searchField.click();
		System.out.println("Cliked on search field");
		
		//--------------Enter text "am"--------------------//
		searchField.sendKeys("am");
		System.out.println("Entered text 'am'");
		
		//--------------Select text from the search result-------------//
		List<WebElement> suggestedList = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		int sizeofList = suggestedList.size();
		System.out.println("listSize: "+sizeofList);
	
		for(int i = 1; i<=sizeofList; i++)
		{
			System.out.println("enter into For loop to search extact match");
			String suggestedValue = driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			System.out.println("showing all suggestedValue: "+suggestedValue);
			if(suggestedValue.equals("amazon"))
			{
				
				driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).click();
				System.out.println("Extact Match found please click on it");
				break;
			}
		}
		
		driver.close();
	
}
		
	

}

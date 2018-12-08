package GITPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoCompletebyArshi {
	@Test
	public void AutoCompleteProgram() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\Chrome Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		System.out.println("URL entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("my");
		Thread.sleep(3000);
		List<WebElement>totalitems=driver.findElements(By.xpath("//ul[@class='erkvQe']//li//span"));
		System.out.println("total size" + totalitems );
		System.out.println(totalitems);
		int size=totalitems.size();
		for(int i=1;i<size;i++)
		{
			String item=driver.findElement(By.xpath("//ul[@class='erkvQe']//li["+i+"]//span")).getText();
			if(item.equals("myntra"))
			{
				System.out.println("entered if");
				driver.findElement(By.xpath("//ul[@class='erkvQe']/li["+i+"]//span")).click();
				System.out.println("Clicked");
			}
			break;
		}
		driver.findElement(By.xpath("//cite[@class='UdQCqe']")).click();
/*		Alert alert= driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();*/
		boolean Logopresent=driver.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-logo']")).isDisplayed();
		System.out.println(Logopresent);
        Assert.assertTrue(Logopresent);
		driver.close();
	}


}


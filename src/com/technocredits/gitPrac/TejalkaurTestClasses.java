package sheinlsignup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class sheinloginpage {
	@Test
	public void loginpage() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.shein.in/user/auth/login");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
		
		//username
		driver.findElement(By.xpath("//div[@class='sign-in j-sign-in']//input[@name='email']")).sendKeys("tejaltechno1@gmail.com");
		System.out.println("Username entered");
		
		//password
		driver.findElement(By.xpath("//div[@class='sign-in j-sign-in']//input[@name='password']")).sendKeys("12345678t");
		System.out.println("Password enetered");
		
		//Click on Signin page
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println("Logged into shein page");
		
		
		
		
	}

}

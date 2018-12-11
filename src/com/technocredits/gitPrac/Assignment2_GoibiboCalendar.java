package com.technocredits.gitPrac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Assignment2_GoibiboCalendar
{
	private WebDriver driver;
	@Test
	public void Calendar() throws InterruptedException, ParseException 
	{	
		//Getting todays date
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
        String strDateFormat = "dd/MM/yyyy"; //Date format is Specified
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
        System.out.println(objSDF.format(objDate)); //Date formatting
        String TodayDate = objSDF.format(objDate); 		
				
        //User input for depart and return date in dd/mm/yyyy format and From-To location
		System.out.println("Please enter the expected depart date in dd/MM/yyyy format");
		String d = takeinput();
		System.out.println("Please enter the expected return date in dd/MM/yyyy format");
		String r = takeinput();
		
		System.out.println("Enter from city");
		String f = takeinput();
		System.out.println("Enter to city");
		String t = takeinput();
		
		//Checking invalid inputs, all cases are not considered
		if(Integer.parseInt(r.split("/")[2])<Integer.parseInt(d.split("/")[2]) ||  Integer.parseInt(r.split("/")[1])>=12 || Integer.parseInt(d.split("/")[1])>=12)
		{
			System.out.println("Invalid input");
			System.exit(1);
		}
		
		
		//Set chromedriver location and launching google.com in chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Downloads\\Compressed\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Browser lunch successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		//Wait for From field, find search field for From location and clicking on it
		driver = WaitForIt("//input[@id='gosuggest_inputSrc']");
		
		//Enter from data
		driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys(f);

		//Select value from dropdown
		driver.findElement(By.xpath("//span[text()='"+f+"']")).click();
		
		//Wait for To field
		driver = WaitForIt("//input[@id='gosuggest_inputSrc']");
		
		//Find search field for To location and clicking on it
		driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).sendKeys(t);
		
		//Enter data for To
		driver.findElement(By.xpath("//span[text()='"+t+"']")).click();
		
		
		//Click on date picker for depart date
		driver.findElement(By.xpath("//div[@class='fl width100']/div/div/span[text()='Depart:']//ancestor::div/div/input[@placeholder='Choose Date']")).click();
		
		//Wait for calendar
		driver = WaitForIt("//div[@class='DayPicker DayPicker--en']");
		
		//get no of clicks on arrow 
		int clicks = NoOf_ClickOnDate(TodayDate,d);
		
		driver = WaitForIt("//div[@role='application']/div/span");
		
		//click on arrow to go to target month
		ClickOnDate(clicks,d);
		
		
		
		//click on date picker for return date
		driver.findElement(By.xpath("//div[@class='fl width100']/div/div/span[text()='Return:']//ancestor::div/div/input[@placeholder='Choose Date']")).click();
		
		//Wait
		driver = WaitForIt("//div[@class='DayPicker DayPicker--en']");
		
		//get no of clicks on arrow 
		clicks = NoOf_ClickOnDate(d,r);

		driver = WaitForIt("//div[@role='application']/div/span");
		
		//Click on arrow to go to target month
		ClickOnDate(clicks,r);
		
		//You can now click Submit button
		System.out.println("Clicked on both the dates");
		
		
		
}
	
	//Cilck on datepicker arrow to move to target month
	private void ClickOnDate(int clicks, String d) throws ParseException, InterruptedException 
	{
		driver.findElement(By.xpath("//div[@role='application']/div/span")).click();
		
		for(int i=1;i<clicks;i++)
		{
			driver = WaitForIt("//div[@role='application']/div/span[2]");
			//Thread.sleep(300);
			driver.findElement(By.xpath("//div[@role='application']/div/span[2]")).click();
		}
		
		SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");
		
		Date objDate = objSDF.parse(d);
		String strDateFormat = "E MMM dd yyyy"; //Date format is Specified 'Fri Dec 21 2018']
        SimpleDateFormat objSDF1 = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
        System.out.println(objSDF1.format(objDate)); //Date formatting
		String dateInDOM = objSDF1.format(objDate);
        
		driver = WaitForIt("//div[@aria-label='"+dateInDOM+"']");
        driver.findElement(By.xpath("//div[@aria-label='"+dateInDOM+"']")).click();
	}
	
	//Calculate number of clicks required
	private int NoOf_ClickOnDate(String Today, String date) {

//		String Today = "11/12/2018";
//		String date = "01/06/2020";
		int NoOfClicks =0;
		
		String[] TodayDate =Today.split("/");
		int cdd = Integer.parseInt(TodayDate[0]);
		int cmm = Integer.parseInt(TodayDate[1]);
		int cyy = Integer.parseInt(TodayDate[2]);
		
		String[] curDate =date.split("/");
		int dd = Integer.parseInt(curDate[0]);
		int mm = Integer.parseInt(curDate[1]);
		int yy = Integer.parseInt(curDate[2]);
		
		if(cmm<=mm)
		{
			NoOfClicks =(mm-cmm)+12*(yy-cyy);
		}
		
		else
		{
			NoOfClicks =12*(yy-cyy)-(cmm-mm);
		}
		
		System.out.println(NoOfClicks);
		return NoOfClicks;
	}
	
	//Scanner user input methode
	private String takeinput() 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
	
		return s;	
	}
	
	//Wait function
	public WebDriver WaitForIt(String path)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		return driver;
	}
}

	
	


package com.technocredits.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.pages.RegistrationPage;
import com.technocredits.util.ExcelDataOperation;

public class LoginTest extends TestMethods {

	@Test(dataProvider = "ExcelReadForLogin")
	public void loginTest(String uname, String pwd, String expectedResult) {
		System.out.println(uname + ":" + pwd);
		System.out.println("Hello world");
		System.out.println("Start : Login Test");
		initialize();
		RegistrationPage registrationPage = goto_Registration();
		registrationPage.login(uname, pwd);
		String actualResult = registrationPage.acceptLoginPageAlert();
		Assert.assertTrue(actualResult.contains(expectedResult));

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			String status = "fail";
			takeScreenShot(result.getMethod().getMethodName(), status);
		}
		teardown();
	}

	@DataProvider(name = "ExcelReadForLogin")
	public String[][] provideLoginTestDataFromExcel() throws IOException {

		String[][] data = ExcelDataOperation.getData(".\\src\\com\\technocredits\\resources\\LoginTestData.xlsx",
				"Data");
		return data;

	}

	@DataProvider(name = "loginDetails")
	public Object[][] provideLoginTestData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "mkanani";
		data[0][1] = 1234567;
		data[0][2] = "Success!";

		data[1][0] = "Aayush";
		data[1][1] = "A123";
		data[1][2] = "Failed! please enter strong password";

		return data;
	}

}

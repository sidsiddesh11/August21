package com.ex.test;
 
import java.io.IOException;
 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ex.Base.BaseTest;
import com.ex.pages.Loginex;
import com.ex.utilities.ExcelUtilities;
import com.ex.utilities.ScreenshotUtilities;
 
public class LoginTest1 extends BaseTest{
	
	 static String projectpath=System.getProperty("user.dir")  ;
	@Test(dataProvider="logindata")
	public void verifylogin(String username, String password) throws IOException
	
	{    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test=extent.createTest("login with the user:"+username);
		Loginex obj=new Loginex(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonbutton();
		
		if(obj.dashisdisplayed())
		
		{
			test.pass("Login is sucess for user:"+username);
			
		}
		else
			test.fail(" login unsuccess for the user:"+username).addScreenCaptureFromPath(ScreenshotUtilities.Capture(driver, "Verify login"));
	
	
	if((driver.getTitle()).equals("orange"))
	{
		test.pass("title is matched");
	}
	else
		test.fail("title is not matched").addScreenCaptureFromPath(ScreenshotUtilities.Capture(driver, "Verify login"));
 
	}
	@DataProvider
	public Object[][] logindata() throws IOException
	{
		return ExcelUtilities.getdata(projectpath+"\\src\\test\\resources\\testdata\\data.xlsx", "Sheet1");
	}
 
}
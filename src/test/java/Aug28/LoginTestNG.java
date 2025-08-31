package Aug28;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestNG extends LogTestng {

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password) {
        ExtentTest test = extent.createTest("Login Test with email: " + email);

        driver.findElement(By.linkText("Signup / Login")).click();
        LoginPageObject loginPage = new LoginPageObject(driver);

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();
        try {
            Assert.assertEquals(actualError, "Your email or password is incorrect!", "Error message mismatch!");
            test.pass("Test Passed with email: " + email);
        } catch (AssertionError e) {
            test.fail("Test Failed with email: " + email + " | Actual Error: " + actualError);
            throw e;
        }
    }
}

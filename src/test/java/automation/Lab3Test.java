package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab3Test {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void lab3Test() {
        System.out.println("===== Lab 3 Test Started =====");

        driver.get("https://tutorialsninja.com/demo/");

        // Step 3: Go to 'Desktops' tab
        driver.findElement(By.linkText("Desktops")).click();
        System.out.println("Clicked on 'Desktops' tab");

        // Step 4: Click on 'Mac'
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
        System.out.println("Clicked on 'Mac' option");

        // Step 5: Select 'Name (A - Z)' from dropdown
        WebElement sortBy = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name (A - Z)");
        System.out.println("Selected 'Name (A - Z)' from Sort By dropdown");

        // Step 6: Click on Add to Cart button 
        WebElement addToCartBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div[2]/button[1]/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        js.executeScript("arguments[0].click();", addToCartBtn);
        System.out.println("Clicked 'Add to Cart' button using JavaScriptExecutor");

        // Verify success message
        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMsg.getText().contains("Success"),
                "Add to Cart success message not displayed!");
        System.out.println("Verified: Product added to cart successfully");

   
    }
}

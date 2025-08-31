package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab4Test {
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
    public void lab4Test() {

        driver.get("https://tutorialsninja.com/demo/");

        // Step 3: Verify title of the page
        String expectedTitle = "Your Store";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title mismatch!");
        System.out.println("Verified page title: " + driver.getTitle());

        // Step 4: Go to 'Desktops' tab
        driver.findElement(By.linkText("Desktops")).click();
        System.out.println("Clicked on 'Desktops' tab");

        // Step 5: Click on 'Mac'
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
        System.out.println("Clicked on 'Mac' option");

        // Step 13 & 18: Verify 'Mac' heading
        WebElement macHeading = driver.findElement(By.xpath("//h2[contains(text(),'Mac')]"));
        Assert.assertTrue(macHeading.isDisplayed(), "'Mac' heading not found!");
        System.out.println("Verified 'Mac' heading is displayed");

        // Step 6: Select 'Name (A - Z)' from dropdown
        WebElement sortBy = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name (A - Z)");
        System.out.println("Selected 'Name (A - Z)' from Sort By dropdown");

        // Step 7: Click on Add to Cart button using JavaScriptExecutor
        WebElement addToCartBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div[2]/button[1]/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        js.executeScript("arguments[0].click();", addToCartBtn);
        System.out.println("Clicked 'Add to Cart' button using JavaScriptExecutor");

        // Step 8: Enter ‘Monitors’ in Search box
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        System.out.println("Entered 'Monitors' in search box");

        // Step 9: Click on Search button
        driver.findElement(By.cssSelector(".btn-default.btn-lg")).click();
        System.out.println("Clicked on 'Search' button");

        // Step 10: Clear the text from 'Search Criteria' text box
        WebElement searchCriteria = driver.findElement(By.id("input-search"));
        searchCriteria.clear();
        System.out.println("Cleared text from Search Criteria box");

        // Step 11: Click on 'Search in product descriptions' checkbox and search again
        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();
        System.out.println("Checked 'Search in product descriptions' and clicked Search");

        // Verify page heading
        WebElement searchHeading = driver.findElement(By.xpath("//h1[contains(text(),'Search')]"));
        Assert.assertTrue(searchHeading.isDisplayed(), "Search heading not displayed!");
        System.out.println("Verified 'Search' page is displayed");

 
    }
}

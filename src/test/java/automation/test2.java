package automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {

	public static void main(String[] args) {
		System.out.println("HEllo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		System.out.println("Title is" + driver.getTitle());
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        myAccount.click();

     
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement heading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (heading.isDisplayed()) {
            System.out.println("Heading Verified: " + heading.getText());
        } else {
            System.out.println("Heading not found!");
        }

       
        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueBtn.click();

      
        WebElement warning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        if (warning.isDisplayed()) {
            System.out.println("✅ Warning Verified: " + warning.getText());
        } else {
            System.out.println("❌ Warning Mismatch! Found: " + warning.getText());
        }
        
        WebElement firstNameField = driver.findElement(By.xpath("//*[@id='input-firstname']"));
        firstNameField.sendKeys("ABCDEFGHIJ7asaaasasaaaaaaaaaaaaaaaaaaaasssssssssss");  // 33 characters
        
        
        WebElement firstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between')]"));
        if (firstNameWarning.isDisplayed()) {
            System.out.println("First Name Validation Message: " + firstNameWarning.getText());
        }
        
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();

        WebElement lastNameField = driver.findElement(By.xpath("//*[@id='input-lastname']"));
        lastNameField.sendKeys("QWERTYUIOPLKJsssssdsdssssddssssdssdsdssdssdssdsssds");
        
        
        WebElement lastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between')]"));
        if (lastNameWarning.isDisplayed()) {
            System.out.println("Last Name Validation Message: " + lastNameWarning.getText());
        }
        
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("sid@example.com");
        System.out.println("Valid Email entered.");
        
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("1223456");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();  


        // Close browser
        driver.quit();
   



	}

}

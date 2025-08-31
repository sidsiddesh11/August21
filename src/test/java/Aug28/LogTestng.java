package Aug28;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogTestng {
    protected WebDriver driver;
    protected static ExtentReports extent;

    @BeforeSuite
    public void startReport() {
        String projectPath = System.getProperty("user.dir");
        ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\Aug28th.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setUp() {
      // update with your chromedriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }

    // 🔹 Excel Data Provider inside Login class
    @DataProvider(name = "loginData")
    public String[][] loginData() throws IOException {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "\\data1.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        workbook.close();
        fs.close();
        return data;
    }
}

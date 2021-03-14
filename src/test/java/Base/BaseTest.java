package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage1;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static pages.LoginPage1 LoginPage1;
    protected static WebDriver driver;
    static ExtentHtmlReporter reporter;
    static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeClass
    public static void setup() {
        reporter = new ExtentHtmlReporter("./Reports/test.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger = extent.createTest("TweetSubmission");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.twitter.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        LoginPage1 = new LoginPage1(driver);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();
    }


}

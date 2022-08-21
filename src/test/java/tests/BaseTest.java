package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class BaseTest {

    protected WebDriver driver;
    private Properties prop;

    @BeforeTest
    @Parameters({"browser","headlessMode"})
    public void setupDriver(String browser, String headlessMode)throws IOException{
    if(browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        if (headlessMode.contains("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        } // execute in chrome driver
    }
    else if (browser.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        if (headlessMode.contains("headless")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            driver = new FirefoxDriver(options);
        } else {
            driver = new FirefoxDriver();
        } // execute in chrome driver

    }
    else if (browser.equals("IE")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        // IE code
    }

    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}



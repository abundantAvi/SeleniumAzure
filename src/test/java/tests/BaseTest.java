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
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;


public class BaseTest {

    public WebDriver driver;
    private Properties prop;


    @Parameters({"browser","headlessMode"})
    @BeforeTest
    public void setupDriver(String browser, String headlessMode)throws IOException{
    if(browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        if (headlessMode.contains("headless1")) {
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
//    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
//    {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
//        //String png= System.currentTimeMillis()+ ".png";
//        TakesScreenshot ts=(TakesScreenshot) driver;
//        File source =ts.getScreenshotAs(OutputType.FILE);
//        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
//        FileUtils.copyFile(source,new File(destinationFile));
//
//        return destinationFile;
//    }
//        public String getScreenShotPath(String testCaseName,WebDriver driver ) throws IOException {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destinationFile = System.getProperty("user.dir") + "\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
//        FileUtils.copyFile(source, new File(destinationFile));
//        return destinationFile;
//
//    }

        //@AfterTest
        public void quitBrowser() {
            this.driver.quit();
        }
}
package test.day8_alerts_iframes_window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowHandleWarmup {

    WebDriver driver;
        @BeforeMethod
        public void setUp() {
            driver = WebDriverFactory.getDriver("chrome");
        }

        @Test
        public void windowHandle_Practice() {
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        List<String> windowHandles=new ArrayList<String>(driver.getWindowHandles());
        for(String each: windowHandles){
            driver.switchTo().window(each);
            if(driver.getTitle().contains("Etsy")) {
                Assert.assertTrue(true);
                break;
            }
        }
    }
    }



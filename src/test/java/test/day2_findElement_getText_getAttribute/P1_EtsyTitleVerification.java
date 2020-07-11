package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_EtsyTitleVerification {
    /*
    TC #1: EtsyTitle Verification
    1.Open Chrome browser
    2.Go to https://www.etsy.com
    3.Search for “wooden spoon”
    4.Verify title: Expected: “Wooden spoon | Etsy"
     */
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
Thread.sleep(5000);
       // driver.findElement(By.id("global-enhancements-search-query")).click();
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"+ Keys.ENTER);
        String actualTitle= driver.getTitle();
        String expectedTitle= "Wooden spoon | Etsy";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title verification PASSED!");
        } else {
            System.out.println("Page title verification FAILED!");
        }
    }
}

package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ZeroBank_HeaderVerification {
    public static void main(String[] args) {
        /*
        TC #2: Zero Bankheader verification
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Verify header textExpected: “Log in to ZeroBank”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedHeader ="Log in to ZeroBank";
        String actualHeader = driver.findElement(By.className("page-header")).getText();
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification Passed!");
        } else {
            System.out.println("Header verification Failed!");
        }
    }
    }



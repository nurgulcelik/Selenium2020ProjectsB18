package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7_ZeroBank_Basic_Auth {
    /*
    Basic authentication Zero Bank
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Enter username: username
    4.Enter password: password
    5.Click sign in button
    6.Verify username is displayed on the page
    7.Verify the title Zero –Account Summary
    8.Verify the link Account Summary’s href value contains:
     “account-summary”Print out results in validation formats
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        String expectedResult="username";
        String actualResult= driver.findElement(By.linkText("username")).getText();
       if (actualResult.equals(expectedResult)){
       System.out.println("Displaying username verification PASSED!");
       }else{
       System.out.println("Displaying username verification FAILED!");
       }
       String actualTitle= driver.getTitle();
       String expectedTitle="Zero - Account Summary";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        String actualLinkValue=driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        System.out.println(actualLinkValue);
        String expectedLinkValue="account-summary";
        if (actualLinkValue.contains(expectedLinkValue)){
            System.out.println("Account link attribute value verification PASSED!");
        }else{
            System.out.println("Account link attribute value verification FAILED!");
        }
    }
}

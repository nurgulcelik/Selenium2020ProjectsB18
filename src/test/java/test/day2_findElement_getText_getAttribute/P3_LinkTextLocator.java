package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Gmail")).click();
       String actualGmailTitle =driver.getTitle();
       String expectedGmailTitle= "Gmail";
       if(actualGmailTitle.contains(expectedGmailTitle)){
           System.out.println("Gmail title verification PASSED!");
       }else{
           System.out.println("Gmail title verification FAILED!");
       }
       driver.navigate().back();
       String actualTitle=driver.getTitle();
       String expectedTitle="Google";
       if(actualTitle.equals(expectedTitle)){
            System.out.println("Google page title verification PASSED!");
        }else{
            System.out.println("Google page title verification FAILED!");
        }
    }
}

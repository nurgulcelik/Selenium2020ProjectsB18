package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P8_PracticeCybertekUrlVerification {
    /*
     PracticeCybertek/ForgotPassword URL verification
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/forgot_password
    3.Enter any email into input box
    4.Click on Retrieve password
    5.Verify URL contains: Expected: “email_sent”
    6.Verify textbox displayed the content as expected.
    Expected: “Your e-mail’s been sent!”
    Hint: You need to use getText method for this practice.
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("cybertekschool@gmail.com");
        driver.findElement(By.id("form_submit")).click();
        String currentURL= driver.getCurrentUrl();
        String expectedURL= "email_sent";
        if(currentURL.contains(expectedURL)){
            System.out.println("URL verification passed!");
        }else{
            System.out.println("URL verification failed!");
        }

        String actualResult= driver.findElement(By.name("confirmation_message")).getText();
       String expectedResult="Your e-mail's been sent!";

        if(actualResult.equals(expectedResult)){
            System.out.println("Textbox content verification PASSED!");
        }else{
            System.out.println("Textbox content verification FAILED");
        }
    }
}

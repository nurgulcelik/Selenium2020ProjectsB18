package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    public static void main(String[] args) {
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
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3.Enter any email into input box
        WebElement emailInput= driver.findElement(By.name("email"));
        emailInput.sendKeys("anyemail@email.com");
        //driver.findElement(By.name("email")).sendKeys("cybertekschool@gmail.com");
       //4.Click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        //driver.findElement(By.id("form_submit")).click();
        //5.Verify URL contains: Expected: “email_sent”
        String actualURL = driver.getCurrentUrl();
        String expectedInURL = "email_sent";
        if (actualURL.contains(expectedInURL)) {
            System.out.println("URL content verification PASSED!");
        } else {
            System.out.println("URL content verification FAILED!");
        }
     //6.Verify textbox displayed the content as expected.
     //    Expected: “Your e-mail’s been sent!”
        WebElement confirmationMessage= driver.findElement(By.name("confirmation_message"));
        String actualMessage=confirmationMessage.getText();
        //String actualResult = driver.findElement(By.name("confirmation_message")).getText();
        String expectedMessage = "Your e-mail's been sent!";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Confirmation message text verification PASSED!");
        } else {
            System.out.println("Confirmation message text verification FAILED");
        }
        if(confirmationMessage.isDisplayed()){
            System.out.println("Message is displayed, verification PASSED");
        }else{
            System.out.println("Message is NOT displayed, verification FAILED");
        }
    }
    }


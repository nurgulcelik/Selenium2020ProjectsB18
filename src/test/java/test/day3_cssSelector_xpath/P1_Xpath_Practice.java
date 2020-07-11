package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;
/* * TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/forgot_password
 * 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
 * a. "Home" link
 * b. "Forgot password" header
 * c. "E-mail" text
 * d. E-mail input box
 * e. "Retrieve password" button
 * f. "Powered by Cybertek School" text
 * 4. Verify all WebElements are displayed.

 */
public class P1_Xpath_Practice {
    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        WebElement homeLink =driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement forgotPasswordHeader= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        WebElement emailText= driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailInput= driver.findElement(By.xpath("//input[@type='text']"));
        WebElement retrievePassword= driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        WebElement poweredByCybertek= driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if(homeLink.isDisplayed()){
            System.out.println("Home link is displayed on the page, PASSED!");
        }else{
            System.out.println("Home link is displayed on the page, FAILED!");
        }
        if(forgotPasswordHeader.isDisplayed()){
            System.out.println("Forgot password header is displayed on the page, PASSED!");
        }else{
            System.out.println("Forgot password header is displayed on the page,FAILED");
        }
        if(emailText.isDisplayed()){
            System.out.println("Email text is displayed on the page, PASSED!");
        }else{
            System.out.println("Email text is displayed on the page, FAILED!");
        }
        if(emailInput.isDisplayed()){
            System.out.println("Email input button is displayed on the page, PASSED!");
        }else{
            System.out.println("Email input button is displayed on the page, FAILED!");
        }
        if(retrievePassword.isDisplayed()){
            System.out.println("Retrieve password is displayed on the page, PASSED!");
        }else{
            System.out.println("Retrieve password is displayed on the page, FAILED!");
        }
        if(poweredByCybertek.isDisplayed()){
            System.out.println("Powered by Cybertek is displayed on the page, PASSED!");
        }else{
            System.out.println("Powered by Cybertek is displayed on the page, FAILED!");
        }

    }
}

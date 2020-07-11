package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankVerification {
    public static void main(String[] args) {
         /*
     Zero Bank URLverification
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Get attribute value of href from the “forgot your password”link
    4.Verify attribute value contains
    Expected: “/forgot-password.html”
    SOLUTION: NEXT PAGE.
    Try to solve yourself before looking at the solution.
    Hint: Locate the “Forgot your password ?” link,
     and use getAttribute value method to get the link behind the attribute within.

     */
           // 1.Open Chrome browser
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            //2.Go to http://zero.webappsecurity.com/login.html
            driver.get("http://zero.webappsecurity.com/login.html");
            //3.Get attribute value of href from the “forgot your password”link
           WebElement forgotPasswordLink= driver.findElement(By.partialLinkText("Forgot"));
           //4.Verify attribute value contains
           //  Expected: “/forgot-password.html”
            String  actualHrefValue = forgotPasswordLink.getAttribute("href");
            System.out.println(actualHrefValue);
            //String actualResult= driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
            String expectedHrefValue ="/forgot-password.html";

            if(actualHrefValue.contains(expectedHrefValue)){
                System.out.println("HREF value verification PASSED!");
            }else{
                System.out.println("HREF value verification FAILED");
            }
            if(forgotPasswordLink.isDisplayed()){
                System.out.println("Message is displayed, verification PASSED");
            }else{
                System.out.println("Message is displayed, verification FAILED");
            }
        }
    }


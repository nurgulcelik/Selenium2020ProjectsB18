package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_ZeroBankURL_Ver {
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
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        String actualResult= driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        String expectedResult="/forgot-password.html";

        if(actualResult.contains(expectedResult)){
            System.out.println("ZeroBank URL verification PASSED!");
        }else{
            System.out.println("ZeroBank URL verification FAILED");
        }
    }
    }


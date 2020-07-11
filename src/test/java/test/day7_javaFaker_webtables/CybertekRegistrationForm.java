package test.day7_javaFaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CybertekRegistrationForm {
    /*
    TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/registration_form
    3.Enter first name
    4.Enter last name
    5.Enter username
    6.Enter email address
    7.Enter password
    8.Enter phone number
    9.Select a gender from radio buttons
    10.Enter date of birth
    11.Select Department/Office
    12.Select Job Title
    13.Select programming language from checkboxes
    14.Click to sign up button
    15.Verify success message “You’ve successfully completed registration.”is displayed
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // close browser
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void registration_form() {
        Faker faker= new Faker();
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());
        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().username().replace(".",""));
        WebElement emailAddress= driver.findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys(faker.internet().emailAddress());
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("842-945-0276");
        WebElement dateOfBirth= driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("01/01/1995");
        WebElement gender = driver.findElement(By.xpath("//input[@value ='female']"));
        gender.click();
        Select department = new Select( driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByValue("DE");
        Select jobTitle = new Select( driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        WebElement programmingLanguage = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programmingLanguage.click();
        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']//p")).getText();
        String expectedMessage="You've successfully completed registration!";
        Assert.assertEquals(actualMessage,expectedMessage);
       }
     }
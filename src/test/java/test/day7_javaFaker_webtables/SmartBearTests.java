package test.day7_javaFaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
       // SmartBearUtilities.verifyOrder(driver,"Susan McLaren");
      // SmartBearUtilities.printNamesAndCities(driver);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        // close browser
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void p1_smartbear_login_test(){

        List<WebElement>allLinks= driver.findElements(By.xpath("//body//a"));
        //System.out.println("Number of the links: "+allLinks.size());
        int expectedNumberOfLinks= 6;
        int actualNumberOfLinks=allLinks.size();
        Assert.assertEquals(6,actualNumberOfLinks);
        for(WebElement link: allLinks){
            System.out.println(link.getText());
        }
    }
    @Test
    public void p2_smarter_order_placing(){
/*// Smartbear software order placing
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        //6. Click on Order
        //7. Select familyAlbum from product, set quantity to 2
        //8. Click to “Calculate” button
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        //10. Click on “visa” radio button
        //11. Generate card number using JavaFaker
        //12. Click on “Process”
        //13.Verify success message “New order has been successfully added.”

 */
     WebElement orderLink= driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys("2");

        WebElement calculateButton= driver.findElement(By.xpath("//input[@value ='Calculate']"));
        calculateButton.click();

        WebElement inputName= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        Faker faker= new Faker();
        //String name= faker.name().fullName();
        inputName.sendKeys(faker.name().fullName());

        WebElement inputStreet=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        inputStreet.sendKeys(faker.address().streetName());

        WebElement inputCity=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        inputCity.sendKeys(faker.address().city());

        WebElement inputState=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        inputState.sendKeys(faker.address().state());

        WebElement inputZipCode=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        String zip =faker.address().zipCode().replaceAll("-", "");
        inputZipCode.sendKeys(zip);


        WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        String card= faker.finance().creditCard().replaceAll("-", "");
        cardNumber.sendKeys(card);

        WebElement date=    driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        date.sendKeys("10/21");

        WebElement processButton=driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        String expectedMessage="New order has been successfully added.";
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
       // String actualMessage = message.getText();
        //Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertTrue(successMessage.isDisplayed());

    }
    @Test
    public void p3_smartbear_order_verification(){
        //2. Click on View all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = susansDate.getText();

        Assert.assertEquals(actualDate, expectedDate);

    }
    @Test
    public void task11_deleteNameTest2(){
        SmartBearUtilities.deleteName(driver, "Bob Feather");
    }
}

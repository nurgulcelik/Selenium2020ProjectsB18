package test.day8_alerts_iframes_window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class VyTrack2 {
    //US1.As a truck driver I should be able to  access Vehicle Under Fleet Module


        @Test
        public void loginValid() throws InterruptedException {
            Driver.getDriver().get("https://qa2.vytrack.com/user/login");
            //1.Verify that truck driver should be able to LOGIN with Valid Credential
            Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("user19" + Keys.ENTER);
            Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123" + Keys.ENTER);
            String userName = "user19";
            String password = "UserUser123";
            //2.Verify that After you login driver is in Home Page
            Thread.sleep(1000);
            System.out.println(Driver.getDriver().getTitle());
            Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");//ASSERT!!!!!!!!!!!!!!!!!!!
            Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"));//ASSERT!!!!!!!!!!!!!!!!!!!
       /* if (driver.getTitle().equals("Dashboard")) {
            System.out.println("User is on HomePage");
        } else {
            System.out.println("User could not log in !");
        }*/
            //3.Verify that after driver login driver able to see Fleet, Customer,Activities,System modules
            List<WebElement> ActualList = Driver.getDriver().findElements(By.xpath("//ul[@class='nav-multilevel main-menu']/li"));
            String[] homePageHeader = {"Fleet", "Customers", "Activities", "System"};
            for (int i = 0; i < homePageHeader.length; i++) {
                // System.out.println(ActualList.get(i).getText().equals(homePageHeader[i]));
                Assert.assertTrue(ActualList.get(i).getText().equals(homePageHeader[i]));
            }
        }
      /*  @Test  //1.Verify that truck driver should not be able to LOGIN with Invalid UserName Credential
        public void loginInvalidUsername() throws InterruptedException {
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("userabc" + Keys.ENTER);
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123" + Keys.ENTER);
            Thread.sleep(3000);
            String userName = "userabc";
            String password = "UserUser123";
            Assert.assertFalse(driver.getTitle().equals("Dashboard"));
        }*/


        //1.Verify that truck driver should not be able to LOGIN without any credential
    @Test
        public void loginWithoutCredential() {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
            WebElement element =Driver.getDriver().findElement(By.name("_username"));
            String validationMessage = element.getAttribute("validationMessage");
            Assert.assertTrue(validationMessage.contains("Please fill out this field"));
        }

        //2.Verify that when user(truck driver) click on any car on the grid,
        // system should display general information about the car
        @Test
        public void clickCar() throws InterruptedException {
            Driver.getDriver().get("https://qa2.vytrack.com/user/login");
            Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("user154" + Keys.ENTER);
            Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123" + Keys.ENTER);
            String userName = "user19";
            String password = "UserUser123";
            Thread.sleep(2000);
            Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1']")).click();
            Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']")).click();
            Driver.getDriver().findElement(By.xpath("(//tbody[@class='grid-body']/tr)[1]")).click();
            Driver.getDriver().findElement(By.xpath("(//tbody[@class='grid-body']/tr)[2]")).click();
            Driver.getDriver().findElement(By.xpath("(//tbody[@class='grid-body']/tr)[3]")).click();
            Thread.sleep(2000);
            //3.Verify that truck driver can add Event and it should display under Activity tab and General  information page as well.
            Thread.sleep(2000);
            Driver.getDriver().findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']/a/i")).click();//Vasyl
            //Click Activities
            Actions action = new Actions(Driver.getDriver());
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[3]/a/span"))).perform();
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//ul/li[@data-route='oro_calendar_event_index']/a"))).click().build().perform();
            Thread.sleep(2000);
            //  Assert.assertTrue(driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-name']")).isDisplayed());
            //4.Verify that Truck driver can reset the Grid by click on Grid setting;
            Driver.getDriver().findElement(By.xpath("//div[@class='column-manager dropdown']/a")).click();
            WebElement element =Driver.getDriver().findElement(By.xpath("//td[@class='visibility-cell']"));
            element.click();
            Assert.assertFalse(element.isSelected());
        }
    }


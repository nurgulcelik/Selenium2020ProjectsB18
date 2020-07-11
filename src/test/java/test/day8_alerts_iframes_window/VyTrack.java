package test.day8_alerts_iframes_window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class VyTrack {
    //User Story 1.As a truck driver
    // I should be able to  access Vehicle Under Fleet Module
    String url = ConfigurationReader.getProperty("url");

    @Test
    public void accessingTheVehiclePage() throws InterruptedException {
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.getProperty("username") + Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        WebElement FleetModule = Driver.getDriver().findElement
                (By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        FleetModule.click();
        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vehicle).click().build().perform();
    }
    //Verify that after clicking any car on the vehicle page,
    // truck driver can see the information about the car.
        @Test
        public void accessingCarInformationPage() throws InterruptedException {
            Driver.getDriver().get(url);
            Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.getProperty("username") + Keys.ENTER);
            Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
            Thread.sleep(2000);
        WebElement FleetModule = Driver.getDriver().findElement
                (By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        FleetModule.click();
            Thread.sleep(2000);
        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vehicle).click().build().perform();
        Thread.sleep(2000);
        WebElement carInfo1 = Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[1]/td[1]"));
        actions.moveToElement(carInfo1).click().build().perform();
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        WebElement carInfo2 = Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[2]/td[1]"));
        actions.moveToElement(carInfo2).click().build().perform();
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        WebElement carInfo3 = Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[3]/td[1]"));
        actions.moveToElement(carInfo3).click().build().perform();
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
    }
//Verify that truck driver can add event
    @Test
        public void addingEvent() throws InterruptedException {
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.getProperty("username") + Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        Thread.sleep(2000);
        WebElement FleetModule = Driver.getDriver().findElement
                (By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        FleetModule.click();
        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vehicle).click().build().perform();
        Thread.sleep(2000);
        WebElement activity= Driver.getDriver().findElement
                (By.xpath("(//span[@class='title title-level-1'])[3]"));
        WebElement calendarEvents= Driver.getDriver().findElement
                (By.xpath("//span[.='Calendar Events']"));
        Thread.sleep(2000);
        actions.moveToElement(activity).click().build().perform();
        Thread.sleep(2000);
        actions.moveToElement(calendarEvents).click().build().perform();
        Thread.sleep(2000);
        WebElement createCalendarEvent= Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        Thread.sleep(2000);
        actions.moveToElement(createCalendarEvent).click().build().perform();
        Thread.sleep(2000);
        WebElement title= Driver.getDriver().findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        title.sendKeys("Test Event");
        WebElement submitButton= Driver.getDriver().findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        submitButton.click();
    }
   // Verify that Truck driver can reset the Grid by click on Grid setting;
    @Test
        public void resettingTheGrid() throws InterruptedException{
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.getProperty("username") + Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        Thread.sleep(1000);
        WebElement FleetModule = Driver.getDriver().findElement
                (By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        FleetModule.click();
        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vehicle).click().build().perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']")).click();
       // Driver.getDriver().findElement(By.xpath("//div[@class='column-manager dropdown']/a")).click();
        WebElement element = Driver.getDriver().findElement(By.xpath("//td[@class='visibility-cell']"));
        element.click();
        Assert.assertFalse(element.isSelected());
        }
    }


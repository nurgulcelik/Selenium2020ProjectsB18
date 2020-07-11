package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {
    LoginPage loginpage;
    @Ignore
    @Test
    public void negative_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebElement usernameInput= Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput= Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton= Driver.getDriver().findElement(By.id("_submit"));
        String username= ConfigurationReader.getProperty("storemanager-username");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys("klmnvalk");
        loginButton.click();
        WebElement errorMessage= Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(),"Assert message is not displayed");
    }
    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
         loginpage= new LoginPage();
        //sending username
        String username= ConfigurationReader.getProperty("storemanager-username");
        loginpage.userNameInput.sendKeys(username);
        //send our incorrect password
        loginpage.passwordInput.sendKeys("zeynepnuran");
        //click using our loginpage object
        loginpage.loginButton.click();
        //asserting error message is displayed
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());
        //asserting the text value of the error message
        String actualText=loginpage.errorMessage.getText();
        String expectedText= "Invalid user name or password.";
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void wrong_username_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginpage= new LoginPage();
        String username="asdrftghy";
        String password=ConfigurationReader.getProperty("storemanager-password");
        loginpage.login(username,password);
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());
        //asserting the text value of the error message
        String actualText=loginpage.errorMessage.getText();
        String expectedText= "Invalid user name or password.";
        Assert.assertEquals(actualText,expectedText);
    }
}

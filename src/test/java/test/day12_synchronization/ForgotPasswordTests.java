package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordTests {

    /*
    1. Go to https://qa3.vytrack.com
2. Click to "Forgot your password?" link
3. Verify title changed to expected
    Expected: "Forgot Password"
4. Verify url is as expected:
    Expected: "https://qa3.vytrack.com/user/reset-request"
   Note: Follow Page Object Model design pattern
     */
    @Test
    public void title_url_verification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage= new LoginPage();
        loginPage.forgotPasswordLink.click();
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle="Forgot Password";
        Assert.assertEquals(actualTitle,expectedTitle);
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa3.vytrack.com/user/reset-request";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    /*
     Vytrack forgot password page verification->ERROR MESSAGE
    1. Go to https://qa3.vytrack.com/user/reset-request
    2. Enter random username
    3. Click to request button
    4. Verify error message is displayed
    5. Verify error message text is as expected.
    Expected: There is no active user with username or email address "given text".
    Note: Follow Page Object Model design pattern
     */
    public void errorMessage_verification(){
       Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));
        ForgotPasswordPage forgotPassword= new ForgotPasswordPage();
        String randomString="abc123";
        forgotPassword.userNameInput.sendKeys(randomString);
        forgotPassword.requestButton.click();
        Assert.assertTrue(forgotPassword.errorMessage.isDisplayed());
        String actualMessage= forgotPassword.errorMessage.getText();
        String expectedMessage="There is no active user with username or email address \""+randomString+"\".";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}

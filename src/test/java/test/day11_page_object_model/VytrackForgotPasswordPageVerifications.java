package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class VytrackForgotPasswordPageVerifications {
   ForgotPasswordPage forgotPassword;
   @Test
   public void vytrackForgotPassword_test(){
      Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
       forgotPassword=new ForgotPasswordPage();
       forgotPassword.forgotPasswordLink.click();
       String actualTitle=Driver.getDriver().getTitle();
       String expectedTitle="Forgot Password";
      Assert.assertEquals(actualTitle,expectedTitle);
      String actualUrl= Driver.getDriver().getCurrentUrl();
      String expectedUrl="https://qa3.vytrack.com/user/reset-request";
      Assert.assertEquals(actualUrl,expectedUrl);
   }
   @Test
   public void forgotPassword_errorMessage_test(){
     Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
      forgotPassword=new ForgotPasswordPage();
      forgotPassword.forgotPasswordLink.click();
      forgotPassword.userNameInput.sendKeys("abc123");
      forgotPassword.requestButton.click();
      String actualMessage= forgotPassword.errorMessage.getText();
      String expectedMessage= "There is no active user with username or email address \"abc123\".";
      Assert.assertEquals(actualMessage,expectedMessage);
   }
}

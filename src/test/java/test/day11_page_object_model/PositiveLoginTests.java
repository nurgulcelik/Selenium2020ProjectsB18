package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTests {
    LoginPage loginpage;
    @Test
    public void store_manger_login_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginpage= new LoginPage();
        String username=ConfigurationReader.getProperty("storemanager-username");
        String password=ConfigurationReader.getProperty("storemanager-password");
        loginpage.login(username,password);
        String expectedTitle="Dashboard";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

}

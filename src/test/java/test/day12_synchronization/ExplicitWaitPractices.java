package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {
    /*
    TC#40: Dynamically Loaded Page Elements 7
    1.Go to http://practice.cybertekschool.com/dynamic_loading/7
    2.Wait until title is “Dynamic Title”
    3.Assert : Message “Done” is displayed.
    4.Assert : Image is displayed.
     */

    @Test
    public void dynamic_title_test(){
        String url="http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        Loading7Page loading7page=new Loading7Page();
        Assert.assertTrue(loading7page.doneMessage.isDisplayed());
        Assert.assertTrue(loading7page.spongeBobImage.isDisplayed());
    }
    @Test
    public void dynamic_form_test(){
        String url="http://practice.cybertekschool.com/dynamic_loading/1";
        Driver.getDriver().get(url);
        Loading1Page loading1Page=new Loading1Page();
        loading1Page.startButton.click();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed());
        loading1Page.usernameInput.sendKeys("abcabc");
        loading1Page.passwordInput.sendKeys("SuperSecretPassword");
        loading1Page.submitButton.click();
        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());
    }
}

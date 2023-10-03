package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnLoginPageButton();

        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnLogInButton();

        Assert.assertTrue(profilePage.getMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLoginWithInvalidUsername(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnLoginPageButton();

        loginPage.inputUsername("incorrectUser"); // invalid username
        loginPage.inputPassword("Password123");
        loginPage.clickOnLogInButton();

        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = loginPage.errorText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }


}

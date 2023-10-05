package AnnotationTests;

import AnnotationBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String URL = "https://practicetestautomation.com/";

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to(URL);
    }

    @Test()
    public void verifyThatUserCanLogIn(){

        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
        Assert.assertTrue(profilePage.message.isDisplayed());
    }

    @Test()
    public void verifyThatUserCannotLoginWithInvalidUsername(){

        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        loginPage.inputUsername("incorrectUser");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();

        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = loginPage.errorText();

        // Error message check
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        // url check
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test()
    public void verifyThatUserCannotLoginWithInvalidPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        loginPage.inputUsername("student");
        loginPage.inputPassword("incorrectPassword");
        loginPage.clickOnSubmitButton();

        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = loginPage.errorText();

        // Error message check
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        // url check
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @AfterMethod
    public void pageSetDown(){
        driver.navigate().to(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

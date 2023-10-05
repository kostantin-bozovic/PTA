package UsingDataDrivenTestingTest;

import UsingDataDrivenTestingBase.BaseTest;
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
    @Test(priority = 1)
    public void verifyThatUserCanLogIn(){

        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        String validUsername = excelReader.getStringData("LoginData",1,0);
        String validPassword = excelReader.getStringData("LoginData", 1, 1);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();

        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
        Assert.assertTrue(profilePage.message.isDisplayed());
    }

    @Test(priority = 2)
    public void userCanNotLogIn() {

        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();

        for (int i = 1; i < excelReader.getLastRow("LoginData"); i++) {

            String invalidUsername = excelReader.getStringData("LoginData", i, 2);
            String invalidPassword = excelReader.getStringData("LoginData", i, 3);

            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();

            // error message check
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());

            // url check
            String expectedURL = "https://practicetestautomation.com/practice-test-login/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        }
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

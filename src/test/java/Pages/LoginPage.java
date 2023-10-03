package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement username;
    WebElement password;
    WebElement logInButton;
    WebElement errorMessage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("error"));
    }

    // TODO Action

    public void inputUsername(String username){
        getUsername().sendKeys(username);
    }
    public void inputPassword(String password){
        getPassword().sendKeys(password);
    }
    public void clickOnLogInButton(){
        getLogInButton().click();
    }

    public String errorText(){
        return getErrorMessage().getText();
    }
}

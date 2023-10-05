package UsingDataDrivenTestingBase;


import UsingDataDrivenTestingPages.HomePage;
import UsingDataDrivenTestingPages.LoginPage;
import UsingDataDrivenTestingPages.PracticePage;
import UsingDataDrivenTestingPages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public HomePage homePage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;


    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        excelReader = new ExcelReader("src/test/java/TestData.xlsx");

        homePage = new HomePage();
        practicePage = new PracticePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

}

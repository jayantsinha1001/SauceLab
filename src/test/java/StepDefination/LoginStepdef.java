package StepDefination;

import Utils.ExtentReportManager;
import Utils.PropertiesFile;
import com.aventstack.extentreports.ExtentTest;
import com.sauce.Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginStepdef {

    private static final Logger log = LoggerFactory.getLogger(LoginStepdef.class);
    public WebDriver driver;
    public LoginPage loginPage;
    public ExtentTest test;
    private static final String url = PropertiesFile.getProperty("url");


    public LoginStepdef() {
        this.test = ExtentReportManager.getTest();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log.info("Browser launched successfully.");

        if (test != null) {
            test.info("Browser launched successfully.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed.");

            if (test != null) {
                test.info("Browser closed.");
            }
        }
    }

    @Given("user navigates to login Page")
    public void user_navigates_to_login_page() {
        driver.get(url);
        loginPage = new LoginPage(driver);
        log.info("Navigated to login page.");

        if (test != null) {
            test.info("Navigated to login page.");
        }
    }

    @Given("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String userId, String password) {
        loginPage.enterId(userId);
        loginPage.enterPassword(password);
        log.info("Entered username and password.");

        if (test != null) {
            test.info("Entered username and password.");
        }
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
        log.info("Clicked on login button.");

        if (test != null) {
            test.info("Clicked on login button.");
        }
    }

    @Then("user navigates to page with title {string}")
    public void user_navigates_to_page_with_title(String expectedPageTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);
        log.info("Verified page title.");

        if (test != null) {
            test.info("Verified page title.");
        }
    }

}

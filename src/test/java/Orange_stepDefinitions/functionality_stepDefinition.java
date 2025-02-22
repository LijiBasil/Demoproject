package Orange_stepDefinitions;

import Orange_pages.AdminPage;
import Orange_pages.LoginPage;
import Orange_pages.MyInfoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class functionality_stepDefinition {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    MyInfoPage myInfoPage;


    @Before
    public void setUp() {

        driver = new ChromeDriver();
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static void captureScreenShot(WebDriver driver, String name) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {

            FileUtils.copyFile(src, new File("src/test/Screenshots" + name + ".png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Given("I am on OrangeHRM webpage")
    public void i_am_on_orange_hrm_webpage() {
        driver.get(" https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Given("I have entered the valid username and password")
    public void i_have_entered_the_valid_username_and_password() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("I click on login button")
    public void i_click_on_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Then("I have successfully landed the dashboard page")
    public void i_have_successfully_landed_the_dashboard_page() {
        adminPage = new AdminPage(driver);
        Assert.assertTrue(adminPage.checkdashboardpage());
        captureScreenShot(driver, "Successful login");
    }

    @Given("I am on the admin panel")
    public void i_am_on_the_admin_panel() throws InterruptedException {
        loginPage.login("Admin", "admin123");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
    }

    @And("I click on My Info at the sidebar menu")
    public void i_click_on_my_info_at_the_sidebar_menu() throws InterruptedException {
        adminPage = new AdminPage(driver);
        adminPage.MyInfoClick();
    }

    @Then("My Info page should be loaded successfully")
    public void my_info_page_should_be_loaded_successfully() {
        myInfoPage = new MyInfoPage(driver);
        myInfoPage.checkMyInfoPage();
    }

    @Then("I verify if the DOB field is prefilled")
    public void i_verify_if_the_dob_field_is_prefilled() throws InterruptedException {
        Assert.assertTrue(myInfoPage.checkPrefilledDOB());
    }

    @Then("I update the DOB field to new value")
    public void i_update_the_dob_field_to_new_value() throws InterruptedException {
        Thread.sleep(3000);
        myInfoPage.enterDOB("1995-01-25");
    }

    @Then("I click on save button")
    public void i_click_on_save_button() throws InterruptedException {
        myInfoPage.clickSave();

    }

    @Then("My Info page should be updated with updated DOB")
    public void my_info_page_should_be_updated_with_updated_dob() throws InterruptedException {
        Assert.assertEquals(myInfoPage.getDOB(), "1995-01-25");
        Thread.sleep(5000);
        captureScreenShot(driver, "Update_DOB");
    }

    @And("I click on logout button")
    public void i_click_on_logout_button() throws InterruptedException {
        adminPage = new AdminPage(driver);
        adminPage.clickLogoutMenu();
    }

    @Then("I should be navigated back to login page")
    public void i_should_be_navigated_back_to_login_page() {
        loginPage.checkLoginPage();
        captureScreenShot(driver, "Logout");
    }
}

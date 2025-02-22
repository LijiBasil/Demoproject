package Orange_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private WebDriver driver;

//By locators

    private By userName = By.name("username");
    private By passWord = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By loginpageLocator = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");

//constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    //Methods

    public void enterUserName(String username) {
        WebElement userInput = driver.findElement(userName);
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passInput = driver.findElement(passWord);
        passInput.sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException {
        WebElement login = driver.findElement(loginButton);
        login.click();
        Thread.sleep(2);
    }

    public void login(String userName, String password) throws InterruptedException {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }


    public boolean checkLoginPage() {
        return driver.findElement(loginpageLocator).isDisplayed();
    }
}

package Orange_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdminPage {

    private WebDriver driver;

    //By locators

    private By MyinfoLocator = By.xpath("//span[normalize-space()='My Info']");
    private By logoutLocator = By.xpath("//a[normalize-space()='Logout']");
    private By dashboardLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private By logoutMenuLocator = By.xpath("//p[@class='oxd-userdropdown-name']");


//    constructor

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods

    public boolean checkdashboardpage() {

        return driver.findElement(dashboardLocator).isDisplayed();
    }

    public void MyInfoClick() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement Myinfo = driver.findElement(MyinfoLocator);
        action.moveToElement(Myinfo).build().perform();
        Myinfo.click();
        Thread.sleep(2000);

    }

    public void clickLogoutMenu() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement logoutMenu = driver.findElement(logoutMenuLocator);
        action.moveToElement(logoutMenu).build().perform();
        logoutMenu.click();
        Thread.sleep(3000);
        WebElement logout_button = driver.findElement(logoutLocator);
        action.moveToElement(logout_button).build().perform();
        logout_button.click();
    }

}

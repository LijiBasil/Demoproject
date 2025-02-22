package Orange_pages;

import org.openqa.selenium.*;

public class MyInfoPage extends LoginPage {
    private WebDriver driver;

    //By locators
    private By personalDetailsLocator = By.xpath("//h6[normalize-space()='Personal Details']");
    private By DOBLocator = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private By DOBInput = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]");
    private By saveLocator = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']");
    private By DOBValue = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]");

    //constructor
    public MyInfoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //methods

    public boolean checkMyInfoPage() {
        return driver.findElement(personalDetailsLocator).isDisplayed();
    }

    public void enterDOB(String dateOfBirth) throws InterruptedException {

        WebElement DOBV = driver.findElement(DOBInput);
        DOBV.sendKeys(Keys.CONTROL + "a");
        DOBV.sendKeys(dateOfBirth);

    }

    public void clickSave() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,250)", "");
        WebElement saveButton = driver.findElement(saveLocator);
        saveButton.click();

    }

    public boolean checkPrefilledDOB() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,250)", "");
        return driver.findElement(DOBLocator).isDisplayed();
    }

    public String getDOB() {
        return driver.findElement(DOBValue).getAttribute("value");
    }


}




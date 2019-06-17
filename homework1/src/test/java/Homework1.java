import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Homework1 {

    private static final String PAGE_URL = "https://pastebin.com";
    private static final String PASTE_FIELD_ID = "paste_code";
    private static final String PASTE_FIELD_TEXT = "Hello from WebDriver";
    private static final String EXPIRE_DATE_DDL_LOCATOR = "//ul[@class='select2-results__options']//li";
    private static final String EXPAND_EXPIRE_DATE_DDL_LOCATOR = "//*[@id='myform']/div[3]/div[2]/div[2]/span/span[1]/span/span[2]";
    private static final String PASTE_NAME_FIELD_LOCATOR ="//*[@id='myform']/div[3]/div[5]/div[2]/input";
    private static final String PASTE_NAME_FIELD_TEXT = "helloweb";
    private static final String SUBMIT_BUTTON_LOCATOR = "submit";
    private static final String SUCCESS_MESSAGE_LOCATOR = "success";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get(PAGE_URL);
        waitForElement(driver, By.id(PASTE_FIELD_ID));

        enterText(driver, By.id(PASTE_FIELD_ID), PASTE_FIELD_TEXT);
        Thread.sleep(3000);

        selectExpirationDDLValue(driver, 1);
        Thread.sleep(3000);

        enterText(driver, By.xpath(PASTE_NAME_FIELD_LOCATOR), PASTE_NAME_FIELD_TEXT);
        Thread.sleep(3000);

        clickButton(driver, By.id(SUBMIT_BUTTON_LOCATOR));
        waitForElement(driver, By.id(SUCCESS_MESSAGE_LOCATOR));
        Thread.sleep(3000);

        driver.quit();
    }
    private static void waitForElement(WebDriver driver, By elementName) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elementName));
    }
    private static void selectExpirationDDLValue(WebDriver driver, int index) {
//        WebElement expandExpirationDDL = driver.findElement(By.xpath(EXPAND_EXPIRE_DATE_DDL_LOCATOR));
//        expandExpirationDDL.click();
        clickButton(driver, By.xpath(EXPAND_EXPIRE_DATE_DDL_LOCATOR));
        List<WebElement> findDropDownValue = driver.findElements(By.xpath(EXPIRE_DATE_DDL_LOCATOR));
        findDropDownValue.get(index).click();
    }
    private static void enterText (WebDriver driver, By fieldName, String text) {
        WebElement searchTextField = driver.findElement(fieldName);
        searchTextField.sendKeys(text);
    }

    private static void clickButton (WebDriver driver, By buttonName) {
        WebElement clickButton = driver.findElement(buttonName);
        clickButton.click();
    }


}

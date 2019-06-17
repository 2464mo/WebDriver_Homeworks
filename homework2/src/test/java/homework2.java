import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class homework2 {

    private static final String PAGE_URL = "https://pastebin.com";
    private static final String PASTE_FIELD_ID = "paste_code";
    private static final String PASTE_FIELD_TEXT = "git config --global user.name  \"New Sheriff in Town\"" +
            "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
            "\ngit push origin master --force";
    private static final String EXPIRE_DATE_DDL_LOCATOR = "//ul[@class='select2-results__options']//li";
    private static final String EXPAND_EXPIRE_DATE_DDL_LOCATOR = "//*[@id='myform']/div[3]/div[2]/div[2]/span/span[1]/span/span[2]";
    private static final String PASTE_NAME_FIELD_LOCATOR ="//*[@id='myform']/div[3]/div[5]/div[2]/input";
    private static final String PASTE_NAME_FIELD_TEXT = "how to gain dominance among developers";
    private static final String SUBMIT_BUTTON_LOCATOR = "submit";
    private static final String SUCCESS_MESSAGE_LOCATOR = "success";
    private static final String SYNTAX_DDL_LOCATOR = "//ul[@class='select2-results__options']//li";
    private static final String EXPAND_SYNTAX_DDL_LOCATOR = "//*[@id='myform']/div[3]/div[1]/div[2]/span/span[1]/span/span[2]";

    @Test
    public void homework2Test() {

        WebDriver driver = new ChromeDriver();

        driver.get(PAGE_URL);
        waitForElement(driver, By.id(PASTE_FIELD_ID));

        enterText(driver, By.id(PASTE_FIELD_ID), PASTE_FIELD_TEXT);

        selectSyntaxValue(driver,2);

        selectExpirationDDLValue(driver, 1);

        enterText(driver, By.xpath(PASTE_NAME_FIELD_LOCATOR), PASTE_NAME_FIELD_TEXT);

        clickButton(driver, By.id(SUBMIT_BUTTON_LOCATOR));
        waitForElement(driver, By.id(SUCCESS_MESSAGE_LOCATOR));

  /* Assertion of page title*/
        Assert.assertTrue(driver.getTitle().contains(PASTE_NAME_FIELD_TEXT), "Page title does not contain initial value");

  /* Assertion of code*/
        Assert.assertEquals(driver.findElement(By.className("paste_code")).getText(),PASTE_FIELD_TEXT);

  /* Assertion of bash formatting*/
        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='bash']//li[1]//div[1]//span[1]")).getCssValue("color"),"rgba(194, 12, 185, 1)");

        driver.quit();
    }
    private static void waitForElement(WebDriver driver, By elementName) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elementName));
    }
    private static void selectExpirationDDLValue(WebDriver driver, int index) {
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
    private static void selectSyntaxValue(WebDriver driver, int index) {
        clickButton(driver, By.xpath(EXPAND_SYNTAX_DDL_LOCATOR));
        List<WebElement> findDropDownValue = driver.findElements(By.xpath(SYNTAX_DDL_LOCATOR));
        findDropDownValue.get(index).click();
    }
}

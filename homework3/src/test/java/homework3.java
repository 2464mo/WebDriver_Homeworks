import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework3 {

    private static final String PAGE_URL = "https://cloud.google.com/";
    private static final String SEE_ALL_PRODUCTS_BUTTON_LOCATOR = "//*[@track-name='seeProducts']";
    private static final String SEE_PRICING_BUTTON_LOCATOR = "//*[@track-name='seePricing']";
    private static final String CALCULATORS_LINK_LOCATOR = "//*[@track-name='pricingNav/calculators']";
    private static final String COMPUTE_ENGINE_ICON_LOCATOR ="//*[@id='mainForm']//md-tab-item[1]//div[text()='Compute Engine']";
    private static final String NUMBER_OF_INSTANCES_FIELD_LOCATOR = "//label[contains(text(),'Number of instances')]//following-sibling::input";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM_FIELD_LOCATOR = "//label[contains(text(),'Operating System / Software')]/following-sibling::md-select";
    private static final String OPERATING_SYSTEM_VALUE_LOCATOR = "//md-select-menu//div[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]";
    private static final String VM_CLASS_FIELD_LOCATOR = "//label[contains(text(),'Machine Class')]/following-sibling::md-select";
    private static final String VM_CLASS_VALUE_LOCATOR = "//body/div//md-option[@value='regular']";
    private static final String VM_TYPE_FIELD_LOCATOR = "//label[contains(text(),'Machine type')]/following-sibling::md-select";
    private static final String VM_TYPE_VALUE_LOCATOR = "//body/div//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']//div";
    private static final String ADD_GPUS_CHECKBOX_LOCATOR = "//div[contains(text(),'Add GPUs.')]";
    private static final String GPU_NUMBER_FIELD_LOCATOR = "//label[contains(text(),'Number of GPUs')]/following-sibling::md-select";
    private static final String GPU_NUMBER_VALUE_LOCATOR = "//body/div//md-option[contains(@ng-disabled,'minGPU') and @value='1']";
    private static final String GPU_TYPE_FIELD_LOCATOR = "//label[contains(text(),'GPU type')]/following-sibling::md-select";
    private static final String GPU_TYPE_VALUE_LOCATOR = "//body/div//md-option[@value='NVIDIA_TESLA_V100']";
    private static final String SSD_FIELD_LOCATOR = "//label[contains(text(),'Local SSD')]/following-sibling::md-select";
    private static final String SSD_VALUE_LOCATOR = "//body/div//md-option[contains(@ng-repeat,'supportedSsd') and @value='2']";
    private static final String DATACENTER_LOCATION_FIELD_LOCATOR = "//label[contains(text(),'Datacenter location')]/following-sibling::md-select/md-select-value";
    private static final String DATACENTER_LOCATION_VALUE_LOCATOR = "//body/div//md-option[@value='europe-west3']";
    private static final String USAGE_FIELD_LOCATOR = "//label[contains(text(),'Committed usage')]/following-sibling::md-select";
    private static final String USAGE_VALUE_LOCATOR = "//body/div//div[contains(text(),'1 Year')]/parent::md-option";
    private static final String ESTIMATE_BUTTON_LOCATOR = "//button[contains(text(),'Add to Estimate')]";
    private static final String RESULTS_BLOCK_LOCATOR = "//md-card-content[@id='resultBlock']";
    private static final String RESULT_VM_CLASS_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//div[contains(text(),'VM class:')]";
    private static final String EXPECTED_VM_CLASS_FIELD_VALUE = "regular";
    private static final String RESULT_VM_TYPE_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//div[contains(text(),'Instance type:')]";
    private static final String EXPECTED_VM_TYPE_FIELD_VALUE = "n1-standard-8";
    private static final String RESULT_REGION_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//div[contains(text(),'Region')]";
    private static final String EXPECTED_REGION_FIELD_VALUE = "Frankfurt";
    private static final String RESULT_SSD_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//div[contains(text(),'Total available local SSD space')]";
    private static final String EXPECTED_SSD_FIELD_VALUE = "2x375 GB";
    private static final String RESULT_COMMITMENT_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//div[contains(text(),'Commitment term')]";
    private static final String EXPECTED_COMMITMENT_FIELD_VALUE = "1 Year";
    private static final String TOTAL_COST_FIELD_LOCATOR = "//md-card-content[@id='resultBlock']//b[contains(text(),'Total Estimated Cost:')]";
    private static final String EXPECTED_TOTAL_COST_FIELD_VALUE = "USD 1,187.77 per 1 month";

    @Test
    public void homework3Test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

/*Open the URL*/
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        waitForElement(driver, By.xpath(SEE_ALL_PRODUCTS_BUTTON_LOCATOR));

/*Click All Products button*/
        clickButton(driver, By.xpath(SEE_ALL_PRODUCTS_BUTTON_LOCATOR));

/*Click See Pricing button */
        clickButton(driver, By.xpath(SEE_PRICING_BUTTON_LOCATOR));

/*Click Calculators link */
        clickButton(driver, By.xpath(CALCULATORS_LINK_LOCATOR));
        waitForElement(driver, By.id("idIframe"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("idIframe");

/*Click Compute Engine icon */
        clickButton(driver, By.xpath(COMPUTE_ENGINE_ICON_LOCATOR));

/*Fill the fields */
        clickButton(driver, By.xpath(NUMBER_OF_INSTANCES_FIELD_LOCATOR));
        enterText(driver, By.xpath(NUMBER_OF_INSTANCES_FIELD_LOCATOR), NUMBER_OF_INSTANCES);

        clickButton(driver, By.xpath(OPERATING_SYSTEM_FIELD_LOCATOR));
        clickButton(driver, By.xpath(OPERATING_SYSTEM_VALUE_LOCATOR));

        clickButton(driver, By.xpath(VM_CLASS_FIELD_LOCATOR));
        clickButton(driver, By.xpath(VM_CLASS_VALUE_LOCATOR));

        clickButton(driver, By.xpath(VM_TYPE_FIELD_LOCATOR));
        clickButton(driver, By.xpath(VM_TYPE_VALUE_LOCATOR));

        clickButton(driver, By.xpath(ADD_GPUS_CHECKBOX_LOCATOR));

        clickButton(driver, By.xpath(GPU_NUMBER_FIELD_LOCATOR));
        clickButton(driver, By.xpath(GPU_NUMBER_VALUE_LOCATOR));

        clickButton(driver, By.xpath(GPU_TYPE_FIELD_LOCATOR));
        clickButton(driver, By.xpath(GPU_TYPE_VALUE_LOCATOR));

        scrollToElement(driver, By.xpath(SSD_FIELD_LOCATOR));

        clickButton(driver, By.xpath(SSD_FIELD_LOCATOR));
        clickButton(driver, By.xpath(SSD_VALUE_LOCATOR));

        clickButton(driver, By.xpath(DATACENTER_LOCATION_FIELD_LOCATOR));
        clickButton(driver, By.xpath(DATACENTER_LOCATION_VALUE_LOCATOR));

        clickButton(driver, By.xpath(USAGE_FIELD_LOCATOR));
        clickButton(driver, By.xpath(USAGE_VALUE_LOCATOR));

/*Click Add to Estimate button*/
        clickButton(driver, By.xpath(ESTIMATE_BUTTON_LOCATOR));
        waitForElement(driver, By.xpath(RESULTS_BLOCK_LOCATOR));

/* Assertion of VM class*/
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_VM_CLASS_FIELD_LOCATOR)).getText().contains(EXPECTED_VM_CLASS_FIELD_VALUE));

/* Assertion of VM type*/
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_VM_TYPE_FIELD_LOCATOR)).getText().contains(EXPECTED_VM_TYPE_FIELD_VALUE));

/* Assertion of Region*/
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_REGION_FIELD_LOCATOR)).getText().contains(EXPECTED_REGION_FIELD_VALUE));

/* Assertion of SSD*/
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_SSD_FIELD_LOCATOR)).getText().contains(EXPECTED_SSD_FIELD_VALUE));

/* Assertion of Commitment Term*/
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_COMMITMENT_FIELD_LOCATOR)).getText().contains(EXPECTED_COMMITMENT_FIELD_VALUE));

/* Assertion of total cost*/
        Assert.assertTrue(driver.findElement(By.xpath(TOTAL_COST_FIELD_LOCATOR)).getText().contains(EXPECTED_TOTAL_COST_FIELD_VALUE));

        driver.quit();
    }
    private static void scrollToElement(WebDriver driver, By elementName) throws InterruptedException{
        WebElement element = driver.findElement(elementName);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    private static void waitForElement(WebDriver driver, By elementName) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(elementName));
    }

    private static void waitForElementClickable(WebDriver driver, By elementName) {
        waitForElement(driver, elementName);
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(elementName));
    }

    private static void enterText (WebDriver driver, By fieldName, String sendText) {
        WebElement searchTextField = driver.findElement(fieldName);
        searchTextField.sendKeys(sendText);
    }

    private static void clickButton (WebDriver driver, By buttonName) {
        waitForElementClickable(driver, buttonName);
        WebElement clickButton = driver.findElement(buttonName);
        clickButton.click();
    }
}

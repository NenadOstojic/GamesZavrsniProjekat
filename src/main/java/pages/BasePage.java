package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    ChromeDriver driver;

    @FindBy (xpath = "//div[@class = 'col-xs-12 col-sm-3 col-md-2 col-lg-4']//div[@class = 'block logo']")
    WebElement headerLogo;

    @FindBy (xpath = "//nav[@class = 'block user']//a[@class='login-btn']//span")
    public
    WebElement prijaviteSeHeaderButton;

    @FindBy (xpath = "//nav[@class = 'block user']//a[@class='register-btn']")
    public
    WebElement registujteSeHeaderButton;

    @FindBy (xpath = "//i[@class = 'icon fa fa-search']")
    WebElement searchIcon;

    @FindBy (xpath = "//input[@id = 'search-text']")
    WebElement searchTextField;

    @FindBy (xpath = "/html/body/header/div/div[2]/div/div/div[3]/div[1]/div")
    WebElement shoppingCartIcon;

    @FindBy (xpath = "//div[@class = 'header-carthor-total']")
    WebElement shoppingCartBadgeNumber;

    @FindBy (xpath = "//a[@href = 'https://www.facebook.com/GameSdoo']")
    WebElement facebookLink;

    @FindBy (xpath = "//a[@href = 'https://www.instagram.com/gamesdoo/?hl=en']")
    WebElement instagramLink;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickShoppingCartIcon() {
        print("clickShoppingCartIcon");
        assert isShoppingCartIconPresent() : "Shopping cart is NOT present";
        shoppingCartIcon.click();
    }
    public void clickHeaderLogo() {
        headerLogo.click();
    }

    public void clickPrijavaHeaderButton() {
        prijaviteSeHeaderButton.click();
    }

    public void clickRegistrujteSeHeaderButton() {
        registujteSeHeaderButton.click();
    }

    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void enterTextIntoSearchField(String text) {
        searchTextField.sendKeys(text);
        searchTextField.sendKeys(Keys.ENTER);
    }

    // Verify that Facebook link button is present, scroll down the Home page (alignToTop argument is set to false
    // because the navigation bar was covering some links, and they weren't clickable)

    public void clickOnFacebookLinkButton() {
        assert  isElementPresent(facebookLink) : "Error. Facebook button is not dysplayed.";
        scrollToElement(facebookLink);
        facebookLink.click();
    }

    public void openAndCloseFacebookPage() {
        waitForElement(facebookLink);
        print("Click on Facebook link button.");
        clickOnFacebookLinkButton();
        print("Switch to Facebook tab.");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Facebook URL is displayed.");
        String actualUrl = driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.FACEBOOK_URL);
        print("Close Facebook tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }

    public void clickOnInstagramLinkButton() {
        assert isElementPresent(instagramLink) : "Error. Instagram button is not displayed.";
        scrollToElement(instagramLink);
        instagramLink.click();
    }

    public void openAndCloseInstagramPage() {
        waitForElement(instagramLink);
        print("Click on Instagram link button.");
        clickOnInstagramLinkButton();
        print("Switch to Instagram tab.");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Instagram URL is displayed.");
        String actualUrl = driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.INSTAGRAM_URL);
        print("Close Instagram tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void assertUrl(String actualUrl, String expectedUrl) {
        print("assertUrl (" + actualUrl + ", " + expectedUrl + ")");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + ". Actual: " + actualUrl;
    }

    public boolean verifyURL(String expectedUrl) {
        print("verifyURL ( " + expectedUrl + " )");
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(expectedUrl);
    }

    public boolean isElementPresent(WebElement element){
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        }catch (Exception e) {
            print(e.getMessage());
            print("Element is not present");
            return false;
        }
    }

    public boolean isShoppingCartIconPresent() {
        print("isShoppingCartIconPresent()");
        boolean isPresent = shoppingCartIcon.isDisplayed();
        return isPresent;
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForStalenessOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep((long)seconds * 1000);
        }
        catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void waitForItemListToReload(){
        WebDriverWait wait = new WebDriverWait(driver, 5);}
}

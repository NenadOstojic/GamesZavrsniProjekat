package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryItemPage extends BasePage {

    @FindBy (xpath = "//button [@class = 'btn btn-success abs-button-reserve buyButtonOnLists ']")
    WebElement dodajUKorpuButton;

    public InventoryItemPage(ChromeDriver driver) {super(driver);}

    public void clickAddToCartButton() {
        dodajUKorpuButton.click();
    }



    public void waitForShoppingBadgeNumber(Integer currentNumber, Integer x) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        currentNumber += x;
        String number = "" + currentNumber;
        wait.until(ExpectedConditions.textToBe(By.className("header-carthor-total"), number));
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy (xpath = "//select[@id='sort']")
    WebElement dropDownButton;
    @FindBy(xpath = "//a[@class = 'icon-caret-right']")
    WebElement nextPageButton;

    @FindBy (xpath = "//body/div[1]/main[1]/div[1]/div[4]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")
    WebElement minecraftGame;

    @FindBy (xpath = "/html/body/div[1]/main/div[4]/div/div[1]/div/div[1]/div[2]/div[5]/ul/li/div/div/div[3]")
    WebElement dodajUKorpu;

    @FindBy (xpath = "//*[@id='xpather-xpath']")
    WebElement rezervisiURadnji;

    @FindBy (xpath = "//div[@class = 'header-carthor-total']")
    WebElement shoppingCartBadgeNumber;

    @FindBy (xpath = "/html/body/header/div/div[4]/div/nav/ul/li[3]/a/span")
    WebElement novoButton;

    public void sortItemsByText(String sortType) {
        print("sortItemsByText ( " + sortType + " )");
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(sortType);

    }
//    public void clickDropDownButton() {
//        dropDownButton.click();
//    }

    public void clickNovoButton() {
        print("clickNovoButton");
        novoButton.click();
    }

    public void clickRezervisiURadnji(){
        print("clickRezervisiURadnji");
        rezervisiURadnji.click();
    }

    public void dodajUKorpuButton(){
        print("dodajUKorpuButton");
        dodajUKorpu.click();
    }

    public void clickMinecraftGame() {
        print("clickMinecraftGame");
        minecraftGame.click();
    }

    public Integer getNumberFromShoppingCartIcon() {
        waitForElement(shoppingCartBadgeNumber);
        String number = shoppingCartBadgeNumber.getText();
        return Integer.valueOf(number);
    }

    public void searchItemTypeByKeyword(String keyword) {
        clickSearchIcon();
        enterTextIntoSearchField(keyword);
        List<WebElement> searchResults = getAllItems();

        assert searchResults.size() != 0 : "No results found";
    }

    public List<WebElement> getAllItems() {
        return driver.findElementsByXPath(Strings.ALL_ITEM_LIST_XPATH);
    }

    public InventoryItemPage findItemByName(String itemName) {
        while (true) {
            List<WebElement> itemList = getAllItems();
            //Going through all items on current page
            for (WebElement item : itemList) {
                if (item.getAttribute("title").trim().equals(itemName)) {
                    item.click();

                    String pageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText().trim();
                    assert pageTitle.equals(itemName.trim()) : "Error: wrong product";

                    return new InventoryItemPage(driver);
                }

            }
            if (isElementPresent(nextPageButton)) {
                nextPageButton.click();
                waitForItemListToReload();
            } else {
                break;
            }

        }
        return null;
    }



    public InventoryPage(ChromeDriver driver) {
        super(driver);
    }

    public void clickAkcijeButton() {
        clickAkcijeButton();
    }

    public boolean isSortedAscending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public List<Double> getItemPrices() {
        return null;
    }

    public boolean isSortedAscending() {
        return true;
    }
}

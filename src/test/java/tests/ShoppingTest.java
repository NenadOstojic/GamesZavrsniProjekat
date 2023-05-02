package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.InventoryPage;
import pages.ShoppingCartPage;
import pages.Strings;

public class ShoppingTest extends BaseTest {

    /**
     * 1. Go to site 'www.games.rs'
     * 2. Login on website
     * 3. Click on item 'PS4 Minecraft Legends - Deluxe Edition' to buy it
     * 4. Click on 'dodaj u korpu' button
     * 5. Click on shopping cart icon
     *
     * Expected results:
     * 4. Verify that you are on page 'kupovina'
     * 5. Verify that item is listed in shopping cart page
     */


    @Test
    public void addOneItemIntoShoppingCart() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("1.Go to site 'www.games.rs'");
            BasePage basePage = new BasePage(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Login on website");
            login(driver, Strings.EMAIL, Strings.PASSWORD);

            print("3. Click on item 'PS4 Minecraft Legends - Deluxe Edition' to buy it");
            inventoryPage.clickMinecraftGame();
//            sleep(3);

            print("4. Click on 'dodaj u korpu' button");
            inventoryPage.dodajUKorpuButton();
            sleep(3);

            print("5. Click on shopping cart icon");
            inventoryPage.clickShoppingCartIcon();

            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

            print("4. Verify that you are on page 'kupovina'");

            print("5. Verify that item is listed in shopping cart page");
            String actualItemName = shoppingCartPage.getFirstItemName();
            assert actualItemName.contains(Strings.MINECRAFT) : "Wrong item. Expected: " + Strings.MINECRAFT +
                    ". Actual " + actualItemName;

        }
        finally {
            print("Test finished.");

        }
    }

}

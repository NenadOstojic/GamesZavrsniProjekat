package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.InventoryPage;
import pages.Strings;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SortingTest extends BaseTest {

    /**
     * 1. Go to site 'www.games.rs'
     * 2. Click on 'NOVO'
     * 3. From sorting menu select 'Najskuplje'
     *
     * 4. Verify that item prices is in ascending row.
     */

    @Test
    public void sortItemsByPriceAsc() {
        print("sortItemsByPRiceAsc");
        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Go to site 'www.games.rs'");
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on 'NOVO'");
            inventoryPage.clickNovoButton();
            sleep(3);

            print("3. From sorting menu select 'Najskuplje'");
            inventoryPage.sortItemsByText(Strings.SORTIRAJ);
            sleep(3);

            print("4. Verify that item prices is in ascending row.");
            List<Double> itemPrices = inventoryPage.getItemPrices();
            assertTrue(inventoryPage.isSortedAscending(), "Items are not sorted in ascending order by price");


        }
        finally {
            print("Test finished.");

        }
    }
}

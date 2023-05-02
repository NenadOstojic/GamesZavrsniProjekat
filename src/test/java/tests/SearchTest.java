package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;
import org.testng.reporters.JUnitReportReporter;

public class SearchTest extends BaseTest {

    /**
     * Search by keyword: 'GTA V', go through several pages,
     * find a specific item: 'PS4 Grand Theft Auto 5 - GTA V - Premium Edition'
     *
     * Steps:
     * 1. Go to: 'https://www.games.rs/'
     * 2. Click on search icon
     * 3. Enter 'GTA V' into search field
     * 4. Find and click "PS4 Grand Theft Auto 5 - GTA V - Premium Edition" on search list
     *
     * Expected results:
     * 4.1. Verify that correct item page is displayed
     */

    @Test
    public void searchByItemTypeAndNAme() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Go to: 'https://www.games.rs/");
            InventoryPage inventoryPage = new InventoryPage(driver);
            print("2. Click on search icon");
            print("3. Enter 'GTA V' into search field");
            inventoryPage.searchItemTypeByKeyword("gta v");

            print("4. Find and click 'PS4 Grand Theft Auto 5 - GTA V - Premium Edition' on search list");
            print("4.1 Verify that correct item page is displayed");
            inventoryPage.findItemByName(Strings.GTA_V_TITLE);
        }
        finally {
            print("Test finished.");
        }
    }
}

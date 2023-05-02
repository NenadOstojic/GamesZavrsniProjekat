package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Strings;

public class SocialMediaTests extends BaseTest {

    /**
     * Click on Facebook and Instagram button in footer links.
     *
     * Steps:
     * 1. Go to: 'https://www.games.rs/'.
     * 2. Scroll down on Home page and click on one of footer links.
     * 3. Switch to new tab Facebook/Instagram.
     * 4. Close Facebook/Instagram tab.
     * 5. Switch to Hoem page.
     * 6. Repeat all steps from 2-5 for Instagram footer link.
     *
     * Expected results:
     * Verify that social network URL is displayed in new tab.
     * Verify that Home page is displayed.
     */
    @Test
    public void clickOnSocialNetworks() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("Go to: 'https://www.games.rs/'");
            BasePage basePage = new BasePage(driver);

            //Switch to Facebook tab, assert Games/Facebook URL, close Facebook tab, switch to Home page tab
            basePage.openAndCloseFacebookPage();

            print("Verify that Home page is displayed.");
            String actualUlr = driver.getCurrentUrl();
            assertUrl(actualUlr, Strings.HOME_PAGE_URL);

            //Switch to Instagram tab, assert Games/Instagram URL, close Facebook tab, switch to Home page tab
            basePage.openAndCloseInstagramPage();

            print("Verify that Home page is displayed.");
            String actualUrl1 = driver.getCurrentUrl();
            assertUrl(actualUrl1, Strings.HOME_PAGE_URL);
        }
        finally {
            print("Test finished.");
        }
    }
}

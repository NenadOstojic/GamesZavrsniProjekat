package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

public class LoginAndLogOutTest extends BaseTest {

    /**
     * Successful login from any page with valid credentials
     *
     * Steps:
     * 1. Go to: "https://www.games.rs/"
     * 2. Click on 'Prijavite se' header button to open login modal
     * 3. Enter valid mail address
     * 4. Enter valid password
     * 5. Click 'PRIJAVA' login button
     *
     * Expected results:
     * 6. Verify that 'Prijavite se' header link has changed into user link
     * 7. Verify that 'Registrujte se' header link has changed into 'Odjava' link
     */

    @Test

    public void loginFromHomePageWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Go to: https://www.games.rs");
            LoginPage loginPage = new LoginPage(driver);

            print("2. Click on 'Prijavite se' header button to open login modal");
            loginPage.openLoginModal();

            print("3. Enter valid mail address");
            loginPage.enterTextIntoEmailField(Strings.EMAIL);

            print("4. Enter valid password");
            loginPage.enterTextIntoLozinkaField(Strings.PASSWORD);

            print("5. Click 'PRIJAVA' login button");
            loginPage.clickLoginModalButton();
            sleep(3);

            print("6. Verify that 'Prijavite se' header link has changed into user link");
            assert loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.userHeaderLink + ". Actual: " + loginPage.prijaviteSeHeaderButton;

            print("6. Verify that 'Registrujte se' header link has changed into 'Odjava' link");
            assert loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.odjavaHeaderLink + ". Actual: " + loginPage.registujteSeHeaderButton;
            sleep(3);
        }
        finally {
            print("Test finished.");
        }
    }


    /**
     * Login and Logout test
     * Steps:
     * 1. Go to: "https://www.games.rs/"
     * 2. Login with valid credentials
     * 3. Click on the 'Odjava' header link
     *
     * Expected results:
     * 2.2 Verify that 'Prijavite se' header link has changed into user link
     * 2.2.2 Verify that 'Registrujte se' header link has changed into 'Odjava' link
     * 3.2 Verify that 'Prijavite se' header link has NOT changed into user link
     * 3.2.2 Verify that 'Registrujte se' header link has NOT changed into 'Odjava' link
     */

    @Test
    public void loginLogoutTest() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Go to: https://www.games.rs/");
            LoginPage loginPage = new LoginPage(driver);

            print("2. Login with valid credentials");
            login(driver,Strings.EMAIL, Strings.PASSWORD);

            loginPage.waitForElement(loginPage.userHeaderLink);
            print("2.2 Verify that 'Prijavite se' header link has changed into user link");
            assert  loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.userHeaderLink + ". Actual: " +loginPage.prijaviteSeHeaderButton;

            print("2.2.2 Verify that 'Registrujte se' header link has changed into 'Odjava' link");
            assert loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.odjavaHeaderLink + ". Actual: " + loginPage.registujteSeHeaderButton;

            print("3. Click on the 'Odjava' header link");
            loginPage.clickOdjavaHeaderButton();

            print("3.2 Verify that 'Prijavite se' header link has NOT changed into user link");
            assert !loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.prijaviteSeHeaderButton + ". Actual: " + loginPage.userHeaderLink;

            print("3.2.2 Verify that 'Registrujte se' header link has NOT changed into 'Odjava' link");
            assert !loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.registujteSeHeaderButton + ". Actual: " +loginPage.registujteSeHeaderButton;
        }
        finally {
            print("Test finished.");
        }
    }
}

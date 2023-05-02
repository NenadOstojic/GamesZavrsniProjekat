package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//div[@class='modal-dialog']//form[@class='login_form']")
    WebElement logginModal;

    @FindBy (xpath = "//input[@id = 'login_email']")
    WebElement loginEmailAdresaField;

    @FindBy (xpath = "//input[@id = 'login_password']")
    WebElement loginLozinkaField;

    @FindBy (xpath = "//button[@class = 'btn btn-success btn-login confirm-loader']")
    WebElement modalPrijavaButton;

    @FindBy(xpath = "//li[@class='item item-username']")
    public
    WebElement userHeaderLink;

    @FindBy (xpath = "//li[@class = 'item item-logout']")
            public
    WebElement odjavaHeaderLink;

    public LoginPage(ChromeDriver driver) {super(driver);}

    public void openLoginModal() {
        clickPrijavaHeaderButton();
        waitForElement(logginModal);
        new LoginPage(driver);
    }

    public void enterTextIntoEmailField(String email) {
        waitForElement(loginEmailAdresaField);
        loginEmailAdresaField.sendKeys(email);
    }

    public void enterTextIntoLozinkaField(String password) {
        waitForElement(loginLozinkaField);
        loginLozinkaField.sendKeys(password);
    }

    public void clickLoginModalButton() {modalPrijavaButton.click();}

    public void clickOdjavaHeaderButton() {odjavaHeaderLink.click();}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {


    @FindBy (xpath = "//div[@id = 'order_cart_content']")
    WebElement cartItem;


    public ShoppingCartPage(ChromeDriver driver) {
        super(driver);
        print("ShoppingCartPage");
        assert verifyURL(Strings.SHOPPING_CART_URL) : "Wrong URL";
    }

    public String getFirstItemName() {
        print("getFirstItemName");
        WebElement itemName = cartItem.findElement(By.xpath("//div[@id = 'order_cart_content']"));
        return itemName.getText();
    }
}

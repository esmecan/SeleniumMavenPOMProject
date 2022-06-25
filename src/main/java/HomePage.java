import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    By selectLocator = new By.ByCssSelector("ul.category-section>li:nth-of-type(4)");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct() {
        click(selectLocator);

    }
}

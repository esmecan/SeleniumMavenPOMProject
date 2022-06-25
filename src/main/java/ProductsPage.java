import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {


    SearchBox searchBox;

    By selectLinkLocator = new By.ByCssSelector("div.category-list-wrapper>ul.inner-list>li>a");
    By modelLocator = new By.ByCssSelector("div.category-list-wrapper>ul.inner-list:nth-of-type(4)>li>a");

    By yearButtonLocator = By.xpath("//div[@class='facet'][5]//div[@class='facet-item']//button[@class='facet-button closed'][1]");



    public ProductsPage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;

    }


    public void piece() {
        click(selectLinkLocator);

    }

    public void model() {

        click(modelLocator);
    }



}

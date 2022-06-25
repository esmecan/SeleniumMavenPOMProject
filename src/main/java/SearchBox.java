import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By submitButtonLocator = new By.ByCssSelector("div.facet>div.facet-item.pb>div>div.range-facet>div.facet-content>div.form-row>:nth-of-type(3)>button.btn.btn-search");
    By searchMinLocator = new By.ByCssSelector("div#yil>div.range-facet>div.facet-content>div.form-row>:nth-of-type(1)>div.input>span>input");
    By searchMaxLocator = new By.ByCssSelector("div#yil>div.range-facet>div.facet-content>div.form-row>:nth-of-type(2)>div.input>span>input");

    public SearchBox(WebDriver driver) {
        super(driver);
    }


    public void yearMin(int valueMin) {
        driver.findElement(searchMinLocator);
        click(searchMinLocator);
        typeInt(searchMinLocator , valueMin);
    }

    public void yearMax(int text) {
        driver.findElement(searchMaxLocator);
        click(searchMaxLocator);
        typeInt(searchMaxLocator , text);
    }

    public void search(String value) {
        driver.findElement(submitButtonLocator);
        click(submitButtonLocator);
        type(submitButtonLocator,value);
    }



}

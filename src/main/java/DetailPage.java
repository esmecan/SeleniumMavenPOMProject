import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class DetailPage extends BasePage {

    By productControl = new By.ByCssSelector("div.df.df-fd>span.color-red4.bold.font-default-plus.mb10");

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public String productInProductPage(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(productControl)).getText();
        return e;
    }
    public DetailPage isOnHomePage(){
        Assert.assertEquals(productInProductPage(),"Aramanıza uygun sonuç bulamadık.","Hatalı test! ");
        return this;
    }


}




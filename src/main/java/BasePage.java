import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver ;

    protected WebDriverWait wait;


    //web driver parametresini alması için
    public BasePage(WebDriver driver){

        this.driver = driver ;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //webelement bulan
    public WebElement find (By locator){

        return driver.findElement(locator);
    }


    //webelement listesi döndürmek için
    public List<WebElement> findAll(By locator){

        return driver.findElements(locator);
    }


    //elemente tıklaması için
    public void click(By locator){

        find(locator).click();
    }

    //elementi bulsun ve oraya bir şey yazması için string
    public void type(By locator , String text){

        find(locator).sendKeys(text);
    }


    //elementi bulsun ve oraya bir şey yazması için int
    public void typeInt(By locator , int textMin){

        find(locator).sendKeys((String.valueOf(textMin)));
    }

    //elementin doğruluğunu kontrol et
    public Boolean isDisplayed(By locator){

        return find(locator).isDisplayed();
    }







}

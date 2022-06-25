import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


public class HomeVerification extends BasePage{

    By logoLocator = new By.ByCssSelector("a.header__logo>img");
    By searchLocator = new By.ByCssSelector("div.search-input__container>input");
    By signInLocator = By.xpath("//a[@aria-label='Giriş Yap']");
    By SignUpLocator = By.xpath("//a[@aria-label='Üye ol']");

    By postFreeAdLocator = By.xpath("//button[@class='btn-create-advert']//span");
    By showcaseTitleLocator = By.xpath("//button[@class='btn-create-advert']//span");
    By listLocator = new By.ByCssSelector("div.row>div[class='col-lg-2 col-md-3 col-xs-6']>div.listing-box-item.should-hover>div.inner-container>div.hover-container>a>div");
    By son24saatLocator = By.xpath("//*[@id='wrapper']/div[2]/div[1]/div/div[1]/ul/li[1]/a[1]");
    By saatLocator = By.xpath("//*[@id='wrapper']/div[2]/div[1]/div/div[1]/ul/li[1]/a[2]");
    By isAcilIlanlarLocator = By.xpath("//*[@id='wrapper']/div[2]/div[1]/div/div[1]/ul/li[2]/a/span");

    By fiyatiDusenlerLocator = By.xpath("//*[@id='wrapper']/div[2]/div[1]/div/div[1]/ul/li[3]/a/span");


    public HomeVerification(WebDriver driver) {
        super(driver);
    }

    public boolean isOnLogo() {
        return isDisplayed(logoLocator);
    }

    public boolean searchBox() {
        return isDisplayed(searchLocator);
    }

    public boolean signIn() {
        return isDisplayed(signInLocator);
    }

    public boolean signUp() {
        return isDisplayed(SignUpLocator);
    }
    public boolean postFreeAd() {
        return isDisplayed(postFreeAdLocator);
    }

    public String showcaseTitle(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(showcaseTitleLocator)).getText();
        return e;
    }
    public HomeVerification isOnHomePage(){
        Assert.assertEquals(showcaseTitle(),"Vitrin","Hatalı test! ");
        return this;
    }

    public List<WebElement> getProducts(){
        return findAll(listLocator);
    }
    public boolean checklistLocator() {
        int count=getProducts().size();
        if(count==18){
            return true;
        }
        else {
            return false;
        }

    }

    public String son24saatPage(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(son24saatLocator)).getText();
        return e;
    }
    public HomeVerification issOn24saatPage(){
        Assert.assertEquals(son24saatPage(),"Son 24 Saat","Hatalı test! ");
        return this;
    }

    public String son48saatPage(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(saatLocator)).getText();
        return e;
    }
    public HomeVerification issOn48saatPage(){
        Assert.assertEquals(son48saatPage(),"48 Saat","Hatalı test! ");
        return this;
    }

    public String acilIlanlarPage(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(isAcilIlanlarLocator)).getText();
        return e;
    }
    public HomeVerification isAcilIlanlarPage(){
        Assert.assertEquals(acilIlanlarPage(),"Acil İlanlar","Hatalı test! ");
        return this;
    }

    public String fiyatiDusenlerPage(){
        String e =  wait.until(ExpectedConditions.visibilityOfElementLocated(fiyatiDusenlerLocator)).getText();
        return e;
    }
    public HomeVerification isfiyatiDusenlerPage(){
        Assert.assertEquals(fiyatiDusenlerPage(),"Fiyatı Düşenler","Hatalı test! ");
        return this;
    }














}

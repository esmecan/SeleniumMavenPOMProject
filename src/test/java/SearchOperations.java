import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchOperations extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;
    DetailPage detailPage ;
    HomeVerification homeVerification;

    @Test
    @Order(1)
    public void homeVerification(){

        homeVerification = new HomeVerification(driver);
        //arabam.com logosu görünürlüğü kontol
        Assertions.assertTrue(homeVerification.isOnLogo(),
                "Logo not found!");

        //arama kutusu kontrol
        Assertions.assertTrue(homeVerification.searchBox(),
                "Search box not found!");

        //giriş yap bağlantısı kontrol
        Assertions.assertTrue(homeVerification.signIn(),
               "sign In not found!");

        //üye ol bağlantısı kontrol
       Assertions.assertTrue(homeVerification.signUp(),
               "sign Up not found!");

        //Ücretsiz İlan Ver buton kontrol
        Assertions.assertTrue(homeVerification.postFreeAd(),
                "post a free ad not found!");

    }

    //Sayfanın orta kısmında “Vitrin” başlığının
    @Test
    @Order(2)
    public void homeCenterisOnHomePage(){

        homeVerification = new HomeVerification(driver);
        homeVerification.isOnHomePage();


    }

    //18 tane resimli ilan bağlantısının görünür olduğunun kontrolü
    @Test
    @Order(3)
    public void homeCenterVerification(){

        homeVerification = new HomeVerification(driver);
        homeVerification.checklistLocator();


    }

    //Son 24 Saat başlığının görünür olduğunun kontrolü
    @Test
    @Order(4)
    public void homeLeftVerification(){

        homeVerification = new HomeVerification(driver);
        homeVerification.issOn24saatPage();


    }

    //48 Saat başlığının görünür olduğunun kontrolü
    @Test
    @Order(5)
    public void homeLeftHourVerification(){

        homeVerification = new HomeVerification(driver);
        homeVerification.issOn48saatPage();


    }

    //Acil İlanlar başlığının görünür olduğunun kontrolü
    @Test
    @Order(6)
    public void acilIlanlarVerification(){

        homeVerification = new HomeVerification(driver);
        homeVerification.isAcilIlanlarPage();


    }
    //Fiyatı Düşenler başlığının görünür olduğunun kontrolü
    @Test
    @Order(7)
    public void fiyatiDüsenlerVerification(){

        homeVerification = new HomeVerification(driver);
        homeVerification.isfiyatiDusenlerPage();


    }


    //motorsiklet linkine tıkla
    @Test
    @Order(8)
    public void clickLink(){
        homePage = new HomePage(driver);
        homePage.selectProduct();
    }

   //arama ekranına Suzuki yaz ve arat
    @Test
    @Order(9)
    public void writeProduct(){
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);
        productsPage.searchBox().search("Suzuki");
    }


    //suzuki adet linkine tıkla
    @Test
    @Order(10)
    public void suzukiPieceLink(){
        productsPage = new ProductsPage(driver);
        productsPage.piece();
    }



    //Burgman AN 650 modeline tıkla
    @Test
    @Order(11)
    public void burgmanModel(){
        productsPage = new ProductsPage(driver);
        productsPage.model();

    }


    //Yıl butonuna tıkla
    //Yıl olarak 2000 - 2001 aralığı girilir ve hemen yandaki “Ara” butonuna tıkla
    @Test
    @Order(12)
    public void year() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);


        ////productsPage.yearButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement element =driver.findElement(By.cssSelector("div.facet-container>span>form>div.facet:nth-of-type(5)>div.facet-item>button.facet-button.closed"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).click().build().perform();
        //mouse u istediğimiz web element üzerinde tutar


        productsPage.searchBox().yearMin(2000);
        productsPage.searchBox().yearMax(2001);
    }


    // “Aramanıza uygun sonuç bulamadık. ” hatasını doğrula
    @Test
    @Order(13)
    public void result(){
        detailPage = new DetailPage(driver);
        detailPage.isOnHomePage();

    }








}

package ru.gb.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.assertj.core.api.Assertions.assertThat;

public class UnsplashWebUIPageUObjectTest {
    WebDriver driver;
    UnsplashMainPage mainPage;
    WebDriverWait wait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://unsplash.com");
        mainPage = new UnsplashMainPage(driver);
    }

    @Test
    @DisplayName("Переход на страницу Unsplash в AppStore с главной страницы десктопной сайта")
    void UnsplashDesktopAppStoreAddonTest(){
        driver.manage().window().setSize(new Dimension(970, 850));
        mainPage.openViewMoreLinksMenu()
                .appsAndPluginsLink()
                .openAppstoreAppPage();
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl()).contains(AppsPage.getAppStoreAppLink()),
                () -> assertThat(driver.findElement(By.xpath(AppsPage.getAssertElementAppStore())).isDisplayed()).isTrue());
    }

    @Test
    @DisplayName("Переход на страницу Unsplash в Интернет-магазине Chrome с главной страницы десктопной сайта")
    void UnsplashDesktopChromeAddonTest(){
        driver.manage().window().setSize(new Dimension(970, 850));
        mainPage.openViewMoreLinksMenu()
                .appsAndPluginsLink()
                .openChromeAddonPage();
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl()).contains(AppsPage.getChromeAddonLink()),
                () -> assertThat(driver.findElement(By.xpath(AppsPage.getAssertElementChrome())).isDisplayed()).isTrue());
    }

    @Test
    @DisplayName("Переход на страницу Unsplash в AppStore с главной страницы мобильной версии сайта")
    void UnsplashMobileAppStoreAddonTest() {
        driver.manage().window().setSize(new Dimension(600, 850));
        mainPage.openMobileViewMoreLinksMenu()
                .productMobilePopupList()
                .appsAndPluginsLink()
                .openAppstoreAppPage();
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl()).contains(AppsPage.getAppStoreAppLink()),
                () -> assertThat(driver.findElement(By.xpath(AppsPage.getAssertElementAppStore())).isDisplayed()).isTrue());
    }

    @Test
    @DisplayName("Переход на страницу Unsplash в Интернет-магазине Chrome с главной страницы мобильной версии сайта")
    void UnsplashMobileChromeAddonTest() {
        driver.manage().window().setSize(new Dimension(600, 850));
        mainPage.openMobileViewMoreLinksMenu()
                .productMobilePopupList()
                .appsAndPluginsLink()
                .openChromeAddonPage();
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl()).contains(AppsPage.getChromeAddonLink()),
                () -> assertThat(driver.findElement(By.xpath(AppsPage.getAssertElementChrome())).isDisplayed()).isTrue());
    }

    @Test
    @DisplayName("Ввод запроса halloween в поисковую строку на главной страницы сайта и поиск")
    void searchByQueryTest() {
        String searchQuery = "halloween"; //Поисковый запрос
        mainPage.searchByQuery(searchQuery);
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains("https://unsplash.com/s/photos/"+searchQuery)).isTrue(),
                () -> assertThat(driver.findElement(By.xpath("//h1[@data-test='page-header-title']")).getText()).containsIgnoringCase(searchQuery));
    }
    @Test
    @DisplayName("Ввод запроса halloween в поисковую строку на главной страницы сайта и клик по саджесту")
    void searchBySuggestTest() {
        String searchQuery = "halloween"; //Поисковый запрос
        mainPage.searchBySuggest(searchQuery);
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains("https://unsplash.com/s/photos/"+searchQuery)).isTrue(),
                () -> assertThat(driver.findElement(By.xpath("//h1[@data-test='page-header-title']")).getText()).containsIgnoringCase(searchQuery));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


package ru.gb.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.Keys.ENTER;

public class UnsplashWebUITest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://unsplash.com");
    }

    @ParameterizedTest
    @DisplayName("Переход на страницу Unsplash в AppStore и Интернет-магазине Chrome с главной страницы десктопной сайта")
    @CsvSource({
            "//a[@title='Download Unsplash for iOS'], https://apps.apple.com/us/app/unsplash/id1290631746, //h1[@class='product-header__title app-header__title']",
            "//a[@title='Download Unsplash Instant for Google Chrome'], https://chrome.google.com/webstore/detail/unsplash-instant/pejkokffkapolfffcgbmdmhdelanoaih, //a[@href='https://instant.unsplash.com']"
    })
    void UnsplashDesktopAppStoreAddoneTest(String widgetLinkXpath, String url, String assertSite) {
        driver.manage().window().setSize(new Dimension(970, 850));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='View more links']")));
        actions.moveToElement(driver.findElement(By.xpath("//button[@title='View more links']")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apps & Plugins")));
        actions.moveToElement(driver.findElement(By.linkText("Apps & Plugins")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(widgetLinkXpath)));
        actions.moveToElement(driver.findElement(By.xpath(widgetLinkXpath)))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assertSite))); //Проверки
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains(url)).isTrue(),
                () -> assertThat(driver.findElement(By.xpath(assertSite)).isDisplayed()).isTrue());

    }

    @ParameterizedTest
    @DisplayName("Переход на страницу Unsplash в AppStore и Интернет-магазине Chrome с главной страницы мобильной версии сайта")
    @CsvSource({
            "//a[@title='Download Unsplash for iOS'], https://apps.apple.com/us/app/unsplash/id1290631746, //h1[@class='product-header__title app-header__title']",
            "//a[@title='Download Unsplash Instant for Google Chrome'], https://chrome.google.com/webstore/detail/unsplash-instant/pejkokffkapolfffcgbmdmhdelanoaih, //a[@href='https://instant.unsplash.com']"
    })
    void UnsplashMobileAppStoreAddoneTest(String widgetLinkXpath, String url, String assertSite) {
        driver.manage().window().setSize(new Dimension(600, 850));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Mobile nav menu button']")));
        actions.moveToElement(driver.findElement(By.xpath("//button[@title='Mobile nav menu button']")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1[contains(.,'Product')]")));
        actions.moveToElement(driver.findElement(By.xpath("//div/h1[contains(.,'Product')]")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apps & Plugins")));
        actions.moveToElement(driver.findElement(By.linkText("Apps & Plugins")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(widgetLinkXpath)));
        actions.moveToElement(driver.findElement(By.xpath(widgetLinkXpath)))
                .click()
                .perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assertSite))); //Проверки
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains(url)).isTrue(),
                () -> assertThat(driver.findElement(By.xpath(assertSite)).isDisplayed()).isTrue());
    }

    @Test
    @DisplayName("Ввод запроса halloween в поисковую строку на главной страницы сайта и поиск")
    void searchQueryTest() {
        actions.moveToElement(driver.findElement(By.xpath("//input[@data-test='nav-bar-search-form-input']")))
                .click()
                .sendKeys("halloween")
                .sendKeys(ENTER)
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-test='page-header-title']")));
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains("https://unsplash.com/s/photos/halloween")).isTrue(),
                () -> assertThat(driver.findElement(By.xpath("//h1[@data-test='page-header-title']")).getText()).isEqualTo("Halloween"));
    }

    @Test
    @DisplayName("Ввод запроса halloween в поисковую строку на главной страницы сайта и клик по саджесту")
    void searchQuerySuggestionTest() {
        actions.moveToElement(driver.findElement(By.xpath("//input[@data-test='nav-bar-search-form-input']")))
                .click()
                .sendKeys("halloween")
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='halloween']")));
        actions.moveToElement(driver.findElement(By.xpath("//div[.='halloween']")))
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-test='page-header-title']")));
        Assertions.assertAll(
                () -> assertThat(driver.getCurrentUrl().contains("https://unsplash.com/s/photos/halloween")).isTrue(),
                () -> assertThat(driver.findElement(By.xpath("//h1[@data-test='page-header-title']")).getText()).isEqualTo("Halloween"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


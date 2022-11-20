package ru.gb.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppsPage extends BaseView{

    private static final String assertElementAppStore = "//h1[@class='product-header__title app-header__title']";
    private static final String assertElementChrome = "//a[@href='https://instant.unsplash.com']";
    private static final String chromeAddonLink = "https://chrome.google.com/webstore/detail/unsplash-instant/pejkokffkapolfffcgbmdmhdelanoaih";
    private static final String appStoreAppLink = "https://apps.apple.com/us/app/unsplash/id1290631746";

    private final String chromeAddonWidgetXpath = "//a[@title='Download Unsplash Instant for Google Chrome']";
    private final String appStoreAppWidgetXpath = "//a[@title='Download Unsplash for iOS']";

    @FindBy(xpath = chromeAddonWidgetXpath)
    private WebElement chromeAddonWidget;
    @FindBy(xpath = appStoreAppWidgetXpath)
    private WebElement appStoreAppWidget;

    public AppsPage(WebDriver driver) {
        super(driver);
    }

    public void openChromeAddonPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(chromeAddonWidgetXpath)));
        chromeAddonWidget.click();
    }

    public void openAppstoreAppPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appStoreAppWidgetXpath)));
        appStoreAppWidget.click();
    }

    //Геттеры для проверок
    public static String getAssertElementAppStore() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assertElementAppStore)));
        return assertElementAppStore;
    }

    public static String getAssertElementChrome() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assertElementChrome)));
        return assertElementChrome;
    }

    public static String getChromeAddonLink() {
        return chromeAddonLink;
    }

    public static String getAppStoreAppLink() {
        return appStoreAppLink;
    }
}

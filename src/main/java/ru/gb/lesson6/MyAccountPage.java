package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BaseView {
    private final String collectionsButtonXpath = "//a[@data-test='user-nav-link-collections']";
    @FindBy(xpath = collectionsButtonXpath)
    private WebElement collectionsButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public CollectionPage openCollection(int number) {
        String collectionXpath = "//a[contains(@href, 'My-"+number+"-Collection')]";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(collectionsButtonXpath)));
        collectionsButton
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(collectionXpath)));
        driver.findElement(By.xpath(collectionXpath))
                .click();
        return new CollectionPage(driver);
    }
}

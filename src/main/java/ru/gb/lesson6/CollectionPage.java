package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CollectionPage extends BaseView{
    private final String collectionsTitleXpath = "//h1[@data-test='page-header-title']";
    @FindBy(xpath = collectionsTitleXpath)
    private WebElement collectionTitle;
    public CollectionPage(WebDriver driver) {
        super(driver);
    }
    public void checkOpenedCollectionTitle(Integer expectedCollectionOpened){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(collectionsTitleXpath)));
        Assertions.assertTrue(collectionTitle.getText().contains(expectedCollectionOpened.toString()));
    }
}

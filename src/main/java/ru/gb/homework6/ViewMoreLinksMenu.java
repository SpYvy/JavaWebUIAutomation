package ru.gb.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewMoreLinksMenu extends BaseView{

    private final String productMobilePopupListXpath = "//div/h1[contains(.,'Product')]";
    private final String appsAndPluginsButtonLinkText = "Apps & Plugins";

    @FindBy(xpath = productMobilePopupListXpath)
    private WebElement productMobilePopupList;
    @FindBy(linkText = "Apps & Plugins")
    private WebElement appsAndPluginsButton;

    public ViewMoreLinksMenu(WebDriver driver) {
        super(driver);
    }
    public ViewMoreLinksMenu productMobilePopupList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productMobilePopupListXpath)));
        productMobilePopupList.click();
        return this;
    }
    public AppsPage appsAndPluginsLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(appsAndPluginsButtonLinkText)));
        appsAndPluginsButton.click();
        return new AppsPage(driver);
    }
}

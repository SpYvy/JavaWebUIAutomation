package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewMoreLinksMenu extends BaseView {
    public ViewMoreLinksMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@title='View more links']")
    private WebElement viewMoreLinksMenuButton;

    @FindBy(xpath = "//a[not(@rel= 'nofollow')and @href='/license']")
    private WebElement licensePageButton;

    @FindBy(xpath = "//a[not(@class='m_sUX _aJTq') and @href='/privacy']")
    private WebElement privacyPageButton;

    @FindBy(xpath = "//a[not(@class='m_sUX _aJTq') and @href='/terms']")
    private WebElement termsPageButton;

    @FindBy(xpath = "//a[not(@class='m_sUX _aJTq') and @href='https://unsplash.com/security']")
    private WebElement securityPageButton;

    private void clickViewMoreLinksMenu(){
        viewMoreLinksMenuButton.click();
    }
    public void licensePageButtonClick(){
        clickViewMoreLinksMenu();
        licensePageButton.click();
    }
}

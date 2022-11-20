package ru.gb.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.gb.lesson6.LoginPage;
import ru.gb.lesson6.MyAccountPage;

import static org.openqa.selenium.Keys.ENTER;

public class UnsplashMainPage extends BaseView {

    private final String searchFormInputXpath = "//input[@data-test='nav-bar-search-form-input']";
    private final String viewMoreLinksMenuButtonXpath = "//button[@title='View more links']";
    private final String mobileViewMoreLinksMenuButtonXpath = "//button[@title='Mobile nav menu button']";
    private final String loginXpath = "//a[@href='https://unsplash.com/login']";
    private final String userMenuButtonXpath = "//*[@alt='Avatar of user UnsplashWebTest Test']";
    private final String viewProfileXpath = "//a[@href='/@unsplashusertest']";

    @FindBy(xpath = searchFormInputXpath)
    private WebElement searchFormInput;
    @FindBy(xpath = viewMoreLinksMenuButtonXpath)
    private WebElement viewMoreLinksMenuButton;
    @FindBy(xpath = mobileViewMoreLinksMenuButtonXpath)
    private WebElement mobileViewMoreLinksMenuButton;
    @FindBy(xpath = loginXpath)
    private WebElement loginButton;
    @FindBy(xpath = userMenuButtonXpath)
    private WebElement userMenuButton;
    @FindBy(xpath = viewProfileXpath)
    private WebElement viewProfileButton;

    public UnsplashMainPage(WebDriver driver) {
        super(driver);
    }

    public void searchByQuery(String searchQuery){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchFormInputXpath)));
        actions.click(searchFormInput)
                .sendKeys(searchQuery)
                .sendKeys(ENTER)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-test='page-header-title']")));
    }
    public void searchBySuggest(String searchQuery){
        String suggestXpath = "//div[.='"+searchQuery+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchFormInputXpath)));
        actions.click(searchFormInput)
                .sendKeys(searchQuery)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(suggestXpath)));
        actions.click(driver.findElement(By.xpath(suggestXpath)))
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-test='page-header-title']")));
    }
    public ViewMoreLinksMenu openViewMoreLinksMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewMoreLinksMenuButtonXpath)));
        viewMoreLinksMenuButton.click();
        return new ViewMoreLinksMenu(driver);
    }
    public ViewMoreLinksMenu openMobileViewMoreLinksMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mobileViewMoreLinksMenuButtonXpath)));
        mobileViewMoreLinksMenuButton.click();
        return new ViewMoreLinksMenu(driver);
    }
    public MyAccountPage viewMyProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userMenuButtonXpath)));
        userMenuButton.click();
        viewProfileButton.click();
        return new MyAccountPage(driver);
    }
    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginXpath)));
        loginButton.click();
        return new LoginPage(driver);
    }

}



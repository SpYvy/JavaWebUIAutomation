package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {
    private final String loginXpath = "//a[@href='https://unsplash.com/login']";
    private final String userMenuButtonXpath = "//*[@alt='Avatar of user UnsplashWebTest Test']";
    private final String viewProfileXpath = "//a[@href='/@unsplashusertest']";
    @FindBy(xpath = loginXpath)
    private WebElement loginButton; //= driver.findElement(By.xpath("//a[@href='https://unsplash.com/login']"))
    @FindBy(xpath = userMenuButtonXpath)
    private WebElement userMenuButton;
    @FindBy(xpath = viewProfileXpath)
    private WebElement viewProfileButton;
    public MainPage(WebDriver driver) {
        super(driver);
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

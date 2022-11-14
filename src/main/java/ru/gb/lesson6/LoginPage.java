package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public MainPage login(String login, String password){
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

}

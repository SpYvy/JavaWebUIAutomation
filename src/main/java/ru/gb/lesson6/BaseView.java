package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    private final String email = "y2doe15yyl@kobrandly.com";
    private final String password = "uYf%Dxtb7g#XV@W";

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}

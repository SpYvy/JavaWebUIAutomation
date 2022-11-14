package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCollectionsTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get("https://unsplash.com");
        mainPage = new MainPage(driver);
    }

    @Test
    void openCollectionTest(){
        mainPage.clickLoginButton()
                .login(mainPage.getEmail(), mainPage.getPassword())
                .viewMyProfile()
                .openCollection(2)
                .checkOpenedCollectionTitle(2);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnsplashTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://unsplash.com/");
    }

    @Test
    void goToSomethingTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //жду до 3 секунд для появления каждого элемента
        ((JavascriptExecutor)driver)
                .executeScript("let element = document.evaluate(\"//a[@href=\\\"/awards\\\"]/..\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                        "element.singleNodeValue.remove()");
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='/t/experimental']")))
                .click()
                .perform();
        actions.moveToElement(driver.findElement(By.xpath("//h3[contains(.,'Top contributors')]/../span[1]")))
                .perform();
        actions.click(driver.findElement(By.xpath("//a[contains(.,'View profile')]"))).perform();

        actions.scrollToElement(driver.findElement(By.xpath("//p[contains(.,'Make something awesome')]")))
                .perform();

        Assertions.assertTrue(driver.getCurrentUrl().contains("@"));
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

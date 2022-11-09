package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ActionsTest {
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
    }
    @Test
    void highlightTextTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //жду до 3 секунд для появления каждого элемента
        driver.get("https://translate.yandex.ru/?ui=ru&lang=en-ru&text=test");
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class=\"translation-word translation-chunk\"]")))
                .doubleClick()
                //.moveByOffset(-10,0)
                .perform();
        Thread.sleep(5000);
    }
    //driver.switchTo().frame()
    @Test
    void alertExampleTest() throws InterruptedException {
        driver.get("https://ya.ru");
        ((JavascriptExecutor)driver).executeScript("alert('asdasd')");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(5000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        driver.close();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

package ru.gb.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnsplashSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //Всегда ждать до 3 секунд до появления элементов
        driver.get("https://unsplash.com");

        WebElement navBarSearch = driver.findElement(By.xpath("//input[@data-test='nav-bar-search-form-input']"));
        navBarSearch.click();
        navBarSearch.sendKeys("halloween");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='halloween']")));

        driver.findElement(By.xpath("//div[.='halloween']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}

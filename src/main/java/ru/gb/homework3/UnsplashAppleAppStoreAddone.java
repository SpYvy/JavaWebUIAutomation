package ru.gb.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnsplashAppleAppStoreAddone {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //Всегда ждать до 3 секунд до появления элементов

        //set window size
        driver.manage().window().setSize(new Dimension(970,850));
        driver.get("https://unsplash.com");

        driver.findElement(By.xpath("//button[@title='View more links']")).click();

        driver.findElement(By.linkText("Apps & Plugins")).click();

        driver.findElement(By.xpath("//a[contains(@title,'Download Unsplash for iOS')]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}

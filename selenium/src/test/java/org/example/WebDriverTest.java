package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class WebDriverTest {
    @Test
    public void testRegisterWithNoData(){
        final WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\firefox-driver\\chromedriver.exe");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://24shop.by/");
        WebElement registerLink = new WebDriverWait(driver, 3)
                .until(v -> v.findElement(By.cssSelector(".top-nav-menu--auth div:first-child a")));
        registerLink.click();
        String currentTitle = driver.getTitle();
        WebElement registerButton = new WebDriverWait(driver, 3)
                .until(v -> v.findElement(By.id("button01")));
        registerButton.click();
        Assert.assertEquals(driver.getTitle(), currentTitle, "24shop.by - Регистрация");
    }
}

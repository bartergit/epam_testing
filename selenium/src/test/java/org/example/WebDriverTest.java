package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverTest {
    @Test
    public void testRegisterWithNoDataWithoutClass(){
        final WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\firefox-driver\\chromedriver.exe");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://24shop.by/");
        WebElement registerLink = new WebDriverWait(driver, 3)
                .until(d -> d.findElement(By.cssSelector(".top-nav-menu--auth div:first-child a")));
        registerLink.click();
        String currentTitle = driver.getTitle();
        WebElement registerButton = new WebDriverWait(driver, 3)
                .until(v -> v.findElement(By.id("button01")));
        registerButton.click();
        Assert.assertThrows(TimeoutException.class,()-> new WebDriverWait(driver, 3)
                .until(v -> v.findElement(By.id("04"))));
    }

    @Test
    public void testRegisterWithNoData() throws Exception{
        MainPage mainPage = new MainPage(new ChromeDriver());
        RegistrationPage registrationPage = mainPage.clickOnRegisterLink();
        Assert.assertThrows(NoSuchElementException.class, ()-> registrationPage.Register("", "", ""));
    }

    @Test
    public void testRegisterWithData() throws Exception{
        MainPage mainPage = new MainPage(new ChromeDriver());
        RegistrationPage registrationPage = mainPage.clickOnRegisterLink();
        registrationPage.Register("445474940", "Ivan", "sale@24.shop");
    }
}

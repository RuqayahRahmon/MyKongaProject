package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class KongaLogin {

    WebDriver driver;
    WebDriverWait wait;
    public void kongaActivity(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        // launch the konga page
        driver.get("https://www.konga.com/");
        //maximize the page
        driver.manage().window().maximize();
        //Get the page title and verify that it is correct
        Assert.assertEquals(driver.getTitle(), "Buy Phones, Fashion, Electronics in Nigeria_Konga Online Shopping | Konga Online Shopping");
        // click the login link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/account/login?return_url=/\"]")));
        driver.findElement(By.cssSelector("a[href=\"/account/login?return_url=/\"]")).click();
        // Input Email address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        driver.findElement(By.cssSelector("#username")).sendKeys("shrewdruqqy@gmail.com");
        // Input Password
        driver.findElement(By.cssSelector("#password")).sendKeys("github");
        //Click Login Button
        driver.findElement(By.cssSelector("button[class=\"_0a08a_3czMG _988cf_1aDdJ\"]")).click();
        /*
        * In order to click the logout button, we need to over on the Accounts link
        * So that we can see the logout button
        * */
        // Hover on the Account Link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._3b382_2WveR > a[href=\"/account/profile\"]")));
        WebElement element = driver.findElement(By.cssSelector("._3b382_2WveR > a[href=\"/account/profile\"]"));
        actions.moveToElement(element).perform();
        // Click Logout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class=\"de870_2eIHs a2562_2y9Sv\"]>a")));
        driver.findElement(By.cssSelector("li[class=\"de870_2eIHs a2562_2y9Sv\"]>a")).click();

        //Quit The Browser
        driver.quit();



    }

    public static void main(String [] args){
        KongaLogin kongaLogin = new KongaLogin();
        kongaLogin.kongaActivity();
    }
}

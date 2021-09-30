package com.accesshq.Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class homePageTests {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @AfterEach
    public void clean() {
        driver.quit();
    }

    @Test
    public void headerTest() {
        //Act
        var text = driver.findElement(By.cssSelector("h1.display-1")).getText();

        //Assert
        Assertions.assertEquals("Web Playground", text);
    }

    @Test
    public void tableTest() {
        //Act
        var tableElement= driver.findElement(By.tagName("table"));
        List<WebElement> elements = tableElement.findElements(By.tagName("input"));

        //Assert
        Assertions.assertEquals(1, Integer.parseInt(elements.get(0).getAttribute("value")));
    }

    @Test
    public void logoTest() {
        //Act
        WebElement ahqLogo = driver.findElement(By.cssSelector("[alt = 'AccessHQ Logo']"));

        //Assert
        Assertions.assertTrue(ahqLogo.isDisplayed());
    }

    @Test
    public void upDownButtonTest() {
        //Act
        var button = driver.findElement(By.cssSelector("a[role=button]"));
        button.click();

        //Assert
        String str = "CLICK ME UP!";
        new WebDriverWait(driver,5).until(ExpectedConditions.textToBePresentInElement(button,str));
        Assertions.assertEquals(str,button.getText());
    }

    @Test
    public void loginTest() {
        //Act
        driver.findElement(By.id ("loginButton")).click();
        var response = driver.findElement(By.className("alert-message"));
        new WebDriverWait(driver,10).
                until(ExpectedConditions.textToBePresentInElement(response,"You clicked the login button"));

        //Assert
        Assertions.assertEquals("You clicked the login button",response.getText());
    }
}

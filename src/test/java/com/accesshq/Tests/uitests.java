package com.accesshq.Tests;

import com.accesshq.ui.FormPage;
import com.accesshq.ui.HomePage;
import com.accesshq.ui.PlanetPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class uitests {

    WebDriver formsDriver;

    @BeforeEach
    public void setup() {
        formsDriver = new ChromeDriver();
        //formsDriver.get("https://d18u5zoaatmpxx.cloudfront.net/#/forms");
        formsDriver.get("https://d18u5zoaatmpxx.cloudfront.net/#/planets");
    }

    @AfterEach
    public void clean() {
        formsDriver.quit();
    }

    @Test
    public void jupDistTest() {
        //Setup
        PlanetPage planetPage = new PlanetPage(formsDriver);

        //Act
        var planet = planetPage.getPlanet(planetPage.getPlanets());
        System.out.println("Jupiter's distance from the sun is: " + planetPage.getPlanetDistance(planet));

        //Assert
        Assertions.assertEquals(planetPage.getPlanetDistance(planet), "778,500,000 km");
    }

/*
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
    */

    @Test
    public void submitErrorTest() {
        //Setup
        FormPage fpage = new FormPage(formsDriver);
        fpage.findSubmit().click();

        Assertions.assertTrue(fpage.isNameErrDisplayed());
        Assertions.assertTrue(fpage.isEmailErrDisplayed());
        Assertions.assertTrue(fpage.isAgreeErrDisplayed());

      //  findSubmit(formsDriver).click();

        //Act
        var response = formsDriver.findElement(By.cssSelector("[id='name-err']"));
        var response2 = formsDriver.findElement(By.cssSelector("[id='email-err']"));

        //Assert
        Assertions.assertEquals(response.getText(),"Your name is required");
        Assertions.assertEquals(response2.getText(),"Your email is required");
    }

    @Test
    public void checkTextTest() {
        //Setup
        FormPage fpage = new FormPage(formsDriver);

        //Act
        fpage.setName("Cameron Coyle");
        fpage.setEmail("cameron.coyle@accesshq.com");

        var str = fpage.getName();
        var str2 = fpage.getEmail();

        //Assert
        Assertions.assertTrue(!str.isEmpty());
        Assertions.assertTrue(!str2.isEmpty());
    }

    @Test
    public void checkboxTest() {
        //Setup
        FormPage fpage = new FormPage(formsDriver);

        //Act
        fpage.findAgree().click();

        //Assert
        //Assertions.assertTrue(checkbox.isSelected());
    }

    @Test
    public void fullSubmitTest() {
        //Setup
        FormPage fpage = new FormPage(formsDriver);

        //Act
        fpage.setName("Cameron Coyle");
        fpage.setEmail("cameron.coyle@accesshq.com");
        fpage.findAgree().click();
        fpage.findSubmit().click();

        var popup = fpage.getPopup();
        new WebDriverWait(formsDriver,10).until(ExpectedConditions.visibilityOf(popup));

        //Assert
        Assertions.assertEquals("Thanks for your feedback " + "Cameron Coyle", popup.getText());
    }
}
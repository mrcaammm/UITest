package com.accesshq.Tests;

import com.accesshq.ui.FormPage;
import com.accesshq.ui.PlanetPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class planetPageTests {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/planets");
    }

    @AfterEach
    public void clean() {
        driver.quit();
    }

    @Test
    public void jupDistTest() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
        var planet = planetPage.getPlanet(planetPage.getPlanets());
        System.out.println("Jupiter's distance from the sun is: " + planetPage.getPlanetDistance(planet));

        //Assert
        Assertions.assertEquals(planetPage.getPlanetDistance(planet), "778,500,000 km");
    }


}

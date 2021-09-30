package com.accesshq.Tests;

import com.accesshq.ui.PlanetPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
        var planetTile = planetPage.getPlanet(planetPage.getPlanets());
        System.out.println("Jupiter's distance from the sun is: " + planetTile.getPlanetDistance());

        //Assert
        Assertions.assertEquals(planetTile.getPlanetDistance(), 778500000);
    }

    @Test
    public void printValues() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
        var planetTile = planetPage.getPlanet(planetPage.getPlanets());
        System.out.println(planetTile.getPlanetName());
        System.out.println(planetTile.getPlanetDistance());
        System.out.println(planetTile.getPlanetRadius());
    }
}

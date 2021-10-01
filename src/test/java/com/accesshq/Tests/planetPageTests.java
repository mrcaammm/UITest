package com.accesshq.Tests;

import com.accesshq.strategies.DistanceMatch;
import com.accesshq.strategies.NameMatch;
import com.accesshq.strategies.RadiusMatch;
import com.accesshq.ui.PlanetPage;
import com.accesshq.ui.PlanetTile;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.BiPredicate;

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
    public void jupDistTestByName() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
        var planets = planetPage.getPlanets();
        var planetTile = planetPage.getPlanetByName(planets, planetTile1 -> planetTile1.getPlanetName().
                equalsIgnoreCase("Jupiter"));
        System.out.println("Jupiter's distance from the sun is: " + planetTile.getPlanetDistance());

        //Assert
        Assertions.assertEquals(planetTile.getPlanetDistance(), 778500000);
    }

    @Test
    public void furthestDistTest() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
        var planets = planetPage.getPlanets();
        var furthestPlanetAway = planetPage.getFurthestDist(planets);
        var planetName = planetPage.getPlanetByDistance(planets,planetTile2 -> planetTile2.getPlanetDistance() ==
                furthestPlanetAway).getPlanetName();

        PlanetTile furthestPlanet = planetPage.getPlanetByDistance(planets, planetTile2 -> planetTile2.getPlanetDistance() ==
        furthestPlanetAway);

        //Assert


        System.out.println("The furthest planet from the sun is: " + planetName);
        System.out.print(" with a distance of: " + furthestPlanetAway);
        Assertions.assertEquals(furthestPlanetAway, 2871000000L);
    }

    @Test
    public void jupDistTestByDistance() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);
        var distance = 778500000;

        //Act
        var planets = planetPage.getPlanets();
        var planetTile = planetPage.getPlanetByDistance(planets, planetTile2 -> planetTile2.getPlanetDistance() ==
                distance);
        System.out.println("Jupiter's distance from the sun is: " + planetTile.getPlanetDistance());

        //Assert
        Assertions.assertEquals(planetTile.getPlanetDistance(), 778500000);
    }

    @Test
    public void jupDistTestByRadius() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
        var planets = planetPage.getPlanets();
        var planetTile = planetPage.getPlanetByRadius(planets, new RadiusMatch(69911.0));
        System.out.println("Jupiter's radius is: " + planetTile.getPlanetRadius());

        //Assert
        Assertions.assertEquals(planetTile.getPlanetRadius(), 69911);
    }

    @Test
    public void printValues() {
        //Setup
        PlanetPage planetPage = new PlanetPage(driver);

        //Act
    //    var planetTile = planetPage.getPlanet(planetPage.getPlanets());
    //    System.out.println(planetTile.getPlanetName());
      //  System.out.println(planetTile.getPlanetDistance());
      //  System.out.println(planetTile.getPlanetRadius());
    }
}

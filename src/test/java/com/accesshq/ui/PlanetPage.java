package com.accesshq.ui;

import com.accesshq.strategies.DistanceMatch;
import com.accesshq.strategies.NameMatch;
import com.accesshq.strategies.RadiusMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PlanetPage {

    private final WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPlanets() {
        return driver.findElements(By.cssSelector("[class='planet']"));
    }

    public PlanetTile getPlanetByName (List<WebElement> planets, Predicate<PlanetTile> predicate) {
        for (WebElement planet : planets) {
            PlanetTile planetTile = new PlanetTile(planet);
            if (predicate.test(planetTile)) {
                return planetTile;
            }
        }
        throw new NoSuchElementException("No planet found");
    }

    public long getFurthestDist (List<WebElement> planets) {
        long max = 0;
        for (WebElement planet : planets) {
            PlanetTile planetTile = new PlanetTile(planet);
            if (planetTile.getPlanetDistance() > max) {
                max = planetTile.getPlanetDistance();
            }
        }
        return max;
    }

    public PlanetTile getPlanetByDistance (List<WebElement> planets, Predicate<PlanetTile> predicate) {
        for (WebElement planet : planets) {
            PlanetTile planetTile = new PlanetTile(planet);
            if (predicate.test(planetTile)) {
                return planetTile;
            }
        }
        throw new NoSuchElementException("No planet found");
    }

    public PlanetTile getPlanetByRadius(List<WebElement> planets, RadiusMatch radius) {
        for (WebElement planet : planets) {
            PlanetTile planetTile = new PlanetTile(planet);
            if (radius.match(planetTile)) {
                return planetTile;
            }
        }
        throw new NoSuchElementException("No planet found");
    }
}
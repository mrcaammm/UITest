package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetPage {

    private final WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPlanets() {
        return driver.findElements(By.cssSelector("[class='planet']"));
    }

    public PlanetTile getPlanet (List<WebElement> planets) {
        for (WebElement planet : planets) {
            if (planet.findElement(By.tagName("h2")).getText().equals("Jupiter")) {
                PlanetTile planetTile = new PlanetTile(planet);
                return planetTile;
            }
        }
        throw new NoSuchElementException("No button found");
    }
}

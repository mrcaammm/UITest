package com.accesshq.ui;

import org.openqa.selenium.*;

public class PlanetTile {
    WebElement planet;
    String name;

    public PlanetTile(WebElement planet) {
        this.planet = planet;
        this.name = planet.findElement(By.tagName("h2")).getText();
    }

    public WebElement getPlanet() {
        return this.planet;
    }

    public String getPlanetName() {
        return this.name;
    }

    public long getPlanetDistance() {
        String distance = planet.findElement(By.className("distance")).getText().split(" ")[0];
        return Long.parseLong(distance.replaceAll(",", ""));
    }

    public double getPlanetRadius() {
        String radius = planet.findElement(By.className("radius")).getText().split(" ")[0];
        return Double.parseDouble(radius.replaceAll(",", ""));
    }
}
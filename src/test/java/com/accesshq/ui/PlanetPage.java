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

    public String getPlanetName(WebElement planet) {
        var str = planet.findElement(By.className("name headline primary--text"));
        return str.getText();
    }

    public String getPlanetDistance(WebElement planet) {
        var str = planet.findElement(By.className("distance"));
        return str.getText();
    }

    public List<WebElement> getPlanets() {
        return driver.findElements(By.cssSelector("[class='planet']"));
    }

    public WebElement getPlanet (List<WebElement> planets) {
        for (WebElement ele : planets) {
            if (ele.findElement(By.tagName("h2")).getText().equals("Jupiter")) {
                return ele;
            }
        }
        throw new NoSuchElementException("No button found");
    }
}

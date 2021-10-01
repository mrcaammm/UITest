package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public class RadiusMatch {
    private final double radius;

    public RadiusMatch(double radius) {
        this.radius = radius;
    }

    public Boolean match(PlanetTile planet) {
        return planet.getPlanetRadius() == (radius);
    }
}
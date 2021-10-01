package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public class DistanceMatch {
    private final long distance;

    public DistanceMatch(long distance) {
        this.distance = distance;
    }

    public Boolean match(PlanetTile planet) {
        return planet.getPlanetDistance() == (distance);
    }
}
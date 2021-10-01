package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public class NameMatch implements MatchingStrategy{
    private final String name;

    public NameMatch(String name) {
        this.name = name;
    }


    public Boolean match(PlanetTile planet) {
        return planet.getPlanetName().equalsIgnoreCase(name);
    }
}

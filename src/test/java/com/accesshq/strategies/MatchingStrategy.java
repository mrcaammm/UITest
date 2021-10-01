package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public interface MatchingStrategy {
    public Boolean match(PlanetTile planet);
}

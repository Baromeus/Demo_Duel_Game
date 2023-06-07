package de.baromeus.dueldemo.interfaces;

import de.baromeus.dueldemo.classes.Stats;
import de.baromeus.dueldemo.enums.EStats;

public interface Player {
    void setName(String name);
    void setFocus(EStats stat);
    void startFight();
    Stats getStatisitc();
    String getName();
}

package com.onebee.rpgcontrol.app.Unit.Monster;

import com.onebee.rpgcontrol.app.Unit.IUnit;

public abstract class Monster implements IUnit {

    @Override
    public int getUnitCamp() {
        return 2;
    }
}

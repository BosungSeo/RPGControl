package com.onebee.rpgcontrol.app.Unit.Monster;

import com.onebee.rpgcontrol.app.Core.IUnitBehavior;
import com.onebee.rpgcontrol.app.Unit.IUnit;
import java.util.ArrayList;

public class Skeleton extends Monster {
    IUnitBehavior mbeHavior;
    IUnit mHuman;

    public int getAttackPoint() {
        return 10;
    }

    @Override
    public int setDamage(int d) {
        return 0;
    }

    @Override
    public void setHeal(int d) {

    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getMP() {
        return 0;
    }

    @Override
    public int getStamina() {
        return 0;
    }

    @Override
    public void doTurn() {
        // mbeHavior.attack(this, );
    }

    @Override
    public int getAttributeType() {
        return 0;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void setEnemyList(ArrayList<IUnit> list) {

    }
}

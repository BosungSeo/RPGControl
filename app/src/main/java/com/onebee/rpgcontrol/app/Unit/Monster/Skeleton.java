package com.onebee.rpgcontrol.app.Unit.Monster;

import com.onebee.rpgcontrol.app.Core.IUnitBehavior;
import com.onebee.rpgcontrol.app.Unit.IUnit;

public class Skeleton extends Monster {
    IUnitBehavior mbeHavior;
    IUnit mHuman;

    public int getAttackPoint() {
        return 10;
    }

    @Override
    public void setDamage(int d) {

    }

    @Override
    public void setHeal(int d) {

    }

    @Override
    public void setTargetUnit(IUnit unit) {

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
    public void doTurn(int dice) {
        // mbeHavior.attack(this, );
    }

    @Override
    public int getAttributeType() {
        return 0;
    }

    @Override
    public void setBehaviorInterface(IUnitBehavior i) {
        mbeHavior = i;
    }
}

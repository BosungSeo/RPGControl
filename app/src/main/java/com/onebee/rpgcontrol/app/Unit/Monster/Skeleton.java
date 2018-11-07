package com.onebee.rpgcontrol.app.Unit.Monster;

import com.onebee.rpgcontrol.app.Core.AttackData;
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
    public int setDamage(IUnit from, AttackData data) {
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

    @Override
    public void alarmAllyAttack(IUnit from, IUnit to) {

    }

    @Override
    public void alarmEnemyDeath(IUnit target) {

    }

    @Override
    public void alarmEnemyAdd(IUnit target) {

    }

    @Override
    public void alarmEnemyHealing(IUnit from, IUnit to) {

    }
}

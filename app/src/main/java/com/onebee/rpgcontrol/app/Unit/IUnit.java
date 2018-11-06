package com.onebee.rpgcontrol.app.Unit;

import com.onebee.rpgcontrol.app.Core.IUnitBehavior;

import java.util.ArrayList;

public interface IUnit {
    void initialize();

    int setDamage(int d);

    void setHeal(int d);

    void setEnemyList(ArrayList<IUnit> list);

    int getHP();

    int getMP();

    int getStamina();

    void doTurn();

    int getAttributeType();

    int getAttackPoint();
}

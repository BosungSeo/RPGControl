package com.onebee.rpgcontrol.app.Unit;

import com.onebee.rpgcontrol.app.Core.AttackData;
import com.onebee.rpgcontrol.app.Core.IUnitBehavior;

import java.util.ArrayList;

public interface IUnit {

    void initialize();

    int getUnitCamp();

    int setDamage(IUnit from, AttackData data);

    void alarmAllyAttack(IUnit from, IUnit to);

    void alarmEnemyDeath(IUnit target);

    void alarmEnemyAdd(IUnit target);
    void alarmEnemyHealing(IUnit from, IUnit to);

    void setHeal(int d);

    void setEnemyList(ArrayList<IUnit> list);

    int getHP();

    int getMP();

    int getStamina();

    void doTurn();

    int getAttributeType();

    int getAttackPoint();
}

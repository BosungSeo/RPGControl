package com.onebee.rpgcontrol.app.Core;

import com.onebee.rpgcontrol.app.Unit.IUnit;

public interface IUnitBehavior {
    int attack(IUnit from, IUnit to, AttackData data);
    void death(IUnit target);
    void heal(IUnit from, IUnit to, HealData data);
    void revival(IUnit target);
}

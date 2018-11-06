package com.onebee.rpgcontrol.app.Core;

import com.onebee.rpgcontrol.app.Unit.IUnit;

public interface IUnitBehavior {
    int attack(IUnit a, IUnit d, AttackData data);
}

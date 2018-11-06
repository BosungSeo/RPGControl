package com.onebee.rpgcontrol.app.Unit.Human;

import com.onebee.rpgcontrol.app.Core.AggroData;
import com.onebee.rpgcontrol.app.Unit.IUnit;
import com.onebee.rpgcontrol.app.Unit.Skill.ISkill;

import java.util.ArrayList;

public abstract class Human implements IUnit {
    int mHP;
    int mMP;
    int mST;
    int mStamina;
    protected AggroData mAggroData = new AggroData();
    ArrayList<ISkill> mSkillList = new ArrayList<>();

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
    public void setEnemyList(ArrayList<IUnit> list) {
        mAggroData.setUnit(list);
    }

    @Override
    public void doTurn(int dice) {
        mAggroData.doTurn();
        realTurn(dice);
    }
    abstract protected void realTurn(int dice);
}

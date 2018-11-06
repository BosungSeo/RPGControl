package com.onebee.rpgcontrol.app.Unit.Human;

import com.onebee.rpgcontrol.app.Core.AttackData;
import com.onebee.rpgcontrol.app.Core.IUnitBehavior;
import com.onebee.rpgcontrol.app.Unit.Equipment.IEquipment;
import com.onebee.rpgcontrol.app.Unit.IUnit;
import com.onebee.rpgcontrol.app.Unit.Skill.DrainNormalAttack;
import com.onebee.rpgcontrol.app.Unit.Skill.ISkill;

import java.util.ArrayList;

public class Warrior extends Human implements ISkill.ApproachSkillFeedBack {
    private int mGuardPoint;
    private int mDefencePoint;
    private int mAttactPoint;
    private int mCurrentDice;
    private IUnitBehavior mUnitBehavior;
    private ArrayList<ISkill> mSkills = new ArrayList<>();
    private ArrayList<IEquipment> mEquipments = new ArrayList<>();

    public Warrior(IUnitBehavior i) {
        mUnitBehavior = i;
        mGuardPoint = 10;
        mDefencePoint = 10;
        mAttactPoint = 10;
        mMP = 0;
        mHP = 100;
        mST = 0;
    }

    public void initialize() {
        mSkills.add(new DrainNormalAttack(this));
    }

    @Override
    public int setDamage(int d) {
        return 0;
    }

    @Override
    public void setHeal(int d) {

    }

    @Override
    public void realTurn(int dice) {
        mCurrentDice = dice;
        mST = mST+5;
        if(mST >100)
            mST = 100;
        for(ISkill skill : mSkills) {
            skill.doTurn();
            if(skill.isEnableCast()) {
                if(skill.getNeedST() < mST) {
                    mST -= skill.getNeedST();
                    skill.use();
                    break;
                }

            }
        }
    }

    @Override
    public int getAttributeType() {
        return 0;
    }

    @Override
    public int getAttackPoint() {
        return 0;
    }

    @Override
    public void drainHP(int HP) {

    }

    @Override
    public int attack(int damage, int type, int aggravationRating) {
        int totalEquipmentDamage = 0;
        int totalCriticalRating = 0;
        int resultDamage;
        for(IEquipment e : mEquipments) {
            totalEquipmentDamage += e.getDamage();
            totalCriticalRating +=e.getCriticalRating();
        }
        AttackData data = new AttackData();
        data.setDamage(totalEquipmentDamage);
        data.setType();
        data.setAggravationRating(aggravationRating);
        resultDamage = mUnitBehavior.attack(this, mAggroData.getTopAggroUnit(),data);
        return resultDamage;
    }
}

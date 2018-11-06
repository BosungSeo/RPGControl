package com.onebee.rpgcontrol.app.Unit.Skill;

import com.onebee.rpgcontrol.app.SkillEffect;

public class DrainNormalAttack extends SkillStatus {
    private ApproachSkillFeedBack mFeedBack;
    private int mInitSkillEffect;
    private int mInitSkillDamage;

    public DrainNormalAttack(ApproachSkillFeedBack feedBack) {
        mFeedBack = feedBack;
    }

    @Override
    public void initialize() {
        mInitSkillDamage = 100;
        mInitSkillEffect = SkillEffect.NORMAL;
        mNeedST = 10;
        mNeedHP = 0;
        mNeedMP = 0;
        mInitCoolTime = 10;
        mInitCastingTime = 2;
    }

    @Override
    protected void realUse() {
        int realDamage = mFeedBack.attack(mInitSkillDamage, mInitSkillEffect, 10);
        mFeedBack.drainHP(realDamage / 10);
    }

    @Override
    public int getSkillPriority() {
        return 0;
    }
}

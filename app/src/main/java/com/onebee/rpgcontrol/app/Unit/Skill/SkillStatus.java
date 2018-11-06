package com.onebee.rpgcontrol.app.Unit.Skill;

import com.onebee.rpgcontrol.app.SkillEffect;

public abstract class SkillStatus implements ISkill {
    private final int MIN_COOL_TIME_RATING = 40;
    private final int MIN_CASTING_TIME_RATING = 40;
    // Must Be define each Skill.
    protected int mNeedST;
    protected int mNeedHP;
    protected int mNeedMP;
    protected int mInitCoolTime;
    protected int mInitCastingTime;

    private int mCurrentCastTime;
    private int mCurrentCoolTime;

    private boolean mIsCast;
    private int mReduceCoolTimeRating = 100;
    private int mReduceCastingTimeRating = 100;


    @Override
    public void setReduceCoolTimeRating(int rating) {
        if (rating < MIN_COOL_TIME_RATING)
            rating = MIN_COOL_TIME_RATING;
        mReduceCoolTimeRating = rating;
    }

    @Override
    public void setReduceCastingTimeRating(int rating) {
        if (rating < MIN_CASTING_TIME_RATING)
            rating = MIN_CASTING_TIME_RATING;
        mReduceCastingTimeRating = rating;
    }

    @Override
    public boolean isEnableCast() {
        if (!mIsCast && mCurrentCoolTime == 0)
            return true;
        else
            return false;

    }

    @Override
    public int getNeedST() {
        return mNeedST;
    }

    @Override
    public int getNeedMP() {
        return mNeedMP;
    }

    @Override
    public int getNeedHP() {
        return mNeedHP;
    }

    @Override
    public int getCurrentCoolTime() {
        return mCurrentCoolTime;
    }

    @Override
    public void doTurn() {
        if (mIsCast) {
            mCurrentCastTime++;
            if (mCurrentCastTime > (mInitCastingTime * mReduceCastingTimeRating) / 100) {
                realUse();

                mIsCast = false;
                mCurrentCoolTime = (mInitCoolTime * mReduceCoolTimeRating) / 100;
                mCurrentCastTime = 0;
            }
            return;
        }
        if (mCurrentCoolTime > 0)
            mCurrentCoolTime--;
    }

    @Override
    public void use() {
        mIsCast = true;
    }

    @Override
    public boolean isCasting() {
        return mIsCast;
    }

    protected abstract void realUse();
}

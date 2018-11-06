package com.onebee.rpgcontrol.app.Unit.Skill;

import com.onebee.rpgcontrol.app.SkillEffect;

public interface ISkill {
    void initialize();

    boolean isEnableCast();

    int getNeedST();

    int getNeedMP();

    int getNeedHP();

    int getCurrentCoolTime();

    void doTurn();

    void use();

    boolean isCasting();

    void setReduceCoolTimeRating(int rating);

    void setReduceCastingTimeRating(int rating);

    int getSkillPriority();

    public interface ApproachSkillFeedBack {
        void drainHP(int HP);

        int attack(int damage, int type, int aggravationRating);
    }

    public interface masicSkillFeedBack {

    }

    public interface healSkillFeedBack {

    }

}

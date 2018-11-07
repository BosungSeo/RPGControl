package com.onebee.rpgcontrol.app.Core;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.onebee.rpgcontrol.app.LogUtil;
import com.onebee.rpgcontrol.app.Unit.Human.Human;
import com.onebee.rpgcontrol.app.Unit.Human.Warrior;
import com.onebee.rpgcontrol.app.Unit.IUnit;
import com.onebee.rpgcontrol.app.Unit.Monster.Skeleton;

import java.util.ArrayList;


public class EngineCore implements IUnitBehavior {
    ArrayList<IUnit> mMonsterUnitList = new ArrayList<>();
    ArrayList<IUnit> mHumanUnitList = new ArrayList<>();
    private Handler mMainHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("EngineCore", "AAAA");
            doTurn();
        }
    };
    private GameScheduler mGameScheduler;

    public EngineCore() {
        mMonsterUnitList.add(new Skeleton());
        mHumanUnitList.add(new Warrior(this));
        mGameScheduler = new GameScheduler(mMainHandler);
        mGameScheduler.start();
    }

    private void doTurn() {
        LogUtil.d("doTurn");
        for (IUnit u : mMonsterUnitList)
            u.doTurn();
        for (IUnit u : mHumanUnitList)
            u.doTurn();
    }
    /*
    상대방의 리스트를 가져 온다.
     */
    private ArrayList<IUnit> getEnemyList(IUnit own){
        if(own.getUnitCamp() == Human.HUMAN_CAMP_ID) {
            return mMonsterUnitList;
        }
        else {
            return mHumanUnitList;
        }
    }
    @Override
    public int attack(IUnit from, IUnit to, AttackData data) {
        // TODO : 렌더링 Engine으로 AttacData의 Effect를 전달, a유닛과, b유닛의 위치정보도 같이 전달.
        LogUtil.d();
        // 1은 Human, 그 외 몬스터로 정의, 공격 대상을 자신의 편에게 알림으로, 도발, 회비, 방어등을
        // 유닛이 처리할 수 있도록 한다.
        for(IUnit u : getEnemyList(from)) {
            u.alarmAllyAttack(from, to);
        }

        return to.setDamage(from, data);
    }

    @Override
    public void death(IUnit target) {
        LogUtil.d();
        for(IUnit u : getEnemyList(target)) {
            u.alarmEnemyDeath(target);
        }
    }

    @Override
    public void heal(IUnit from, IUnit to, HealData data) {
        LogUtil.d();
        for(IUnit u : getEnemyList(from)) {
            u.alarmEnemyHealing(from, to);
        }
    }

    @Override
    public void revival(IUnit target) {
        LogUtil.d();
        for(IUnit u : getEnemyList(target)) {
            u.alarmEnemyAdd(target);
        }
    }
}

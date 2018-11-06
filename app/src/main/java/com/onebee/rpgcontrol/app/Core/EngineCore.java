package com.onebee.rpgcontrol.app.Core;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.onebee.rpgcontrol.app.LogUtil;
import com.onebee.rpgcontrol.app.Unit.Human.Warrior;
import com.onebee.rpgcontrol.app.Unit.IUnit;
import com.onebee.rpgcontrol.app.Unit.Monster.Monster;
import com.onebee.rpgcontrol.app.Unit.Monster.Skeleton;

import java.util.ArrayList;
import java.util.Random;


public class EngineCore implements IUnitBehavior {
    Random mRandomGenerator = new Random();
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
            u.doTurn(mRandomGenerator.nextInt(10));
        for (IUnit u : mHumanUnitList)
            u.doTurn(mRandomGenerator.nextInt(10));
    }

    @Override
    public int attack(IUnit a, IUnit d, AttackData data) {
        return d.setDamage(a.getAttackPoint());
    }
}

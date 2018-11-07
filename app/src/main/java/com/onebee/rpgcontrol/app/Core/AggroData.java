package com.onebee.rpgcontrol.app.Core;

import com.onebee.rpgcontrol.app.Unit.IUnit;

import java.util.ArrayList;

public class AggroData {
    private class UnitAggroData {
        IUnit mUint;
        int mAggroValue;

        public UnitAggroData(IUnit unit, int mAggroValue) {
            this.mUint = unit;
            this.mAggroValue = mAggroValue;
        }

        public void setUint(IUnit unit) {
            this.mUint = unit;
        }

        public void setAggroValue(int mAggroValue) {
            this.mAggroValue = mAggroValue;
        }

        public IUnit getUint() {
            return mUint;
        }

        public int getAggroValue() {
            return mAggroValue;
        }
        public void addAggroValue(int value) {
            mAggroValue += value;
        }
    }

    private ArrayList<UnitAggroData> mList = new ArrayList<>();

    public void setUnit(ArrayList<IUnit> list) {
        int defaultValue = list.size() * 100;
        for (IUnit u : list) {
            mList.add(new UnitAggroData(u, defaultValue));
            defaultValue = defaultValue - 100;
        }
    }

    public void doTurn() {
        for (UnitAggroData data : mList) {
            int value = data.getAggroValue();
            value = value - value / 10;
            data.setAggroValue(value);
        }
    }
    public void addAggroValue(IUnit unit, AttackData data) {
        int value = data.getDamage();
        for (UnitAggroData d : mList) {
            if(d.getUint() == unit) {
                d.addAggroValue(value);
                break;
            }
        }
    }
    public void removeUnit(IUnit unit) {
        for (UnitAggroData d : mList) {
            if(d.getUint() == unit) {
                mList.remove(d);
            }
        }
    }
    public void addUnit(IUnit unit) {
        mList.add(new UnitAggroData(unit, 0));
    }
    public IUnit getTopAggroUnit()
    {
        IUnit r = null;
        int tempValue = 0;
        for (UnitAggroData data : mList) {
            if(data.getAggroValue()>tempValue) {
                r = data.getUint();
            }
        }
        return r;
    }
}

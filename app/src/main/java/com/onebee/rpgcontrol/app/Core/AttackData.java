package com.onebee.rpgcontrol.app.Core;

public class AttackData {
    private int damage;
    private int type;
    private int aggravationRating;

    public int getDamage() {
        return damage;
    }

    public int getType() {
        return type;
    }

    public int getAggravationRating() {
        return aggravationRating;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAggravationRating(int aggravationRating) {
        this.aggravationRating = aggravationRating;
    }
}

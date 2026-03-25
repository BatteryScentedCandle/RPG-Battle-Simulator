package Strategies;

public class RangedAttack implements AttackStrategy {
    private String attackName;
    private int range;
    private int damage;
    private int targetCount;
    //private final String damageType = "Ranged";

    public RangedAttack(String attackName, int range, int damage, int targetCount) {
        this.attackName = attackName;
        this.range = range;
        this.damage = damage;
        this.targetCount = targetCount;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getTargetCount() {
        return targetCount;
    }

    @Override
    public String getAttackName() {
        return attackName;
    }

//    @Override
//    public String getDamageType() {
//        return damageType;
//    }
}


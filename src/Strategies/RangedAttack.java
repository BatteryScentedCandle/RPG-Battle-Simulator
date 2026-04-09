package Strategies;

public class RangedAttack implements AttackStrategy {
    private String attackName;
    private int range;
    private int damage;
    private int targetCount;
    private boolean isDoubleHit;
    //private final String damageType = "Ranged";

    public RangedAttack(String attackName, int range, int damage, int targetCount, boolean isDoubleHit) {
        this.attackName = attackName;
        this.range = range;
        this.damage = damage;
        this.targetCount = targetCount;
        this.isDoubleHit = isDoubleHit;
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

    @Override
    public boolean isDoubleHit() {
        return isDoubleHit;
    }

//    @Override
//    public String getDamageType() {
//        return damageType;
//    }
}


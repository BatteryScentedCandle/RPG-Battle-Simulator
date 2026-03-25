package Strategies;

public class MagicAttack implements AttackStrategy {
    private String attackName;
    private int range;
    private int damage;
    private int targetCount;
    //private final String damageType = "Magic";

    public MagicAttack(String attackName, int range, int damage, int targetCount) {
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

}

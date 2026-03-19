public class rangedAttack implements attackStrategy{
    private String attackName;
    private int attackSpeed;
    private int range;
    private int damage;
    private int targetCount;
    private final String damageType = "Ranged";

    public rangedAttack(String attackName, int attackSpeed, int range, int damage, int targetCount) {
        this.attackName = attackName;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damage = damage;
        this.targetCount = targetCount;
    }

    @Override
    public void attackTarget(String attackName) {
    }

    @Override
    public int getAttackSpeed() {
        return attackSpeed;
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
    public String getDamageType() {
        return damageType;
    }
}


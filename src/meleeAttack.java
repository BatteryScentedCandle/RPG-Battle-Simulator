public class meleeAttack implements attackStrategy{
    private String attackName;
    private int range;
    private int damage;
    private int targetCount;
    //private final String damageType = "Melee";

    public meleeAttack(String attackName, int range, int damage, int targetCount) {
        this.attackName = attackName;
        this.range = range;
        this.damage = damage;
        this.targetCount = targetCount;
    }

    @Override
    public void attackTarget(String attackerName) {
        System.out.println(attackerName + " used " + attackName);
        System.out.println("Damage dealt: " + damage);
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
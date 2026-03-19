public interface attackStrategy {
    void attackTarget(String attackerName);
    int getAttackSpeed();
    int getRange();
    int getDamage();
    int getTargetCount();
    String getAttackName();
    String getDamageType();
}

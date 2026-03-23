package ConcreteStrategies;

public interface AttackStrategy {
    void attackTarget(String attackerName);
    int getRange();
    int getDamage();
    int getTargetCount();
    String getAttackName();
    //String getDamageType(); Ignore for now as
}

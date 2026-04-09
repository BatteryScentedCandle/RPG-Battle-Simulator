package Strategies;

public interface AttackStrategy {
    int getRange();
    int getDamage();
    int getTargetCount();
    String getAttackName();
    default boolean isDoubleHit() { return false; }
    default boolean hasHitEffect() { return false; }

    //String getDamageType(); Ignore for now as
}

package Observers;

public interface CombatObserver {
    void onDamageDealt(String attacker, String attackName, String target, int damage);
    void onDefense(String attacker, int defense);
    void onEffectApplied(String target, String effectName);
    void onCharacterDeath(String name);
    void onTurnStart(String characterName);;

}

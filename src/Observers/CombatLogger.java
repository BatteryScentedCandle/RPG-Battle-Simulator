package Observers;

public class CombatLogger implements CombatObserver {
    @Override
    public void onDamageDealt(String attacker, String attackName, String target, int damage) {
        System.out.printf("  ⚔  %s used %s on %s for %d damage!%n", attacker, attackName, target, damage);
    }

    @Override
    public void onDefense(String attacker, int defense) {
        System.out.printf(" %s defense grew by %d!", attacker, defense);
    }

    @Override
    public void onEffectApplied(String target, String effectName) {
        System.out.printf("  ✦  %s is afflicted with %s!%n", target, effectName);
    }

    @Override
    public void onCharacterDeath(String name) {
        System.out.printf("  ✝  %s has been slain!%n", name);
    }

    @Override
    public void onTurnStart(String characterName) {
        System.out.printf("%n--- %s's Turn ---%n", characterName);
    }
}

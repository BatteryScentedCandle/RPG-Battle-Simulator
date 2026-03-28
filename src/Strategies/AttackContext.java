package Strategies;

public class AttackContext {
    private AttackStrategy strategy;

    public AttackContext(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    // Combines base power + strategy bonus
    public int calculateDamage(int baseAttackPower) {
        return baseAttackPower + strategy.getDamage();
    }

    public String getAttackName() {
        return strategy.getAttackName();
    }

    public int getRange() {
        return strategy.getRange();
    }

    public int getTargetCount() {
        return strategy.getTargetCount();
    }
}
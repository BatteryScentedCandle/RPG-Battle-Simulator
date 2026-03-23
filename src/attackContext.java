import ConcreteStrategies.AttackStrategy;

public class attackContext {
    private AttackStrategy strategy;

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeAttack(String attacker) {
        strategy.attackTarget(attacker);
    }
}

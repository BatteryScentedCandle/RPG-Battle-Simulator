package Commands;

import Strategies.AttackStrategy;

public class AttackCommand implements Command{

    private final ActionReceiver receiver;
    private final AttackStrategy strategy;
    private final int damage;

    public AttackCommand(ActionReceiver playerAction, AttackStrategy strategy, int damage) {
        this.receiver = playerAction;
        this.strategy = strategy;
        this.damage = damage;
    }

    @Override
    public void execute() {
        int totalDamage = damage + strategy.getDamage();
        String attackName = strategy.getAttackName();
        receiver.performAttack(totalDamage, attackName);
    }
}

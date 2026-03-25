package Commands;

import Strategies.AttackStrategy;

public class AttackCommand implements Command{

    private final ActionReceiver receiver;
    private final int damage;

    public AttackCommand(ActionReceiver playerAction, int damage) {
        this.receiver = playerAction;
        this.damage = damage;
    }

    @Override
    public void execute() {
        receiver.performAttack(damage);
    }
}

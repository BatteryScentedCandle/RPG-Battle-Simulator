package Commands;

import Strategies.AttackContext;

public class AttackCommand implements Command {
    private final ActionReceiver receiver;
    private final AttackContext context;
    private final int baseAttackPower;

    public AttackCommand(ActionReceiver receiver, AttackContext context, int baseAttackPower) {
        this.receiver = receiver;
        this.context = context;
        this.baseAttackPower = baseAttackPower;
    }

    @Override
    public void execute() {
        int totalDamage = context.calculateDamage(baseAttackPower);
        String attackName = context.getAttackName();
        receiver.performAttack(totalDamage, attackName);
    }
}
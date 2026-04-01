package Commands;

import Factories.CharacterClass;
import Strategies.AttackContext;

public class AttackCommand implements Command {
    private final ActionReceiver receiver;
    private final AttackContext context;
    private final CharacterClass player;

    public AttackCommand(ActionReceiver receiver, AttackContext context, CharacterClass player) {
        this.receiver = receiver;
        this.context = context;
        this.player = player;
    }

    @Override
    public void execute() {
        int totalDamage = context.calculateDamage(player.getAttackPower()); // uses live attack value
        String attackName = context.getAttackName();
        receiver.performAttack(totalDamage, attackName);
    }
}
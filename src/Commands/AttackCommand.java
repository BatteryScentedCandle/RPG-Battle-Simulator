package Commands;

import Factories.CharacterClass;
import Strategies.AttackContext;
import Strategies.AttackStrategy;

public class AttackCommand implements Command {
    private final ActionReceiver receiver;
    private final CharacterClass player;
    private final int attackIndex;          // which attack to use

    public AttackCommand(ActionReceiver receiver, CharacterClass player, int attackIndex) {
        this.receiver = receiver;
        this.player = player;
        this.attackIndex = attackIndex;
    }

    @Override
    public void execute() {
        AttackStrategy strategy = player.getAttacks().get(attackIndex);
        AttackContext context = new AttackContext(strategy);
        int totalDamage = context.calculateDamage(player.getAttackPower());
        receiver.performAttack(totalDamage, context.getAttackName());
    }
}
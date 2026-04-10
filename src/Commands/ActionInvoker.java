package Commands;

import Factories.CharacterClass;

import java.util.ArrayDeque;
import java.util.Deque;

public class ActionInvoker {
    private Deque<Command> history = new ArrayDeque<>();
    private CharacterClass playerCharacter;
    private CharacterClass enemyCharacter;
    private ActionReceiver receiver;

    public ActionInvoker(CharacterClass player, CharacterClass enemy, ActionReceiver receiver) {
        this.playerCharacter = player;
        this.enemyCharacter = enemy;
        this.receiver = receiver;
    }

    // Player turn
    public void executePlayerAction(Command command) {
        receiver.removeDefense();
        receiver.notifyTurnStart(playerCharacter.getName());
        command.execute();
        playerCharacter.tickEffects();
        history.push(command);
    }

    // Enemy turn — auto runs after player
    public void executeEnemyTurn() {
        receiver.notifyTurnStart(enemyCharacter.getName());
        Command enemyAction = new EnemyAttackCommand(receiver);
        enemyAction.execute();
        enemyCharacter.tickEffects();
    }
}

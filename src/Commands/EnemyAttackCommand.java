package Commands;

class EnemyAttackCommand implements Command {
    private final ActionReceiver receiver;

    public EnemyAttackCommand(ActionReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performEnemyAttack();
    }
}
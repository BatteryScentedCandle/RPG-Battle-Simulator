package Commands;

public class AttackCommand implements Command{

    private PlayerAction playerAction;

    public AttackCommand(PlayerAction playerAction) {
        this.playerAction = playerAction;
    }

    @Override
    public void execute() {
        playerAction.act();
    }
}

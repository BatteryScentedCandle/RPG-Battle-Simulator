package Commands;

public class DefendCommand implements Command{

    private final ActionReceiver receiver;

    public DefendCommand(ActionReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performDefense();
    }
}

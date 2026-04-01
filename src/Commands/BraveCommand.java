package Commands;

public class BraveCommand implements Command{

    private final ActionReceiver receiver;

    public BraveCommand(ActionReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performBrave();
    }
}

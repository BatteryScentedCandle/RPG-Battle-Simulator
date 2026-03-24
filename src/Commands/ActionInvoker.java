package Commands;

public class ActionInvoker {
    private Command command;

    public void setAction(Command command) {
        this.command = command;
    }

    public void executeAction() {
        command.execute();
    }
}

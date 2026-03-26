package Commands;

import java.util.Scanner;

public class UseItemCommand implements Command{
    private ActionReceiver receiver;

    public UseItemCommand(ActionReceiver playerAction) {
        this.receiver = playerAction;
    }

    private static int getValidInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.next(); // clear invalid input
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void execute() {
        System.out.println("\nChoose Item: ");
        System.out.println("1 - Potion (Heals Player by 30% of their Max Health)");
        System.out.println("2 - Hi-Potion (Fully heals the Player");
        System.out.println("3 - Rouge Doll (Adds a random debuff to an enemy");

        int itemChoice = getValidInput("Enter choice (1-3): ", 1, 3);

        switch (itemChoice) {
            case 1: receiver.usePotion(); break;
            case 2: receiver.useHiPotion(); break;
            case 3: receiver.useRougeDoll(); break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemChoice);
        }
    }
}


import java.util.Scanner;

import Commands.*;
import Factories.*;
import Strategies.*;

public class Main {

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

    public static void main(String[] args) {

        String defaultName = "Terra";

        // ===== CLASS SELECTION =====
        System.out.println("\nChoose Character Class: ");
        System.out.println("1 - Warrior");
        System.out.println("2 - Archer");
        System.out.println("3 - Magician");

        int classChoice = getValidInput("Enter choice (1-3): ", 1, 3);

        CharacterKit kit = null;

        switch (classChoice) {
            case 1: kit = new FactoryWarrior(); break;
            case 2: kit = new FactoryArcher(); break;
            case 3: kit = new FactoryMage(); break;
        }

        // Create player using factory
        assert kit != null;
        CharacterClass playerCharacter = kit.createCharacter(defaultName);

        // Create enemy directly (boss for now)
        CharacterClass enemyCharacter = new Boss("Enemy", 1000, 1000, 10, 10);

        // Commands.ActionReceiver (handles actions)
        ActionReceiver receiver = new ActionReceiver(playerCharacter, enemyCharacter);
        ActionInvoker invoker = new ActionInvoker();

        System.out.println("\nCurrent Turn: " + playerCharacter.getName());

        // ===== ACTION SELECTION =====
        System.out.println("\nChoose Action");
        System.out.println("1 - Attack");
        System.out.println("2 - Defend");
        System.out.println("3 - Use Item");
        System.out.println("4 - Run");

        int actionChoice = getValidInput("Enter choice (1-4): ", 1, 4);

        Command command = null;

        switch (actionChoice) {
            case 1:
                command = new AttackCommand(receiver, playerCharacter.getAttackPower());
                command.execute();
                break;
            case 2:
                //pending
                return;
            case 3:
                //pending
                return;
            case 4:
                //pending
                return;
        }
    }

}
import java.util.Scanner;

import Commands.*;
import Strategies.MeleeAttack;

public class Main {

    //Note: This main is for testing and may be changed in the future in case I have time to complete the UI
    //Else, Ill just streamline it
    private static int getValidInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return choice;
    }

    public static void main(String[] args) {

        String defaultName = "Terra";

        Character character = null;
        System.out.println("\nChoose Class");
        System.out.println("1 - Warrior");
        System.out.println("2 - Archer");
        System.out.println("3 - Magician");
        int classChoice = getValidInput("Enter choice (1-3): ", 1, 3);

        switch (classChoice) {
            case 1: character = new Warrior(defaultName, 100, 100, 20, 20);      break;
            case 2: character = new Archer(defaultName, 125, 125, 10, 30);       break;
            case 3: character = new Magician(defaultName, 70, 70, 30, 10); break;
        }

        Player player = new Player(character);
        Monster monster = new Monster();
        AttackContext context = new AttackContext();

        PlayerAction playerAction = new PlayerAction();
        Command command = null;
        ActionInvoker actionInvoker = new ActionInvoker();

        System.out.println("Current Turn: " + character.name);
        System.out.println("\nChoose Action");
        System.out.println("1 - Attack");
        System.out.println("2 - Defend");
        System.out.println("3 - UseItem");
        System.out.println("4 - Run");
        int actionChoice = getValidInput("Enter choice (1-4): ", 1, 4);

        switch (actionChoice) {
            case 1: command = new AttackCommand(playerAction);       break;
            case 2:  break;  //Lowers enemy attack
            case 3:  break; //Use potion ig?
            case 4: break; //Chance to run, new enemy is summoned
        }

        //Assume Attack was chosen
        //For now I made it so that you can choose any of the available attack types

        System.out.println("\nChoose Action");
        System.out.println("1 - Melee");
        System.out.println("2 - Magic");
        System.out.println("3 - Ranged");
        int attackChoice = getValidInput("Enter choice (1-3): ", 1, 3);

        switch (actionChoice) {
            case 1: context.setStrategy(new MeleeAttack("ChuChu", 1, character.getAttackPower(), 1));     break;
            case 2:  break;  //Lowers enemy attack
            case 3:  break; //Use potion ig?
        }

        context.executeAttack(character.name);



    }
}

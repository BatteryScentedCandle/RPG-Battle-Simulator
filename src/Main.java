import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Commands.*;
import Factories.*;
import Observers.CombatLogger;
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
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    private static CharacterClass generateRandomEnemy() {
        Random random = new Random();

        String[] prefixes = {"Dark", "Ancient", "Cursed", "Wicked", "Savage"};
        String[] names    = {"Goliath", "Ravager", "Colossus", "Behemoth", "Tyrant"};

        String enemyName = "[Boss] - " + prefixes[random.nextInt(prefixes.length)]
                + " " + names[random.nextInt(names.length)];

        int hp        = 100 + random.nextInt(101); // 100–200
        int attack    = 20  + random.nextInt(31);  // 20–50
        int defense   = 5   + random.nextInt(16);  // 5–20

        return new Boss(enemyName, hp, hp, attack, defense);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your name? ");
        String defaultName = scan.next();

        // ===== CLASS SELECTION =====
        System.out.println("\nChoose Character Class: ");
        System.out.println("1 - Warrior");
        System.out.println("2 - Archer");
        System.out.println("3 - Magician");

        int classChoice = getValidInput("Enter choice (1-3): ", 1, 3);

        CharacterKit kit = null;
        switch (classChoice) {
            case 1: kit = new FactoryWarrior(); break;
            case 2: kit = new FactoryArcher();  break;
            case 3: kit = new FactoryMage();    break;
        }

        System.out.println("\n=== NAVIA ===");
        System.out.println("A pattern-driven RPG battle simulator.");

        boolean keepPlaying = true;

        while (keepPlaying) {
            assert kit != null;
            CharacterClass playerCharacter = kit.createCharacter(defaultName);
            playerCharacter.setAttacks(kit.createAttackStrategies());

            CharacterClass enemyCharacter = generateRandomEnemy();
            System.out.println("\nA new enemy appears: " + enemyCharacter.getName() + "!");

            ActionReceiver receiver = new ActionReceiver(playerCharacter, enemyCharacter);
            ActionInvoker invoker   = new ActionInvoker(playerCharacter, enemyCharacter, receiver);
            receiver.addObserver(new CombatLogger());

            // ===== BATTLE LOOP =====
            while (playerCharacter.isAlive() && enemyCharacter.isAlive()) {
                System.out.println("\n================================");
                System.out.printf("  %s   HP: %d/%d%n",
                        playerCharacter.getName(), playerCharacter.getHealth(), playerCharacter.getMaxHealth());
                System.out.printf("  %s   HP: %d/%d%n",
                        enemyCharacter.getName(), enemyCharacter.getHealth(), enemyCharacter.getMaxHealth());
                System.out.println("================================");

                System.out.println("\n1 - Attack  2 - Defend");
                System.out.println("3 - Use Item  4 - Brave\n");
                int actionChoice = getValidInput("Enter choice (1-4): ", 1, 4);

                Command command = null;
                switch (actionChoice) {
                    case 1:
                        System.out.println("\nChoose Attack:");
                        List<AttackStrategy> attacks = playerCharacter.getAttacks();
                        for (int i = 0; i < attacks.size(); i++) {
                            System.out.printf("%d - %s%n", i + 1, attacks.get(i).getAttackName());
                        }
                        int attackChoice = getValidInput("Enter choice (1-" + attacks.size() + "): ", 1, attacks.size());
                        command = new AttackCommand(receiver, playerCharacter, attackChoice - 1);
                        break;
                    case 2: command = new DefendCommand(receiver); break;
                    case 3: command = new UseItemCommand(receiver); break;
                    case 4: command = new BraveCommand(receiver);  break;
                }

                if (command != null) {
                    invoker.executePlayerAction(command);
                    if (enemyCharacter.isAlive()) {
                        invoker.executeEnemyTurn();
                    }
                }
            }

            // ===== RESULT =====
            if (playerCharacter.isAlive()) {
                System.out.println("\n🏆 VICTORY! " + enemyCharacter.getName() + " was defeated!");
            } else {
                System.out.println("\n💀 DEFEAT! " + playerCharacter.getName() + " has fallen...");
            }

            // ===== PLAY AGAIN =====
            System.out.println("\n1 - Play Again");
            System.out.println("2 - Quit");
            int replayChoice = getValidInput("Enter choice (1-2): ", 1, 2);
            keepPlaying = (replayChoice == 1);
        }

        System.out.println("\nThanks for playing, " + defaultName + "!");
    }
}
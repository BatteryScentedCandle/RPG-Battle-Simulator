package Factories;

import Strategies.AttackStrategy;
import Strategies.MagicAttack;

public class FactoryMage implements CharacterKit {

    @Override
    public CharacterClass createCharacter(String name) {
        return new Magician(
                name,
                125,
                125,
                30,
                5
        );
    }

    @Override
    public AttackStrategy createAttackStrategy() {
        return new MagicAttack(
                generateAttackName(),
                3,
                40,
                1
        );
    }

    private String generateAttackName() {
        String[] prefixes = {"Final", "Quantum", "Abyssal", "Cosmic", "Wild"};
        String[] suffixes = {"Flash", "Quake", "Flare", "Aurora", "Storm"};

        int p = (int)(Math.random() * prefixes.length);
        int s = (int)(Math.random() * suffixes.length);

        return prefixes[p] + " " + suffixes[s];
    }
}

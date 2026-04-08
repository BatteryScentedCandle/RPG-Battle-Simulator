package Factories;

import Strategies.AttackStrategy;
import Strategies.MagicAttack;
import Strategies.RangedAttack;

import java.util.List;

public class FactoryMage implements CharacterKit {

    @Override
    public CharacterClass createCharacter(String name) {
        return new Magician(
                name,
                125,
                125,
                30,
                15
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

    @Override
    public List<AttackStrategy> createAttackStrategies() {
        return List.of(
                new RangedAttack("Basic Spell", 1, 20, 1),
                new RangedAttack(generateAttackName(), 3, 40, 1)
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

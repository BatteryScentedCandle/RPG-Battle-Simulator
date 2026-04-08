package Factories;

import Strategies.AttackStrategy;
import Strategies.RangedAttack;

import java.util.List;

public class FactoryArcher implements CharacterKit {

    @Override
    public CharacterClass createCharacter(String name) {
        return new Archer(
                name,
                175,
                175,
                20,
                20
        );
    }

    @Override
    public AttackStrategy createAttackStrategy() {
        return new RangedAttack(
                generateAttackName(),
                3,
                25,
                1
        );
    }

    @Override
    public List<AttackStrategy> createAttackStrategies() {
        return List.of(
                new RangedAttack("Basic Shot", 1, 20, 1),
                new RangedAttack(generateAttackName(), 3, 25, 1)
        );
    }

    private String generateAttackName() {
        String[] prefixes = {"Perfect", "Infinite", "Destiny", "Gallick", "Shin"};
        String[] suffixes = {"Trigger", "Shot", "Bullet", "Gun", "Kamehameha"};

        int p = (int)(Math.random() * prefixes.length);
        int s = (int)(Math.random() * suffixes.length);

        return prefixes[p] + " " + suffixes[s];
    }
}

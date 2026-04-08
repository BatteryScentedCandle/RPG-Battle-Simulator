package Factories;

import Strategies.AttackStrategy;
import Strategies.MeleeAttack;
import Strategies.RangedAttack;

import java.util.List;

public class FactoryWarrior implements CharacterKit {

    @Override
    public CharacterClass createCharacter(String name) {
        return new Warrior(
                name,
                150,
                150,
                25,
                10
        );
    }

    @Override
    public AttackStrategy createAttackStrategy() {
        return new MeleeAttack(
                generateAttackName(),
                1,
                35,
                1
        );
    }

    @Override
    public List<AttackStrategy> createAttackStrategies() {
        return List.of(
                new RangedAttack("Basic Hit", 1, 20, 1),
                new RangedAttack(generateAttackName(), 1, 35, 1)
        );
    }


    private String generateAttackName() {
        String[] prefixes = {"Final", "Brutal", "Calamity", "Crushing", "Ultimate"};
        String[] suffixes = {"Slash", "Strike", "Cleave", "Blow", "Smash"};

        int p = (int)(Math.random() * prefixes.length);
        int s = (int)(Math.random() * suffixes.length);

        return prefixes[p] + " " + suffixes[s];
    }
}

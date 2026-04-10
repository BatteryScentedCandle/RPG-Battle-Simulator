package Factories;

import Strategies.AttackStrategy;
import java.util.List;

public interface CharacterKit {
    CharacterClass createCharacter(String name);
    AttackStrategy createAttackStrategy();
    default List<AttackStrategy> createAttackStrategies() {
        return List.of(createAttackStrategy());
    }
}
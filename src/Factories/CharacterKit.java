package Factories;

import Strategies.AttackStrategy;
import java.util.List;

public interface CharacterKit {
    CharacterClass createCharacter(String name);
    AttackStrategy createAttackStrategy();           // keep for backwards compat
    default List<AttackStrategy> createAttackStrategies() {  // new
        return List.of(createAttackStrategy());
    }
}
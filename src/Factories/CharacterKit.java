package Factories;

import Strategies.AttackStrategy;

public interface CharacterKit {
    CharacterClass createCharacter(String name);
    AttackStrategy createAttackStrategy();
}

import ConcreteStrategies.AttackStrategy;

public interface CharacterKit {
    Character createCharacter();
    AttackStrategy createAttackStrategy();
}

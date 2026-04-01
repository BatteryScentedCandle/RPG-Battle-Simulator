package Effects;

import Factories.CharacterClass;

public class PoisonedDecorator extends EffectsDecorator{

    private int turns = 5;
    private CharacterClass target;

    public PoisonedDecorator(Effects effects, CharacterClass target) {
        super(effects);
        this.target = target;
    }

    @Override
    public void applyEffect() {
        target.takeTrueDamage(20 / turns);
        System.out.println(target.getName() + " is poisoned! (" + turns + " turns left)");
    }

    @Override
    public void removeEffect() {
        System.out.println(target.getName() + " is no longer burning.");
    }

    @Override
    public String effectName() {
        return "Poisoned!";
    }

    @Override
    public int effectTurns() {
        return turns;
    }

    @Override
    public void tick() {
        turns--;
    }
}

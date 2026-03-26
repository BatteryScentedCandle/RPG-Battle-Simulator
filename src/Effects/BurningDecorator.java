package Effects;

import Factories.CharacterClass;

public class BurningDecorator extends EffectsDecorator{

    private int turns = 3;
    private CharacterClass target;

    public BurningDecorator(Effects effects, CharacterClass target) {
        super(effects);
        this.target = target;
    }

    @Override
    public void applyEffect() {
        target.takeDamage(5); // burn tick damage
        turns--;
        System.out.println(target.getName() + " is burning! (" + turns + " turns left)");
    }

    @Override
    public void removeEffect() {
        System.out.println(target.getName() + " is no longer burning.");
    }

    @Override
    public String effectName() { return "Burning"; }

    @Override
    public int effectTurns() { return turns; }
}

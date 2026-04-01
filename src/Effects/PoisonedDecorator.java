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
        target.takeDamage(turns); //deals damage that will decrease with each turn (I might make this *1.5 for craps and giggles)
        turns --;
        System.out.println(target.getName() + " has been poisoned (" + turns + " turns left)");
    }

    @Override
    public void removeEffect() {
        System.out.println(target.getName() + " is no longer burning.");
    }

    @Override
    public String effectName() {
        return "Poisoned by your constituents";
    }

    @Override
    public int effectTurns() {
        return turns;
    }
}

package Effects;

import Factories.CharacterClass;

public class ShieldedDecorator extends EffectsDecorator{

    private int turns = 3;
    private CharacterClass self;

    public ShieldedDecorator(Effects effects, CharacterClass self){
        super(effects);
        this.self = self;
    }

    public void applyEffect() {
        self.addDefense(10);
        turns--;
        System.out.println(self.getName() + " is shielded (" + turns + " turns left");
    }

    public void removeEffect() {
        System.out.println(self.getName() + " is no longer shielded.");
    }

    public String effectName() {
        return "Shielded";
    }

    public int effectTurns() {
        return turns;
    }
}

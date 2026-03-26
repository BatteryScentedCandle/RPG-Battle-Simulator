package Effects;

import Factories.CharacterClass;

public class ShieldedDecorator extends EffectsDecorator{

    public ShieldedDecorator(Effects effects){
        super(effects);
    }

    public void applyEffect() {
    }

    public void removeEffect() {

    }

    public String effectName() {
        return "Shielded";
    }

    public int effectTurns() {
        return 0;
    }
}

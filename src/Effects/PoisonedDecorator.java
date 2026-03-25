package Effects;

public class PoisonedDecorator extends EffectsDecorator{

    public PoisonedDecorator(Effects effects){
        super(effects);
    }

    public void applyEffect() {

    }

    public void removeEffect() {

    }

    public String effectName() {
        return "Poisoned";
    }

    public int effectTurns() {
        return 0;
    }
}

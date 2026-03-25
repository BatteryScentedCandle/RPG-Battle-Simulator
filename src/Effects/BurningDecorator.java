package Effects;

public class BurningDecorator extends EffectsDecorator{

    public BurningDecorator(Effects effects){
        super(effects);
    }

    public void applyEffect() {

    }

    public void removeEffect() {

    }

    public String effectName() {
        return "On Fire";
    }

    public int effectTurns() {
        return 0;
    }
}

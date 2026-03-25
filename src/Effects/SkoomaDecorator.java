package Effects;

public class SkoomaDecorator extends EffectsDecorator{ //I'll gonna delete this later

    public SkoomaDecorator(Effects effects){
        super(effects);
    }

    public void applyEffect() {
        System.out.println("You have the urge to beat your spouse but they are not here at the moment so you turn your anger towards the enemy (turns + 1)");
    }

    public void removeEffect() {

    }

    public String effectName() {
        return "Skooma Addicted";
    }

    public int effectTurns() {
        return 0;
    }
}

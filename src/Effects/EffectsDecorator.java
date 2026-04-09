package Effects;

public abstract class EffectsDecorator implements Effects{
    protected Effects effects;

    public EffectsDecorator (Effects effects){
        this.effects = effects;
    }

}

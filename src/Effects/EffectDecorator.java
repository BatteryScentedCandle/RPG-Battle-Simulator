package Effects;

public interface EffectDecorator {
    void applyEffect();
    void removeEffect();
    String effectName();
    int effectTurns();
}

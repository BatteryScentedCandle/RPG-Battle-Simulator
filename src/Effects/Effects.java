package Effects;

public interface Effects {
    void applyEffect();
    void removeEffect();
    String effectName();
    int effectTurns();
    void tick();
}
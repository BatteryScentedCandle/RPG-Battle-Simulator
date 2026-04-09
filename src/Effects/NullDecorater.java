package Effects;

public class NullDecorater implements Effects {
    @Override
    public void applyEffect() {
    }

    @Override
    public void removeEffect() {

    }

    @Override
    public String effectName() {
        return "";
    }

    @Override
    public int effectTurns() {
        return 0;
    }

    @Override
    public void tick() {

    }
}

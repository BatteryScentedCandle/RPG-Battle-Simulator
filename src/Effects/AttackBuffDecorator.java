package Effects;

import Factories.CharacterClass;

public class AttackBuffDecorator extends EffectsDecorator {

    private int turns = 2;
    private int buffAmount = 30;
    private CharacterClass target;

    public AttackBuffDecorator(Effects effects, CharacterClass target) {
        super(effects);
        this.target = target;
    }

    @Override
    public void applyEffect() {
        target.addAttackBuff(buffAmount);
        System.out.println(target.getName() + " is attack buffed! (" + turns + " turns left)");
    }

    @Override
    public void removeEffect() {
        target.removeAttackBuff(buffAmount);
        System.out.println(target.getName() + "'s attack buff wore off.");
    }

    @Override
    public void tick() {
        turns--;
    }

    @Override
    public String effectName() { return "AttackBuff"; }

    @Override
    public int effectTurns() { return turns; }
}
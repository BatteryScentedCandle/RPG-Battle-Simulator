package Factories;

import Effects.Effects;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterClass {
    String name;
    int maxHealth;
    int health;
    int attackPower;
    int shield;
    final int baseShield;
    private List<Effects> activeEffects = new ArrayList<>();


    public CharacterClass(String name, int maxHealth, int health, int attackPower, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.shield = defense;
        this.baseShield = defense;
    }

    public void takeDamage(int baseDamage){
        int actualDamage = baseDamage - shield;
        if (actualDamage < 0){
            actualDamage = 0;
        }
        health -= actualDamage;
        if (health < 0){
            health = 0;
        }
    }

    public void addEffect(Effects effect) {
        activeEffects.add(effect);
        effect.applyEffect();
    }

    public void removeEffect(Effects effect) {
        activeEffects.remove(effect);
        effect.removeEffect();
    }

    public void tickEffects() {
        activeEffects.removeIf(e -> e.effectTurns() <= 0);
        for (Effects e : activeEffects) {
            e.applyEffect();
        }
    }

    public void healDamage(int heal){
        health += heal;
        if (health > maxHealth){
            health = maxHealth;
        }
    }

    public void addDefense(int defense){
        shield += defense;
    }

    public void removeDefense(int defense) {
        shield = Math.max(baseShield, shield - defense);
    }

    public void addAttack(int attack){
        attackPower += attack;
    }

    //TODO: attack function once buffs and debuffs are figured out
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }
}

class Warrior extends CharacterClass {
    public Warrior(String name, int maxHealth, int health, int attackPower, int defense) {
        super(name, maxHealth, health, attackPower, defense);
    }
}

class Archer extends CharacterClass {
    public Archer(String name, int maxHealth, int health, int attackPower, int defense) {
        super(name, maxHealth, health, attackPower, defense);
    }
}

class Magician extends CharacterClass {
    public Magician(String name, int maxHealth, int health, int attackPower, int defense) {
        super(name, maxHealth, health, attackPower, defense);
    }
}


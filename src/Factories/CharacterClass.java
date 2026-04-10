package Factories;

import Effects.Effects;
import Strategies.AttackStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterClass {
    String name;
    int maxHealth;
    int health;
    int attack;
    int baseAttack;
    int shield;
    final int baseShield;
    private List<Effects> activeEffects = new ArrayList<>();
    private List<AttackStrategy> attacks = new ArrayList<>();

    public CharacterClass(String name, int maxHealth, int health, int attack, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.baseAttack = attack;
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

    public void takeTrueDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(getName() + " took " + damage + " damage from effects! HP: " + health);
    }

    public void addEffect(Effects effect) {
        activeEffects.add(effect);
    }

    public void tickEffects() {
        for (Effects e : activeEffects) {
            e.applyEffect();
            e.tick();
        }
        activeEffects.removeIf(e -> {
            if (e.effectTurns() <= 0) {
                e.removeEffect(); // properly cleans up on expiry
                return true;
            }
            return false;
        });
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

    public void addAttackBuff(int amount) {
        attack += amount;
    }

    public void removeAttackBuff() {
        attack = baseAttack;
    }

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
        return attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setAttacks(List<AttackStrategy> attacks) {
        this.attacks = attacks;
    }

    public List<AttackStrategy> getAttacks() {
        return attacks;
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


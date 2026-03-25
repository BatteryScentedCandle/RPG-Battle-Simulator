package Factories;

public abstract class CharacterClass {
    String name;
    int maxHealth;
    int health;
    int attackPower;
    int shield;

    public CharacterClass(String name, int maxHealth, int health, int attackPower, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.shield = defense;
    }

    public void takeDamage(int damage){
        int net = damage - shield;
        if (net < 0){
            net = 0;
        }
        health -= net;
        if (health < 0){
            health = 0;
        }
    }

    public void healDamage(int heal){
        health += heal;
        if (health > maxHealth){
            health = maxHealth;
        }
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


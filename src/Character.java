public abstract class Character {
    String name;
    int maxHealth;
    int health;
    int attackPower;
    int shield;
//    int level;
//    int xp;
//    int xpToNextLevel; //might be used if we have time

    public Character(String name, int maxHealth, int health, int attackPower, int defense) {
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

    //add attack function once buffs and debuffs are figured out

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

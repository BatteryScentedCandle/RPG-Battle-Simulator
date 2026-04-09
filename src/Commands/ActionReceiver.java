package Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Effects.*;
import Factories.*;
import Observers.*;

public class ActionReceiver {
   private CharacterClass playerCharacter;
   private CharacterClass enemyCharacter;
   private List<CombatObserver> observers = new ArrayList<>();
   private int tempDefenseBonus = 0;
   private boolean isDefending = false;
   private boolean isBraved = false;


   public ActionReceiver(CharacterClass playerCharacter, CharacterClass enemyCharacter) {
      this.playerCharacter = playerCharacter;
      this.enemyCharacter = enemyCharacter;
   }

   public void addObserver(CombatObserver observer) {
      observers.add(observer);
   }

   // --- Attack ---
   public void performAttack(int damage, String attackName) {
      enemyCharacter.takeDamage(damage);
      notifyDamage(playerCharacter.getName(), attackName, enemyCharacter.getName(), damage);
      if (!enemyCharacter.isAlive()) {
         notifyDeath(enemyCharacter.getName());
      }
   }

   public void applyBonusDamage(int damage) {
      enemyCharacter.takeDamage(damage);
      notifyDamage(playerCharacter.getName(), "Arcane Aftershock", enemyCharacter.getName(), damage);
      if (!enemyCharacter.isAlive()) {
         notifyDeath(enemyCharacter.getName());
      }
   }

   public void performEnemyAttack() {
      int damage = enemyCharacter.getAttackPower();
      playerCharacter.takeDamage(damage);

      //Icba to make a dedicated attack for him
      notifyDamage(enemyCharacter.getName(), "GARGANTUA PUNISHER", playerCharacter.getName(), damage);
      if (!playerCharacter.isAlive()) {
         notifyDeath(playerCharacter.getName());
      }
   }


   // --- Defense ---
   public void performDefense() {
      if (isDefending) return; // prevent stacking

      tempDefenseBonus = 50;
      playerCharacter.addDefense(tempDefenseBonus);
      isDefending = true;
      notifyDefense(playerCharacter.getName(), playerCharacter.getShield());
   }

   public void removeDefense() {
      if (!isDefending) return;

      playerCharacter.removeDefense(tempDefenseBonus);
      tempDefenseBonus = 0;
      isDefending = false;
   }


   // --- Use Items ---
   public void usePotion() {
      int healingCount = (int) (playerCharacter.getMaxHealth() * 0.30);
      playerCharacter.healDamage(healingCount);
   }

   public void useHiPotion() {
      playerCharacter.healDamage(playerCharacter.getMaxHealth());
   }

   //TODO EFFECTS
   public void useRougeDoll() {
       Random random = new Random();
       int randomEffect = random.nextInt(2); //add +1 if you need to add more effects

       switch (randomEffect){
           case 0:
              Effects burn = new BurningDecorator(new NullDecorater(), enemyCharacter);
              enemyCharacter.addEffect(burn);
              notifyEffectApplied(enemyCharacter.getName(), burn.effectName());
              break;

           case 1:
               Effects poison = new PoisonedDecorator(new NullDecorater(), enemyCharacter);
               enemyCharacter.addEffect(poison);
              notifyEffectApplied(enemyCharacter.getName(), poison.effectName());
               break;
       }
   }


   // --- Brave --- This is meant to replace run, this acts as the attackbuff effect to the user
   public void performBrave() {
      if (isBraved) return; // prevent stacking
      Effects attackBuff = new AttackBuffDecorator(new NullDecorater(), playerCharacter);
      playerCharacter.addEffect(attackBuff);
      isBraved = true;
      notifyEffectApplied(playerCharacter.getName(), attackBuff.effectName());
   }


   // --- Notify helpers ---
   private void notifyDamage(String attacker, String attackName, String target, int damage) {
      observers.forEach(o -> o.onDamageDealt(attacker, attackName, target, damage));
   }

   private void notifyDefense(String attacker, int defense) {
      observers.forEach(o -> o.onDefense(attacker, defense));
   }

   private void notifyDeath(String name) {
      observers.forEach(o -> o.onCharacterDeath(name));
   }

   public void notifyTurnStart(String name) {
      observers.forEach(o -> o.onTurnStart(name));
   }

   private void notifyEffectApplied(String target, String effectName) {
      observers.forEach(o -> o.onEffectApplied(target, effectName));
   }

}

package Commands;

import java.util.Random;
import Factories.*;


//Commands.ActionReceiver
public class ActionReceiver {
   private CharacterClass playerCharacter;
   private CharacterClass enemyCharacter;
   private Random rng = new Random();

   public ActionReceiver(CharacterClass playerCharacter, CharacterClass enemyCharacter) {
      this.playerCharacter = playerCharacter;
      this.enemyCharacter = enemyCharacter;
   }

   public String getPlayerName() { return playerCharacter.getName(); }

   // --- Attack ---
   public void performAttack(int damage) {
      int dealt = Math.max(0, damage - enemyCharacter.getShield());
      enemyCharacter.takeDamage(dealt);
      System.out.printf("%s attacks for %d damage! (Monster HP: %d/%d)%n",
              playerCharacter.getName(), dealt, enemyCharacter.getHealth(), enemyCharacter.getMaxHealth());
   }
}

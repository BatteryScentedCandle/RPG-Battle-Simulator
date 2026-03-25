import Factories.CharacterClass;

class Player implements Observer {
   private CharacterClass character;

    public Player(CharacterClass character) {
        this.character = character;
    }

    //Pending changes
    @Override
    public void update(String message) {
        System.out.println(character.getName() + "message: " + message);
    }
}

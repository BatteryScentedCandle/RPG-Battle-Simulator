class Player implements Observer {
   private Character character;

    public Player(Character character) {
        this.character = character;
    }

    //Pending changes
    @Override
    public void update(String message) {
        System.out.println(character.name + "message: " + message);
    }
}

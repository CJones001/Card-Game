package CardGame;

public class Player {
    private String name;
    private Hand hand;
    public void setHand(Hand h){
        hand = h;
        hand.setValue();
    }
    public void setName(String player){
        name = player;
    }
    public String showHand(){
        return hand.showHand();
    }
    public String getName(){
      return name;
    }
    public Hand getHand(){
        return hand;
    }

}

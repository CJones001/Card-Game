package CardGame;

public class Card {
    private int Value;
    private String Suit;
    public void setSuit(int s){
        if (s==0){
            Suit = "Hearts";
        }
        if (s==1) {
            Suit = "Clubs";
        }
        if (s==2){
            Suit = "Spades";
        }
        if(s==3){
            Suit = "Diamonds";
        }
    }
    public void setValue(int v)
    {
        Value = v;
    }
    public int getValue(){
        return Value;
    }
    public String getSuit(){
        return Suit;
    }
    public String getCard(){
        return Value + " of " + Suit;
    }

}

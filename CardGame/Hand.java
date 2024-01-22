package CardGame;

import java.util.ArrayList;
public class Hand {
    private int Value;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public void setHand(ArrayList<Card> hs){
        hand = hs;
    }
    public Card getCard(int i){
        return hand.get(i);
    }
    public void addCard(Card c){
        hand.add(c);
    }
    public String showHand(){
        String cardSuit = "";
        for (int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            String showCard = card.getCard();
            int value = card.getValue();
            if(value == 1){
                cardSuit += "Ace of " + card.getSuit() + "\n";
            }
            else if(value == 11){
                cardSuit += "Jack of " + card.getSuit() + "\n";
            }
            else if(value == 12){
                cardSuit += "Queen of " + card.getSuit() + "\n";
            }
            else if(value == 13){
                cardSuit += "King of " + card.getSuit() + "\n";
            }
            else {
                cardSuit += showCard + "\n";
            }
        }
        return cardSuit + Value;
    }
    public String showCard(Card c){
        String card = "";
        String showCard = c.getCard();
        int value = c.getValue();
        if(value == 1){
            card += "Ace of " + c.getSuit();
        }
        else if(value == 11){
            card += "Jack of " + c.getSuit();
        }
        else if(value == 12){
            card += "Queen of " + c.getSuit();
        }
        else if(value == 13){
            card += "King of " + c.getSuit();
        }
        else {
            card += showCard;
        }
        return card;
    }
    public int findValue(){
        int value = 0;
        for (int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            int v = card.getValue();
            if(v > 10) {
                value += 10;
            }
            else{
                value += v;
            }
        }
        for (int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            int v = card.getValue();
            if (v == 1){
                if(value < 21){
                    value += 10;
                    if(value > 21){
                        value -= 10;
                    }
                }
            }
        }

        Value = value;
        return Value;
    }
    public int cardValue(Card c){
        int v = c.getValue();
        int value = 1;
        if(v>10){
            value = 10;
        }
        if(v==1){
            value += 10;
        }
        else {
            value = v;
        }
        return value;
    }
    public void setValue(){
        int value = 0;
        for (int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            int v = card.getValue();
            if(v > 10) {
                value += 10;
            }
            else{
                value += v;
            }
        }
        for (int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            int v = card.getValue();
            if (v == 1){
                if(value < 21){
                    value += 10;
                    if(value > 21){
                        value -= 10;
                    }
                }
            }
        }

        Value = value;
    }
}

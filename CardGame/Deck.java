package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private final ArrayList<Card> deck = new ArrayList<Card>();

    public void createDeck() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card c = new Card();
                c.setValue(i);
                c.setSuit(j);
                deck.add(c);
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }
    public ArrayList<Card> deal(int numCards){
        ArrayList<Card> hand = new ArrayList<Card>();
        for(int i = 0; i < numCards; i++){
            int index = (int)(Math.random() * deck.size());
            Card c = deck.get(index);
            hand.add(c);
        }
        return hand;
    }
    public int deckSize(){
        return deck.size();
    }
    public Card getCard(int i){
        return deck.get(i);
    }

}
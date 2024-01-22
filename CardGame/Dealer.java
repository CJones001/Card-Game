package CardGame;

import java.util.ArrayList;
import java.util.Scanner;
public class Dealer {
    private Deck deck;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Hand hand;

    public void setPlayers(int num){
        ArrayList<Player> p = new ArrayList<Player>();
        for(int i = 0; i < num ; i++){
            Player player = new Player();
            p.add(player);
        }
        players = p;
    }
    public void setPlayerName(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < players.size(); i++){
            System.out.println("What is Player " + (i + 1) + "'s name?");
            players.get(i).setName(sc.next());
        }
        System.out.println();
    }
    public void setHands(){
        for (int i = 0; i < players.size(); i++) {
            Hand h = new Hand();
            h.setHand(deck.deal(2));
            players.get(i).setHand(h);
        }
        Hand dHand = new Hand();
        dHand.setHand(deck.deal(2));
        dHand.setValue();
        hand = dHand;
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public void setDeck(){
        Deck d = new Deck();
        d.createDeck();
        d.shuffle();
        deck = d;
    }
    public Deck getDeck(){
        return deck;
    }
    public void dealPlayers(){
        System.out.println("Dealer");
        System.out.println(hand.showCard(hand.getCard(0)));
        System.out.println("Secret Card");
        System.out.println(hand.cardValue(hand.getCard(0)));
        for (Player player : players) {
            System.out.println(" ");
            System.out.println(player.getName());
            System.out.println(player.showHand());
        }
    }
    public void playersPlay(){
        Scanner sc = new Scanner(System.in);
        for(Player player : players){
            System.out.println(player.getName() + "'s Turn!");
            do{
                System.out.println("Hit or Skip? Please Enter h or s");
                String choice = sc.next();
                if(choice.equals("h")) {
                    int j = (int) (Math.random() * deck.deckSize());
                    player.getHand().addCard(deck.getCard(j));
                    player.getHand().findValue();
                    System.out.println(player.showHand());
                }
                else if(choice.equals("s")){
                    break;
                }
            }
            while (player.getHand().findValue() < 21);
            if(player.getHand().findValue() > 21){
                System.out.println("You Lose!!!");
            }
        }
    }
    public void dealerTurn(){
        System.out.println("Dealer's Turn!");
        int value = 0;
        int p = 0;
        int d = 0;
        if (players.isEmpty()){
            System.out.println("Dealer Wins!!!");
        }
        else {
            System.out.println(hand.showHand());
            for (Player player : players) {
                p = player.getHand().findValue();
                d = hand.findValue();
                if(p > value){
                    value = p;
                }
                while (p > d) {
                    int j = (int) (Math.random() * deck.deckSize());
                    hand.addCard(deck.getCard(j));
                    d = hand.findValue();
                }
            }
            System.out.println(hand.showHand());
            System.out.println("Game Over!");
            if (d <= 21) {
                System.out.println("Dealer Wins!!!");
            }
            else if(value <= 21){
                for(Player player : players){
                    if(player.getHand().findValue() == value){
                        System.out.println(player.getName() + " Wins!!!");
                    }
                }
            }
        }
    }


}

package CardGame;

import java.util.Scanner;
public class MainTable {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Players?");
        int numPlayers = sc.nextInt();
        Dealer dealer = new Dealer();
        dealer.setPlayers(numPlayers);
        dealer.setDeck();
        dealer.setPlayerName();
        dealer.setHands();
        dealer.dealPlayers();
        dealer.playersPlay();
        dealer.dealerTurn();
    }
}

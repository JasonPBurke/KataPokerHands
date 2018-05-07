/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;
import java.util.*;
/**
 *
 * @author jpbur
 */
public class KataPokerHands {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dealer dealer = new Dealer();

        ArrayList<String> handOne = dealer.dealHand();
        ArrayList<String> handTwo = dealer.dealHand();

        System.out.println("Player Black's cards: " + handOne);
        System.out.println("Player White's cards: " + handTwo);
        System.out.println();

        CompareHands hands = new CompareHands(handOne, handTwo);
        hands.compareHands(handOne, handTwo);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;

/**
 *
 * @author jpbur
 */
public class Straight {
    boolean isStraight(ArrayList<Integer> hand) {
        boolean isStraight = false;
        int straight = 1;
        for(int i = 0; i < 4; i++) {
            if(hand.get(i)+1 == hand.get(i+1)) straight++;
            else break;
        }
        if(straight == 5) return isStraight = true;
        if( hand.get(0) == 2 && hand.get(1) == 3  && hand.get(2) == 4 && hand.get(3) == 5 && hand.get(4) == 14 ) {
            hand.remove(4);
            hand.add(0, 1);
            //isStraight(hand); // NOT SURE WHY RECURSION ISNT WORKING HERE.....
            straight = 1;
            for(int i = 0; i < 4; i++) {
                if(hand.get(i)+1 == hand.get(i+1)) straight++;
                else break;
            }
            if(straight == 5) return isStraight = true;
        }
        return isStraight;
    }
    
    boolean straightWinner(boolean h1Straight, boolean h2Straight, ValuesAndSuitSplitter h1Split,
            ValuesAndSuitSplitter h2Split, CardMapping h1HighCard, CardMapping h2HighCard) {
        boolean isStraight = true;
        if(!h1Straight && !h2Straight) return isStraight = false; // CHECK IF A HAND HAS A STRAIGHT
        // DECLARE STRAIGHT WINNER
        if(h1Straight && !h2Straight) {
            System.out.println("Black wins with a straight.");
            //return;
        }
        else if(!h1Straight && h2Straight) {
            System.out.println("White wins with a straight.");
        }
        else {
            if(h1Split.getValues().contains(1) && h1Split.getValues().contains(5)) {
                h1HighCard.setValue(5);
                h1HighCard.setName("5");
            }
            if(h2Split.getValues().contains(1) && h2Split.getValues().contains(5)) {
                h2HighCard.setValue(5);
                h2HighCard.setName("5");
            }
            if(h1HighCard.getValue() > h2HighCard.getValue()) {
                System.out.println("Black wins with a straight, " + h1HighCard.getName() + " high.");
            }
            else if(h1HighCard.getValue() < h2HighCard.getValue()) {
                System.out.println("White wins with a straight, " + h2HighCard.getName() + " high.");
            }
            else System.out.println("Players Tie.");
        }
        return isStraight;
    }
    
}// end class

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
public class Flush {
    boolean isFlush(ArrayList<String> hand) {
        int suitMatch = 1;
        boolean isFlush = false;
        for(int i = 0; i < hand.size(); i++){
            if(i+1 >= hand.size()) break;
            if(hand.get(i).equals(hand.get(i+1))){
                suitMatch++;
            }
            if(suitMatch == 5) isFlush = true;
        }       
        return isFlush;
    }
    
    boolean flushWinner(boolean h1Flush, boolean h2Flush, CardMapping h1HighCard, CardMapping h2HighCard) {
        boolean isFlush = true;
        if(!h1Flush && !h2Flush) return isFlush = false; // CHECK IF A HAND HAS A FLUSH
        // DECLARE FLUSH WINNER
        if(h1Flush && !h2Flush) {
            System.out.println("Black wins with a flush.");
        }
        else if(!h1Flush && h2Flush) {
            System.out.println("White wins with a flush.");
        }
        else {
            if(h1HighCard.getValue() > h2HighCard.getValue()) {
                System.out.println("Black wins with a flush, " + h1HighCard.getName() + " high.");
            }
            else if(h1HighCard.getValue() < h2HighCard.getValue()) {
                System.out.println("White wins with a flush, " + h2HighCard.getName() + " high.");
            }
            else {
                System.out.println("Players Black and White Tie.");
            }
        }
        return isFlush;
    }
}

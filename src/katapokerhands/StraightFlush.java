/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

/**
 *
 * @author jpbur
 */
public class StraightFlush {
    boolean isStraightFlush(boolean flush, boolean straight) {
        return flush == true && straight == true;
    }
    
    boolean straightFlushWinner(boolean h1StraightFlush, boolean h2StraightFlush, ValuesAndSuitSplitter h1Split,
            ValuesAndSuitSplitter h2Split, CardMapping h1HighCard, CardMapping h2HighCard) {
        boolean isStraightFlush = true;
        if(!h1StraightFlush && !h1StraightFlush) return isStraightFlush = false;
        // DECLARE STRAIGHT-FLUSH WINNER
        if(h1StraightFlush && !h2StraightFlush) {
            System.out.println("Black wins. - with a straight flush.");
        }
        else if(!h1StraightFlush && h2StraightFlush) {
            System.out.println("White wins. - with a straight flush.");
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
                System.out.println("Black wins. - with a straight flush, " + h1HighCard.getName() + " high.");
            }
            else if(h1HighCard.getValue() < h2HighCard.getValue()) {
                System.out.println("White wins. - with a straight flush, " + h2HighCard.getName() + " high.");
            }
            else System.out.println("Players Tie.");
            //return;
        }
    
        return isStraightFlush;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jpbur
 */
public class FourOfAKind {
    int isFourOfAKind(ArrayList<Integer> values) {
        int value = 0 , temp;
        
        for(Integer i : values) {
            temp = Collections.frequency(values, i);
            if (temp == 4) {
                value = i;
                return value;
            }
        }
        return value;// RETURN 0 IF NOT FOUR OF A KIND
    }
    boolean fourOfAKindWinner(int h1FourOfAKind, int h2FourOfAKind, String h1MatchFourName, String h2MatchFourName) {
        boolean isFourOfAKind = true;
        if(h1FourOfAKind + h2FourOfAKind == 0) return isFourOfAKind = false;
        // DECLARE FOUR-OF-A-KIND WINNER
        if(h1FourOfAKind !=0 && h2FourOfAKind == 0) {
            System.out.println("Black wins with four " + h1MatchFourName + "'s.");
        }
        else if(h1FourOfAKind == 0 && h2FourOfAKind != 0) {
            System.out.println("White wins with four " + h2MatchFourName + "'s.");
        }
        else {
            if(h1FourOfAKind > h2FourOfAKind) {
                System.out.println("Black wins with four " + h1MatchFourName + "'s.");
            }
            else if(h1FourOfAKind < h2FourOfAKind) {
                System.out.println("White wins with four " + h2MatchFourName + "'s.");
            }
        }
        return isFourOfAKind;
    }
}

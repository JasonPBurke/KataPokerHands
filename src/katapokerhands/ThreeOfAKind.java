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
public class ThreeOfAKind {
    int isThreeOfAKind(ArrayList<Integer> values) {
        int value = 0 , temp;
        
        for(Integer i : values) {
            temp = Collections.frequency(values, i);
            if (temp == 3) {
                value = i;
                return value;
            }
        }
        return value;// RETURN 0 IF NOT THREE OF A KIND
    }
    
    boolean threeOfAKindWinner(int h1ThreeOfAKind, int h2ThreeOfAKind, String h1MatchThreeName, String h2MatchThreeName) {
        boolean isThreeOfAKind = true;
        if(h1ThreeOfAKind + h2ThreeOfAKind == 0) return isThreeOfAKind = false;
        
               // DECLARE THREE-OF-A-KIND WINNER
        if(h1ThreeOfAKind !=0 && h2ThreeOfAKind == 0) {
            System.out.println("Black wins with three " + h1MatchThreeName + "'s.");
        }
        else if(h1ThreeOfAKind == 0 && h2ThreeOfAKind != 0) {
            System.out.println("White wins with three " + h2MatchThreeName + "'s.");
        }
        else {
            if(h1ThreeOfAKind > h2ThreeOfAKind) {
                System.out.println("Black wins with three " + h1MatchThreeName + "'s.");
            }
            if(h1ThreeOfAKind < h2ThreeOfAKind) {
                System.out.println("White wins with three " + h2MatchThreeName + "'s.");
            }
        }
        return isThreeOfAKind;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Collections;
import static katapokerhands.CompareHands.intToName;

/**
 *
 * @author jpbur
 */
public class Pair {
    ArrayList<Integer> isPair(ArrayList<Integer> values){
        ArrayList<Integer> vals = new ArrayList<>();
        vals.addAll(values);
        ArrayList<Integer> returnList = new ArrayList<>();
        int temp;
        
        for(Integer i : values) {
            temp = Collections.frequency(values, i);
            if (temp == 2) {
                returnList.add(i);
                vals.remove(i);
                vals.remove(i);
                Collections.sort(vals);
                Collections.reverse(vals);
                returnList.addAll(vals);
                return returnList;
            }
        }
        return returnList;// RETURN 0 IF NOT A PAIR
    }
    
    boolean pairWinner(ArrayList<Integer> h1Pair, ArrayList<Integer> h2Pair) {
        boolean isPair = true;
        if(h1Pair.isEmpty() && h2Pair.isEmpty()) return isPair = false;
        
        // DECLARE PAIR WINNER
        if(!h1Pair.isEmpty() && h2Pair.isEmpty()) {
            System.out.println("Black wins with a pair of " + intToName(h1Pair.get(0)) + "'s.");
        }
        else if(h1Pair.isEmpty() && !h2Pair.isEmpty()) {
            System.out.println("White wins with a pair of " + intToName(h2Pair.get(0)) + "'s.");
        }
        else {
            if(h1Pair.get(0) > h2Pair.get(0)) {
                System.out.println("Black wins with a pair of " + intToName(h1Pair.get(0)) + "'s.");
            }
            else if(h1Pair.get(0) < h2Pair.get(0)) {
                System.out.println("White wins with a pair of " + intToName(h2Pair.get(0)) + "'s.");
            }
            else {
                if(h1Pair.get(1) > h2Pair.get(1)) {
                   System.out.println("Black wins with a pair of " + intToName(h1Pair.get(0)) 
                           + "'s, " + intToName(h1Pair.get(1)) + " high."); 
                }
                else if(h1Pair.get(1) < h2Pair.get(1)) {
                    System.out.println("White wins with a pair of " + intToName(h2Pair.get(0)) 
                            + "'s, " + intToName(h2Pair.get(1)) + " high.");
                }
                else {
                    if(h1Pair.get(2) > h2Pair.get(2)) {
                        System.out.println("Black wins with a pair of " + intToName(h1Pair.get(0)) 
                                + "'s, " + intToName(h1Pair.get(1)) + ", " + intToName(h1Pair.get(2)) + " high."); 
                    }
                    else if(h1Pair.get(2) < h2Pair.get(2)) {
                        System.out.println("White wins with a pair of " + intToName(h2Pair.get(0)) 
                                + "'s, " + intToName(h2Pair.get(1)) + ", " + intToName(h2Pair.get(2)) + " high."); 
                    }
                    else {
                        if(h1Pair.get(3) > h2Pair.get(3)) {
                            System.out.println("Black wins with a pair of " + intToName(h1Pair.get(0)) + "'s, " 
                                    + intToName(h1Pair.get(1)) + ", " + intToName(h1Pair.get(2)) 
                                    + ", " + intToName(h1Pair.get(3)) + " high."); 
                        }
                        else if(h1Pair.get(3) < h2Pair.get(3)) {
                            System.out.println("White wins with a pair of " + intToName(h2Pair.get(0)) + "'s, " 
                                    + intToName(h2Pair.get(1)) + ", " + intToName(h2Pair.get(2)) 
                                    + ", " + intToName(h2Pair.get(3)) + " high."); 
                        }
                        else {
                            System.out.println("Players Tie.");
                        }
                    }
                }
            }
        }
        return isPair;
    }
}

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
public class HighCard {
    ArrayList<Integer> isHighCard(ArrayList<Integer> values) {
        ArrayList<Integer> reversedList = new ArrayList<>();
        reversedList.addAll(values);
        Collections.reverse(reversedList);
        return reversedList;
    }
    
    boolean highCardWinner(ArrayList<Integer> h1High, ArrayList<Integer> h2High) {
        boolean isHighCard = true;
        if(h1High.isEmpty() && h2High.isEmpty()) return isHighCard = false;
        
        // DECLARE HIGH CARD WINNER
        if(h1High.get(0) > h2High.get(0)) {
            System.out.println("Black wins with high card " + intToName(h1High.get(0)) + ".");
        }
        else if(h1High.get(0) < h2High.get(0)) {
            System.out.println("White wins with high card " + intToName(h2High.get(0)) + ".");
        } 
        else {
            if(h1High.get(1) > h2High.get(1)) {
                System.out.println("Black wins with high cards " 
                        + intToName(h1High.get(0)) + ", " + intToName(h1High.get(1)) + ".");
            }
            else if(h1High.get(1) < h2High.get(1)) {
                System.out.println("White wins with high cards " 
                        + intToName(h2High.get(0)) + ", " + intToName(h2High.get(1)) + ".");
            }
            else {
                if(h1High.get(2) > h2High.get(2)) {
                    System.out.println("Black wins with high cards " + intToName(h1High.get(0)) 
                            + ", " + intToName(h1High.get(1)) + ", " + intToName(h1High.get(2)) + ".");
                }
                else if(h1High.get(2) < h2High.get(2)) {
                    System.out.println("White wins with high cards " + intToName(h2High.get(0)) 
                        + ", " + intToName(h2High.get(1)) + ", " + intToName(h2High.get(2)) + ".");
                }
                else {
                    if(h1High.get(3) > h2High.get(3)) {
                        System.out.println("Black wins with high cards " + intToName(h1High.get(0)) 
                            + ", " + intToName(h1High.get(1)) + ", " + intToName(h1High.get(2)) 
                                + ", " + intToName(h1High.get(3)) + ".");
                    }
                    else if(h1High.get(3) < h2High.get(3)) {
                        System.out.println("White wins with high cards " + intToName(h2High.get(0)) 
                            + ", " + intToName(h2High.get(1)) + ", " + intToName(h2High.get(2)) 
                                + ", " + intToName(h2High.get(3)) + ".");
                    }
                    else {
                        if(h1High.get(4) > h2High.get(4)) {
                            System.out.println("Black wins with high cards " + intToName(h1High.get(0)) 
                                + ", " + intToName(h1High.get(1)) + ", " + intToName(h1High.get(2)) 
                                    + ", " + intToName(h1High.get(3)) + ", " + intToName(h1High.get(4)) + ".");
                        }
                        else if(h1High.get(4) < h2High.get(4)) {
                            System.out.println("White wins with high cards " + intToName(h2High.get(0)) 
                                + ", " + intToName(h2High.get(1)) + ", " + intToName(h2High.get(2)) 
                                    + ", " + intToName(h2High.get(3)) + ", " + intToName(h2High.get(4)) + ".");
                        }
                        else {
                            System.out.println("Players tie.");
                        }
                    }
                }
            }
        }
        return isHighCard;
    }
}
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
public class FullHouse {
    ArrayList<Integer> isFullHouse(ArrayList<Integer> values) {
        ArrayList<Integer> vals = new ArrayList<>();
        vals.addAll(values);
        ArrayList<Integer> returnList = new ArrayList<>();
        int freq1 = 0, freq2 = 0, value1 = 0, value2 = 0 , temp;
        
        for(Integer i : vals){
            temp = Collections.frequency(vals, i);
            if (temp > freq1) {
                freq1 = temp;
                value1 = i;
            }
            if(freq1 == 3) {
                returnList.add(value1);
                vals.remove(i);
                vals.remove(i);
                vals.remove(i);
                break;
            }
        }
        for(Integer i : vals) {
            temp = Collections.frequency(vals, i);
            if (temp > freq2) {
                freq2 = temp;
                value2 = i;
            }
            if(freq2 == 2) {
                returnList.add(value2);
                break;
            }
        }
        if(freq1 != 3 || freq2 !=2) { // RETURN [] IF NOT FULL HOUSE
            returnList.clear();
        }
        return returnList;
    }
    
    boolean fullHouseWinner(ArrayList<Integer> h1FullHouse, ArrayList<Integer> h2FullHouse) {
        boolean isFullHouse = true;
        if(h1FullHouse.isEmpty() && h2FullHouse.isEmpty()) return isFullHouse = false;
        
        // DECLARE FULL-HOUSE WINNER
        if(!h1FullHouse.isEmpty() && h2FullHouse.isEmpty()) {
            System.out.println("Black wins with full house, " + CompareHands.intToName(h1FullHouse.get(0)) 
                    + "'s over " + CompareHands.intToName(h1FullHouse.get(1)) + "'s.");
        }
        else if(h1FullHouse.isEmpty() && !h2FullHouse.isEmpty()) {
            System.out.println("White wins with full house, " + CompareHands.intToName(h2FullHouse.get(0)) 
                    + "'s over " + CompareHands.intToName(h2FullHouse.get(1)) + "'s.");
        }
        else {
            if(h1FullHouse.get(0) > h2FullHouse.get(0)) {
                System.out.println("Black wins with full house, " + CompareHands.intToName(h1FullHouse.get(0)) 
                        + "'s over " + CompareHands.intToName(h1FullHouse.get(1)) + "'s.");
            }
            else 
                System.out.println("White wins with full house, " + CompareHands.intToName(h2FullHouse.get(0)) 
                        + "'s over " + CompareHands.intToName(h2FullHouse.get(1)) + "'s.");
        }
        return isFullHouse;
    }
}

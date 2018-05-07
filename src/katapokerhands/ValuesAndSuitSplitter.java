/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jpbur
 */
// THIS CLASS SPLITS THE VALUES AND SUITS INTO SEPERATE LISTS
public class ValuesAndSuitSplitter {
    ArrayList<Integer> values = new ArrayList<>(5);       
    ArrayList<String> suits = new ArrayList<>(5);  
    ArrayList<String> hand = new ArrayList<>(5);
    String[] splits;

    ValuesAndSuitSplitter(ArrayList<String> hand) {
        this.hand = hand;
        for(String str : hand) {
        splits = str.split("");
        values = faceValuesToInts(hand);
        suits.add(splits[1]);
        }
    }
    ArrayList<Integer> getValues() { return values; }
    ArrayList<String> getSuits() { return suits; }
    
    
    public static ArrayList<Integer> faceValuesToInts(List<String> hand) {
        ArrayList<Integer> values = new ArrayList<>(5); 
        String[] splits;
        for(String str : hand) {
            splits = str.split("");
            switch (splits[0]) {
                case "T":
                    values.add(10);
                    break;
                case "J":
                    values.add(11);
                    break;
                case "Q":
                    values.add(12);
                    break;
                case "K":
                    values.add(13);
                    break;
                case "A":
                    values.add(14);
                    break;
                default:
                    values.add(Integer.parseInt(splits[0]));
                    break;
            }
        }
        Collections.sort(values);
        return values;
    }
}

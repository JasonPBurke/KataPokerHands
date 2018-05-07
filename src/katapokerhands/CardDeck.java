/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jpbur
 */
public class CardDeck {
    private final ArrayList<String> deck;
    
    CardDeck() {
        deck = new ArrayList<>();      
        for(int i = 2; i < 10; i++){
            deck.add(i + "H");
            deck.add(i + "D");
            deck.add(i + "S");
            deck.add(i + "C");
        }
        deck.addAll(Arrays.asList("TH TD TS TC JH JD JS JC QH QD QS QC KH KD KS KC AH AD AS AC".split(" ")));
    }
    ArrayList<String> getDeck(){
        return deck;
    }
}

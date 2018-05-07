/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author jpbur
 */
public class Dealer {
    int deckSize;
    ArrayList<String> newDeck;
    Random rand;
    Dealer() {
        deckSize = 52;
        newDeck = new CardDeck().getDeck();
        Collections.shuffle(newDeck);
        rand = new Random(42);
    }
    
    ArrayList dealHand() {
        ArrayList<String> myHand = new ArrayList<>();
        int cardIndex;
        for(int i = 0; i < 5; i++, deckSize--) {
            cardIndex = rand.nextInt(deckSize);
            myHand.add(newDeck.get(cardIndex));
            newDeck.remove(cardIndex);// remove the card picked from the deck
        }
        return myHand;
    }
}

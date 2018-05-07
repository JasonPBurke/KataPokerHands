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

// USE THIS CLASS TO RETURN THE STRING NAME AND INTEGER VALUE OF THE HIGH CARD IN PLAYERS HANDS
public class CardMapping {
    int value;
    String name;
    CardMapping(int value, String name) {
        this.name = name;
        this.value = value;
    }
    int getValue() { return value; }
    void setValue(int newValue) { value = newValue; } // this is here to change the value of an Ace to low on a straight
    String getName() { return name; }
    void setName(String newName) { name = newName; }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapokerhands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Objects;

/**
 *
 * @author jpbur
 */
public class CompareHands {
    List hand1, hand2;
    
    
    CompareHands(ArrayList<String> hand1, ArrayList<String> hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }    
    
    
    public static String intToName(int value) {
        String name;

        switch (value) {
            case 11:
                name = "Jack";
                break;
            case 12:
                name = "Queen";
                break;
            case 13:
                name = "King";
                break;
            case 14:
                name = "Ace";
                break;
            default:
                name = Integer.toString(value);
                break;
        }
        return name;
    }
    
    CardMapping highCard(ArrayList<Integer> cards) {

        int highCard = Collections.max(cards);
        String highCardName;

        switch (highCard) {
            case 11:
                highCardName = "Jack";
                break;
            case 12:
                highCardName = "Queen";
                break;
            case 13:
                highCardName = "King";
                break;
            case 14:
                highCardName = "Ace";
                break;
            default:
                highCardName = Integer.toString(highCard);
                break;
        }
        CardMapping cMap = new CardMapping(highCard, highCardName);
        return cMap;
    }
    
    void compareHands(ArrayList<String> hand1, ArrayList<String> hand2) {

        ValuesAndSuitSplitter h1Split = new ValuesAndSuitSplitter(hand1);
        ValuesAndSuitSplitter h2Split = new ValuesAndSuitSplitter(hand2);
        
        CardMapping h1HighCard = highCard(h1Split.getValues());
        CardMapping h2HighCard = highCard(h2Split.getValues());
        
        // DETERMINE IF HANDS ARE FLUSH OR NOT
        Flush flush = new Flush();
        boolean h1Flush = flush.isFlush(h1Split.getSuits());
        boolean h2Flush = flush.isFlush(h2Split.getSuits());
        
        // DETERMINE IF HANDS ARE STRAIGHT OR NOT
        Straight straight = new Straight();
        boolean h1Straight = straight.isStraight(h1Split.getValues());
        boolean h2Straight = straight.isStraight(h2Split.getValues());
        
        // DETERMINE IF HANDS ARE STRAIGHT-FLUSH OR NOT
        StraightFlush straightFlush = new StraightFlush();
        boolean h1StraightFlush = straightFlush.isStraightFlush(h1Flush, h1Straight);
        boolean h2StraightFlush = straightFlush.isStraightFlush(h2Flush, h2Straight);
        
        // DECLARE STRAIGHT-FLUSH WINNER
        if(straightFlush.straightFlushWinner(h1StraightFlush, h2StraightFlush, h1Split, h2Split, h1HighCard, h2HighCard)) return;
        
        // DETERMINE IF HANDS ARE FOUR-OF-A-KIND OR NOT
        FourOfAKind fourOfAKind = new FourOfAKind();
        int h1FourOfAKind = fourOfAKind.isFourOfAKind(h1Split.getValues());
        String h1MatchFourName = intToName(h1FourOfAKind);
        int h2FourOfAKind = fourOfAKind.isFourOfAKind(h2Split.getValues());
        String h2MatchFourName = intToName(h2FourOfAKind);
        
        // DECLARE FOUR-OF-A-KIND WINNER
        if(fourOfAKind.fourOfAKindWinner(h1FourOfAKind, h2FourOfAKind, h1MatchFourName, h2MatchFourName)) return;
        
        // DETERMINE IF HANDS ARE FULL-HOUSE OR NOT
        FullHouse fullHouse = new FullHouse();
        ArrayList<Integer> h1FullHouse = fullHouse.isFullHouse(h1Split.getValues());
        ArrayList<Integer> h2FullHouse = fullHouse.isFullHouse(h2Split.getValues());
        
        // DECLARE FULL-HOUSE WINNER
        if(fullHouse.fullHouseWinner(h1FullHouse, h2FullHouse)) return;
        
        // DECLARE FLUSH WINNER
        if(flush.flushWinner(h1Flush, h2Flush, h1HighCard, h2HighCard)) return;

        // DECLARE STRAIGHT WINNER
        if(straight.straightWinner(h1Straight, h2Straight, h1Split, h2Split, h1HighCard, h2HighCard)) return;
        
        // DETERMINE IF HANDS ARE THREE-OF-A-KIND OR NOT
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        int h1ThreeOfAKind = threeOfAKind.isThreeOfAKind(h1Split.getValues());
        String h1MatchThreeName = intToName(h1ThreeOfAKind);
        int h2ThreeOfAKind = threeOfAKind.isThreeOfAKind(h2Split.getValues());
        String h2MatchThreeName = intToName(h2ThreeOfAKind);
        
        // DECLARE THREE-OF-A-KIND WINNER
        if(threeOfAKind.threeOfAKindWinner(h1ThreeOfAKind, h2ThreeOfAKind, h1MatchThreeName, h2MatchThreeName)) return;

        // DETERMINE IF HANDS ARE TWO-PAIR OR NOT
        TwoPair twoPair = new TwoPair();
        ArrayList<Integer> h1TwoPair = twoPair.isTwoPair(h1Split.getValues());
        ArrayList<Integer> h2TwoPair = twoPair.isTwoPair(h2Split.getValues());
        
        // DECLARE TWO-PAIR WINNER
        if(twoPair.twoPairWinner(h1TwoPair, h2TwoPair)) return;

        // DETERMINE IF HANDS ARE PAIR OR NOT
        Pair pair = new Pair();
        ArrayList<Integer> h1Pair = pair.isPair(h1Split.getValues());
        ArrayList<Integer> h2Pair = pair.isPair(h2Split.getValues());
        
        // DECLARE PAIR WINNER
        if(pair.pairWinner(h1Pair, h2Pair)) return;

        // PREPARE ARRAY FOR HIGH CARD CHECK BY REVERSING IT
        HighCard highCard = new HighCard();
        ArrayList<Integer> h1High = highCard.isHighCard(h1Split.getValues());
        ArrayList<Integer> h2High = highCard.isHighCard(h2Split.getValues());
        
        // DECLARE HIGH CARD WINNER
        if(highCard.highCardWinner(h1High, h2High));
   }
}


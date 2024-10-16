/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lavinia
 */
import java.util.*;
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print(){
        for(Card card: hand) {
            System.out.println(card.toString());
        }
    }
    
    public void sort(){
        Collections.sort(hand);
        this.print();
    }
    
    public int getSum() { 
        int sum = 0;
        for(Card card : hand) {
            sum = sum + card.getValue();
        }
        return sum;
    }
    
    public int compareTo(Hand hand) {
        return this.getSum() - hand.getSum();
    }
    
    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
    }
}

=> Playing Card and Hand Management Implementation
In this exercise, I developed a system to represent playing cards and manage a player's hand of cards. Each card consists of a value and a suit, where values range from 2 to 14 (with 14 representing Ace) and suits are represented as an enumeration: Club, Diamond, Heart, and Spade.

=> Card Class
The Card class represents an individual playing card and includes a toString method for readable output. Cards can be instantiated as follows:

Card first = new Card(2, Suit.DIAMOND);
Card second = new Card(14, Suit.SPADE);
Card third = new Card(12, Suit.HEART);
When printed, the cards display their suit and value:

DIAMOND 2
SPADE A
HEART Q

=> Comparable Card Class
To enable sorting, I modified the Card class to implement the Comparable interface by adding a compareTo method. Cards are sorted primarily by their value in ascending order, and in the case of equal values, by suit in the following order: Clubs, Diamonds, Hearts, and Spades.

=> Hand Class
The Hand class represents a collection of cards in a player’s hand. This class includes the following methods:

public void add(Card card): Adds a card to the hand.
public void print(): Prints all the cards in the hand.

For example:
Hand hand = new Hand();
hand.add(new Card(2, Suit.DIAMOND));
hand.add(new Card(14, Suit.SPADE));
hand.add(new Card(12, Suit.HEART));
hand.add(new Card(2, Suit.SPADE));
hand.print();

=> This will output:

DIAMOND 2
SPADE A
HEART Q
SPADE 2

=> Sorting the Hand
I added a method public void sort() to the Hand class, which sorts the cards according to their values and suits. After sorting, the cards are printed in the correct order:

hand.sort();
hand.print();
The output will be:

DIAMOND 2
SPADE 2
HEART Q
SPADE A

=> Comparing Hands
In card games, hands are ranked based on the sum of their card values. I modified the Hand class to implement Comparable<Hand>, allowing comparison based on the total value of the cards:

Hand hand1 = new Hand();
hand1.add(new Card(2, Suit.DIAMOND));
hand1.add(new Card(14, Suit.SPADE));
hand1.add(new Card(12, Suit.HEART));
hand1.add(new Card(2, Suit.SPADE));

Hand hand2 = new Hand();
hand2.add(new Card(11, Suit.DIAMOND));
hand2.add(new Card(11, Suit.SPADE));
hand2.add(new Card(11, Suit.HEART));

int comparison = hand1.compareTo(hand2);

if (comparison < 0) {
    System.out.println("better hand is");
    hand2.print();
} else if (comparison > 0) {
    System.out.println("better hand is");
    hand1.print();
} else {
    System.out.println("hands are equal");
}
This will produce output indicating which hand is better.

=> Alternative Sorting Criteria
To sort cards in different ways, I created a separate sorting class that implements the Comparator<Card> interface. For example, the following class sorts cards by suit:

public class SortBySuit implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        return c1.getSuit().ordinal() - c2.getSuit().ordinal();
    }
}
Using this sorting logic, cards can be sorted by suit:

ArrayList<Card> cards = new ArrayList<>();
cards.add(new Card(3, Suit.SPADE));
cards.add(new Card(2, Suit.DIAMOND));
cards.add(new Card(14, Suit.SPADE));
cards.add(new Card(12, Suit.HEART));
cards.add(new Card(2, Suit.SPADE));

SortBySuit sortBySuitSorter = new SortBySuit();
Collections.sort(cards, sortBySuitSorter);
cards.forEach(System.out::println);

This would output:

DIAMOND 2
HEART Q
SPADE 3
SPADE A
SPADE 2

=> Sorting by Suit with Value Order
I also created a class called BySuitInValueOrder to sort cards first by suit and then by value within each suit. Furthermore, I added a method public void sortBySuit() to the Hand class, which sorts the cards based on suit first and value second:

Hand hand = new Hand();
hand.add(new Card(12, Suit.HEART));
hand.add(new Card(4, Suit.SPADE));
hand.add(new Card(2, Suit.DIAMOND));
hand.add(new Card(14, Suit.SPADE));
hand.add(new Card(7, Suit.HEART));
hand.add(new Card(2, Suit.SPADE));

hand.sortBySuit();
hand.print();
The output after sorting will be:


DIAMOND 2
HEART 7
HEART Q
SPADE 2
SPADE 4
SPADE A

=> This comprehensive card management system allows for efficient handling and sorting of playing cards in various ways, providing a flexible structure for potential card games.


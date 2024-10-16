
import java.util.Comparator;

/**
 *
 * @author Lavinia
 */
public class BySuitInValueOrder implements Comparator<Card> {
    
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuit().ordinal() != c2.getSuit().ordinal()) {
            return c1.getSuit().ordinal() - c2.getSuit().ordinal();
        } else {
            return c1.getValue() - c2.getValue();
        }
    }
}

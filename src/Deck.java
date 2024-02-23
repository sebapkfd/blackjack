import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards;
    public ArrayList<String> suits;

    Deck() {
        this.suits = new ArrayList<String>(Arrays.asList("Heart", "Diamonds", "Clovers", "Pikes"));
        this.cards = new ArrayList<Card>();

        this.suits.forEach(suit -> {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(i, suit);
                this.cards.add(card);
            }
        });
    }

    public void showDeck() {
        this.cards.forEach(card -> card.showCard());
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Card getCard() {
        return this.cards.removeFirst();
    }
}

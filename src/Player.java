import java.util.ArrayList;

public class Player {
    ArrayList<Card> cards;
    int score;
    String role;
    boolean openToPlay;

    Player(String role) {
        this.role = role;
        this.score = 0;
        this.cards = new ArrayList<Card>();
        this.openToPlay = true;
    }

    public void receiveCard(Card card) {
        this.cards.add(card);
        if (this.score <= 10 && card.label == "A") {
            updateScore(11);
        }
        else {
            updateScore(card.value);
        }

        this.openToPlay = this.score < 21;
    }

    public void updateScore(int value) {
        this.score += value;
    }

    public void showHand() {
        System.out.println( this.role + " score: " + this.score);
    }

    public boolean canPlay() {
        if (this.role == "Dealer") {
            return this.score < 15 && openToPlay;
        }
        else {
            return this.score < 21 && openToPlay;
        }
    }
    public void standPlay() {
        this.openToPlay = false;
    }
}

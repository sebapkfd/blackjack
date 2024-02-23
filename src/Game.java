import java.util.Scanner;

public class Game {
    Player dealer;
    Player player_1;
    Deck deck;

    Game() {
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.dealer = new Player("Dealer");
        this.player_1 = new Player("Player 1");
    }

    public void play() {
        initialDeal();
        Scanner scanner = new Scanner(System.in);
        while (this.player_1.canPlay()) {
            showScores();
            showOptions();
            int option = scanner.nextInt();
            if (option == 1) {
                this.player_1.receiveCard(this.deck.getCard());
            }
            else if (option == 2) {
                this.player_1.standPlay();
                break;
            }
        }
        scanner.close();
        while (this.dealer.canPlay()) {
            if (this.player_1.score > 21) {
                break;
            }
            if (this.dealer.score < 15) {
                this.dealer.receiveCard(this.deck.getCard());
            }
        }        
        showScores();
        showResults();
    }

    public void initialDeal() {
        System.out.println("The cards are dealt");
        this.player_1.receiveCard(this.deck.getCard());
        this.dealer.receiveCard(this.deck.getCard());
        this.player_1.receiveCard(this.deck.getCard());
    }

    public void showScores() {
        this.player_1.showHand();
        this.dealer.showHand();
    }

    public void showOptions() {
        System.out.println("-------------------------------");
        System.out.println("Select your choice");
        System.out.println("1. Hit, ask for another card");
        System.out.println("2. Stand, no more cards");
    }

    public void showResults() {
        if ((this.player_1.score > this.dealer.score && this.player_1.score <= 21) || (this.player_1.score <= 21 && this.dealer.score > 21)) {
            System.out.println("Player 1 wins");
        }
        else if ((this.player_1.score < this.dealer.score && this.dealer.score <= 21) || (this.player_1.score > 21 && this.dealer.score <= 21)) {
            System.out.println("Dealer wins");
        }
        else {
            System.out.println(" Game tied" );
        }

    }
}

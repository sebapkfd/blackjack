public class Card {
    public int value;
    public String label;
    public String suit;

    Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        switch (this.value) {
            case 1:
                this.label = "A";
                break;
            case 11:
                this.label = "J";
                break;
            case 12:
                this.label = "Q";
                break;
            case 13:
                this.label = "K";
                break;
            default:
                this.label = String.valueOf(this.value);
                break;
        }
    }

    public void showCard() {
        System.out.println(this.label + " " + this.suit);
    }

}

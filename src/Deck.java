public class Deck {

    private Deck() {}

    public static String[] shuffle() {
        String[] suits = {
                "Diamonds", "Clubs", "Hearts", "Spades"
        };
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };
        String[] deck = new String[suits.length * ranks.length];
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
            }
        }
        for (int i = 0; i < deck.length; i++) {
            int random = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
        /* for (int i = 0; i < deck.length; i++) {
            System.out.printf("%s\n", deck[i]);
        } */
        return deck;
    }

    private static String[][] poker(int players) {
        String[] deck = shuffle();
        int cardsPerPlayer = 5;
        String[][] deal = new String[players][cardsPerPlayer];
        for (int i = 0; i < players; i++) {
            // System.out.printf("Player %d:\n", i + 1);
            for (int j = 0; j < cardsPerPlayer; j++) {
                // System.out.printf("%s\n", deck[i * cardsPerPlayer + j]);
                deal[i][j] = deck[i * cardsPerPlayer + j];
            }
            // System.out.println();
        }
        return deal;
    }

}

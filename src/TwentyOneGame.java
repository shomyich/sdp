import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TwentyOneGame implements CardGame {
    private List<Integer> deck;
    private int playerScore;
    private int computerScore;

    public TwentyOneGame() {
        deck = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
    }

    @Override
    public void startGame() {
        shuffleDeck();
        dealInitialCards();
        playGame();
    }

    private void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            int temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            playerScore += deck.get(0);
            deck.remove(0);
            computerScore += deck.get(0);
            deck.remove(0);
        }
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player's score: " + playerScore);
            System.out.println("Computer's score: " + computerScore);
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if ("h".equalsIgnoreCase(choice)) {
                int card = deck.get(0);
                playerScore += card;
                deck.remove(0);
                if (playerScore > 21) {
                    System.out.println("Player's score: " + playerScore);
                    System.out.println("Computer's score: " + computerScore);
                    System.out.println("Player busted. Computer wins!");
                    break;
                }
            } else if ("s".equalsIgnoreCase(choice)) {
                while (computerScore < 17) {
                    int card = deck.get(0);
                    computerScore += card;
                    deck.remove(0);
                }
                if (computerScore > 21 || playerScore > computerScore) {
                    System.out.println("Player's score: " + playerScore);
                    System.out.println("Computer's score: " + computerScore);
                    System.out.println("Player wins!");
                } else if (playerScore < computerScore) {
                    System.out.println("Player's score: " + playerScore);
                    System.out.println("Computer's score: " + computerScore);
                    System.out.println("Computer wins!");
                } else {
                    System.out.println("It's a tie!");
                }
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
        scanner.close();
    }
}
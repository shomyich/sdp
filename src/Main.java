public class Main {
    public static void main(String[] args) {

        ExistingCardGame existingCardGame = new ExistingCardGame();
        CardGame adapter = new ExistingCardGameAdapter(existingCardGame);


        CardGame game = new TwentyOneGame();
        game.startGame();
    }
}
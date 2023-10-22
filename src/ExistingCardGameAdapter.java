class ExistingCardGameAdapter implements CardGame {
    private ExistingCardGame existingCardGame;

    public ExistingCardGameAdapter(ExistingCardGame existingCardGame) {
        this.existingCardGame = existingCardGame;
    }

    @Override
    public void startGame() {
        existingCardGame.play();
    }
}
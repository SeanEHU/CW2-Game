public class DTEMM {

    public static void main(String[] args) {
        
        Game newGame = new Game();
        
        while(!newGame.isGameOver()) {

            newGame.nextTurn();

        }

    }
}
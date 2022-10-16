

public class Game {

    public Board board;

    Player[] players = new Player[2];

    private int currentPlayer;

    private void setCurrentPlayer(){
        if(players[0].getPieceColour().equals("WHITE")){
            this.currentPlayer = 0;
        }
        else if(players[1].getPieceColour().equals("WHITE")){
            this.currentPlayer = 1;
        }
    }

    public int getCurrentPlayer(){
        return this.currentPlayer;
    }

    public int getNextPlayer(){
        if(this.getCurrentPlayer()==0){
            return 1;
        }
        else if(this.getCurrentPlayer()==1){
            return 0;
        }
        return 11111;
    }

    public void setNextPlayer(){
        if(this.getCurrentPlayer()==0){
            this.currentPlayer = 1;
        }
        else if(this.getCurrentPlayer()==1){
            this.currentPlayer = 0;
        }
    }

    public void removePieceFromPlayer(int player, String pieceCoordinates){
        int playerItemCord = this.players[player].findPiece(this.board.chessBoard[this.board.coordinateArray(pieceCoordinates)[0]][this.board.coordinateArray(pieceCoordinates)[1]].getName());
        if(playerItemCord!=-1) {
            this.players[player].pieces[playerItemCord] = new Item();
        }
    }

    public void addPointsToPlayer(int player, Item capturedItem){
        players[player].addToScore((capturedItem).getPieceMultiplier());
    }

    Game(int whitePlayer){
        players[whitePlayer] = new Player("WHITE");

        int blackPlayer = 1 + (-1 * whitePlayer); //small algebraic trick to set the black player

        players[blackPlayer] = new Player("BLACK");

        this.setCurrentPlayer(); //sets the current player as the white player at the start of the game;

        board = new Board();
        board.printBoard();

    }


}

public class Player {

    Item[] pieces = new Item[16];

    private String pieceColour;

    public void setPieceColour(String pieceColour){
        this.pieceColour = pieceColour;
    }

    public String getPieceColour(){
        return this.pieceColour;
    }

    private void changeWhiteToBlack(int pieceChoice){
            pieces[pieceChoice].setName((char)((pieces[pieceChoice].getName()-65) + 97));
    }

    public void displayMessage(){
        if(this.getPieceColour().equals("WHITE")) {
            System.out.println("Sira Beyazda. " +
                    "Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
        }
        else if(this.getPieceColour().equals("BLACK")){
            System.out.println("Sira Siyahta. " +
                    "Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
        }
    }

    Player(String pieceColour){
        this.setPieceColour(pieceColour);
        for(int i = 0;i<16;i++){
            if(i<8){
                pieces[i] = new Pawn();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            else if(i == 8 || i == 15){
                pieces[i] = new Rook();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            else if(i == 9 || i == 14){
                pieces[i] = new Knight();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            else if(i == 10 || i == 13){
                pieces[i] = new Bishop();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            else if(i == 11){
                pieces[i] = new Queen();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            else{
                pieces[i] = new King();
                if(pieceColour.equals("BLACK")){
                    changeWhiteToBlack(i);
                }
            }
            pieces[i].setColour(pieceColour);
        }
    }

    public int findPiece(char name){
        for (int i = 0; i < pieces.length; i++) {
            if(pieces[i].getName() == name){
                return i;
            }
        }
        return -1;
    }

    public boolean kingIsDead(){
        boolean isKingDead = true;
        for (Item piece : pieces) {
            if (piece.getLongName().equals("Sah")) {
                isKingDead = false;
                break;
            }
        }
        if(isKingDead){
            System.out.println("CHECK MATE!");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean MakeMove(String pieceCoordinates,String newCoordinates,Board board){

        int itemCount = 0;
        int itemCord = 0;
        for (int i = 0; i < 16; i++) {
            if(pieces[i].getClass() == board.returnPieceClass(pieceCoordinates)){
                if(this.getPieceColour().equals(board.chessBoard[board.coordinateArray(pieceCoordinates)[0]][board.coordinateArray(pieceCoordinates)[1]].getColour())){
                    itemCount++;
                    itemCord = i;
                }
                break;
            }
        }


        if(itemCount>0){ //this is just to check if the player has that kind of piece that is stated, does not check if it is the exact one
                if (pieces[itemCord].MoveTo(board.coordinateArray(pieceCoordinates), board.coordinateArray(newCoordinates))) {
                    if (!board.collisionCheck(pieceCoordinates, newCoordinates)) {
                        System.out.println(); // different error messages can be implemented if needed for each false condition.
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
        }
        else{
            return false;
        }
    }

    private int Score = 0;

    public void addToScore(int value){
        this.Score += value;
    }

    public int getScore(){
        return this.Score;
    }

}

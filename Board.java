public class Board {


    public Item[][] chessBoard;

    Board(){
        chessBoard = new Item[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==0 || i == 7){
                    chessBoard[i][j] = new Pawn();
                    if(i == 7){
                        chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                        chessBoard[i][j].setColour("BLACK");
                    }
                }
                else if (i == 1 || i == 6) {
                    if(j==0 || j == 7){
                        chessBoard[i][j] = new Rook();
                        if(i == 6){
                            chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                            chessBoard[i][j].setColour("BLACK");
                        }
                    }
                    else if( j == 1 || j == 6){
                        chessBoard[i][j] = new Knight();
                        if(i == 6){
                            chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                            chessBoard[i][j].setColour("BLACK");
                        }
                    }
                    else if (j == 2 || j == 5) {
                        chessBoard[i][j] = new Bishop();
                        if(i == 6){
                            chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                            chessBoard[i][j].setColour("BLACK");
                        }
                    }
                    else if(j == 3){
                        chessBoard[i][j] = new Queen();
                        if(i == 6){
                            chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                            chessBoard[i][j].setColour("BLACK");
                        }
                    } else{
                        chessBoard[i][j] = new King();
                        if(i == 6){
                            chessBoard[i][j].setName((char)((chessBoard[i][j].getName()-65) + 97));
                            chessBoard[i][j].setColour("BLACK");
                        }
                    }
                }
                else{
                    chessBoard[i][j] = new Item();
                }
            }
        }

    }

    public void MoveAll(){

        Item[] temp = new Item[8];
        for(int i = 0;i<8;i++){

            temp[i] = chessBoard[i][0];

        }

        for(int i = 0;i<8;i++){
            for(int j = 1;j<8;j++){
                chessBoard[i][j-1] = chessBoard[i][j];
            }
        }

        for(int i = 0;i<8;i++){
            chessBoard[i][7] = temp[i];
        }

    }

    public int[] coordinateArray(String coordinates){
        int[] cord = new int[2];
        cord[0] = (coordinates.charAt(0)-97);
        cord[1] = (coordinates.charAt(1)-49);
        return cord;
    }

    public boolean collisionCheck(String pieceCoordinates,String newCoordinates){
        int[] pieceCord = this.coordinateArray(pieceCoordinates);
        int[] newCord = this.coordinateArray(newCoordinates);
        return chessBoard[pieceCord[0]][pieceCord[1]].collisionControl(pieceCord, newCord, chessBoard);
    }

    public void MovePiece(String pieceCoordinates,String newCoordinates){ // just for moving not checking!

        int[] pieceCord = this.coordinateArray(pieceCoordinates);

        int[] newCord = this.coordinateArray(newCoordinates);


        this.chessBoard[newCord[0]][newCord[1]] = this.chessBoard[pieceCord[0]][pieceCord[1]];
        this.chessBoard[pieceCord[0]][pieceCord[1]] = new Item();



        this.MoveAll();

        System.out.println();
        System.out.println();

        this.printBoard();

        System.out.println();

    }

    public void printBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessBoard[i][j].getName() + "     ");
            }
            System.out.println();
        }
    }

    public Class returnPieceClass(String coordinates){
        int[] coords = this.coordinateArray(coordinates);
        return this.chessBoard[coords[0]][coords[1]].getClass();
    }

}

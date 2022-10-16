public class Bishop extends Item{

    private final int pieceMultiplier = 3;

    Bishop(){
        this.setName('F');
        this.setColour("WHITE");
        this.setLongName("Fil");
    }

    public int getPieceMultiplier(){
        return this.pieceMultiplier;
    }

    public boolean collisionControl(int[] pieceCoords,int[] newCoords,Item[][] collisionBoard){
        int collisions = 0;
        int piecesWithOtherColour = 0;
        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]) + 1;
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]) + 1;

        if((newCoords[0] - pieceCoords[0])<0 && (newCoords[1] - pieceCoords[1])<0){
            for (int i = 0; i < diffCol; i++) {
                if (collisionBoard[pieceCoords[0] - i][pieceCoords[1] - i].getName() != '-' && i != 0) {
                    if(this.checkColour(collisionBoard[pieceCoords[0]-i][pieceCoords[1]-i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if((newCoords[0] - pieceCoords[0])<0 && (newCoords[1] - pieceCoords[1])>0){
            for (int i = 0; i < diffCol; i++) {
                if (collisionBoard[pieceCoords[0] - i][pieceCoords[1] + i].getName() != '-' && i != 0) {
                    if(this.checkColour(collisionBoard[pieceCoords[0]-i][pieceCoords[1]+i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if((newCoords[0] - pieceCoords[0])>0 && (newCoords[1] - pieceCoords[1])>0){
            for (int i = 0; i < diffRow; i++) {
                if (collisionBoard[pieceCoords[0] + i][pieceCoords[1] + i].getName() != '-' && i != 0) {
                    if(this.checkColour(collisionBoard[pieceCoords[0]+i][pieceCoords[1]+i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < diffRow; i++) {
                if (collisionBoard[pieceCoords[0] + i][pieceCoords[1] - i].getName() != '-' && i != 0) {
                    if(this.checkColour(collisionBoard[pieceCoords[0]+i][pieceCoords[1]-i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        return collisions != 0;
    }

    public boolean MoveTo(int[] pieceCoords,int[] newCoords){
        if(this.checkStillness(pieceCoords,newCoords)){
            return false;
        }
        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]);
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]);
        return diffCol == diffRow;
    }
}

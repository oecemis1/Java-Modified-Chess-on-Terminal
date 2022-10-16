public class Queen extends Item{

    private final int pieceMultiplier = 9;

    Queen(){
        this.setName('V');
        this.setColour("WHITE");
        this.setLongName("Vezir");
    }

    public int getPieceMultiplier(){
        return this.pieceMultiplier;
    }

    public boolean collisionControl(int[] pieceCoords,int[] newCoords,Item[][] collisionBoard){
        int collisions = 0;
        int piecesWithOtherColour = 0;

        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]);
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]);

        if(diffCol==0&&(newCoords[0]-pieceCoords[0])<0){
            for (int i = 0; i < diffRow + 1; i++) {
                if(collisionBoard[pieceCoords[0]-i][pieceCoords[1]].getName() != '-' && i!=0){
                    if(this.checkColour(collisionBoard[pieceCoords[0]-i][pieceCoords[1]]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if(diffCol==0&&(newCoords[0]-pieceCoords[0])>0){
            for (int i = 0; i < diffRow + 1; i++) {
                if(collisionBoard[pieceCoords[0]+i][pieceCoords[1]].getName() != '-' && i!=0){
                    if(this.checkColour(collisionBoard[pieceCoords[0]+i][pieceCoords[1]]) || piecesWithOtherColour>0){
                        collisions++;

                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if(diffRow==0&&(newCoords[1]-pieceCoords[1])<0){
            for (int i = 0; i < diffCol + 1; i++) {
                if(collisionBoard[pieceCoords[0]][pieceCoords[1]-i].getName() != '-' && i!=0){
                    if(this.checkColour(collisionBoard[pieceCoords[0]][pieceCoords[1]-i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if(diffRow==0 && (newCoords[1] - pieceCoords[1]) > 0){
            for (int i = 0; i < diffCol + 1; i++) {
                if(collisionBoard[pieceCoords[0]][pieceCoords[1]+i].getName() != '-' && i!=0){
                    if(this.checkColour(collisionBoard[pieceCoords[0]][pieceCoords[1]+i]) || piecesWithOtherColour>0){
                        collisions++;
                    }
                    else{
                        piecesWithOtherColour++;
                    }
                }
            }
        }
        else if(diffCol==diffRow) {

            diffRow = Math.abs(pieceCoords[0] - newCoords[0]) + 1;
            diffCol = Math.abs(pieceCoords[1] - newCoords[1]) + 1;

            if ((newCoords[0] - pieceCoords[0]) < 0 && (newCoords[1] - pieceCoords[1]) < 0) {
                for (int i = 0; i < diffCol; i++) {
                    if (collisionBoard[pieceCoords[0] - i][pieceCoords[1] - i].getName() != '-' && i != 0) {
                        if (this.checkColour(collisionBoard[pieceCoords[0] - i][pieceCoords[1] - i]) || piecesWithOtherColour>0) {
                            collisions++;
                        }
                        else{
                            piecesWithOtherColour++;
                        }
                    }
                }
            } else if ((newCoords[0] - pieceCoords[0]) < 0 && (newCoords[1] - pieceCoords[1]) > 0) {
                for (int i = 0; i < diffCol; i++) {
                    if (collisionBoard[pieceCoords[0] - i][pieceCoords[1] + i].getName() != '-' && i != 0) {
                        if (this.checkColour(collisionBoard[pieceCoords[0] - i][pieceCoords[1] + i]) || piecesWithOtherColour>0) {
                            collisions++;
                        }
                        else{
                            piecesWithOtherColour++;
                        }
                    }
                }
            } else if ((newCoords[0] - pieceCoords[0]) > 0 && (newCoords[1] - pieceCoords[1]) > 0) {
                for (int i = 0; i < diffRow; i++) {
                    if (collisionBoard[pieceCoords[0] + i][pieceCoords[1] + i].getName() != '-' && i != 0) {
                        if (this.checkColour(collisionBoard[pieceCoords[0] + i][pieceCoords[1] + i]) || piecesWithOtherColour>0) {
                            collisions++;
                        }
                        else{
                            piecesWithOtherColour++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < diffRow; i++) {
                    if (collisionBoard[pieceCoords[0] + i][pieceCoords[1] - i].getName() != '-' && i != 0) {
                        if (this.checkColour(collisionBoard[pieceCoords[0] + i][pieceCoords[1] - i]) || piecesWithOtherColour>0) {
                            collisions++;
                        }
                        else{
                            piecesWithOtherColour++;
                        }
                    }
                }
            }
        }

        if(collisions!=0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean MoveTo(int[] pieceCoords,int[] newCoords){

        if(this.checkStillness(pieceCoords,newCoords)){
            return false;
        }
        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]);
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]);
        if(diffCol==diffRow){
            return true;
        }
        else if ((diffCol==0&&diffRow>0)||(diffCol>0&&diffRow==0)) {
            return true;
        }
        else{
            return false;
        }
    }
}

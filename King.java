public class King extends Item{

    // King has no pieceMultiplier since Item superclass already has the value 0 for its pieceMultiplier and the King class uses that
    King(){
        this.setName('S');
        this.setColour("WHITE");
        this.setLongName("Sah");
    }

    private int collisionCounter(Item targetItem){
        if(!this.isThePieceNull(targetItem)){
            if(this.checkColour(targetItem)){
                return 1;
            }
            else{
                return 0;
            }
        }
        return 0;
    }

    public boolean collisionControl(int[] pieceCoords, int[] newCoords, Item[][] collisionBoard) {
        int collisions = 0;
        Item targetItem = collisionBoard[newCoords[0]][newCoords[1]];
        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]);
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]);
        if((diffCol==1&&diffRow==0)||(diffCol==1&&diffRow==1)||(diffCol==0&&diffRow==1)) {
            collisions = collisionCounter(targetItem);
        }
        else{
            collisions++;
        }
        return collisions != 0;
    }

    public boolean MoveTo(int[] pieceCoords, int[] newCoords){
        if(this.checkStillness(pieceCoords,newCoords)){
            return false;
        }
        int diffRow = Math.abs(pieceCoords[0] - newCoords[0]);
        int diffCol = Math.abs(pieceCoords[1] - newCoords[1]);
        if((diffCol==1&&diffRow==0)||(diffCol==1&&diffRow==1)||(diffCol==0&&diffRow==1)){
            return true;
        }
        else{
            return false;
        }
    }
}

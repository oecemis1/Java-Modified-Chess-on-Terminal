public class Knight extends Item{

    private final int pieceMultiplier = 3;

    Knight(){
        this.setName('A');
        this.setColour("WHITE");
        this.setLongName("At");
    }

    public int getPieceMultiplier(){
        return this.pieceMultiplier;
    }

    public boolean collisionControl(int[] pieceCoords,int[] newCoords,Item[][] collisionBoard){
        Item targetItem = collisionBoard[newCoords[0]][newCoords[1]];

        int collisions = 0;
        if(this.checkColour(targetItem)){
            collisions++;
        }
        return collisions != 0;
    }

    public boolean MoveTo(int[] pieceCoords,int[] newCoords){
        if(this.checkStillness(pieceCoords,newCoords)){
            return false;
        }
        int diffRow = pieceCoords[0] - newCoords[0];
        int diffCol = pieceCoords[1] - newCoords[1];
        if((diffRow*diffRow) + (diffCol*diffCol) == 5){
            return true;
        }
        else{
            return false;
        }
    }
}

public class Pawn extends Item{

    private final int pieceMultiplier = 1;

    Pawn(){
        this.setName('P');
        this.setColour("WHITE");
        this.setLongName("Piyon");
    }

    public int getPieceMultiplier(){
        return this.pieceMultiplier;
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

        if(this.checkColour(collisionBoard[newCoords[0]][newCoords[1]])){
            return true;
        }

        Item targetItem = collisionBoard[newCoords[0]][newCoords[1]];

        int collisions = 0;

        if(Math.abs(newCoords[0] - pieceCoords[0]) == 1 && newCoords[1] - pieceCoords[1] == 0  && targetItem.getName() == '-'){
            collisions = collisionCounter(targetItem);
        }
        else if(newCoords[0] - pieceCoords[0] == 1 && this.getColour().equals("WHITE") && Math.abs(newCoords[1] - pieceCoords[1]) == 1 && !this.checkColour(targetItem) ){
            collisions = collisionCounter(targetItem);
        }
        else if(newCoords[0] - pieceCoords[0] == -1 && this.getColour().equals("BLACK") && Math.abs(newCoords[1] - pieceCoords[1]) == 1  && !this.checkColour(targetItem) ){
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
        if(newCoords[0] - pieceCoords[0]==1 && newCoords[1] - pieceCoords[1] == 0 && this.getColour().equals("WHITE")){
            return true;
        }
        else if (newCoords[0] - pieceCoords[0]==-1 && newCoords[1] - pieceCoords[1] == 0 && this.getColour().equals("BLACK") ) {
            return true;
        }
        else if(newCoords[0] - pieceCoords[0] == 1 && this.getColour().equals("WHITE") && Math.abs(newCoords[1] - pieceCoords[1]) == 1 ){
            return true;
        }
        else if(newCoords[0] - pieceCoords[0] == -1 && this.getColour().equals("BLACK") && Math.abs(newCoords[1] - pieceCoords[1]) == 1 ){
            return true;
        }
        else{
            return false;
        }
    }

}

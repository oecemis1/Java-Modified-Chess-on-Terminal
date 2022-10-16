public class Item{
    //this class could have been make abstact with some adjustments but was not done so
    private char name;

    private String longName;

    private String colour;

    private final int pieceMultiplier = 0;

    public void setName(char name){
        this.name = name;
    }

    public void setLongName(String longName){
        this.longName = longName;
    }

    public String getLongName(){return this.longName;}

    public char getName(){
        return this.name;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return this.colour;
    }

    public boolean checkColour(Item itemAtLocation){
        return this.getColour().equals(itemAtLocation.getColour());
    }

    public boolean isThePieceNull(Item tested){
        return tested.getName() == '-';
    }

    public int getPieceMultiplier(){
        return this.pieceMultiplier;
    }

    Item(){
        this.setName('-');
        this.setColour("NULL");
        this.longName = "NULL";
    }

    public boolean MoveTo(int[] pieceCoords,int[] newCoords){
        return false;
    }

    public boolean collisionControl(int[] pieceCoords,int[] newCoords,Item[][] collisionBoard){
        return false;
    }

    public boolean checkStillness(int[] pieceCoords,int[] newCoords){
        return pieceCoords[0] == newCoords[0] && pieceCoords[1] == newCoords[1];
    }

}

import java.util.Scanner;

public class Main {

    public static String pieceCords;
    public static String targetCords;

    public static int exitCondition = 0;

    public static boolean checkInput(String inputData){
        if(inputData.length()!=5 && !inputData.equals("exit")){
            System.out.println("Dogru Giris Yapin!");
            return false;
        }
        if(inputData.equals("exit")){
            exitCondition = 1;
            return true;
        }
        pieceCords = inputData.substring(0,2);
        targetCords = inputData.substring(3,5);


        if(pieceCords.charAt(0)<97||pieceCords.charAt(0)>104||pieceCords.charAt(1)<49||pieceCords.charAt(1)>56){
            System.out.println("Dogru Giris Yapin!");
            return false;
        }
        else if(targetCords.charAt(0)<97||targetCords.charAt(0)>104||targetCords.charAt(1)<49||targetCords.charAt(1)>56){
            System.out.println("Dogru Giris Yapin!");
            return false;
        }
        else if((pieceCords.charAt(0)>=97&&pieceCords.charAt(0)<=104&&pieceCords.charAt(1)>=49&&pieceCords.charAt(1)<=56)&&(targetCords.charAt(0)>=97&&targetCords.charAt(0)<=122&&targetCords.charAt(1)>=49&&targetCords.charAt(1)<=57)){
            return true;
        }
        System.out.println("Dogru Giris Yapin!");
        return false;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int whitePlayer = -1;
        while(whitePlayer == -1){
            System.out.println("Beyaz Taslari Alacak Oyuncunun No'sunu Giriniz(1-2):");
            String temp = keyboard.nextLine();
            if(temp.length()!=1){
                System.out.println("Dogru Giris Yapin!");
            }
            else {
                if (temp.charAt(0) == 49) {
                    whitePlayer = 0;
                } else if (temp.charAt(0) == 50) {
                    whitePlayer = 1;
                }
            }
        }


        Game game = new Game(whitePlayer);

        while((game.players[0].kingIsDead() && game.players[1].kingIsDead()) && exitCondition == 0){
            boolean move;

            game.players[game.getCurrentPlayer()].displayMessage();

            Scanner keyboard1 = new Scanner(System.in);
            String totalCords = keyboard1.nextLine();

            if(checkInput(totalCords)) {
                if(exitCondition == 1){
                    break;
                }

                move = game.players[game.getCurrentPlayer()].MakeMove(pieceCords, targetCords, game.board);

                if (move) {
                    game.addPointsToPlayer(game.getCurrentPlayer(), game.board.chessBoard[game.board.coordinateArray(targetCords)[0]][game.board.coordinateArray(targetCords)[1]]);
                    game.removePieceFromPlayer(game.getNextPlayer(), targetCords);
                    game.board.MovePiece(pieceCords, targetCords);
                    game.setNextPlayer();
                } else {
                    System.out.println("Hatali Hareket!, Baska Bir Hamle Yapiniz.");

                    System.out.println();
                    game.board.printBoard();
                }
            }
        }

        System.out.println("Oyuncu 1 Skoru: " + game.players[0].getScore());
        System.out.println("Oyuncu 2 Skoru: " + game.players[1].getScore());


    }

}

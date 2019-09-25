package main.java.projectmanagers;

import main.java.projectmanagers.logic.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!");

        Board board = new Board();
        Position pos = new Position();
        Player W = new Player(GameStatuses.ColorStatus.WHITE);
        Player B = new Player(GameStatuses.ColorStatus.BLACK);


        System.out.println(board.boardArray[0][0]);
        System.out.println(B.get_totalPieces());

        pos.placePiece(B, 0, 0);

        System.out.println(board.boardArray[0][0]);
        System.out.println(B.get_totalPieces());

        pos.remove(0,0);

        System.out.println(board.boardArray[0][0]);
        System.out.println(B.get_totalPieces());

    }
}

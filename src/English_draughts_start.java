import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Board.*;
import GUI.Display_board;
import GUI.CircleMovablePieces;
import GUI.MoveOnePieceGUI;

import javax.swing.*;

public class English_draughts_start {
    public static void main(String args[]) throws IOException, InterruptedException {
        /*
        Initial_board boad0 = new Initial_board();
        Display_board display_func = new Display_board();
        display_func.display(boad0.current_board);
         */

        JFrame frame = new JFrame();
        int left, up, ulength;

        Example_boards examples = new Example_boards();
        int[][] test_board = examples.tmp0();
        //display_func.display(test_board);

        /*
        OutputAllMovablePieces Output_func = new OutputAllMovablePieces();
        Output_func.black_turn = true;
        List<int[]> OutputList = Output_func.MovablePieces(test_board);
        for (int[] row : OutputList) {
            System.out.println("Movable = " + Arrays.toString(row));
        }
         */

        CircleMovablePieces NowPossibleMovable = new CircleMovablePieces();
        NowPossibleMovable.black_turn = true;
        NowPossibleMovable.current_board = test_board;
        //NowPossibleMovable.frame = frame;
        NowPossibleMovable.Circle();
        frame = NowPossibleMovable.frame;
        left = NowPossibleMovable.left;
        up = NowPossibleMovable.up;
        ulength = NowPossibleMovable.ulength;


        /*
        MoveOnePiece PieceOperation = new MoveOnePiece();
        PieceOperation.black_turn = true;
        PieceOperation.current_board = test_board;
        //PieceOperation.frame = frame;
        PieceOperation.Move(4,3,3,2);
        //frame = PieceOperation.frame;


        PieceOperation.black_turn = false;
        PieceOperation.current_board = test_board;
        //PieceOperation.frame = frame;
        PieceOperation.Move(2,3,4,1);
        frame = PieceOperation.frame;
        left = PieceOperation.left;
        up = PieceOperation.up;
        ulength = PieceOperation.ulength;
         */


        MoveOnePieceGUI PieceOperationGUI = new MoveOnePieceGUI();
        PieceOperationGUI.black_turn = true;
        PieceOperationGUI.current_board = test_board;
        PieceOperationGUI.frame = frame;
        PieceOperationGUI.left = left;
        PieceOperationGUI.up = up;
        PieceOperationGUI.ulength = ulength;
        PieceOperationGUI.MoveOnePiece();




        /*
        test_board = examples.tmp3();
        NowPossibleMovable.black_turn = true;
        NowPossibleMovable.current_board = test_board;
        NowPossibleMovable.Circle();
         */

        System.out.println("Start English Draughts...");
    }
}

package GUI;

import Board.OutputAllMovablePieces;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.*;

public class CircleMovablePieces extends Display_board{
    public boolean display = true;

    public boolean black_turn = true;
    public boolean eatable = false;
    public int[][] current_board = new int[8][8];
    public List<int[]> OutputList = new ArrayList<int[]>();

    Display_board display_func = new Display_board();
    public JFrame frame = new JFrame();
    public int left, up, ulength;

    List<Integer> pieces_x = new ArrayList<Integer>();
    List<Integer> pieces_y = new ArrayList<Integer>();

    public void close_previous_frame(){
        if(display){
            //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));//close previous frame
            frame.setVisible(false);
            frame.dispose();
            frame = new JFrame();//Create new frame
        }
    }

    public void Circle() throws IOException, InterruptedException {
        /*
         */
        OutputAllMovablePieces Output_func = new OutputAllMovablePieces();
        Output_func.black_turn = black_turn;
        OutputList = Output_func.MovablePieces(current_board);
        eatable = Output_func.eatable;
        for (int[] row : OutputList) {
            int x = row[0];
            int y = row[1];
            pieces_x.add(x);
            pieces_y.add(y);
        }

        display_func.pieces_i = pieces_x;
        display_func.pieces_j = pieces_y;
        //System.out.println(display_func.pieces_i.size());
        //System.out.println(display_func.pieces_j.size());
        //display_func.frame = frame;

        if(display){
            display_func.display(current_board);
        }
        frame = display_func.frame;
        left = display_func.left;
        up = display_func.up;
        ulength = display_func.ulength;
    }
}

package Board;

import javax.swing.*;
import java.awt.*;

public class DetermineWinOrNot {
    public int[][] current_board = new int[8][8];
    public boolean black_turn = true;

    int black_number = 0;
    int white_number = 0;

    public void WhetherWinOrNot(){
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(current_board[i][j]>0){
                    black_number++;
                }
                if(current_board[i][j]<0){
                    white_number++;
                }
            }
        }

        //System.out.println("Black has "+black_number+" pieces left.\n");
        //System.out.println("White has "+white_number+" pieces left.\n");

        if(black_turn&&black_number==0){
            System.out.println("White Win!\n End of Game!\n");
            JFrame result = new JFrame("White Win!");
            JFrame.setDefaultLookAndFeelDecorated(true);
            result.setSize(450, 250);
            result.setVisible(true);
            result.setLocation(800,400);
            result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel lb = new JLabel("Congratulation!");
            result.add(lb);
            lb.setText("White Win!");
            lb.setFont(new Font("Courier", Font.BOLD,36));
            Dimension size = lb.getPreferredSize();
            lb.setBounds((450-size.width)/2, (250-size.height)/2-25, size.width, size.height);
            result.setResizable(false);
        }
        if(!black_turn&&white_number==0){
            System.out.println("Black Win!\n End of Game!\n");
            JFrame result = new JFrame("Black Win!");
            JFrame.setDefaultLookAndFeelDecorated(true);
            result.setSize(450, 250);
            result.setVisible(true);
            result.setLocation(800,400);
            result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel lb = new JLabel("Congratulation!");
            result.add(lb);
            lb.setText("Black Win!");
            lb.setFont(new Font("Courier", Font.BOLD,36));
            Dimension size = lb.getPreferredSize();
            lb.setBounds((450-size.width)/2, (250-size.height)/2-25, size.width, size.height);
            result.setResizable(false);
        }

    }
}

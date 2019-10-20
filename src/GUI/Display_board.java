package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.imageio.ImageIO;

import java.util.concurrent.TimeUnit;

public class Display_board extends JPanel{
    //https://1bestcsharp.blogspot.com/2015/04/Java-How-To-Draw-Chess-Board-In-Java-Swing-Using-NetBeans.html

    public List<Integer> pieces_i = new ArrayList<Integer>();
    public List<Integer> pieces_j = new ArrayList<Integer>();

    String title = "English Draughts";
    public JFrame frame = new JFrame(title);

    public int left = 10;
    public int up = 10;
    public int ulength = 80;


    JPanel show_pieces(int[][] argsJ, int x, int y) throws IOException {
        //https://www.javacodex.com/More-Examples/2/1
        //Pictures come from https://github.com/Trinkle23897/draughts-qt5

        int piece = argsJ[x][y];
        JPanel panel = new JPanel();

        JLabel image_b = new JLabel(new ImageIcon("./pics/bgb2.jpg"));
        JLabel image_bk = new JLabel(new ImageIcon("./pics/bgbk2.jpg"));
        JLabel image_w = new JLabel(new ImageIcon("./pics/bgw2.jpg"));
        JLabel image_wk = new JLabel(new ImageIcon("./pics/bgwk2.jpg"));

        if(piece != 0){
            switch(piece){
                case 1:
                    panel.add(image_b);
                    break;

                case 2:
                    panel.add(image_bk);
                    break;

                case -1:
                    panel.add(image_w);
                    break;

                case -2:
                    panel.add(image_wk);
            }
            panel.setLocation(left+ulength*y, up+ulength*x);
            panel.setSize(ulength, ulength);
        }
        else panel = null;

        return panel;
    }


    public void paint(Graphics layout){
        layout.fillRect(left, up, ulength*8, ulength*8);

        for(int i = left; i <= left+ulength*6; i += ulength*2){
            for(int j = up; j <= up+ulength*6; j += ulength*2){
                layout.clearRect(i, j, ulength, ulength);
            }
        }

        for(int i = left+ulength; i <= left+ulength*7; i += ulength*2){
            for(int j = up+ulength; j <= up+ulength*7; j += ulength*2){
                layout.clearRect(i, j, ulength, ulength);
            }
        }

        layout.setColor(Color.RED);
        Graphics2D layout2 = (Graphics2D)layout;
        layout2.setStroke(new BasicStroke(5.0f));
        layout2.setColor(Color.RED);
        //layout.drawRect(left+ 1 *ulength,up+ 1 *ulength,ulength,ulength);
        //System.out.println("i size?"+pieces_i.size());
        if (pieces_i.size() != 0){
            //System.out.println("Not ZERO");
            for(int k=0; k< pieces_i.size(); ++k){
                //System.out.println("["+pieces_i.get(k)+","+pieces_j.get(k)+"]");
                layout2.drawRect(left+ pieces_j.get(k) *ulength,up+ pieces_i.get(k) *ulength,ulength,ulength);
            }
        }
    }


    /*
    void forcely_attribute_pieces_list(){
        board_tmp.pieces_i = pieces_i;
        board_tmp.pieces_j = pieces_j;
    }
     */

    public void display(int[][] args) throws IOException, InterruptedException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int window_width = ulength*8+2*left;
        int window_height = ulength*8+2*up+23;
        frame.setSize(window_width, window_height);

        for(int i=0; i<8; ++i){
            for(int j=0; j<8; j++){
                JPanel panel_r = this.show_pieces(args, i, j);
                if (panel_r != null){
                    frame.getContentPane().add(panel_r);
                }
            }
        }

        Display_board board_tmp= new Display_board();

        board_tmp.pieces_i = pieces_i;
        board_tmp.pieces_j = pieces_j;


        frame.getContentPane().add(board_tmp);

        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);


        frame.setVisible(true);
        //TimeUnit.SECONDS.sleep(2);
    }
}

package Board;

import GUI.CircleMovablePieces;
import GUI.Display_board;

import javax.swing.*;
import java.util.*;
import java.io.IOException;
import java.util.List;
import java.lang.*;

public class MoveOnePiece {
    public boolean black_turn = true;
    public boolean eatable = false;
    public boolean eated = false;
    public boolean eatable_again = false;
    public int[][] current_board = new int[8][8];
    public List<int[]> OutputList = new ArrayList<int[]>();
    public boolean moved = false;
    public boolean display = true;
    public boolean Whether_Println= true;

    public JFrame frame = new JFrame();
    public int left, up, ulength;

    void Move_black(int i, int j, int n_i, int n_j){
        if((n_i-i==-1&&Math.abs(n_j-j)==1)||
                (Math.abs(n_j-j)==2&&n_i-i==-2)||
                (n_i-i==1&&Math.abs(n_j-j)==1&&current_board[i][j]==2)||
                (n_i-i==2&&Math.abs(n_j-j)==2&&current_board[i][j]==2)
        ){
            if(n_i>=0&&n_i<=7&&n_j>=0&&n_j<=7&&current_board[n_i][n_j] == 0){
                if((i>=1&&j<=6&&n_i-i==-1&&n_j-j==1&&!eatable)||
                (i>=1&&j>=1&&n_i-i==-1&&n_j-j==-1&&!eatable)){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    moved = true;
                }
                if(i>=2&&j>=2&&n_i-i==-2&&n_j-j==-2&&current_board[i-1][j-1]*current_board[i][j]<0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i-1][j-1]=0;
                    moved = true;
                }
                if(i>=2&&j<=5&&n_i-i==-2&&n_j-j==2&&current_board[i-1][j+1]*current_board[i][j]<0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i-1][j+1]=0;
                    moved = true;
                }//Men

                if((i<=6 && j>=1 && current_board[i][j]==2 && n_i-i==1 && n_j-j==-1&&!eatable)||
                        (i<=6 && j<=6 && current_board[i][j]==2 && n_i-i==1 && n_j-j==1&&!eatable)){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    moved = true;
                }
                if(i<=5 && j>=2 && current_board[i][j]==2 && n_i-i==2 && n_j-j==-2 && current_board[i+1][j-1]*current_board[i][j] < 0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i+1][j-1]=0;
                    moved = true;
                }
                if(i<=5 && j<=5 && current_board[i][j]==2 && n_i-i==2 && n_j-j==2 && current_board[i+1][j+1]*current_board[i][j] < 0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i+1][j+1]=0;
                    moved = true;
                }//King

                if(!moved&&Whether_Println){
                    System.out.println("Not a valid move![2]\n");
                    System.out.println("Possibility: Did you choose not to eat while you could?[2]\n");
                }
            }else{
                if(Whether_Println){
                    System.out.println("Not a valid move![3]\n");
                    System.out.println("Destination is not null![3]\n");
                }
            }
        }else{
            if(Whether_Println){
                System.out.println("Not a valid move![4]\n");
                System.out.println("Did you move too many steps at one time?[4]\n");
            }
        }
    }

    void Move_White(int i, int j, int n_i, int n_j){
        if((n_i-i==1&&Math.abs(n_j-j)==1)||
                (Math.abs(n_j-j)==2&&n_i-i==2)||
                (n_i-i==-1&&Math.abs(n_j-j)==1&&current_board[i][j]==-2)||
                (n_i-i==-2&&Math.abs(n_j-j)==2&&current_board[i][j]==-2)
        ){
            if(n_i>=0&&n_i<=7&&n_j>=0&&n_j<=7&&current_board[n_i][n_j] == 0){
                if((i<=6&&j<=6&&n_i-i==1&&n_j-j==1&&!eatable)||
                        (i<=6&&j>=1&&n_i-i==1&&n_j-j==-1&&!eatable)){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    moved = true;
                }
                if(i<=5&&j>=2&&n_i-i==2&&n_j-j==-2&&current_board[i+1][j-1]*current_board[i][j]<0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i+1][j-1]=0;
                    moved = true;
                }
                if(i<=5&&j<=5&&n_i-i==2&&n_j-j==2&&current_board[i+1][j+1]*current_board[i][j]<0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i+1][j+1]=0;
                    moved = true;
                }//Men

                if((i>=1 && j>=1 && current_board[i][j]==-2 && n_i-i==-1 && n_j-j==-1&&!eatable)||
                        (i>=1 && j<=6 && current_board[i][j]==-2 && n_i-i==-1 && n_j-j==1&&!eatable)){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    moved = true;
                }

                if(i>=2 && j>=2 && current_board[i][j]==-2 && n_i-i==-2 && n_j-j==-2 && current_board[i-1][j-1]*current_board[i][j] < 0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i-1][j-1]=0;
                    moved = true;
                }
                if(i>=2 && j<=5 && current_board[i][j]==-2 && n_i-i==-2 && n_j-j==2 && current_board[i-1][j+1]*current_board[i][j] < 0){
                    current_board[n_i][n_j]=current_board[i][j];
                    current_board[i][j]=0;
                    current_board[i-1][j+1]=0;
                    moved = true;
                }//King

                if(!moved&&Whether_Println){
                    System.out.println("Not a valid move![5]\n");
                    System.out.println("Possibility: Did you choose not to eat while you could?[5]\n");
                }
            }else{
                if(Whether_Println){
                    System.out.println("Not a valid move![6]\n");
                    System.out.println("Destination is not null![6]\n");
                }
            }
        }else{
            if(Whether_Println){
                System.out.println("Not a valid move![7]\n");
                System.out.println("Did you move too many steps at one time?[7]\n");
            }
        }
    }

    public void Move(int i, int j, int n_i, int n_j) throws IOException, InterruptedException {
        OutputAllMovablePieces Output_func = new OutputAllMovablePieces();
        Output_func.black_turn = black_turn;
        OutputList = Output_func.MovablePieces(current_board);
        eatable = Output_func.eatable;
        int[] intended_move = new int[]{i,j};
        boolean index_of_move = false;
        for (int[] row : OutputList) {
            if(row[0]==intended_move[0]&&row[1]==intended_move[1]){
                index_of_move = true;
            }
        }
        if (!index_of_move&&Whether_Println){
            System.out.println("Not movable piece chosen![1]\n");
        }
        else{
            if(black_turn){
                Move_black(i, j, n_i, n_j);
            }
            else{
                Move_White(i, j, n_i, n_j);
            }
            if(moved){
                ConvertMan2King Convert_func = new ConvertMan2King();
                Convert_func.current_board = current_board;
                Convert_func.Convert();
                current_board = Convert_func.current_board;

                if(eatable){
                    eated = true;
                }

                OutputAllMovablePieces Output_func2 = new OutputAllMovablePieces();
                Output_func2.black_turn = black_turn;
                List<int[]> OutputList2 = Output_func2.MovablePieces(current_board);
                eatable_again = Output_func2.eatable;
                if(eatable_again&&eated){
                    black_turn = !black_turn;
                }

                CircleMovablePieces NowPossibleMovable = new CircleMovablePieces();
                NowPossibleMovable.display = display;
                NowPossibleMovable.black_turn = !black_turn;
                NowPossibleMovable.current_board = current_board;
                NowPossibleMovable.frame = frame;
                NowPossibleMovable.close_previous_frame();
                NowPossibleMovable.Circle();
                OutputList = NowPossibleMovable.OutputList;
                frame = NowPossibleMovable.frame;
                up = NowPossibleMovable.up;
                left = NowPossibleMovable.left;
                ulength = NowPossibleMovable.ulength;
            }
        }
    }

}

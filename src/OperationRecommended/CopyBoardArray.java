package OperationRecommended;

public class CopyBoardArray {
    public int[][] current_board = new int[8][8];
    public int[][] copied_board = new int[8][8];

    public void copy(){
        for(int i=0; i<8; ++i){
            copied_board[i] = current_board[i].clone();
        }
    }
}

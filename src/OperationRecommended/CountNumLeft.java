package OperationRecommended;

public class CountNumLeft {
    public int black_num=0;
    public int white_num=0;
    public int[][] current_board = new int[8][8];
    public void count(){
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(current_board[i][j]>0){
                    black_num++;
                }else if(current_board[i][j]<0){
                    white_num++;
                }
            }
        }
    }
}

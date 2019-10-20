package Board;

public class ConvertMan2King {
    public int[][] current_board = new int[8][8];

    public void Convert(){
        for(int i=0; i<8; ++i){
            if(current_board[0][i]==1){
                current_board[0][i]=2;
            }
            if(current_board[7][i]==-1){
                current_board[7][i]=-2;
            }
        }
    }
}

package Board;

public class ScanPossibleMenMoves {//Actually for Both Men and King
    public boolean black_turn = true;
    public boolean eatable = false;

    boolean black_judge(int[][] argsJ, int x, int y){
        boolean valid = false;
        if(argsJ[x][y]>0){
            if ((x>=1 && y>=1 && argsJ[x-1][y-1] == 0)||
                    (x>=1 && y<=6 && argsJ[x-1][y+1] == 0)
            ){
                valid = true;
            }
            if ((x>=2 && y>=2 && argsJ[x-2][y-2]==0 && argsJ[x-1][y-1]*argsJ[x][y] < 0)||
                    (x>=2 && y<=5 && argsJ[x-2][y+2]==0 && argsJ[x-1][y+1]*argsJ[x][y] < 0)
            ){
                valid = true;
                eatable = true;
            }//Men

            if ((x<=6 && y>=1 && argsJ[x][y]==2 && argsJ[x+1][y-1]==0)||
                    (x<=6 && y<=6 && argsJ[x][y]==2 && argsJ[x+1][y+1]==0)
            ){
                valid = true;
            }
            if ((x<=5 && y>=2 && argsJ[x][y]==2 && argsJ[x+2][y-2]==0 && argsJ[x+1][y-1]*argsJ[x][y] < 0)||
                    (x<=5 && y<=5 && argsJ[x][y]==2 && argsJ[x+2][y+2]==0 && argsJ[x+1][y+1]*argsJ[x][y] < 0)
            ){
                valid = true;
                eatable = true;
            }//King
        }
        return valid;
    }

    boolean white_judge(int[][] argsJ, int x, int y){
        boolean valid = false;
        if(argsJ[x][y]<0){
            if ((x<=6 && y>=1 && argsJ[x+1][y-1] == 0)||
                    (x<=6 && y<=6 && argsJ[x+1][y+1] == 0)
            ){
                valid = true;
            }
            if ((x<=5 && y>=2 && argsJ[x+2][y-2]==0 && argsJ[x+1][y-1]*argsJ[x][y] < 0)||
                    (x<=5 && y<=5 && argsJ[x+2][y+2]==0 && argsJ[x+1][y+1]*argsJ[x][y] < 0)
            ){
                valid = true;
                eatable = true;
            }//Men


            if ((x>=1 && y>=1 && argsJ[x][y]==-2 && argsJ[x-1][y-1]==0)||
                    (x>=1 && y<=6 && argsJ[x][y]==-2 && argsJ[x-1][y+1]==0)
            ){
                valid = true;
            }
            if ((x>=2 && y>=2 && argsJ[x][y]==-2 && argsJ[x-2][y-2]==0 && argsJ[x-1][y-1]*argsJ[x][y] < 0)||
                    (x>=2 && y<=5 && argsJ[x][y]==-2 && argsJ[x-2][y+2]==0 && argsJ[x-1][y+1]*argsJ[x][y] < 0)
            ){
                valid = true;
                eatable = true;
            }//King
        }
        return valid;
    }


    public boolean Scan(int[][] args, int i, int j){
        if(black_turn){
            return black_judge(args, i, j);
        }
        else{
            return white_judge(args, i, j);
        }
    }
}

package Board;

import java.util.*;

public class OutputAllMovablePieces extends ScanPossibleMenMoves{
    public boolean black_turn = true;
    public boolean eatable = false;
    public List<int[]> MovablePieces(int[][] args){
        List<int[]> pieces = new ArrayList<int[]>();
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                super.black_turn = black_turn;
                if(super.Scan(args, i, j)){
                    pieces.add(new int[] {i, j});
                }
                if(super.eatable){
                    eatable = super.eatable;
                }
            }
        }
        return pieces;
    }
}

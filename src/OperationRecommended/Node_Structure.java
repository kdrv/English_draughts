package OperationRecommended;

import java.util.ArrayList;
import java.util.List;

public class Node_Structure {
    public int i, j, n_i, n_j;
    public int[][] current_test_board = new int[8][8];
    public boolean black_turn = true;
    public List<int[]> OutputList_from_MoveOnePiece = new ArrayList<int[]>();
    public int EatedMoreThanEatedBy = 0;
    public int depth = 0;
    public Node_Structure parent;
}

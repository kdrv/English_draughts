package OperationRecommended;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parent_to_Children {
    public boolean black_turn = true;
    public List<int[]> OutputList_from_MoveOnePiece = new ArrayList<int[]>();
    public int[][] current_test_board = new int[8][8];
    public int EatedMoreThanEatedBy = 0;
    public int depth = 0;
    public Node_Structure parent = new Node_Structure();

    public List<Node_Structure> ChildrenOperations;

    public void GetAllOperations() throws IOException, InterruptedException {
        AllPossibleOperations PossibleOperationsOfAllPossibleMoable = new AllPossibleOperations();
        PossibleOperationsOfAllPossibleMoable.OutputList_from_MoveOnePiece = OutputList_from_MoveOnePiece;
        PossibleOperationsOfAllPossibleMoable.black_turn = black_turn;
        PossibleOperationsOfAllPossibleMoable.current_board = current_test_board;
        PossibleOperationsOfAllPossibleMoable.EatedMoreThanEatedBy = EatedMoreThanEatedBy;
        PossibleOperationsOfAllPossibleMoable.depth = depth;
        PossibleOperationsOfAllPossibleMoable.parent = parent;
        PossibleOperationsOfAllPossibleMoable.Whether_Println = false;
        PossibleOperationsOfAllPossibleMoable.OutputAllOperationsPossible();
        ChildrenOperations = PossibleOperationsOfAllPossibleMoable.PossibleOperationsPerPossibleMovable;
        /*
        for(Node_Structure row : PossibleOperationsOfAllPossibleMoable.PossibleOperationsPerPossibleMovable){
            System.out.println("Tested i = "+row.i+", j = "+row.j+", n_i = "+row.n_i+", n_j = "+row.n_j+"\n");
        }
         */
    }
}

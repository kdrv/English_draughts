package OperationRecommended;

import Board.MoveOnePiece;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllPossibleOperations {
    public boolean black_turn = true;
    public int[][] current_board = new int[8][8];
    public List<int[]> OutputList_from_MoveOnePiece = new ArrayList<int[]>();
    public boolean moved=false, eated=false, eatable_again=false;
    public List<Node_Structure> PossibleOperationsPerPossibleMovable = new ArrayList<Node_Structure>();
    public int EatedMoreThanEatedBy = 0;
    public Node_Structure parent = new Node_Structure();
    public int depth = 0;
    public boolean Whether_Println= true;

    int[] attempt_8_poss_i = new int[]{-1, -1, 1, 1, -2, -2, 2, 2};
    int[] attempt_8_poss_j = new int[]{-1, 1, -1, 1, -2, 2, -2, 2};

    public void print_children(){
        for(Node_Structure Node_TMP : PossibleOperationsPerPossibleMovable){
            System.out.println("Node.i = "+Node_TMP.i+", Node.j = "+Node_TMP.j+", Node.n_i = "+Node_TMP.n_i+", Node.n_j = "+Node_TMP.n_j+"[3]\n");
        }
    }

    public void OutputAllOperationsPossible() throws IOException, InterruptedException {
        for(int[] row : OutputList_from_MoveOnePiece){
            int position_i = row[0];
            int position_j = row[1];

            for(int attempt_for_ij=0; attempt_for_ij<8; attempt_for_ij++){
                int d_i = attempt_8_poss_i[attempt_for_ij];
                int d_j = attempt_8_poss_j[attempt_for_ij];
                int intended_i = position_i+d_i;
                int intended_j = position_j+d_j;

                CopyBoardArray Copy_func = new CopyBoardArray();
                int[][] test_board = new int[8][8];
                Copy_func.current_board = current_board;
                Copy_func.copy();
                test_board = Copy_func.copied_board;

                MoveOnePiece PieceOperation = new MoveOnePiece();
                PieceOperation.Whether_Println = Whether_Println;
                PieceOperation.display = false;
                PieceOperation.black_turn = black_turn;
                PieceOperation.current_board = test_board;
                PieceOperation.Move(position_i,position_j, intended_i, intended_j);
                List<int[]> OutputList_from_MoveOnePiece2 = PieceOperation.OutputList;
                test_board = PieceOperation.current_board;
                moved = PieceOperation.moved;
                eated = PieceOperation.eated;
                eatable_again = PieceOperation.eatable_again;

                if(moved){
                    Node_Structure Node_TMP = new Node_Structure();
                    Node_TMP.i = position_i;
                    Node_TMP.j = position_j;
                    Node_TMP.n_i = intended_i;
                    Node_TMP.n_j = intended_j;
                    if(Whether_Println){
                        System.out.println("Node.i = "+Node_TMP.i+", Node.j = "+Node_TMP.j+", Node.n_i = "+Node_TMP.n_i+", Node.n_j = "+Node_TMP.n_j+"[1]\n");
                    }

                    if(eated){
                        if(Node_TMP.depth%2==0){
                            Node_TMP.EatedMoreThanEatedBy++;
                        }
                        else{
                            Node_TMP.EatedMoreThanEatedBy--;
                        }
                    }

                    if(eated&&eatable_again){
                        Node_TMP.black_turn = black_turn;
                    }else{
                        Node_TMP.black_turn = !black_turn;
                    }

                    Node_TMP.depth++;
                    Node_TMP.parent = parent;
                    Node_TMP.current_test_board = test_board;

                    Node_TMP.OutputList_from_MoveOnePiece = OutputList_from_MoveOnePiece2;
                    if(Whether_Println){
                        System.out.println("Node.i = "+Node_TMP.i+", Node.j = "+Node_TMP.j+", Node.n_i = "+Node_TMP.n_i+", Node.n_j = "+Node_TMP.n_j+"[2]\n");
                    }
                    PossibleOperationsPerPossibleMovable.add(Node_TMP);
                }

                moved = false;
                eated = false;
                eatable_again = false;
            }

        }

        if(Whether_Println){
            print_children();
        }

    }

}

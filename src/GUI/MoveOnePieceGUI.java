package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Board.MoveOnePiece;
import Board.DetermineWinOrNot;
import Board.OutputAllMovablePieces;
import OperationRecommended.AllPossibleOperations;
import OperationRecommended.AlphaBetaPruning;
import OperationRecommended.CountNumLeft;
import OperationRecommended.Node_Structure;

public class MoveOnePieceGUI {
    public boolean black_turn = true;
    public int[][] current_board = new int[8][8];
    public List<int[]> OutputList_from_MoveOnePiece = new ArrayList<int[]>();
    public JFrame frame = new JFrame();
    public int left, up, ulength;

    public boolean eated = false;
    public boolean eatable_again = false;
    public boolean moved = false;

    public int i, j, n_i, n_j;

    long startTime;

    void Pass2MoveOnePiece(int i, int j, int n_i, int n_j) throws IOException, InterruptedException {
        MoveOnePiece PieceOperation = new MoveOnePiece();
        PieceOperation.frame = frame;
        PieceOperation.black_turn = black_turn;
        PieceOperation.current_board = current_board;
        PieceOperation.Move(i,j, n_i, n_j);
        OutputList_from_MoveOnePiece = PieceOperation.OutputList;
        eated = PieceOperation.eated;
        moved = PieceOperation.moved;
        //System.out.println("The clicked piece was ("+i+", "+j+")[3]\n");
        //System.out.println("The intended move was ("+n_i+", "+n_j+")[4]\n");
        frame = PieceOperation.frame;

        OutputAllMovablePieces Output_func = new OutputAllMovablePieces();
        Output_func.black_turn = black_turn;
        List<int[]> OutputList = Output_func.MovablePieces(current_board);
        eatable_again = Output_func.eatable;
        if(eatable_again&&eated){
            black_turn = !black_turn;
        }

        if(moved){
            Node_Structure Root_node = new Node_Structure();
            Root_node.current_test_board = current_board;
            Root_node.black_turn = !black_turn;
            Root_node.OutputList_from_MoveOnePiece = OutputList_from_MoveOnePiece;
            Root_node.i = i;
            Root_node.j = j;
            Root_node.n_i = n_i;
            Root_node.n_j = n_j;
            Root_node.EatedMoreThanEatedBy = 0;
            Root_node.depth = 0;
            Root_node.parent = null;

            //Insert Recommendation Here
            //Use OutputList_from_MoveOnePiece, !black_turn, current_board as input
            //RecommendedNode = OperationRecommended(RootNode)


            AlphaBetaPruning AB_func = new AlphaBetaPruning();

///*
            int target_depth = AB_func.target_depth;
            CountNumLeft whether_end = new CountNumLeft();
            whether_end.current_board = Root_node.current_test_board;
            whether_end.count();
            boolean black_end = ((whether_end.black_num >= target_depth) ? true: false);
            boolean white_end = ((whether_end.white_num >= target_depth) ? true: false);

// */

            int MAX = 1000;
            int MIN = -1000;

            /*
            System.out.println("Root node movable pieces number = "+Root_node.OutputList_from_MoveOnePiece.size()+"\n");
            AllPossibleOperations PossibleOperationsOfAllPossibleMoable = new AllPossibleOperations();
            PossibleOperationsOfAllPossibleMoable.Whether_Println = true;
            PossibleOperationsOfAllPossibleMoable.OutputList_from_MoveOnePiece = Root_node.OutputList_from_MoveOnePiece;
            PossibleOperationsOfAllPossibleMoable.black_turn = Root_node.black_turn;
            PossibleOperationsOfAllPossibleMoable.current_board = Root_node.current_test_board;
            PossibleOperationsOfAllPossibleMoable.EatedMoreThanEatedBy = Root_node.EatedMoreThanEatedBy;
            PossibleOperationsOfAllPossibleMoable.depth = Root_node.depth;
            PossibleOperationsOfAllPossibleMoable.parent = Root_node;
            PossibleOperationsOfAllPossibleMoable.OutputAllOperationsPossible();
            //PossibleOperationsOfAllPossibleMoable.print_children();

            */

            /*
            for(Node_Structure row : AB_func.getChildren(Root_node)){
                System.out.println("i = "+row.i+", j = "+row.j+", n_i = "+row.n_i+", n_j = "+row.n_j+"\n");
            }
             */

            ///*
            if(black_end&&white_end){
                AlphaBetaPruning.result_structure RecommendedNode = AB_func.MiniMax(0, true, Root_node, MIN, MAX);
                int MoreEated = RecommendedNode.result_num;
                Node_Structure SelectedNode = RecommendedNode.node_iter;
                for(int k=0; k<AB_func.target_depth-1; k++){
                    SelectedNode = SelectedNode.parent;
                }
                System.out.println("More eated: "+MoreEated+"\n");
                System.out.println("Depth calculated: "+AB_func.target_depth+"\n");
                //System.out.println("Suggested move's depth: "+SelectedNode.depth);
                System.out.println("Suggested move: i = "+SelectedNode.i+", j = "+SelectedNode.j +", n_i = "+SelectedNode.n_i+", n_j = "+SelectedNode.n_j+"\n");
            }
            else{
                System.out.println("The following step is so obvious!");
            }

             //*/

            //End Recommendation
            long endTime=System.currentTimeMillis();
            System.out.println("Recommendation Run Time： "+(endTime-startTime)+"ms\n");


            MoveOnePieceGUI PieceOperationGUI = new MoveOnePieceGUI();
            PieceOperationGUI.black_turn = !black_turn;
            PieceOperationGUI.current_board = current_board;
            PieceOperationGUI.frame = frame;
            PieceOperationGUI.left = left;
            PieceOperationGUI.up = up;
            PieceOperationGUI.ulength = ulength;
            PieceOperationGUI.MoveOnePiece();
        }
    }

    public void MoveOnePiece() throws IOException, InterruptedException {

        frame.setVisible(true);
        frame.addMouseListener(new MouseListener() {
            int count = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                startTime=System.currentTimeMillis();
                DetermineWinOrNot WhetherWinOrNot = new DetermineWinOrNot();
                WhetherWinOrNot.black_turn = black_turn;
                WhetherWinOrNot.current_board = current_board;
                WhetherWinOrNot.WhetherWinOrNot();
                if(e.getButton()==e.BUTTON1&&count%2==0){
                    i = (e.getY()-up)/ulength;
                    j = (e.getX()-left)/ulength;
                    ++count;
                    System.out.println("The clicked piece is ("+i+", "+j+")[1]\n");
                }else if(e.getButton()==e.BUTTON1&&count%2==1){
                    n_i = (e.getY()-up)/ulength;
                    n_j = (e.getX()-left)/ulength;
                    ++count;
                    System.out.println("The intended move is ("+n_i+", "+n_j+")[2]\n");
                }

                if(count%2==0){
                    try {
                        Pass2MoveOnePiece(i,j,n_i, n_j);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}

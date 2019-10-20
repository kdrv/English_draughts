package OperationRecommended;

import org.w3c.dom.Node;

import java.io.IOException;
import java.util.List;

public class AlphaBetaPruning {

    public List<Node_Structure> getChildren(Node_Structure parent_node) throws IOException, InterruptedException {
        Parent_to_Children childrens = new Parent_to_Children();
        childrens.black_turn = parent_node.black_turn;
        childrens.current_test_board = parent_node.current_test_board;
        childrens.OutputList_from_MoveOnePiece = parent_node.OutputList_from_MoveOnePiece;
        childrens.depth = parent_node.depth;
        childrens.EatedMoreThanEatedBy = parent_node.EatedMoreThanEatedBy;
        childrens.parent = parent_node;
        childrens.GetAllOperations();

        return  childrens.ChildrenOperations;
    }


    public class result_structure{
        public Node_Structure node_iter = new Node_Structure();
        public int result_num;
    }
    result_structure result = new result_structure();

    static int MAX = 1000;
    static int MIN = -1000;

    public static int target_depth = 6;
    //public int test_index = 0;//debug usage

    public result_structure MiniMax(int depth, Boolean MaxOrMiniPlayer, Node_Structure node_iter, int alpha, int beta) throws IOException, InterruptedException {
        if(depth == target_depth || getChildren(node_iter)==null){
            result.result_num = node_iter.EatedMoreThanEatedBy;
            result.node_iter = node_iter;

            //test_index++;
            //System.out.println("Depth "+target_depth+"'s nodes "+test_index+": i = "+node_iter.i+", j = "+node_iter.j+", n_i = "+node_iter.n_i+", n_j = "+node_iter.n_j+"\n");

            return result;
        }

        if (MaxOrMiniPlayer){

            int best = MIN;
            result_structure result2 = new result_structure();
            result2.result_num = best;

            for(Node_Structure row : getChildren(node_iter)){
                result_structure result_tmp = MiniMax(depth+1, false, row, alpha, beta);
                int val = result_tmp.result_num;
                best = Math.max(best, val);
                alpha = Math.max(alpha, beta);

                if(best==val){
                    result2.node_iter = result_tmp.node_iter;
                    result2.result_num = result_tmp.result_num;
                }

                if (beta <= alpha)
                    break;
            }
            return result2;
        }
        else
        {
            int best = MAX;
            result_structure result2 = new result_structure();
            result2.result_num = best;

            for(Node_Structure row: getChildren(node_iter)){
                result_structure result_tmp = MiniMax(depth+1, true, row, alpha, beta);
                int val = result_tmp.result_num;
                best = Math.min(best, val);
                beta = Math.min(beta, best);

                if(best==val){
                    result2.node_iter = result_tmp.node_iter;
                    result2.result_num = result_tmp.result_num;
                }

                if (beta <= alpha)
                    break;
            }
            return result2;

        }
    }

}

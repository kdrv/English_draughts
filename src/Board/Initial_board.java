package Board;

public class Initial_board{
    int[][] initial_board = new int[][]{
        { 0, -1, 0, -1, 0, -1, 0, -1},
        { -1, 0, -1, 0, -1, 0, -1, 0},
        { 0, -1, 0, -1, 0, -1, 0, -1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0}
    };
    public int[][] current_board = initial_board;
}
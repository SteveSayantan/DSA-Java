import java.util.Arrays;

public class Recursion_BackTrackingIntro {
    
    static boolean [][] board={     // Here false represents unvisited cells
        {false,false, false},
        {false,false, false},
        {false,false, false}
    };

    static int[][] numberedBoard= new int[3][3];    // Here 0 represents unvisited cells

    public static void main(String[] args){
        printNumberedPath(0, 0, numberedBoard,1, "");       // step should be always started from 1
    }

    static void printAllPaths(int r,int c, boolean [][] board,String ans){
        /* 
            Question: Given a 3x3 maze, we have to find all the paths to the bottom right cell, moving up, down, right and left

             If we try to solve this problem the same way we solved the other maze problems, we shall fail.
             Because, in this case, as we are allowed to move upwards also, we shall keep circling around the same cells again and again.

             Therefore, we need to keep track of the visited cells during every recursion call. However, at the end of each recursive call,
              we need to reset the count of visited cells, so that further recursive calls can function properly.
            
              This approach is known as backtracking. The changes made during a recursive call should be reverted when that recursive call is over/returned.
        */
        if(r==board.length-1 && c==board[0].length-1){
            System.out.println(ans);
            return;
        }

        if(board[r][c]){   //  if the current cell is already visited, return
            return;
        }
        board[r][c]=true;

        if(r<board.length-1){
            printAllPaths(r+1, c, board, ans+"Down ");
        }
        if(r>0){
            printAllPaths(r-1, c, board, ans+"Up ");
        }
        if(c<board[0].length-1){
            printAllPaths(r, c+1, board, ans+"Right ");
        }
        if(c>0){
            printAllPaths(r, c-1, board, ans+"Left ");
        }
        // This is where the function call gets over. Before that revert the changes.
        board[r][c]=false;
    }



    static void printNumberedPath(int r,int c, int [][] board,int step,String ans){

        /* 
            Question: Given a 3x3 maze, we have to find all the paths to the bottom right cell, moving up, down, right and left and mark them using numbers.

             The approach is quite similar to the above one. Here, we are using a 2D int array instead of a boolean one.

             For numbering, we take an additional argument 'step' to keep track of the current level of recursion.

             Whenever another function is called, 'step' is incremented by 1 and passed to that call.

        */

        if(r==board.length-1 && c==board[0].length-1){

            board[r][c]=step;       // since we want to mark the destination cell as well
            print2DArray(board);
            board[r][c]=0;          // reverting the changes, though not necessary here
            System.out.println(ans);
            System.out.println();
            return;
        }

        if(board[r][c]!=0){   //  if the current cell is already visited, return
            return;
        }
        board[r][c]=step;

        if(r<board.length-1){
            printNumberedPath(r+1, c, board,step+1, ans+"Down ");
        }
        if(r>0){
            printNumberedPath(r-1, c, board,step+1, ans+"Up ");
        }
        if(c<board[0].length-1){
            printNumberedPath(r, c+1, board,step+1, ans+"Right ");
        }
        if(c>0){
            printNumberedPath(r, c-1, board,step+1, ans+"Left ");
        }
        // This is where the function call gets over. Before that revert the changes.
        board[r][c]=0;
    }

    static void print2DArray(int[][] arr){
        for(int[] ele: arr){
           System.out.println(Arrays.toString(ele));
        }
    }
}

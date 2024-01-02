import java.util.ArrayList;

public class Recursion_MazeProblem {
    
    static boolean [][] maze={     // Here false represents the obstacle
        {true,true, true},
        {true,true, false},
        {true,true, true}
    };

    public static void main(String[] args) {
        // printPaths(0, 0, "");
        // System.out.println(countPaths(0, 0));
        // System.out.println(pathsDiagonalArrayList(0, 0, ""));

        mazeWithObstacles(0, 0, maze, "");


    }

    static void printPaths(int r,int c,String ans){ 
    /* 
      Question: Given a 3x3 maze, we have to find all the paths to the bottom right cell, moving only down and right

        At every step, we can either go to right or down (except the edge cases). Hence, it can be thought as a recursion problem.
        
        Now, at most we can take 4 steps. Either two of them has to be same, hence, there are 4!/(2! * 2!) =6 possible ways to move to the 
        bottom right cell. Since, it can be solved using permutations, most likely it can be solved by subset pattern.
      
    */
        if(r==2 && c==2){
            System.out.println(ans);
            return;
        }
        
        if(r<2) printPaths(r+1, c, ans+'D');
        if(c<2) printPaths(r, c+1, ans+'R');     
    }

    static int countPaths(int r,int c){ 
    /* 
      Question: Given a 3x3 maze, we have to find number of paths to the bottom right cell, moving only down and right

        Approach is quite similar to the previous one. 

        However, we can apply this shortcut for this question,

             we know, if we reach the last row or last column, there is only one way to move to the destination.
             As this question asks to count the paths, we can simply run our recursion till we reach the last row or column.

             Because, there is a possible solution in both the cases.
      
    */
        if(r==2 || c==2){
            return 1;
        }
        
        int left= countPaths(r+1, c);
        int right= countPaths(r, c+1);
        
        return left+right;
    }

    static ArrayList<String> pathsDiagonalArrayList(int r,int c,String ans){ 
    /* 
      Question: Given a 3x3 maze, we have to find all the paths to the bottom right cell, moving down, right and diagonally (right)

        Approach is quite similar to the first one. 

        However, we are only allowed to move diagonally when row and column both are less than 2.

        Here, H indicates moving right, V indicates moving down and D indicates moving diagonally right.
      
    */
        if(r==2 && c==2){
            ArrayList<String> temp= new ArrayList<>();
            temp.add(ans);
            return temp;
        }
        ArrayList<String> result= new ArrayList<>();

        if(r<2){
            ArrayList<String> left= pathsDiagonalArrayList(r+1, c, ans+'V');
            result.addAll(left);
        }

        if(r<2 && c<2){
            ArrayList<String> diagonally= pathsDiagonalArrayList(r+1, c+1, ans+'D');
            result.addAll(diagonally);
        }
         
        if(c<2){
            ArrayList<String> right= pathsDiagonalArrayList(r, c+1, ans+'H');
            result.addAll(right);
        }
        
        return result;
    }


    static void mazeWithObstacles(int r,int c, boolean [][] board,String ans){
        /* 
            Here, we are considering a 3X3 maze but one cell of the maze contains an obstacle. Our goal is to reach the the bottom right cell,
             avoiding the obstacle. We can move only down and right.
            
            The approach is quite similar to the above ones, just we have to create one extra check that stops the recursive call that enters the 
             obstacle.

            Here, we need to create a 2D boolean array to represent the board.
        */

        if(r==board.length-1 && c==board[0].length-1){
            System.out.println(ans);
            return;
        }

        if(!board[r][c]){   // First, check if the current cell is the obstacle
            return;
        }

        if(r<board.length-1){
            mazeWithObstacles(r+1, c, board, ans+"Down ");
        }
        if(c<board[0].length-1){
            mazeWithObstacles(r, c+1, board, ans+"Right ");
        }
    }

}

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion_BackTrackingIntro {
    
    static boolean [][] board={     // Here false represents unvisited cells
        {false,false, false},
        {false,false, false},
        {false,false, false}
    };

    static int[][] numberedBoard= new int[3][3];    // Here 0 represents unvisited cells

    static char[][] sudokuBoard={{'9', '5', '7', '.', '1', '3', '.', '8', '4'},
    {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
    {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
    {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
    {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
    {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
    {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
    {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
    {'7', '.', '6', '1', '8', '5', '4', '.', '9'}};
    public static void main(String[] args){
        // printNumberedPath(0, 0, numberedBoard,1, "");       // step should be always started from 1

        // for (ArrayList<String> list : nQueen(4)) {
        //     System.out.println(list);
        // }
        
        solveSudokuTryAllCombo(sudokuBoard);
        
    }

    static void printAllPaths(int r,int c, boolean [][] board,String ans){
        /* 
            Question: Given a 3x3 maze, we have to find all the paths to the bottom right cell, moving up, down, right and left

             If we try to solve this problem the same way we solved the other maze problems, we would fail.
             Because, in this case, as we are allowed to move upwards also, we would keep circling around the same cells again and again.

             Therefore, we need to keep track of the visited cells during every recursion call. However, at the end of each recursive call,
              we need to reset the count of visited cells, so that other recursive calls can function properly.
            
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



    static ArrayList<ArrayList<String>> nQueen(int n){
        
        // creating a board
        String[][] board= new String[n][];

        for(int i=0;i<n;i++){

            board[i]= new String[n];

            for(int j=0;j<n;j++){

                board[i][j]=".";
            }
        }
        // calling the helper function
        return nQueenWrapper(0, board);
        
    }

    static ArrayList<ArrayList<String>> nQueenWrapper(int r,String[][] board){  // https://leetcode.com/problems/n-queens/description/

        // When we choose a possible answer and it can affect the future answers, we have to use backtracking.

        if(r>board.length-1){      // when we have already crossed the last row, we know we got our answer

            // capture the state of the board and send it to the above function call

            ArrayList<ArrayList<String>> ans= new ArrayList<>();
            
            ArrayList<String> boardState= new ArrayList<>();

            for (String[] row : board) {
                StringBuffer temp= new StringBuffer();
                for (String string : row) {
                    temp.append(string);
                }
                boardState.add(temp.toString());
            }

            ans.add(boardState);
            return ans;

            /* 
                Time Complexity Analysis:
                -------------------------

                The recurrence relation for nQueen is as follows:

                T(N)= T(N-1)*O(N^2)

                If we solve the recurrence relation, we get T.C. --> O(N! * N)
                S.C --> O(N^2)
            */
        }

        ArrayList<ArrayList<String>> ans= new ArrayList<>();

        for (int i = 0; i < board.length; i++) {        // this is used to traverse a row

            if(isSafe(r,i,board)){

                board[r][i]="Q";        // place the queen

                ans.addAll(nQueenWrapper(r+1, board));  // call the function for the next row

                board[r][i]=".";        // restore the changes done 
            }
        }

        return ans;
    }

    static boolean isSafe(int r,int c,String[][] board){ // idea for this is taken from Striver's lecture:

        int copyRow=r,copyCol=c;

        // No need to check in the same row, as we only place one queen per row

        // check in the same column
        while (copyRow>=0) {
            if(board[copyRow][c]=="Q") return false;
            copyRow--;
        }
        copyRow=r;


        // check the right diagonal
        while(copyRow>=0 && copyCol<board.length){      // we have to check till the 0th row and n-1th col
            if(board[copyRow][copyCol]=="Q") return false;
            copyRow--;
            copyCol++;
        }

        copyRow=r;
        copyCol=c;

        // check the left diagonal
        while(copyRow>=0 && copyCol>=0){                // we have to check till the 0th row and 0th col
            if(board[copyRow][copyCol]=="Q") return false;
            copyRow--;
            copyCol--;
        }

        return true;
    }




    static void solveSudokuTryAllCombo(char [][] board){        

        /* 
            In this approach, we try putting all the possible gueeses in a cell, even if we have found out the final solution.

            This approach is good for understanding the algorithm, but not for practical usage.

            The T.C. is O(9^N^2) where N is the number of empty cells.

            The S.C. is O(N^2) i.e. the size of the sudoku board.

        */

        for (int i = 0; i < board.length; i++) {            // traverse the rows
            
            for (int j = 0; j < board[i].length; j++) {     // traverse the columns
               
                if(board[i][j]!='.') continue;  

                for (int k = 1; k < 10; k++) {              // try all the possible digits from 1 to 9
                    
                    char guess=(char)('0'+k);

                    if(isPossible(guess,i,j,board)){        // check if the guessed digit is valid

                        board[i][j]= guess;                 // place the gussed digit in the board
                        solveSudokuTryAllCombo(board);      // call the function for the modified board where it will find the next empty cell and try to place digits 

                        board[i][j]='.';                    // restore the changes made in the board
                    }
                }

                if(board[i][j]=='.') return;                // if none of the guesses work, return to the previous function call, no need to traverse to the next cell
            }
        }

        printSudokuBoard(board);                            // when both of the loops are over (as all the cells are filled), we know we got our solution
    }

    static boolean isPossible(char guess,int r,int c, char [][] board){

        for (int i = 0; i < board.length; i++) {
            
            // checking the same row
            if(board[r][i]==guess) return false;

            // checking the same col
            if(board[i][c]==guess) return false;

            // checking the small square (dry-run the subsequent code for clarity)
            int startRow=r/3*3;         
            int startCol=c/3*3;

            if(board[startRow+i/3][startCol+i%3]==guess) return false;
        }

        return true;
    }

    static void printSudokuBoard(char[][] board){

        for(char [] arr:board){
            System.out.println(Arrays.toString(arr));
        }
    }




    static boolean solveSudoku(char [][] board){        

        /* 
            This approach is similar to the previous one, however, it does not puts all the possible digits in a cell if a solution is already found. 
         */
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[i].length; j++) {
               
                if(board[i][j]!='.') continue;

                for (int k = 1; k < 10; k++) {
                    
                    char guess=(char)('0'+k);

                    if(isPossible(guess,i,j,board)){

                        board[i][j]= guess;

                        if(solveSudoku(board)){     // this function call will find the next empty cells, try to fill values in those wrt the current guess 

                            return true;            // our current guess is right, keep the changes and return true 
                        }
                        else{                       // our current guess is not right, hence restore the changes
                            board[i][j]='.';
                        }
                    }
                }

                return false;                       // if we can't place any of the 10 digits (1-9), it indicates our one of our previous guesses was wrong
            }
        }
        return true;                                // when both of the loops are over (as all the cells are filled), we know we got our solution hence return true
    }



    static boolean isValidSudoku(char[][] board) {      //https://leetcode.com/problems/valid-sudoku/

        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[i].length; j++) {
               
                if(board[i][j]=='.') continue;          // if cell is empty, just ignore those

                // if cell is not empty,

                char temp= board[i][j];                 // keep a copy of the value
                board[i][j]='.';                        // make that cell empty     (otherwise, we can't perform the subsequent check properly )

                boolean res=isPossible(temp,i,j,board); // check if it is possible to have that value at this cell

                board[i][j]=temp;                       // restore the value at the cell
                
                if(!res) return false;                  
            }
        }
        return true;
    }
}

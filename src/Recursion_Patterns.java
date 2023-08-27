public class Recursion_Patterns {
    public static void main(String[] args) {
        triangle(3, 0);
        // System.out.println("hello");

    }

    static void invertedTriangle(int r,int c){
    // Dry run the code to understand the function calls
        if(r==0) return;        

        if(r>c){
            System.out.print("*");
            invertedTriangle(r, c+1);
        }
        else{
            System.out.println();
            invertedTriangle(r-1, 0);
        }
    }


    static void triangle(int r,int c){
    // Dry run the code to understand the function calls   
        if(r==0) return;        

        if(r>c){
            triangle(r, c+1);
            System.out.print("*");
        }
        else{
            triangle(r-1, 0);
            System.out.println();
        }
    }
}

public class Time_SpaceComplexity {
    public static void main(String[] args) {
        //Time Complexity: It is the function that gives us the relationship about how the time will grow as the input grows.

        //Constant Time Complexity is always better than linear, logarithmic or exponential time complexity i.e. 1 < logN < N^0.5 < N < NlogN < N^2 < N^3 < .... < 2^N < 3^N ... < N^N

        // 1. O (Big Oh) represents the upper-bound of time-complexity for an algorithm, i.e., an algorithm of O(N^2) complexity will have (maximum) time-complexity of O(N^2), it can never exceed that. We can write this as greater than O(N^2) i.e. O(N^3), O(N^4) but never less than O(N^2). However, it is always recommended to use the closest value.

        //2. Big Omega (Opposite of Big O ) represents the lower-bound of time-complexity for an algo. I.e., an algo of BigOmega(N^2) will take minimum N^2 complexity (It may take more than N^2 too). We can write this as less than O(N^2) i.e. O(N), O(NlogN) etc. But never greater than O(N^2). However, it is always recommended to use the closest value.

        //3. Theta Notation denotes the average bound of time-complexity for an algo. E.g., Theta(N^2) represents an algo having the average time complexity of N^2.

        //4. Little O notation also represents the upper bound of time-complexity but the actual time-complexity of the algo is always less (Strictly slower) than it  unlike Big Oh.

        //5. Little Omega represents the lower bound of time-complexity for an algo but the actual time-complexity of the algo is always greater (Strictly grows) than it unlike Big Omega.


        //Space Complexity

        // 1. Space Complexity of an algorithm is total space taken by the algorithm with respect to the input size. Space complexity includes both Auxiliary space (the extra space or temporary space used by an algorithm) and space used by input.

        // 2. As we have no control over the input, we have to look for the auxiliary space used by the algorithm 


        // For queries checkout https://www.youtube.com/watch?v=A03oI0znAoc&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=11

        for (int i = 0; i < 11; i++) {
            System.out.println(fiboFormula(i));
        }
    }

    static int fiboFormula(int n){
        //Use long
        return (int) (((Math.pow((1+Math.sqrt(5))/2,n))-(Math.pow((1-Math.sqrt(5))/2,n)))/Math.sqrt(5)); // Ignoring the second part as that is less dominating
    }
}

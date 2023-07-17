import java.util.ArrayList;

public class AlgoMaths {
    public static void main(String[] args) {
        // sieve(37);

        // System.out.format("%.1f",sqroot(12, 1));

        // System.out.format("%.2f",newtonRaphson(12, 0.05));      // e.g. if the actual sqrt is 3.55, we may get values upto 3.60 

        // printFactors(50);
        System.out.println(gcd(30, 0));
    }

    static void sieve(int n){ // Sieve of Eratosthenis

    /* 
        General Idea:
        ------------
        It is used to find all the prime numbers in a given range. For a given range, all the multiples of each number are eliminated. 
        Finally, we are left with only Prime numbers i.end. numbers which are not multiple of any other number.

        Implementation  T.C. O(N*log(logN))
        --------------
        First, we create a boolean array of size n+1 (so that n is present as an index), all the index contain false initially.

        Now, we run the loop and if a particular index contains false, we mark its multiple indices as true i.end. eliminate the multiples of that index. 
    
    */ 
        boolean [] newArr= new boolean[n+1];

        /* 
            we run this outer loop till sqrt of n because the all composite numbers <= n must be multiple of any number between 2 and sqrt of n. 
            Therefore, we can eliminate all such multiples by running the loop till sqrt of n.
        */
        for (int i = 2; i*i <=n ; i++) {        
            
            if(!newArr[i]){

                for (int j = i*i; j <=n; j+=i) {    // we need to check from i*i as the multiples before it are already checked by previous numbers.
                    newArr[j]=true;
                }
            }
        }
        for (int i = 2; i < newArr.length; i++) {
            if(!newArr[i]){
                System.out.print(i+" ");
            }
        } 
    } 
    

    static double sqroot(int n,int noOfDecimalPlaces){

        // first we need to find the integer part of the sqrt using BS

        if(n<=0) return 0.0;

        int start=1, end= n;
        double root=0.0;

        while(start<=end){
            int mid = start + (end - start) / 2;

            if (mid * mid == n) {
                return mid;
            }

            if (mid * mid > n) {
                end = mid - 1;
            } else {
                root = mid;
                start = mid + 1;
            }
        }

        double incr=0.1;
        for (int i = 0; i < noOfDecimalPlaces; i++) {

            // Now we shall add keep adding 0.1 to the integer part, till it is < n .

            double ans= root+incr;
            while(ans*ans<n){
                root=ans;
                ans+=incr;
            }
            
        // Here, we have already calculated the first digit after decimal.

            incr/=10; // Now we shall divide it by 10 and run the for loop again to get the second digit
        }

        return root;
    }


    static double newtonRaphson(int n,double permittedError){       
        /* 
            According to this method, sqrt of N = (X+N/X)/2 , where X is our assumption
            Error is calculated as the difference of the generated answer and X

            Steps:
            ------
            Initially, the input 'n' itself is assigned to X.

            The formula generates an answer that is close to the original sqrt.

            Now, if the difference between our guess and the generated answer i.e. the error is greater than the permittedError,
            the loop runs again but now X = generated answer . 

            This process is repeated until the error is minimised below the permittedError.

            Time Complexity: O((logN)*F(N)) where F(N) is a function of N
        */

        double X= n,possibleSqrt=0;
        
        while(true){

            possibleSqrt= 0.5*(X+n/X);      // Calculating the possible answer 
             

            if(Math.abs(possibleSqrt-X)<=permittedError){ 
                // if the error is within permissible limit then break
                break;
            }

            // The error is greater than the permissible limit

            X= possibleSqrt;    // the previous guess was incorrect, now use the possible answer as our new guess 

        }
        return possibleSqrt;
    }


    static void printFactors(int n) {   // This method prints the factors of a number in sorted manner

        // Time Complexity: O(sqrt(n))      Space Complexity: O(sqrt(n))
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " ");
                    list.add(n/i);          // storing these values in the arraylist
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {   // Printing the array list in reverse to get the sorted values  
            System.out.print(list.get(i) + " ");
        }
    }


    static void moduloProperties(){

        /* 
            (a+b) % m = ((a % m) + (b % m)) % m 

            (a-b) % m = ((a % m) - (b % m) +m ) % m 

            (a*b) % m = ((a % m) * (b % m)) % m

            (a/b) % m = ((a % m) * ((b^-1) % m)) % m 

            # (b^-1)%m is the Multiplicative Modulo Inverse (MMI), it denotes that b and m are co-primes.

            (a % m) % m = a % m

            (m^x) % m = 0 for all x that belongs to +ve integers

         */
    }


    static int gcd(int a,int b){    // Eucledian Algorithm
        if(a==0) return b;
        return gcd(b%a,a);
    }
 
}

/* 
    Important Concept about GCD:
    ----------------------------

    We know, GCD(a,b)=ax+by, where x and y are two integers. Basically, it gives the smallest +ve value of the equation ax+by.

    Example:

        1) Can we fill a 6L bucket using a 3L and a 4L bucket ?

            Here, we have to find if 3x+4y=6 is possible. If it is, then we can perform the task.

            Now, gcd(3,4)=1, 1 divides 6, therefore it is possible (for x=2,y=0).

        2) Can we fill a 17L bucket using a 5L and a 10L bucket ?

            Here, we have to find if 5x+10y=17 is possible. If it is, then we can perform the task.

            Now, gcd(5,10)=5 , 5 does not divide 17, therefore it is not possible (for integral values of x & y).


 */

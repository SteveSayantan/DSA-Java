public class Scopes {
    public static void main(String[] args) {
       int a =10;
       int b= 20; 

       System.out.println(a+" "+b); //a and b are accessible within this function scope only

       {
        //    int a =45; //Will give an error as 'a' is already defined outside this block under the same function
        a=67; //This is valid, this updates the value of the a to 67

        int c=56;
        System.out.println(c);   //c is only accessible inside this block as it is initialized inside this block
       }

    //    System.out.println(c);  //c is not accessible here, hence we may initialize c again outside the previous block


       for (int i = 0; i < 4; i++) {
          System.out.println(i); //i is accessible only inside the for loop.

          //If 'i' were initialized inside the main function, it would give an error for initializing same variable in the same function scope
       }

    }

    static void anything(int marks){
       //Can not access a and b (from the main function) here inside anything function
       int a=45;    
       System.out.println(a); //This 'a' is outside the main function scope, so it has no relation with the 'a' used in main function  

       System.out.println(marks); //the argument marks is available only inside this function
    }
}

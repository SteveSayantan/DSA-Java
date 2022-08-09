public class Shadowing {

    //The use of two variables with same name within overlapping scopes, is known as Shadowing. It is only takes place in case of class variables, not in methods.

    static int x= 45; // It is known as class variable.To use it in static function, we must add static to make it Object independent
    public static void main(String[] args) {
        System.out.println(x); //45

        int x= 34; 
        /**
         * In case of separate declaration and initialization for shadowing
         * 
         * int x; (declaration)
         * 
         * System.out.println(x) //Gives an error, as it has not been initialized yet
         * 
         * x=34; (initialization)
         * 
         * System.out.println(x) //34 (It can only be used after initialization)
         */
        System.out.println(x); //34  The class variable(having higher scope) at line 2 is shadowed by this x (only available inside the main function)
        fun(); //45
    }

    static void fun(){
        System.out.println(x); //45 as the 'x' declared inside the main function is not available inside fun  
    }
}

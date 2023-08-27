public class First {//This public class is to be named the same as the file name.'public' denotes that the 'First' class is accessible to other files
    public static void main(String[] args) { //This is the "main" function, the entry point of the program. This is also public to make it accessible as it is the entry point. It is a static method because we want to execute this method without creating an object of the First class (Generally, to use any method, we have to create an object of that class). 
    //It is void because it does not return anything. args represent the argument which is a String in this case.

        System.out.println("Hello World"); //System class contains useful methods.out is a printstream which contains a println method which takes a String to give it as output.
        System.out.print("Hello Steve"); //print method does not creates a new line after printing the output, hence the next output will be in the same line as this.
        System.out.println("Hello Anything"); 
        System.out.print(46584); 
         
    }
}

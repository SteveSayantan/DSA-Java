import java.util.Scanner;

public class SwitchCases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next().trim();
        int day= in.nextInt();
        in.close();
/**
       Traditional Switch Case Statement: (Without the break, it will keep executing the other cases even after executing the right one)
 
        switch (fruit) {
            case "Mango": System.out.println("The king of fruits");
                break;
            case "Banana": System.out.println("Monkeys' favourite");
                break;
            case "Orange": System.out.println("A colour as well");
                break;
            case "Apple": System.out.println("An apple a day, keeps the doctor away");
                break;
        
            default: System.out.println("Enter a valid fruit, idiot!!");
                break;
        }
**/

//New Syntax: (No need to add break, it automatically assumes the break after each statement)
    
    /**
      
     switch(fruit){
         case "Mango" -> System.out.println("The king of fruits");
         case "Banana" -> System.out.println("Monkeys' favourite");
         case "Orange" -> System.out.println("A colour as well");
         case "Apple" -> System.out.println("An apple a day, keeps the doctor away");
         default -> System.out.println("Enter a valid fruit, idiot!!");
     }
      
     
     **/

//Use of Switch Case without break statement: (For all the numbers from 1 to 5 it will print weekday and for 6 and 7 it will print weekend)

/**
    //Traditional Syntax:
      
     
      switch (day) {
          case 1:
          case 2:
          case 3:
          case 4:
          case 5: System.out.println("WeekDay");
          case 6: 
          case 7: System.out.println("WeekEnd");
              break;
      
          default: System.out.println("Enter a valid number");
              break;
      }

**/
//New Syntax:
        /**
          
         switch(day){
             case 1,2,3,4,5 -> System.out.println("WeekDay");
             case 6,7 -> System.out.println("WeekEnd");
         }
         **/
          
//Nested Switch Cases: (For values upto 3 it is only going to print but for 4, it also triggers the nested switch)

         switch(day){
             case 1: System.out.println("Entered 1");
                break;
             case 2: System.out.println("Entered 2");
                break;
             case 3: System.out.println("Entered 3");
                break;
             case 4:
                System.out.println("Entered 4");
                switch(fruit){ //This is called nested switch case
                    case "Apple": System.out.println("An apple a day, keeps the doctor away");
                        break;
                    case "Banana" : System.out.println("Monkeys' favourite");
                        break;
                    default: System.out.println("Enter a valid fruit");
                }
                break;
             default:System.out.println("Enter a valid Number");
         }

//Using new Syntax: (For using multiple lines in the new syntax, we need to add {} example @line 100)
         /**
          
          switch(day){
             case 1 -> System.out.println("Entered 1");
             case 2 -> System.out.println("Entered 2");
             case 3 -> System.out.println("Entered 3");
             case 4 ->{
                  System.out.println("Entered 4");
                  switch(fruit){
                    case "Apple" -> System.out.println("An apple a day, keeps the doctor away");
                    case "Banana" -> System.out.println("Monkeys' favourite");
                    default -> System.out.println("Enter a valid fruit");
                  }
             }
            default -> System.out.println("Enter a valid Number");

          }


          **/

    }
}

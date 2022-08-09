public class LoopBasics {
    public static void main(String[] args) {
        //While Loop (When we don't know how many times the loop is going to run)
        int a=20;
        while (a<31) {
            System.out.println(a);
            a++; //a+=2 will increment the value of a by 2
        }
        
         //For Loop (When we know how many times the loop is going to run)
         
         for(int count=10;count<21;count++){  //(initialization;condition;increment/decrement)
             System.out.println(count);
         }

         //Do-while Loop (It will run at least once even though the condition is not met)

         int n=1;
         do {
           System.out.println(n);  
           n++;
         } while (n<5);



         //Multiple if-else statement (Only one block will be executed according to the conditions met)
         int salary=25400;
         if(salary>10000){ //Either this will execute
             salary+=2000;
         }
         else if(salary>20000){ //or this will execute
             salary+=3000;
         }
         else{ //or this will execute
             salary+=1000;
         }

         System.out.println(salary);
    }
}

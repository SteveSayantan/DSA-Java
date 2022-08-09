public class Loop_Break_Continue {
    public static void main(String[] args) {
        //Break Statement in For Loop

       for (int i = 0; i < 5; i++) {
           System.out.println(i);
           if(i==3){
               System.out.println("Bye Bye");
               break; //Break statement breaks the loop
           }
       }

       //Break in while loop (Works the same in do-while loop)

       int count=0;
      while(count<5){
          if(count==4){
              break;
          }
          System.out.println(count);
          count++;
      } 

      //Continue in for Loop
      for (int i = 0; i < 4; i++) {
          if(i==2){
              continue; //continue in for loop is used to skip the current iteration and increments the value (jumps to the increment part)
          }
          System.out.println(i);
      }


      //Continue in While loop (Works the same for Do-While)

      int alice=0;

      /*-->Entry Point<--*/
      while (alice<5) {
          if(alice==3){
              alice++; // Without this increment, there will be an infinite loop when the value becomes 3.
              continue; //continue in a while loop takes the loop to the Entry Point. It does not increment the value like for loop. The user has to add increment manually.
          }
          System.out.println(alice);
          alice++;
      }
    }

}

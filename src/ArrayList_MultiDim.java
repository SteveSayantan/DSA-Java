import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_MultiDim {
    public static void main(String[] args) {

        ArrayList <ArrayList<Integer>> multiList= new ArrayList<>(3); //An arraylist that may contain three or more arraylists has been declared.
        Scanner in= new Scanner(System.in);

        //First, we need to add the element arraylists to the multiList (otherwise each index will be containing null)
        for (int i = 0; i < 3; i++) {
            multiList.add(new ArrayList<>());
        }

        //Now, adding items to each element arraylist
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) { //each element arraylist will contain three integers
                multiList.get(j).add(in.nextInt()) ;               
            }
        }

        System.out.println(multiList);
        in.close();
    }
}

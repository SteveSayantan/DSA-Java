import java.util.Arrays;

public class Recursion_Sort {
    public static void main(String[] args) {
        int[] test={23,56,34,12,6,2};

        // recursiveBubbleSort(test.length-1, 0, test);

        recursiveSelectionSort(0, test.length-1, test);
        System.out.println(Arrays.toString(test));
    }

    static void recursiveBubbleSort(int iCount,int ind,int[] arr){

        /* 
            iCount counts the number of iterations required, which is n-1 (n=length of the array)

            ind indicates the index of an element

            The working is very similar to the pattern solved in Recursion_Patterns.java
         */
        if(iCount==0) return;

        if(iCount>ind){

            if(arr[ind]>arr[ind+1]) swap(ind,ind+1,arr);

            recursiveBubbleSort(iCount, ind+1, arr);
        }
        else{
            recursiveBubbleSort(iCount-1, 0, arr);
        }
    }

    static void swap(int ind1, int ind2,int[] array){
        int temp= array[ind1];
        array[ind1]=array[ind2];

        array[ind2]=temp;
    }

       static void recursiveSelectionSort(int start,int end,int [] arr){
        if(start==end) return;
        int maxInd=findMaxInd(start,end,arr);
        swap(maxInd,end,arr);
        recursiveSelectionSort(start,end-1,arr);
    }

    static int findMaxInd(int ind1, int ind2,int[] array){
        int ans=ind1;
        for (int i = ind1; i <=ind2; i++) {
            if(array[ans]<array[i]){
                ans=i;
            }
        }
        return ans;
    }

}

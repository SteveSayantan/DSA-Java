import java.util.ArrayList;
import java.util.Arrays;


public class Test {
    public static void main(String[] args) {
        // PTriplet(1, 2, 3);
        
        // Factorial(2);

        // LeapYear(2024);

        // Table(19);
        int[] arr = {2,5,1,3,4,7};
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        ArrayList<Integer> list2= new ArrayList<>();
        
        list2.add(4);
        list2.add(5);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        // System.out.println(findArrayIntersection(list1, 7, list2, 5));
            
        // System.out.println(Arrays.toString(shuffle(arr,3)));
        

        int[][] nums1={{2,3,1},{3,2,1}}, nums2={{1,2},{2,1},{1,2}};
        MultiplyArray(nums2, nums1);

    }

    static void PTriplet(int num1,int num2,int num3){
        int max= Math.max(num1,(Math.max(num2,num3)));

        int min= Math.min(num1,(Math.min(num2,num3)));

        int last= num1+num2+num3-max-min;

        if(max*max-min*min==last*last){
            System.out.println("Given triplet is Pythagorean");
            return;
        }
        System.out.println("Given triplet is not Pythagorean");
    }

    static void Factorial(int num){
        int ans=1;
        while(num>1){
            ans*=num;
            num--;
        }
        System.out.println(ans);
    }

    static void LeapYear(int year){
        if(year%4==0 && year%100==0){
            
            if(year%400==0){
                System.out.println(year+" is a leap year");
            }
            else{
                System.out.println(year+" is not a leap year");  
            }          
        }
        else {
            if(year%4==0){

                System.out.println(year+" is a leap year");
            }
            else{
                System.out.println(year+" is not a leap year");
            }
        }
    }

    static void Table(int n){
        int i=1;
        while(i<=10){
           System.out.printf("%d X %d = %d%n",n,i,n*i);
           i++;
        }
    }
    
    static void ReverseTable(int n){
        int i=10;
        while(i>=1){
           System.out.printf("%d X %d = %d%n",n,i,n*i);
           i--;
        }
    }

    static int[] swapAlternate(int[] arr){
        int fPointer=0, sPointer=1;
        while(fPointer<arr.length&&sPointer<arr.length){
            int temp= arr[fPointer];

            arr[fPointer]=arr[sPointer];
            arr[sPointer]=temp;

            fPointer+=2;
            sPointer+=2;
        }
        return arr;
    }

    static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		// Write Your Code Here.
          int i=0,j=0;
        ArrayList<Integer> newArray= new ArrayList<>() ;
        
        while(i<n&&j<m){
            if(arr2.get(j)==arr1.get(i)){
               newArray.add(arr1.get(i));
                i++;
                j++;
                
            }
            else if(arr2.get(j)>arr1.get(i)){
               i++;
    }
            else{
                j++;
}
        }
        return newArray;
	} 

    static void MultiplyArray(int[][] arr1, int [][] arr2 ){

        if(arr1[0].length!=arr2.length){
            System.out.println("Invalid Array");
            return;
        }
        for (int row = 0; row < arr1.length; row++) {

            for (int colArr2 = 0; colArr2 < arr2[0].length; colArr2++) {
                
                int sum=0;

                for (int numArr2 = 0; numArr2 < arr2.length; numArr2++) {

                   sum+= arr1[row][numArr2]*arr2[numArr2][colArr2]; 
                }
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }

    }



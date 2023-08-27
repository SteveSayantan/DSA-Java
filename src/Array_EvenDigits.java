public class Array_EvenDigits {
    public static void main(String[] args) {
        
    //Q: Given an array of integers, return how many of them contain an even number of digits.
        
        int[] arr={12,345,2,6,7896};
        System.out.println(numberOfEle(arr));
        
    }
    
    static int numberOfEle(int[] arr){
        int number=0;
        for (int ele : arr) {
            if(EvenorOdd(DigitCounterAdv(ele)))
            {
                number++;
            }
        }
        return number;
    }

    static boolean EvenorOdd(int num){
        return num%2==0;
    }
/*
    static int DigitCounter(int num){ //Traditional method to find the number of digits in a number
        if(num==0) return 1;
        
        if(num<0)  num*=-1;
        
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }

*/   
    static int DigitCounterAdv(int num){
        if(num<0) num*=-1;
        return (int)(Math.log10(num))+1; //This is a shortcut formula to count the digits of a number
    }
}

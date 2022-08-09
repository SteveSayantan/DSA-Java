public class LoopQ_Reverse {
    public static void main(String[] args) {
        int num=28479;

        int ans=0;

        while(num>0){
            int rem= num%10;
            num/=10;
            if((ans>Integer.MAX_VALUE/10)||(ans<Integer.MIN_VALUE/10)){ //For handling edge cases where the ans (When multiplied by 10) exceeds the range of Integer
                System.out.println("Invalid Number");
            }
            ans= ans*10+rem; 
        }

        System.out.println(ans);
    }

    
}

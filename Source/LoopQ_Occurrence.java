public class LoopQ_Occurrence{
    public static void main(String[] args) {
        
        int n= 45535;
        
        int count =0;
        while (n>0) {
            int rem= n%10;
            if(rem==5){
                count++;
            }
            n/=10;
        }

        System.out.println(count); //Gives the occurrence of 5 in the given expression

    }
}